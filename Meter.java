/**
 * @version 23/03/18
 * @author Faith Yemofio
 */

/**
 * program is a prototype of the meter readers in trip computer mode and implements the planed functionality of the meter readers
 */

//package Meter imports the java swing package so the class Meter can use text displays
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.util.Random;

//class Meter extends the jFrame class so the class Meter can use text displays
public class Meter extends JFrame
{
	public static Constant constant = new Constant ();
	public final Random randomNumberGenerator = new Random ();
	public final String string1 = Integer.toString (randomNumberGenerator.nextInt (30));
	public final String string2 = Integer.toString (randomNumberGenerator.nextInt (120));
	public final String string3 = Integer.toString (randomNumberGenerator.nextInt (60));
	public final String string4 = Integer.toString (randomNumberGenerator.nextInt (60));	
	public final JTextField field1 = new JTextField (constant.getTripOdometer ());
	public final JTextField field2 = new JTextField (string1 + constant.getDistanceUnits ());
	public final JTextField field3 = new JTextField (constant.getSpeed ());
	public final JTextField field4 = new JTextField (string2 + constant.getSpeedUnits ());
	public final JTextField field5 = new JTextField (constant.getMovingTime ());
	public final JTextField field6 = new JTextField (string3 + constant.getTimeUnits1 () + string4 + constant.getTimeUnits2 ());
	
	//sets up the class so the meter readers can be displayed on the screen
	//displays the trip odometer, speed and moving time in the displays on the meter readers on the screen
	public Meter ()
	{
		setTitle (constant.getTripComputer ());
		setContentPane (new JLabel (new ImageIcon (constant.getMeterBackground ())));
		setLayout (null);
		field1.setHorizontalAlignment (JTextField.CENTER);
		field1.setBounds (constant.getMeterColumn1 (), constant.getMeterRow1 (), constant.getMeterWidth1 (), constant.getMeterHeight1 ());
		add (field1);
		field2.setHorizontalAlignment (JTextField.CENTER);
		field2.setBounds (constant.getMeterColumn1 (), constant.getMeterRow2 (), constant.getMeterWidth1 (), constant.getMeterHeight1 ());
		add (field2);
		field3.setHorizontalAlignment (JTextField.CENTER);
		field3.setBounds (constant.getMeterColumn1 (), constant.getMeterRow3 (), constant.getMeterWidth1 (), constant.getMeterHeight1 ());
		add (field3);
		field4.setHorizontalAlignment (JTextField.CENTER);
		field4.setBounds (constant.getMeterColumn1 (), constant.getMeterRow4 (), constant.getMeterWidth1 (), constant.getMeterHeight1 ());
		add (field4);
		field5.setHorizontalAlignment (JTextField.CENTER);
		field5.setBounds (constant.getMeterColumn1 (), constant.getMeterRow5 (), constant.getMeterWidth1 (), constant.getMeterHeight1 ());
		add (field5);
		field6.setHorizontalAlignment (JTextField.CENTER);
		field6.setBounds (constant.getMeterColumn1 (), constant.getMeterRow6 (), constant.getMeterWidth1 (), constant.getMeterHeight1 ());
		add (field6);
	}
	
	//displays the meter readers on the screen
	public static void main (String [] array)
	{		
		JFrame frame = new Meter ();
		frame.setLocationRelativeTo (null);
		frame.setSize (constant.getTripComputerWidth (), constant.getTripComputerHeight ());
		frame.setResizable (false);
		frame.setVisible (true);
	}
}