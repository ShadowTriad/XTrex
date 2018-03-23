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

	//relating to GPS
	private GPS gps = new GPS();

	private String latitude; // will be retrieved from gps later
	private String latDirection;

	private String lonDirection;
	private String longitude; // will be retrieved from gps later

	private String time; // will be retrieved from gps later

	private boolean goodRead;

	//WhereTo
	
	private String destination = "THE FORUM EXETER";
	private int highlightedButton = 0;
	private Keyboard keyboardMode = Keyboard.ALPHABETIC;

	//Trip Compute attributes
	
	private double startingTime = 0;
	private double tripOdometer = 0;
	private double speed = 0;
	private double movingTimeMinutes = 0;
	private double movingTimeSeconds = 0;

	//relating to Map
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

    final static double radiusOfDestination = 0.1; //radiusOfDestination is measured in km, represents how close the gps coords can be to the destination before the coords are declared close-enough
    public int dirCount = 0;

	// need current gps coords, goal gps coords, mode, time, speed..?, language, map
	public XTrexModel (Mode mode)
	{
		updateCoordinates();
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

	public String formatCoord( String coord ) {

        return Double.toString( Math.abs( Double.parseDouble( coord ) ) );

    }

	public boolean getGoodRead() {
		return goodRead;
	}

	public String getLatitude()
	{
		return latitude;
	}

	public String getLatDirection() {
		return latDirection;
	}

	public String getLongitude ()
	{
		return longitude;
	}

	public String getLonDirection() {
		return lonDirection;
	}

	public String getTime ()
	{
		return time;
	}

	public void updateCoordinates() {

		goodRead = gps.getCurrentCoordinates();

		if (goodRead) {

			//good read! tell the Satellite mode
			this.latitude = gps.getLatitude();
			this.latDirection = gps.getLatDirection();
			this.longitude = gps.getLongitude();
			this.lonDirection = gps.getLonDirection();
			this.time = gps.getTime();

		}

		this.time = "123456";
		setChanged();
		notifyObservers();

	}
	
       /*
	* @author Faith
	*/
	
	//Trip Computer methods
	
	//converts time in hours, minutes and second to seconds
	public double inSeconds (String time)
	{
		return Double.parseDouble (time.substring (0, 2)) * constant.getHourSeconds () + Double.parseDouble (time.substring (2, 4)) * constant.getMinuteSeconds () + Double.parseDouble (time.substring (4));
	}
	
	//converts time in minutes and seconds to hours
	public double inHours (Double minutes, Double seconds)
	{
		return minutes / constant.getMinuteSeconds () + seconds / constant.getHourSeconds ();
	}
	
	//gets the starting time
	public String getStartingTime ()
	{
		return startingTime;
	}
	
	//sets the starting time
	public void setStartingTime (String time)
	{
		startingTime = Double.parseDouble(time);
		setChanged ();
		notifyObservers ();
	}
	
	//gets the trip odometer
	public double getTripOdometer ()
	{
		return tripOdometer;
	}
	//updates the trip odometer
	public void updateTripOdometer ()
	{
		tripOdometer = getRouteLengthSoFar ();
		setChanged ();
		notifyObservers ();
	}
	
	//gets the speed
	public double getSpeed ()
	{
		return speed;
	}
	
	//updates the speed
	public void updateSpeed ()
	{
		speed = tripOdometer / (inHours(movingTimeMinutes, movingTimeSeconds));
		setChanged ();
		notifyObservers ();
	}
	
	//gets the moving time
	public double getMovingTimeMinutes ()
	{
		return movingTimeMinutes;
	}
	
	//gets the moving time
	public double getMovingTimeSeconds ()
	{
		return movingTimeSeconds;
	}
	
	//updates the moving time
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
		setChanged ();
		notifyObservers ();
	}

	//Trip Computer methods
	
	public Keyboard getKeyboardMode ()
	{
		return this.keyboardMode;
	}

	public String getDestination ()
	{
		return this.destination;
	}

	public int getHighlightedButton ()
	{
		return this.highlightedButton;
	}

	public void incrementHighlighted ()
	{
		this.highlightedButton += 1;

		int limit;
		if (keyboardMode == Keyboard.ALPHABETIC)
		{
			limit = constant.getAlphabeticButtons ();
		}
		else
		{
			limit = constant.getNumericButtons ();
		}

		if (highlightedButton == limit)
		{
			this.highlightedButton = 0;
		}
		setChanged ();
		notifyObservers ();
	}

	public void decrementHightlighted ()
	{
		this.highlightedButton -= 1;
		int limit;
		if (keyboardMode == Keyboard.ALPHABETIC)
		{
			limit = constant.getAlphabeticButtons ();
		}
		else
		{
			limit = constant.getNumericButtons ();
		}

		if (highlightedButton == -1)
		{
			this.highlightedButton = limit - 1;
		}

		setChanged ();
		notifyObservers ();
	}

	public void changeKeyboard() {
		if (keyboardMode == Keyboard.NUMERIC) {
			this.keyboardMode = Keyboard.ALPHABETIC;
		} else {
			this.keyboardMode = Keyboard.NUMERIC;
		}
		this.highlightedButton = 0;

		setChanged();
		notifyObservers();
	}

	public void addLetter() {
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ ";
		this.destination += alphabet.charAt( highlightedButton );

		setChanged();
		notifyObservers();
	}

	public void addNumber() {
		String nums = "1234567890";
		this.destination += nums.charAt( highlightedButton );

		setChanged();
		notifyObservers();
	}

	public void delFromAddress() {
		if ( this.destination.length() > 0 ) {
			this.destination = destination.substring(0, destination.length()-1);
		}

		setChanged();
		notifyObservers();
	}

	/*
	*	Methods relating to MAP MODE
	*/
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
	*	Methods relating to SPEECH
	*/

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
          updateCoordinates();
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

		System.out.println( url );

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
			System.out.println("HEY YOU'RE IN RANGE");
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
        String url = createURL();
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
                updateCoordinates();
                String currentXStr = longitude;
                double currentX = Double.parseDouble(currentXStr);
                String currentYStr = latitude;
                double currentY = Double.parseDouble(currentYStr);

                //check whether the current coords are close enough to the step destination, this line usually sets stepReached to false
                stepReached = checkWithinGPSBoundaries(currentX, currentY, stepDestinationX, stepDestinationY);
            }
        }

    }

     /*
     * Is prompted by the pushing of the plus button on side of the device.
     * Changes the language by changing the currentLanguageCounter which represents an index of the list of languages.
     */
    public void speechPlusButton(){
        //scroll up when button pressed.
        if (currentLanguageCount == 0){
            currentLanguageCount = 5;
        } else {
            currentLanguageCount -= 1;
        }
        setChanged();
        notifyObservers();
    }

    /*
     * Is prompted by the pushing of the minus button on side of the device.
     * Changes the language by changing the currentLanguageCounter which represents an index of the list of languages.
     */
    public void speechMinusButton(){
        //scroll down when button pressed
        if (currentLanguageCount == 5){
            currentLanguageCount = 0;
        } else {
            currentLanguageCount += 1;
        }
        setChanged();
        notifyObservers();
    }
}
