/**
 * @version 08/03/18
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
	
	//stores the starting coordinate
	
	private static double startingLongitude = 0;
	
	private static double startingLatitude = 0;
	
	//stores the trip odometer
	
	private static double tripOdometer = 0;
	
	//stores the speed
	
	private static double speed = 0;
	
	//stores the starting time
	
	private static double startingTimeMinutes = 0;
	
	private static double startingTimeSeconds = 0;
	
	//stores the moving time
	
	private static double movingTimeMinutes = 0;
	
	private static double movingTimeSeconds = 0;
	
	//sets up the class so the mode can be displayed on the screen of the XTrex
	//sets the starting coordinate to the starting coordinate attribute
	//sets the starting time to the starting time attribute
	
	public TripComputer ()
	{
		String longitude = gps.getLongitude ();
		
		String latitude = gps.getLatitude ();
		
		startingLongitude = Double.parseDouble (longitude);
		
		startingLatitude = Double.parseDouble (latitude);
		
		String time = gps.getTime ();
		
		startingTimeMinutes = getMinutes (time);
		
		startingTimeSeconds = getSeconds (time);
	}
	
	//updateTripOdometer method is used to update the trip odometer
	//uses the haversine formula to compute the shortest distance over a spherical approximation of the Earth's surface between the starting position and the current position
	
	public void updateTripOdometer ()
	{
		String longitude = gps.getLongitude ();
		
		String latitude = gps.getLatitude ();
		
		double differenceLongitude = Math.toRadians(Double.parseDouble (longitude) - startingLongitude);
		
		double differenceLatitude = Math.toRadians(Double.parseDouble (latitude) - startingLatitude);
		
		double odometer = Math.pow (Math.sin (differenceLatitude / 2), 2) + Math.cos (startingLatitude) * Math.cos (Double.parseDouble(latitude)) * Math.pow (Math.sin (differenceLongitude / 2), 2);
		
		tripOdometer = 6371 * 2 * Math.atan2 (Math.sqrt (odometer), Math.sqrt (1 - odometer));
	}
	
	//updateSpeed method is used to update the speed
	//uses the equation speed = distance / time to compute an approximation of the speed
	
	public void updateSpeed ()
	{
		speed = tripOdometer / (movingTimeMinutes / 60 + movingTimeSeconds / 3600);
	}
	
	//getMinutes method is used to compute the minutes of a time
	//uses the hours and minutes of a time
		
	public double getMinutes (String time)
	{
		String hours = time.substring (0, 2);
		
		String minutes = time.substring (2, 4);
		
		return Double.parseDouble (hours) * 60 + Double.parseDouble (minutes);
	}
	
	//getSeconds method is used to compute the seconds of a time 
	//uses the seconds of a time
	
	public double getSeconds (String time)
	{
		String seconds = time.substring (4);
		
		return Double.parseDouble (seconds);
	}

	
	//updateMovingTime method is used to update the moving time
	//uses the equation Δtime = ending time - starting time to compute an approximation of the elapsed time
	
	public void updateMovingTime ()
	{
		String time = gps.getTime ();
				
		double minutes = getMinutes (time);
		
		double seconds = getSeconds (time);
		
		if (minutes > startingTimeMinutes)
		{
			movingTimeMinutes = minutes - startingTimeMinutes;
		}
		
		else
		{
			movingTimeMinutes = minutes + 24 * 60 - startingTimeMinutes;
		}
		
		movingTimeSeconds = seconds - startingTimeSeconds;
	}
		
	//paint component method is used to continuously display the screen on the XTrex
	
	public void paintComponent (Graphics graphics)
	{
		//updates the trip odometer
				
		updateTripOdometer ();
		
		//updates the moving time
		
		updateMovingTime ();
		
		//updates the speed
		
		updateSpeed ();
		
		//draws the background on the screen
		
		graphics.setColor(Color.black);
		
		graphics.fillRect(0, 0, 240, 353);
		
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