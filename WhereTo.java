import java.awt.Color;

import java.awt.event.MouseAdapter;

import java.awt.event.MouseEvent;

import java.awt.TextField;

import javax.swing.ImageIcon;

import javax.swing.JButton;

import javax.swing.JFrame;

import javax.swing.JLabel;

public class WhereTo extends JFrame
{
	private static String string = "";
		
	public final TextField display = new TextField ();
	
	public final CharacterButton button1 = new CharacterButton ("1");
	
	public final CharacterButton button2 = new CharacterButton ("2");
	
	public final CharacterButton button3 = new CharacterButton ("3");
	
	public final CharacterButton button4 = new CharacterButton ("4");
	
	public final CharacterButton button5 = new CharacterButton ("5");
	
	public final CharacterButton button6 = new CharacterButton ("6");
	
	public final CharacterButton button7 = new CharacterButton ("7");
	
	public final CharacterButton button8 = new CharacterButton ("8");
	
	public final CharacterButton button9 = new CharacterButton ("9");
	
	public final CharacterButton button0 = new CharacterButton ("0");
	
	private class CharacterButton extends JButton
	{
		CharacterButton (String character)
		{
			setIcon (new ImageIcon ("keycap" + character + ".png"));
			
			setBorder (null);
			
			addMouseListener (new MouseAdapter ()
			{
				public void mouseClicked (MouseEvent event)
				{
					string = string + character;
					
					display.setText("" + string);
				}
			});
		}
	}
	
	public WhereTo ()
	{
		setTitle ("WhereTo");
		
		setContentPane (new JLabel (new ImageIcon ("background.png")));
		
		setLayout (null);
		
		display.setBounds (14, 12, 208, 25);
		
		add (display);
		
		button1.setBounds (9, 52, 72, 61);
		
		add (button1);
		
		button2.setBounds (82, 52, 74, 61);
		
		add (button2);
		
		button3.setBounds (157, 52, 74, 61);
		
		add (button3);
		
		button4.setBounds (9, 114, 72, 59);
		
		add (button4);
		
		button5.setBounds (82, 114, 74, 59);
		
		add (button5);
		
		button6.setBounds (157, 114, 74, 59);
		
		add (button6);
		
		button7.setBounds (9, 174, 72, 53);
		
		add (button7);
		
		button8.setBounds (82, 174, 74, 53);
		
		add (button8);
		
		button9.setBounds (157, 174, 74, 53);
		
		add (button9);
		
		button0.setBounds (9, 228, 72, 53);
		
		add (button0);
		
	}
	
	public static void main (String [] array)
	{
		JFrame frame = new WhereTo ();
		
		frame.setLocationRelativeTo (null);
		
		frame.setSize (240, 375);
		
		frame.setResizable (false);
		
		frame.setVisible (true);
	}
}