/**
 * @version 22/02/18
 * @author Faith Yemofio
 */

import java.awt.Color;

import java.awt.event.MouseAdapter;

import java.awt.event.MouseEvent;

import javax.swing.JTextField;

import javax.swing.ImageIcon;

import javax.swing.JButton;

import javax.swing.JFrame;

import javax.swing.JLabel;

/**
 * Reader is a simulation of Trip Computer mode and show the planed functionality of the mode.
 * In Trip Computer mode the screen displays the users trip odometer, speed and moving time.
 * At the moment the screen displays a random trip odometer, speed and moving time using default values.
 * In the future the screen will display the actual trip odometer, speed and moving time using real life data.
 */

//class Reader extends jFrame so the mode can use clickable buttons

public class Reader extends JFrame
{
	//stores a random value for the trip odometer
	
	private static String string1 = "0.86";
	
	//stores a random value for the speed
	
	private static String string2 = "7.00";
	
	//stores a random value for the moving time
	
	private static String string3 = "27";
	
	private static String string4 = "8";
	
	//displays the trip odometer
		
	public final JTextField field1 = new JTextField ("trip odometer");
	
	public final JTextField field2 = new JTextField (string1 + " KM");
	
	//displays the speed
	
	public final JTextField field3 = new JTextField ("speed");
	
	public final JTextField field4 = new JTextField (string2 + " KM/H");
	
	//displays the moving time 
	
	public final JTextField field5 = new JTextField ("moving time");
	
	public final JTextField field6 = new JTextField (string2 + " min " + string4 + " sec");
	
	//sets up the class so the simulation can be displayed
	
	public Reader ()
	{
		setTitle ("Reader");
		
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
	
	//displays the simulation
	
	public static void main (String [] array)
	{
		JFrame frame = new Reader ();
		
		frame.setLocationRelativeTo (null);
		
		frame.setSize (240, 321);
		
		frame.setResizable (false);
		
		frame.setVisible (true);
	}
}