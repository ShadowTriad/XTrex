/**
 * @version 22/02/18
 * @author Faith Yemofio
 */

import javax.swing.*;

import java.awt.*;

import static java.lang.Math.abs;

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
	
	public int getMinutes (String string)
	{
		String hours = string.substring (0, 2);
		
		String minutes = string.substring (2, 4);
		
		return Integer.parseInt (hours) * 60 + Integer.parseInt (minutes);
	}
	
	public String getSeconds (String string)
	{
		String seconds = string.substring (4);
		
		return Integer.parseInt (seconds);
	}
	
	//paint component method is used to continuously display the screen on the XTrex
	
	public void paintComponent (Graphics graphics)
	{
		String time = gps.getTime ();
		 
		movingTimeMinutes = abs (getMinutes (String time) - startingTimeMinutes)
		
		movingTimeSeconds = abs (getSeconds (String time) - startingTimeSeconds)
		
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