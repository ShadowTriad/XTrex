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

//extends ModeView and implements Observer so the class can use model view controller
public class TripComputer extends ModeView implements Observer
{
	public XTrexController controller;
	public XTrexModel model;
	
	//sets up the view
	public TripComputer (XTrexController controller, XTrexModel model)
	{
		this.controller = controller;
		this.model = model;
		model.addObserver (this);
	}
	
	//updates the view
	public void update (Observable observable, Object object)
	{
		System.out.println (observable);
	}
	
	//updates the screen
	public void paintComponent (Graphics graphics)
	{
		graphics.setColor(Color.black);
		graphics.fillRect(0, 0, mode.getConstant.getXTrexWidth (), mode.getConstant.getXTrexHeight ());
		(new ImageIcon (mode.getConstant.getMeterBackground ())).paintIcon(this, graphics, 0, mode.getConstant.getTripComputerBackgroundRow ());
		graphics.setColor (Color.black);	
		graphics.setFont (new Font (mode.getConstant.getTextFont (), Font.PLAIN, mode.getConstant.getTextSize ()));
		mode.updateCoordinates ();
		mode.updateTripOdometer ();
		mode.updateMovingTime ();
		mode.updateSpeed ();
		graphics.drawString (mode.getConstant.getTripOdometer (), mode.getConstant.getTripComputerTextColumn1 (), mode.getConstant.getTripComputerTextRow1 ());
		graphics.drawString (mode.getTripOdometer + mode.getConstant.getDistanceUnits (), mode.getConstant.getTripComputerTextColumn2 (), mode.getConstant.getTripComputerTextRow2 ());
		graphics.drawString (mode.getConstant.getSpeed (), mode.getConstant.getTripComputerTextColumn3 (), mode.getConstant.getTripComputerTextRow3 ());
		graphics.drawString (mode.getSpeed + mode.getConstant.getSpeedUnits (), mode.getConstant.getTripComputerTextColumn4 (), mode.getConstant.getTripComputerTextRow4 ());
		graphics.drawString (mode.getConstant.getMovingTime (), mode.getConstant.getTripComputerTextColumn5 (), mode.getConstant.getTripComputerTextRow5 ());
		graphics.drawString (mode.getMovingTimeMinutes + mode.getConstant.getTimeUnits1 () + mode.getMovingTimeSeconds + mode.getConstant.getTimeUnits2 (), mode.getConstant.getTripComputerTextColumn6 (), mode.getConstant.getTripComputerTextRow6 ());
		repaint ();
	}
}