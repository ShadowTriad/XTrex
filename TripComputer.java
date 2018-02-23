/**
 * @version 22/02/18
 * @author Faith Yemofio
 */

import javax.swing.*;

import java.awt.*;

/**
 * In Trip Computer mode the screen displays the users trip odometer, speed and moving time.
 * At the moment the screen displays a random trip odometer, speed and moving time using default values.
 * In the future the screen will display the actual trip odometer, speed and moving time using real life data.
 */

//class TripComputer extends jPanel so the mode can be displayed on the screen of the Xtrex

class TripComputer extends JPanel
{
	//random trip odometer value
	
	private static String tripOdometer = "0.86";
	
	//random speed value
	
	private static String speed = "7.00";
	
	//random moving time value
	
	private static String movingTimeMinuites = "027";
	
	private static String movingTimeSeconds = "08";
	
	//no argument constructor sets up the mode
	
	public TripComputer ()
	{
		
	}
	
	//paint component method is used to continuously display the screen on the Xtrex
	
	public void paintComponent (Graphics graphics)
	{
		//draws the background
		
		(new ImageIcon ("img/background3.png")).paintIcon(this, graphics, 0, 27);
		
		//draws the text
				
		graphics.setColor (Color.black);
			
		graphics.setFont (new Font ("Arial", Font.PLAIN, 27));
		
		//draws the trip odometer
		
		graphics.drawString ("trip odometer", 40, 75);
		
		graphics.drawString (tripOdometer + " KM", 65, 100);
		
		//draws the speed
		
		graphics.drawString ("speed", 75, 175);
		
		graphics.drawString (speed + " KM/H", 50, 200);
		
		//draws the moving time
		
		graphics.drawString ("moving time", 45, 270);
		
		graphics.drawString (movingTimeMinuites + " min " + movingTimeSeconds + " sec", 30, 295);
		
		repaint ();
	}
}