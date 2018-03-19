import java.net.URL;
import java.net.MalformedURLException;
import java.net.HttpURLConnection;
import java.io.*;
import java.util.HashMap;
import java.util.ArrayList;
import com.google.gson.*;

public class JsonReader {

    private String sUrl;
    private Gson gson;
    private HashMap<String, String> cleanMap = new HashMap<String, String>();

    public JsonReader( String sUrl ) {

        this.sUrl = sUrl;
        this.gson = new Gson();

        try {

            //try to read in a file with all address abbrievations
            BufferedReader in = new BufferedReader(new FileReader("addrs.txt"));
            String line;

            while ((line = in.readLine()) != null) {

                String[] lineArray = line.split(", ");
                String addr = lineArray[0];
                String abbr = lineArray[1];

                //add each abbrievation to a hashmap
                cleanMap.put( abbr, addr );

            }
            in.close();

        } catch (IOException e) {
            System.out.println( "File addrs.txt is missing or damaged." );
        }

    }

    public ArrayList<Direction> readDirections()
    throws MalformedURLException, IOException {

        ArrayList<Direction> directions = new ArrayList<Direction>();

        URL url = new URL( sUrl );
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();

        JsonParser jp = new JsonParser();

        JsonElement root = jp.parse(new InputStreamReader(
                                    (InputStream) request.getContent() ) );

        JsonElement route = root.getAsJsonObject().get("routes")
                                .getAsJsonArray().get(0);

        //we're only ever making requests with one waypoint -> one leg
        JsonElement leg = route.getAsJsonObject().get("legs")
                               .getAsJsonArray().get(0);

        //steps contain information about each instruction in the journey
        JsonArray steps = leg.getAsJsonObject().get("steps").getAsJsonArray();

        for ( JsonElement step : steps ) {

            JsonObject stepObj = step.getAsJsonObject();

            //for each step, get and clean it's instruction
            String instruction = stepObj.get("html_instructions")
                                        .getAsString();

            instruction = directionCleaner( instruction );

            //then form an object with all the relevant information
            Direction dir = gson.fromJson( stepObj, Direction.class );

            //set the instruction to the previously cleaned instruction
            dir.setInstruction( instruction );

            directions.add( dir );

        }

        //we return an array list of direction objects, all with info
        //of the small parts of the journey
        return directions;
    }

    private String directionCleaner( String s ) {

        //first strip out HTML tags
        s = s.replaceAll("<[^>]*>", " ")
             .replaceAll(" +", " ");

        //next replace any abbrievations
        for ( String abbr : cleanMap.keySet() ) {

            String addr = cleanMap.get( abbr );

            s = s.replaceAll( "(?<!\\S)" + abbr + "(?!\\S)", addr );

        }

        return s;

    }

}
