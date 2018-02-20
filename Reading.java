import java.awt.Color;

import java.awt.event.MouseAdapter;

import java.awt.event.MouseEvent;

import java.awt.TextField;

import javax.swing.ImageIcon;

import javax.swing.JButton;

import javax.swing.JFrame;

import javax.swing.JLabel;

public class Reading extends JFrame
{
	private static String string1 = "a";
	
	private static String string2 = "b";
	
	private static String string3 = "c";
		
	public final TextField field1 = new TextField ();
	
	public final TextField field2 = new TextField ();
	
	public final TextField field3 = new TextField ();
	
	public Reading ()
	{
		setTitle ("Reading");
		
		setContentPane (new JLabel (new ImageIcon ("background3.png")));
		
		setLayout (null);
		
		field1.setBounds (14, 12, 208, 25);
		
		add (field1);
		
		field2.setBounds (28, 24, 208, 25);
		
		add (field2);
		
		field3.setBounds (42, 36, 208, 25);
		
		add (field3);
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