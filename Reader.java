/**
 * @version 23/03/18
 * @author Faith Yemofio
 */

/**
 * program is a prototype of the meter readers in trip computer mode and implements the planed functionality of the meter readers
 */

//package Reader imports the java swing package so the class Reader can use text displays

import javax.swing.JTextField;

import javax.swing.ImageIcon;

import javax.swing.JFrame;

import javax.swing.JLabel;

import java.util.Random;

//class Reader extends the jFrame class so the class Reader can use text displays

public class Reader extends JFrame
{	
	private static Random randomNumberGenerator = new Random ();
		
	private static String string1 =  Integer.toString (randomNumberGenerator.nextInt (30));
		
	private static String string2 =  Integer.toString (randomNumberGenerator.nextInt (112));
		
	private static String string3 = Integer.toString (randomNumberGenerator.nextInt (60));
	
	private static String string4 = Integer.toString (randomNumberGenerator.nextInt (60));
			
	public final JTextField field1 = new JTextField ("trip odometer");
	
	public final JTextField field2 = new JTextField (string1 + " KM");
		
	public final JTextField field3 = new JTextField ("speed");
	
	public final JTextField field4 = new JTextField (string2 + " KM/H");
		
	public final JTextField field5 = new JTextField ("moving time");
	
	public final JTextField field6 = new JTextField (string3 + " min " + string4 + " sec");
	
	//sets up the class so the meter readers can be displayed on the screen
	//displays the trip odometer, speed and moving time in the displays on the meter readers on the screen
	
	public Reader ()
	{
		setTitle ("Trip Computer");
				
		setContentPane (new JLabel (new ImageIcon ("img/background3.png")));
		
		setLayout (null);
				
		field1.setHorizontalAlignment (JTextField.CENTER);
		
		field1.setBounds (16, 17, 208, 25);
		
		add (field1);
				
		field2.setHorizontalAlignment (JTextField.CENTER);
		
		field2.setBounds (16, 64, 208, 25);
		
		add (field2);
				
		field3.setHorizontalAlignment (JTextField.CENTER);
		
		field3.setBounds (16, 115, 208, 25);
		
		add (field3);
		
		field4.setHorizontalAlignment (JTextField.CENTER);
		
		field4.setBounds (16, 162, 208, 25);
		
		add (field4);
		
		field5.setHorizontalAlignment (JTextField.CENTER);
		
		field5.setBounds (16, 213, 208, 25);
		
		add (field5);
		
		field6.setHorizontalAlignment (JTextField.CENTER);
		
		field6.setBounds (16, 257, 208, 25);
		
		add (field6);
	}
	
	//displays the meter readers on the screen
	
	public static void main (String [] array)
	{		
		JFrame frame = new Reader ();
		
		frame.setLocationRelativeTo (null);
		
		frame.setSize (240, 321);
		
		frame.setResizable (false);
		
		frame.setVisible (true);
	}
}