import javax.swing.*;

import java.awt.*;

class TripComputer extends JPanel
{ 
	private static String tripOdometer = "0.86";
	
	private static String speed = "7.00";
	
	private static String movingTimeMinuites = "027";
	
	private static String movingTimeSeconds = "08";
	
	public TripComputer ()
	{
		
	}
	
	public void paintComponent (Graphics graphics)
	{
		graphics.setColor (Color.black);
		
		graphics.fillRect (0, 0, 240, 353);
		
		(new ImageIcon ("background3.png")).paintIcon(this, graphics, 0, 27);
			
		graphics.setFont (new Font ("Arial", Font.PLAIN, 27));
		
		graphics.drawString("trip odometer", 40, 75);
		
		graphics.drawString(tripOdometer + " KM", 65, 100);
		
		graphics.drawString("speed", 75, 175);
		
		graphics.drawString(speed + " KM/H", 50, 200);
		
		graphics.drawString("moving time", 45, 270);
		
		graphics.drawString(movingTimeMinuites + " min " + movingTimeSeconds + " sec", 30, 295);
	}
}