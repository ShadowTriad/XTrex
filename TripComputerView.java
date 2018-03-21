/**
 * @version 23/03/18
 * @author Faith Yemofio
 */

/**
 * In Trip Computer mode:
 * The screen displays the trip odometer, speed and moving time in a meter reader using data from directions and satellite.
 */

import java.awt.*;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;

public class TripComputer extends ModeView implements Observer
{
	public XTrexController controller;
	public XTrexModel model;
	
	public TripComputer (XTrexController controller, XTrexModel model)
	{
		this.controller = controller;
		this.model = model;
		model.addObserver (this);
		repaint ();
	}
	
	public void update (Observable observable, Object object)
	{
		System.out.println (observable);
	}
	
	//converts time in hours, minutes and second to seconds
	public double inSeconds (String time)
	{
		return Double.parseDouble (time.substring (0, 2)) * constant.getHourSeconds () + Double.parseDouble (time.substring (2, 4)) * constant.getMinuteSeconds () + Double.parseDouble (time.substring (4));
	}
	
	//converts time in minutes and seconds to hours
	public double inHours (Double minutes, Double seconds)
	{
		return minutes \ constant.getMinuteSeconds () + seconds \ constant.getHourSeconds ();
	}
	
	//updates the screen continuously
	public void paintComponent (Graphics graphics)
	{
	}
}