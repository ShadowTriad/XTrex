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

//class TripComputer extends jPanel so the mode can be displayed on the screen of the XTrex

class TripComputer extends JPanel
{
	//stores a random value for the trip odometer
	
	private static String tripOdometer = "0.86";
	
	//stores a random value for the speed
	
	private static String speed = "7.00";
	
	//stores a random value for the moving time
	
	private static String movingTimeMinutes = "027";
	
	private static String movingTimeSeconds = "08";
	
	//sets up the class so the mode can be displayed on the screen of the XTrex
	
	public TripComputer ()
	{
		
	}
	
	//paint component method is used to continuously display the screen on the XTrex
	
	public void paintComponent (Graphics graphics)
	{
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