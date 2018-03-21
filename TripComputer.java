/**
 * @version 23/03/18
 * @author Faith Yemofio
 */

/**
 * In Trip Computer mode:
 * The screen displays the trip odometer, speed and moving time in a meter reader using data from directions and satellite.
 */

//imports the java awt and java swing packages so the class can use screens
import java.awt.*;
import javax.swing.*;
import java.lang.Math.*;

//extends jPanel so the class can use screens
class TripComputer extends JPanel
{
	private static Constant constant = new Constant ();
	private static GPS gps = new GPS ();	
	private static Speech speech = new Speech ();
	private static double startingLongitude = 0;
	private static double startingLatitude = 0;
	private static double startingTime = 0;	
	private double tripOdometer = 0;
	private double speed = 0;
	private double movingTimeMinutes = 0;
	private double movingTimeSeconds = 0;
	
	//sets up the class so the mode can be displayed on the screen
	//sets the starting coordinates to the starting coordinate attributes
	//sets the starting time to the starting time attribute
	public TripComputer ()
	{
		startingLongitude = Double.parseDouble (gps.getLongitude ());
		startingLatitude = Double.parseDouble (gps.getLatitude ());
		startingTime = inSeconds (gps.getTime ());
	}
	
	//updates the trip odometer using directions
	public void updateTripOdometer ()
	{
		tripOdometer = speech.getRouteLengthSoFar (speech.getDirections ());
	}
	
	//updates the speed using trip odometer and moving time
	public void updateSpeed ()
	{
		speed = tripOdometer / (inHours(movingTimeMinutes, movingTimeSeconds));
	}
	
	//converts time in hours, minutes and second to seconds
	public double inSeconds (String time)
	{
		return Double.parseDouble (time.substring (0, 2)) * 3600 + Double.parseDouble (time.substring (2, 4)) * 60 + Double.parseDouble (time.substring (4));
	}
	
	//converts time in minutes and seconds to hours
	public double inHours (Double minutes, Double seconds)
	{
		return minutes / 60 + seconds / 3600;
	}
	
	//updates the moving time using time difference
	public void updateMovingTime ()
	{
		double seconds = inSeconds (gps.getTime ());
		if (seconds > startingTime)
		{
			seconds = seconds - startingTime;
		}
		else
		{
			seconds = seconds + 3600 - startingTime;
		}
		movingTimeMinutes = seconds / 60;
		movingTimeSeconds = seconds % 60;
	}
	
	//updates the screen continuously
	public void paintComponent (Graphics graphics)
	{
		updateTripOdometer ();
		updateMovingTime ();
		updateSpeed ();
		graphics.setColor(Color.black);
		graphics.fillRect(0, 0, 240, 353);
		(new ImageIcon (constant.getMeterBackground ())).paintIcon(this, graphics, 0, 27);
		graphics.setColor (Color.black);	
		graphics.setFont (new Font (constant.getTextFont (), Font.PLAIN, constant.getTextSize ()));
		graphics.drawString (constant.getTripOdometer (), 40, 75);
		graphics.drawString (tripOdometer + constant.getDistanceUnits (), 65, 100);
		graphics.drawString (constant.getSpeed (), 75, 175);
		graphics.drawString (speed + constant.getSpeedUnits (), 50, 200);
		graphics.drawString (constant.getMovingTime (), 45, 270);
		graphics.drawString (movingTimeMinutes + constant.getTimeUnits1 () + movingTimeSeconds + constant.getTimeUnits2 (), 30, 295);
		repaint ();
	}
}