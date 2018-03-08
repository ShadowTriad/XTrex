/**
 * @version 08/03/18
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

import java.util.Random;

/**
 * Reader is a simulation of Trip Computer mode and show the planed functionality of the mode.
 * In Trip Computer mode the screen displays the users trip odometer, speed and moving time.
 * At the moment the screen displays a random trip odometer, speed and moving time using default values.
 * In the future the screen will display the actual trip odometer, speed and moving time using real life data.
 */

//class Reader extends jFrame so the mode can use clickable buttons and text display

public class Reader extends JFrame
{	
	private static Random randomNumberGenerator = new Random ();
	
	//stores a random value for the trip odometer
	
	private static String string1 =  Integer.toString (randomNumberGenerator.nextInt (30));
	
	//stores a random value for the speed
	
	private static String string2 =  Integer.toString (randomNumberGenerator.nextInt (112));
	
	//stores a random value for the moving time
	
	private static String string3 = Integer.toString (randomNumberGenerator.nextInt (60));
	
	private static String string4 = Integer.toString (randomNumberGenerator.nextInt (60));
	
	//stores the trip odometer display
		
	public final JTextField field1 = new JTextField ("trip odometer");
	
	public final JTextField field2 = new JTextField (string1 + " KM");
	
	//stores the speed display
	
	public final JTextField field3 = new JTextField ("speed");
	
	public final JTextField field4 = new JTextField (string2 + " KM/H");
	
	//stores the moving time display
	
	public final JTextField field5 = new JTextField ("moving time");
	
	public final JTextField field6 = new JTextField (string3 + " min " + string4 + " sec");
	
	//sets up the class so the simulation can be displayed
	//adds the displays to the simulation
	
	public Reader ()
	{
		setTitle ("Reader");
		
		//displays the background on the simulation
		
		setContentPane (new JLabel (new ImageIcon ("img/background3.png")));
		
		setLayout (null);
		
		//displays the trip odometer on the simulation
		
		field1.setHorizontalAlignment (JTextField.CENTER);
		
		field1.setBounds (16, 17, 208, 25);
		
		add (field1);
		
		//displays the speed on the simulation
		
		field2.setHorizontalAlignment (JTextField.CENTER);
		
		field2.setBounds (16, 64, 208, 25);
		
		add (field2);
		
		//displays the moving time on the simulation
		
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
		//creates a simulation and displays the simulation
		
		JFrame frame = new Reader ();
		
		frame.setLocationRelativeTo (null);
		
		frame.setSize (240, 321);
		
		frame.setResizable (false);
		
		frame.setVisible (true);
	}
}