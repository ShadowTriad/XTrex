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

//extends ModelView and implements Observer so the class can use model view controller
public class TripComputer extends ModelView implements Observer
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
		graphics.fillRect(0, 0, model.getConstant.getXTrexWidth (), model.getConstant.getXTrexHeight ());
		(new ImageIcon (model.getConstant.getMeterBackground ())).paintIcon(this, graphics, 0, model.getConstant.getTripComputerBackgroundRow ());
		graphics.setColor (Color.black);	
		graphics.setFont (new Font (model.getConstant.getTextFont (), Font.PLAIN, model.getConstant.getTextSize ()));
		model.updateCoordinates ();
		model.updateTripOdometer ();
		model.updateMovingTime ();
		model.updateSpeed ();
		graphics.drawString (model.getConstant.getTripOdometer (), model.getConstant.getTripComputerTextColumn1 (), model.getConstant.getTripComputerTextRow1 ());
		graphics.drawString (model.getTripOdometer + model.getConstant.getDistanceUnits (), model.getConstant.getTripComputerTextColumn2 (), model.getConstant.getTripComputerTextRow2 ());
		graphics.drawString (model.getConstant.getSpeed (), model.getConstant.getTripComputerTextColumn3 (), model.getConstant.getTripComputerTextRow3 ());
		graphics.drawString (model.getSpeed + model.getConstant.getSpeedUnits (), model.getConstant.getTripComputerTextColumn4 (), model.getConstant.getTripComputerTextRow4 ());
		graphics.drawString (model.getConstant.getMovingTime (), model.getConstant.getTripComputerTextColumn5 (), model.getConstant.getTripComputerTextRow5 ());
		graphics.drawString (model.getMovingTimeMinutes + model.getConstant.getTimeUnits1 () + model.getMovingTimeSeconds + model.getConstant.getTimeUnits2 (), model.getConstant.getTripComputerTextColumn6 (), model.getConstant.getTripComputerTextRow6 ());
		repaint ();
	}
}