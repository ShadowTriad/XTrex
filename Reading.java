import java.awt.Color;

import java.awt.event.MouseAdapter;

import java.awt.event.MouseEvent;

import javax.swing.JTextField;

import javax.swing.ImageIcon;

import javax.swing.JButton;

import javax.swing.JFrame;

import javax.swing.JLabel;

public class Reading extends JFrame
{
	private static String string1 = "";
	
	private static String string2 = "";
	
	private static String string3 = "";
	
	private static String string4 = "";
		
	public final JTextField field1 = new JTextField ("trip odometer");
	
	public final JTextField field2 = new JTextField (string1 + " KM");
	
	public final JTextField field3 = new JTextField ("speed");
	
	public final JTextField field4 = new JTextField (string2 + " KM/H");
	
	public final JTextField field5 = new JTextField ("moving time");
	
	public final JTextField field6 = new JTextField (string2 + " min " + string4 + " sec");
		
	public Reading ()
	{
		setTitle ("Reading");
		
		setContentPane (new JLabel (new ImageIcon ("background3.png")));
		
		setLayout (null);
		
		field1.setHorizontalAlignment(JTextField.CENTER);
		
		field1.setBounds (16, 17, 208, 25);
		
		add (field1);
		
		field2.setHorizontalAlignment(JTextField.CENTER);
		
		field2.setBounds (16, 64, 208, 25);
		
		add (field2);
		
		field3.setHorizontalAlignment(JTextField.CENTER);
		
		field3.setBounds (16, 115, 208, 25);
		
		add (field3);
		
		field4.setHorizontalAlignment(JTextField.CENTER);
		
		field4.setBounds (16, 162, 208, 25);
		
		add (field4);
		
		field5.setHorizontalAlignment(JTextField.CENTER);
		
		field5.setBounds (16, 213, 208, 25);
		
		add (field5);
		
		field6.setHorizontalAlignment(JTextField.CENTER);
		
		field6.setBounds (16, 257, 208, 25);
		
		add (field6);
	}
	
	public static void main (String [] array)
	{
		JFrame frame = new Reading ();
		
		frame.setLocationRelativeTo (null);
		
		frame.setSize (240, 321);
		
		frame.setResizable (false);
		
		frame.setVisible (true);
	}
}