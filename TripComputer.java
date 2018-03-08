/**
 * @version 22/02/18
 * @author Faith Yemofio
 */

import javax.swing.*;

import java.awt.*;

import java.lang.Math.*;

/**
 * In Trip Computer mode the screen displays the users trip odometer, speed and moving time.
 * At the moment the screen displays a random trip odometer, speed and moving time using default values.
 * In the future the screen will display the actual trip odometer, speed and moving time using real life data.
 */

//class TripComputer extends jPanel so the mode can be displayed on the screen of the XTrex

class TripComputer extends JPanel
{
	private static GPS gps = new GPS ();
	
	private static int startingLatitude = 0;
	
	private static int startingLongitude = 0;
		
	private static int tripOdometer = 0;
		
	private static int speed = 0;
		
	private static int startingTimeMinutes = 0;
	
	private static int startingTimeSeconds = 0;
	
	private static int movingTimeMinutes = 0;
	
	private static int movingTimeSeconds = 0;
	
	//sets up the class so the mode can be displayed on the screen of the XTrex
	
	public TripComputer ()
	{
		string latitude = gps.getLatitude ();
		
		string longitude = gps.getLongitude ();
		
		startingLatitude = Integer.parseInt (latitude);
		
		startingLongitude = Integer.parseInt (longitude);
		
		String time = gps.getTime ();
		
		startingTimeMinutes = getMinutes (time)
		
		startingTimeSeconds = getSeconds (time)
	}
	
	public int getOdometer (String latitude, String longitude)
	{
		String differenceLatitude = (Integer.parseInt (latitude) - Integer.parseInt (startingLatitude)).toRadians ();
		
		String differenceLongitude = (Integer.parseInt (longitude) - Integer.parseInt (startingLongitude)).toRadians ();
		
		odometer = Math.sin (differenceLatitude / 2) * Math.sin (differenceLatitude / 2) + Math.cos (startingLatitude) * Math.cos (latitude) * Math.sin (differenceLongitude / 2) * Math.sin (differenceLongitude / 2)
	}
	
	public int getMinutes (String time)
	{
		String hours = time.substring (0, 2);
		
		String minutes = time.substring (2, 4);
		
		return Integer.parseInt (hours) * 60 + Integer.parseInt (minutes);
	}
	
	public String getSeconds (String time)
	{
		String seconds = time.substring (4);
		
		return Integer.parseInt (seconds);
	}
	
	//paint component method is used to continuously display the screen on the XTrex
	
	public void paintComponent (Graphics graphics)
	{
		string latitude = gps.getLatitude ();
		
		string longitude = gps.getLongitude ();
		
		tripOdometer = tripOdometer (latitude, longitude)
		
		String time = gps.getTime ();
				
		int minutes = getMinutes (String time);
		
		int seconds = getSeconds (String time);
		
		if (minutes > startingTimeMinutes)
		{
			movingTimeMinutes = minutes - startingTimeMinutes;
			
			movingTimeSeconds = seconds - startingTimeSeconds;
		}
		
		else
		{
			movingTimeMinutes = minutes + 24 * 60 - startingTimeMinutes;
			
			movingTimeSeconds = seconds + 24 * 3600 - startingTimeSeconds;
		}
		
		speed = tripOdometer / (movingTimeMinutes / 60 + movingTimeSeconds / 3600)
		
		graphics.setColor(Color.black);
		
		graphics.fillRect(0, 0, 240, 353);
		
		//draws the background on the screen
		
		(new ImageIcon ("img/background3.png")).paintIcon(this, graphics, 0, 27);
		
		//draws the text on the screen
				
		graphics.setColor (Color.black);
			
		graphics.setFont (new Font ("Arial", Font.PLAIN, 27));
		
		//draws the trip odometer on the screen
		
		graphics.drawString ("trip odometer", 40, 75);
		
		graphics.drawString (tripOdometer + " KM", 65, 100);
		
		//draws the speed on the screen
		
		graphics.drawString ("speed", 75, 175);
		
		graphics.drawString (speed + " KM/H", 50, 200);
		
		//draws the moving time on the screen
		
		graphics.drawString ("moving time", 45, 270);
		
		graphics.drawString (movingTimeMinutes + " min " + movingTimeSeconds + " sec", 30, 295);
		
		//continuously redraws the screen on the Xtrex
		
		repaint ();
	}
}