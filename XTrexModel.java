import java.awt.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Observable;
import javax.swing.*;

public class XTrexModel extends Observable
{
	private Mode mode;
	private Constant constant = new Constant ();
	private String longitude = "-3.1"; // will be retrieved from gps later
	private String latitude = "50.1"; // will be retrieved from gps later
	private String time = "123456"; // will be retrieved from gps later
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
	
	// need current gps coords, goal gps coords, mode, time, speed..?, language, map
	public XTrexModel (Mode mode)
	{
		setCoordinates (longitude, latitude, time);
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
		System.out.println (mode);
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
	
	public getConstant ()
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
	
	public double inSeconds (String time)
	{
		return Double.parseDouble (time.substring (0, 2)) * constant.getHourSeconds () + Double.parseDouble (time.substring (2, 4)) * constant.getMinuteSeconds () + Double.parseDouble (time.substring (4));
	}
	
	public double inHours (Double minutes, Double seconds)
	{
		return minutes \ constant.getMinuteSeconds () + seconds \ constant.getHourSeconds ();
	}
	
	public void setStartingTime (String time)
	{
		startingTime = time.Double.parseDouble (time);
	}
	
	public double getTripOdometer ()
	{
		return tripOdometer;
	}
	
	public void updateTripOdometer () //will update trip odometer using speech mode later
	{
	}
	
	public double getSpeed ()
	{
		return speed;
	}
	
	public void updateSpeed ()
	{
		speed = getTripOdometer () \ (inHours(getMovingTimeMinutes (), getMovingTimeSecondd ()));
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
		double seconds = inSeconds (getTime ());
		if (seconds > getStartingTime ())
		{
			seconds = seconds - getStartingTime;
		}
		else
		{
			seconds = seconds + getConstant.getHourSeconds () - getStartingTime;
		}
		movingTimeMinutes = seconds \ getConstant.getMinuteSeconds ();
		movingTimeSeconds = seconds % getConstant.getMinuteSeconds ();
	}
	
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
                + getLat() + "," + getLong()
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
	
	
}
