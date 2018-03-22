/**
 * @version 23/03/18
 * @author Faith Yemofio
 */

/**
 * In Trip Computer mode:
 * The screen displays the trip odometer, speed and moving time in a meter reader using data from directions and satellite.
 */

//imports the java awt, java swing and java util packages so the class can use model view controller
import java.awt.*;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;

//extends JPanel and implements Observer so the class can use screens and views
public class TripComputerView extends JPanel implements Observer
{
	private XTrexController controller;
	private XTrexModel model;
	private Constant constant;
	private double tripOdometer = 0;
	private double speed = 0;
	private double movingTimeMinutes = 0;
	private double movingTimeSeconds = 0;
	
	//sets up the view
	public TripComputerView (XTrexController controller, XTrexModel model)
	{
		this.controller = controller;
		this.model = model;
		constant = model.getConstant ();
		tripOdometer = model.getTripOdometer ();
		speed = model.getSpeed ();
		movingTimeMinutes = model.getMovingTimeMinutes ();
		movingTimeSeconds = model.getMovingTimeSeconds ();
		model.addObserver (this);
	}
	
	//updates the view
	public void update (Observable observable, Object object)
	{
		tripOdometer = model.getTripOdometer ();
		speed = model.getSpeed ();
		movingTimeMinutes = model.getMovingTimeMinutes ();
		movingTimeSeconds = model.getMovingTimeSeconds ();
		repaint ();
	}
	
	//updates the screen
	public void paintComponent (Graphics graphics)
	{
		graphics.setColor(Color.black);
		graphics.fillRect(0, 0, constant.getXTrexWidth (), constant.getXTrexHeight ());
		(new ImageIcon (constant.getMeterBackground ())).paintIcon(this, graphics, 0, constant.getTripComputerBackgroundRow ());
		graphics.setColor (Color.black);	
		graphics.setFont (new Font (constant.getTextFont (), Font.PLAIN, constant.getTextSize ()));
		graphics.drawString (constant.getTripOdometer (), constant.getTripComputerTextColumn1 (), constant.getTripComputerTextRow1 ());
		graphics.drawString (tripOdometer + constant.getDistanceUnits (), constant.getTripComputerTextColumn2 (), constant.getTripComputerTextRow2 ());
		graphics.drawString (constant.getSpeed (), constant.getTripComputerTextColumn3 (), constant.getTripComputerTextRow3 ());
		graphics.drawString (speed + constant.getSpeedUnits (), constant.getTripComputerTextColumn4 (), constant.getTripComputerTextRow4 ());
		graphics.drawString (constant.getMovingTime (), constant.getTripComputerTextColumn5 (), constant.getTripComputerTextRow5 ());
		graphics.drawString (movingTimeMinutes + constant.getTimeUnits1 () + movingTimeSeconds + constant.getTimeUnits2 (), constant.getTripComputerTextColumn6 (), constant.getTripComputerTextRow6 ());
	}
}