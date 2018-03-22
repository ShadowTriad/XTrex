import java.awt.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Observable;
import javax.swing.*;
import java.util.*;
import java.util.List;

import java.io.File;
import java.io.FileOutputStream;
import java.io.DataOutputStream;

import java.net.URLEncoder;
import java.util.concurrent.TimeUnit;

public class XTrexModel extends Observable
{
	private Mode mode;
	private Constant constant = new Constant ();
	private String longitude = "-3.1"; // will be retrieved from gps later
	private String latitude = "50.1"; // will be retrieved from gps later
	private String time = "123456"; // will be retrieved from gps later
	private String destination = "Chagford"; //Change me
	
	private String address = "";
	private int highlightedButton = 0;
	private Keyboard keyboard = Keyboard.ALPHABETIC;
	private ArrayList <Keycap> alphabeticButtons = new ArrayList <Keycap> (constant.getAlphabeticButtons ());
	private ArrayList <Keycap> numericButtons = new ArrayList <Keycap> (constant.getNumericButtons ());
	private Keycap buttonA = new Keycap ("A", constant.getAlphabeticColumn1 (), constant.getAlphabeticRow1 ());
	private Keycap buttonB = new Keycap ("B", constant.getAlphabeticColumn2 (), constant.getAlphabeticRow1 ());
	private Keycap buttonC = new Keycap ("C", constant.getAlphabeticColumn3 (), constant.getAlphabeticRow1 ());
	private Keycap buttonD = new Keycap ("D", constant.getAlphabeticColumn4 (), constant.getAlphabeticRow1 ());
	private Keycap buttonE = new Keycap ("E", constant.getAlphabeticColumn1 (), constant.getAlphabeticRow2 ());
	private Keycap buttonF = new Keycap ("F", constant.getAlphabeticColumn2 (), constant.getAlphabeticRow2 ());
	private Keycap buttonG = new Keycap ("G", constant.getAlphabeticColumn3 (), constant.getAlphabeticRow2 ());
	private Keycap buttonH = new Keycap ("H", constant.getAlphabeticColumn4 (), constant.getAlphabeticRow2 ());
	private Keycap buttonI = new Keycap ("I", constant.getAlphabeticColumn1 (), constant.getAlphabeticRow3 ());
	private Keycap buttonJ = new Keycap ("J", constant.getAlphabeticColumn2 (), constant.getAlphabeticRow3 ());
	private Keycap buttonK = new Keycap ("K", constant.getAlphabeticColumn3 (), constant.getAlphabeticRow3 ());
	private Keycap buttonL = new Keycap ("L", constant.getAlphabeticColumn4 (), constant.getAlphabeticRow3 ());
	private Keycap buttonM = new Keycap ("M", constant.getAlphabeticColumn1 (), constant.getAlphabeticRow4 ());
	private Keycap buttonN = new Keycap ("N", constant.getAlphabeticColumn2 (), constant.getAlphabeticRow4 ());
	private Keycap buttonO = new Keycap ("O", constant.getAlphabeticColumn3 (), constant.getAlphabeticRow4 ());
	private Keycap buttonP = new Keycap ("P", constant.getAlphabeticColumn4 (), constant.getAlphabeticRow4 ());
	private Keycap buttonQ = new Keycap ("Q", constant.getAlphabeticColumn1 (), constant.getAlphabeticRow5 ());
	private Keycap buttonR = new Keycap ("R", constant.getAlphabeticColumn2 (), constant.getAlphabeticRow5 ());
	private Keycap buttonS = new Keycap ("S", constant.getAlphabeticColumn3 (), constant.getAlphabeticRow5 ());
	private Keycap buttonT = new Keycap ("T", constant.getAlphabeticColumn4 (), constant.getAlphabeticRow5 ());
	private Keycap buttonU = new Keycap ("U", constant.getAlphabeticColumn1 (), constant.getAlphabeticRow6 ());
	private Keycap buttonV = new Keycap ("V", constant.getAlphabeticColumn2 (), constant.getAlphabeticRow6 ());
	private Keycap buttonW = new Keycap ("W", constant.getAlphabeticColumn3 (), constant.getAlphabeticRow6 ());
	private Keycap buttonX = new Keycap ("X", constant.getAlphabeticColumn4 (), constant.getAlphabeticRow6 ());
	private Keycap buttonY = new Keycap ("Y", constant.getAlphabeticColumn1 (), constant.getAlphabeticRow7 ());
	private Keycap buttonZ = new Keycap ("Z", constant.getAlphabeticColumn2 (), constant.getAlphabeticRow7 ());
	private Keycap button_ = new Keycap ("_", constant.getAlphabeticColumn3 (), constant.getAlphabeticRow7 ());
	private Keycap buttonRIG = new Keycap ("RIG", constant.getAlphabeticColumn4 (), constant.getAlphabeticRow7 ());
	private Keycap button1 = new Keycap ("1", constant.getNumericColumn1 (), constant.getNumericRow1 ());
	private Keycap button2 = new Keycap ("2", constant.getNumericColumn2 (), constant.getNumericRow1 ());
	private Keycap button3 = new Keycap ("3", constant.getNumericColumn3 (), constant.getNumericRow1 ());
	private Keycap button4 = new Keycap ("4", constant.getNumericColumn1 (), constant.getNumericRow2 ());
	private Keycap button5 = new Keycap ("5", constant.getNumericColumn2 (), constant.getNumericRow2 ());
	private Keycap button6 = new Keycap ("6", constant.getNumericColumn3 (), constant.getNumericRow2 ());
	private Keycap button7 = new Keycap ("7", constant.getNumericColumn1 (), constant.getNumericRow3 ());
	private Keycap button8 = new Keycap ("8", constant.getNumericColumn2 (), constant.getNumericRow3 ());
	private Keycap button9 = new Keycap ("9", constant.getNumericColumn3 (), constant.getNumericRow3 ());
	private Keycap button0 = new Keycap ("0", constant.getNumericColumn1 (), constant.getNumericRow4 ());
	private Keycap buttonLEF = new Keycap ("LEF", constant.getNumericColumn1 (), constant.getNumericRow5 ());
	private Keycap buttonDEL = new Keycap ("DEL", constant.getNumericColumn2 (), constant.getNumericRow4 ());
	
	private double startingTime = 0;
	private double tripOdometer = 0;
	private double speed = 0;
	private double movingTimeMinutes = 0;
	private double movingTimeSeconds = 0;
	
	private int zoom = 15;
	private String strZoom = Integer.toString (zoom);  
	private ImageIcon map;
	private String[ ] tiles = {"WhereTo", "TripComputer", "Map", "Speech", "Satellite", "About"};
	private int index = 0;
	
	public int currentLanguageCount = 3; 
    public List<String> languages = Arrays.asList("Off","en-US", "fr-FR","de-DE","It-IT","es-ES");
    final static String region = "uk";
    final static String travelMode = "WALKING"; 
    final static String FILENAME = "output.wav";
    ArrayList<Direction> directions = new ArrayList<Direction>();
    
    final static double radiusOfDestination = 0.01; //radiusOfDestination is measured in km, represents how close the gps coords can be to the destination before the coords are declared close-enough
    public int dirCount = 0; 
	
	// need current gps coords, goal gps coords, mode, time, speed..?, language, map
	public XTrexModel (Mode mode)
	{
		setCoordinates (longitude, latitude, time);
		alphabeticButtons.add (buttonA);
		alphabeticButtons.add (buttonB);
		alphabeticButtons.add (buttonC);
		alphabeticButtons.add (buttonD);
		alphabeticButtons.add (buttonE);
		alphabeticButtons.add (buttonF);
		alphabeticButtons.add (buttonG);
		alphabeticButtons.add (buttonH);
		alphabeticButtons.add (buttonI);
		alphabeticButtons.add (buttonJ);
		alphabeticButtons.add (buttonK);
		alphabeticButtons.add (buttonL);
		alphabeticButtons.add (buttonM);
		alphabeticButtons.add (buttonN);
		alphabeticButtons.add (buttonO);
		alphabeticButtons.add (buttonP);
		alphabeticButtons.add (buttonQ);
		alphabeticButtons.add (buttonR);
		alphabeticButtons.add (buttonS);
		alphabeticButtons.add (buttonT);
		alphabeticButtons.add (buttonU);
		alphabeticButtons.add (buttonV);
		alphabeticButtons.add (buttonW);
		alphabeticButtons.add (buttonX);
		alphabeticButtons.add (buttonY);
		alphabeticButtons.add (buttonZ);
		alphabeticButtons.add (button_);
		alphabeticButtons.add (buttonRIG);
		numericButtons.add (button1);
		numericButtons.add (button2);
		numericButtons.add (button3);
		numericButtons.add (button4);
		numericButtons.add (button5);
		numericButtons.add (button6);
		numericButtons.add (button7);
		numericButtons.add (button8);
		numericButtons.add (button9);
		numericButtons.add (button0);
		numericButtons.add (buttonLEF);
		numericButtons.add (buttonDEL);
		setStartingTime (getTime ());
		setMode (mode);
	}
	
	public Mode getMode ()
	{
		return mode;
	}
	
	public void setMode (Mode mode)
	{
		this.mode = mode;
		setChanged ();
		notifyObservers (mode);
	}
	
	/*
	* @author Jasmine
	*/
	public void switchMode (Mode newMode)
	{
        	mode = newMode;
	}
	
	public Constant getConstant ()
	{
		return constant;
	}
	
	public String getLongitude ()
	{
		return longitude;
	}
	
	public String getLatitude ()
	{
		return latitude;
	}
	
	public String getTime ()
	{
		return time;
	}
	
	public void setCoordinates (String longitude, String latitude, String time)
	{
		this.longitude = longitude;
		this.latitude  = latitude;
		this.time  = time;
		updateMap ();
		setChanged (); ////????????????????????????????????????
		notifyObservers ();
	}
	
	public void updateCoordinates () /// will update current coordinates later
	{
	}
	
	//Where To start
	public String getAddress ()
	{
		return address;
	}
	
	public int getHighlightedButton ()
	{
		return highlightedButton;
	}
	
	public Keyboard getKeyboard ()
	{
		return keyboard;
	}
	
	public ArrayList <Keycap> getAlphabeticButtons ()
	{
		return alphabeticButtons;
	}
	
	public ArrayList <Keycap> getNumericButtons ()
	{
		return numericButtons;
	}
	
	public void whereToPlusButton ()
	{
		if (keyboard == Keyboard.ALPHABETIC)
		{
			if (highlightedButton == constant.getAlphabeticButtons () - 1)
			{
				highlightedButton = 0;
			}
			else
			{
				highlightedButton = highlightedButton + 1;
			}
		}
		else
		{
			if (highlightedButton == constant.getNumericButtons () - 1)
			{
				highlightedButton = 0;
			}
			else
			{
				highlightedButton = highlightedButton + 1;
			}
		}
	}
	
	public void whereToMinusButton ()
	{
		if (keyboard == Keyboard.ALPHABETIC)
		{
			if (highlightedButton == 0)
			{
				highlightedButton = constant.getAlphabeticButtons () - 1;
			}
			else
			{
				highlightedButton = highlightedButton - 1;
			}
		}
		else
		{
			if (highlightedButton == 0)
			{
				highlightedButton = constant.getNumericButtons () - 1;
			}
			else
			{
				highlightedButton = highlightedButton - 1;
			}
		}
	}
	
	public void whereToSelectButton ()
	{
		if (keyboard == Keyboard.ALPHABETIC)
		{		
			if ((alphabeticButtons.get (highlightedButton)).getName () == "RIG")
			{
				keyboard = Keyboard.NUMERIC;
				highlightedButton = 0;
			}
			else
			{
				address = address + (alphabeticButtons.get (highlightedButton)).getName ();
			}
		}
		else
		{
			if ((numericButtons.get (highlightedButton)).getName () == "DEL")
			{			
				if (address.length () == 0)
				{
				}
				else if (address.length () == 1)
				{
					address = "";
				}
				else
				{
					address = address.substring (0, address.length () - 1);
				}
			}
			else if ((numericButtons.get (highlightedButton)).getName () == "LEF")
			{
				keyboard = Keyboard.ALPHABETIC;
				highlightedButton = 0;
			}
			else
			{
				address = address + (numericButtons.get (highlightedButton)).getName ();
			}
		}
	}
	//Where To end
	
	//Trip Computer start
	public double inSeconds (String time)
	{
		return Double.parseDouble (time.substring (0, 2)) * constant.getHourSeconds () + Double.parseDouble (time.substring (2, 4)) * constant.getMinuteSeconds () + Double.parseDouble (time.substring (4));
	}
	
	public double inHours (Double minutes, Double seconds)
	{
		return minutes / constant.getMinuteSeconds () + seconds / constant.getHourSeconds ();
	}
	
	public void setStartingTime (String time)
	{
		startingTime = Double.parseDouble (time);
	}
	
	public double getTripOdometer ()
	{
		return tripOdometer;
	}
	
	public void updateTripOdometer ()
	{
		tripOdometer = getRouteLengthSoFar ();
	}
	
	public double getSpeed ()
	{
		return speed;
	}
	
	public void updateSpeed ()
	{
		speed = tripOdometer / (inHours(movingTimeMinutes, movingTimeSeconds));
	}
	
	public double getMovingTimeMinutes ()
	{
		return movingTimeMinutes;
	}
	
	public double getMovingTimeSeconds ()
	{
		return movingTimeSeconds;
	}
	
	public void updateMovingTime ()
	{
		double seconds = inSeconds (time);
		if (seconds > startingTime)
		{
			seconds = seconds - startingTime;
		}
		else
		{
			seconds = seconds + constant.getDaySeconds () - startingTime;
		}
		movingTimeMinutes = seconds / constant.getMinuteSeconds ();
		movingTimeSeconds = seconds % constant.getMinuteSeconds ();
	}
	//Trip Computer end
	
	public String getZoom() {
		return strZoom;
	}
	
	public void setMap(ImageIcon map) {
		this.map = map;
		setChanged(); ////????????????????????????????????????
		notifyObservers();
	}
	public ImageIcon getMap() {
		return map;
	}
	
	// is this constant?
	public String[] getTiles() {
		return tiles;
	}
	
	public int getIndex()
	{
		return index;
	}
	public void setIndex (int index)
	{
		this.index = index;
		setChanged(); ////????????????????????????????????????
		notifyObservers();
	}
	
	/* REALLY not happy about putting this functionality in the model but 
	 * was experiencing issues putting it in controller 
	 *
     * Retrieve map data from Google Static Maps.
     * Based on method supplied by David Wakeling.
     */
    private byte[] readData() {
		byte[] response = null;
        String url = (
                "https://maps.googleapis.com/maps/api/staticmap?center=" 
                + getLatitude() + "," + getLongitude()
                + "&zoom=" + getZoom()
                + "&size=500x500" 
				+ "&key=AIzaSyBfZkuFHznqWYthnTcstRKpN8Ia6UQUzas" ////////////////////////////////////////////////
                );
        byte[] body = {};
        String[][] headers = {};
		while (response == null) {
			try {
				response = HttpConnect.httpConnect( "GET", url, headers, body );
			} catch (Exception e ) {}; //////////////////////////////////////////////////
		}
        return response;
    }

    /*
     * Write map data to file so image can be used.
     * Based on method supplied by David Wakeling.
     */
    private void writeData( String file, byte[] data ) {
        try {
            OutputStream os = new FileOutputStream( file );
            os.write( data, 0, data.length );
            os.close();
        } catch ( IOException e ) {
            //e.printStackTrace(); // CHANGE ////////////////////////////////////////////////////
			System.out.println("H");
        }
    }
	
	public void updateMap() {
		String output = "map.png"; ///////////////////////////////////////////////
		writeData( output, this.readData() ); 
		setMap(new ImageIcon(output));
	}
	
	 /*
     * Renews the access token for the API
     * WRITTEN BY DAVID WAKELING, 2018
     */
    static String renewAccessToken( ) {
       final byte[] body = {}; 
       final String[][] headers
          = { { "Ocp-Apim-Subscription-Key", "c7a58cbdf5544b41bd33fe3226a553b1"                          }
            , { "Content-Length"           , String.valueOf( body.length ) }
            };
       byte[] response = HttpConnect.httpConnect( "POST" , "https://api.cognitive.microsoft.com/sts/v1.0/issueToken", headers, body );
       return new String( response ); 
    }
    
    /*
     * Creates a sound file with some given text in a given accent
     * WRITTEN BY DAVID WAKELING, 2018
     * edited by Tilly for more specific use
     */
    static void createSoundFile(String token, String text, String lang) {
        String artist = "(en-GB, Susan, Apollo)";
      
        final byte[] body
          = ( "<speak version='1.0' xml:lang='en-us'>"
            + "<voice xml:lang='" + lang   + "' "
            + "xml:gender='"      + "Female" + "' "
            + "name='Microsoft Server Speech Text to Speech Voice "
            + artist + "'>"
            + text
            + "</voice></speak>" ).getBytes(); 
        final String[][] headers
          = { { "Content-Type"             , "application/ssml+xml"        }
            , { "Content-Length"           , String.valueOf( body.length ) }
            , { "Authorization"            , "Bearer " + token             }
            , { "X-Microsoft-OutputFormat" , "riff-16khz-16bit-mono-pcm"                        }
            };
        byte[] buffer = HttpConnect.httpConnect( "POST", "https://speech.platform.bing.com/synthesize", headers, body );
        
        try {
          File             file = new File( FILENAME );
          FileOutputStream fos  = new FileOutputStream( file );
          DataOutputStream dos  = new DataOutputStream( fos ); 
          dos.write( buffer );
          dos.flush();
          dos.close();
        } catch ( Exception ex ) {
          System.out.println( ex ); 
          System.out.println("There has been a problem in the creation of the sound file. Close application and try again or alert the developer of the above exception.");
        }
    }
    
    /*
    * This function creates a url to be passed into the google directions JSON.
    * Written by Tilly Porthouse
    */
    public String createURL() {
        String url = new String();
        try {
          String lat = latitude;
          String lon = longitude;
             
          String encDestination = URLEncoder.encode( destination, "UTF-8" );
          String language = languages.get(currentLanguageCount);
          
          //fortunately the directions API just needs the first two characters of these language inputs used in the speech api.
          language = language.substring(0,2); 
          
          url 
            = ( "https://maps.googleapis.com/maps/api/directions/json"
              + "?" + "origin"      + "=" + lat + "," + lon 
              + "&" + "destination" + "=" + encDestination
              + "&" + "key"         + "=" + "AIzaSyDaX_hkPxn_qxqMENGZEeSZWX5-Qkcjk8Y" //key can only be used 2500 times a day
              + "&" + "mode"        + "=" + travelMode
              + "&" + "language"    + "=" + languages.get(currentLanguageCount)
              );
         
        } catch ( Exception ex ) {
          System.out.println( ex );  
          System.out.println("There has been a problem in the getting of directions. Reopen the application and try to be more specific with the destination.");
          System.out.println("It's possible that you have ran out of requests as there can only be 2500 direction requests per day.");
        }
         return url;
    } 
    
    /*
     * This function checks to see whether the current coordinates are close enough to the destination.
     * In this function, the destination may be the final destination of the place the next instructions are given.
     * Written by Tilly Porthouse
     */
    public boolean checkWithinGPSBoundaries(double currentX, double currentY, double destinationX, double destinationY){
        double distance = Haversine.distance(currentX, currentY, destinationX, destinationY);
    
        if (distance <= radiusOfDestination){
            return true;
        } else {
            return false;
        }
    }
    
     /*
     * This function updates the directions from the current lang and long to the given destination, using the google directions API.
     * Written by Tilly Porthouse
     */
    public void updateDirections(){
        String url = createURL(longitude, latitude , destination, region , travelMode );
        JsonReader jr = new JsonReader(url);
        try {
            directions = jr.readDirections();
        } catch (Exception ex) {
            System.out.println( ex );  
            System.out.println("There has been a problem in the reading of directions. Reopen the application and try again.");
        }
        
    }
    
    /*
     * This function returns the length of the entire trip.
     * Written by Tilly Porthouse
    */
    public double getRouteLength(){
        double length = 0;
        String disStr = new String();
        for (Direction dir : directions){
            disStr = dir.getDistance();
            length += Double.parseDouble(disStr);
        }
      
        return length;
    }
    
    /*
     * This function returns the length of the trip taken so far, from the starting destination to the last instruction.
     * Written by Tilly Porthouse
     */
    public double getRouteLengthSoFar(){
        double length = 0;
        String disStr = new String();
        int runningDirCount = 0;
        for (Direction dir : directions){
            if (runningDirCount < dirCount){
                disStr = dir.getDistance();
                length += Double.parseDouble(disStr);
            }
        }
        
        return length;
    }
    
     /*
     * This function returns the length of the trip taken so far, from the starting destination to the last instruction.
     * Written by Tilly Porthouse
     */
    public void playDirectionsUntilAtDestination(){
        //directions is an ArrayList of directions from the google directions API. The directions represent the route from the starting position to the final destination.
        updateDirections();
        
        //stepReached stores whether the next direction has been reached yet
        boolean stepReached = false; 
        
        for (Direction dir : directions){ //for every direction in the directions array
            
            //the direction count increases by one as the next direction has been reached and stepReached is set back to false
            dirCount += 1;
            stepReached = false;
            
            //the instruction for the next direction is retrieved 
            String instruction = dir.getInstruction();
            
            //the instruction is sent to the microsoft Speech API to update the output.wav file to the most recent direction
            String token = renewAccessToken(); 
            createSoundFile(token, instruction, languages.get(currentLanguageCount));
            
            //the sound file (that has just been updated) is played
            SoundFileReader sfr = new SoundFileReader();
            sfr.playFile(FILENAME);
           
            //get the coordinates for the goal of the current direction
            String stepDestinationXStr = dir.getEndLongitude();
            double stepDestinationX = Double.parseDouble(stepDestinationXStr);
            String stepDestinationYStr = dir.getEndLatitude();
            double stepDestinationY = Double.parseDouble(stepDestinationYStr);
            
            while (!stepReached){ //while the next step hasn't been reached
                
                //waits 2 seconds until checks to see whether destination is found
                try{
                    TimeUnit.SECONDS.sleep(2); 
                } catch (Exception ex) {
                    System.out.println( ex ); 
                    System.out.println("There has been a problem in waiting two seconds. Close application and try again or alert the developer of the above exception.");
                }
                
                //get the current gps coords
                String currentXStr = longitude;
                double currentX = Double.parseDouble(currentXStr);
                String currentYStr = latitude;
                double currentY = Double.parseDouble(currentYStr);
                
                //check whether the current coords are close enough to the step destination, this line usually sets stepReached to false
                stepReached = checkWithinGPSBoundaries(currentX, currentY, stepDestinationX, stepDestinationY);
            }
        }
       
    }
}
