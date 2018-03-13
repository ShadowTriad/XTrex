/**
 * @version 23/03/18
 * @author Faith Yemofio
 */

/**
 * program is a prototype of the numeric keyboard in where to mode and implements the planed functionality of the numeric keyboard
 */

//package Numeric imports the java awt and java swing packages so the class Numeric can use clickable buttons and text displays

import java.awt.event.MouseAdapter;

import java.awt.event.MouseEvent;

import java.awt.TextField;

import javax.swing.ImageIcon;

import javax.swing.JButton;

import javax.swing.JFrame;

import javax.swing.JLabel;

//class Numeric extends the Keyboard class so the class Numeric can use character buttons and destination displays

public class Numeric extends Keyboard
{	
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
	
	public final DeleteButton buttonDEL = new DeleteButton ("DEL");
	
	public final LeftButton buttonLEF = new LeftButton ("LEF");
	
	//sets up the class so the numeric keyboard can be displayed on the screen
	//displays the character buttons, delete buttons and left arrow buttons on the keyboard on the screen
	//displays the destination in the display on the keyboard on the screen
	
	public Numeric ()
	{
		setTitle ("Where To");
				
		setContentPane (new JLabel (new ImageIcon ("img/background2.png")));
		
		setLayout (null);
		
		field.setText(string);
		
		field.setBounds (14, 12, 208, 25);
		
		add (field);
		
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
		
		buttonDEL.setBounds (82, 228, 149, 116);
		
		add (buttonDEL);
		
		buttonLEF.setBounds (9, 282, 72, 62);
		
		add (buttonLEF);
	}
	
	//stores the information about the delete buttons on the keyboard
	//delete buttons highlight orange when the delete buttons is rolled over
	//delete buttons remove the last character added to the destination from the destination
	
	private class DeleteButton extends JButton
	{
		DeleteButton (String delete)
		{
			setIcon (new ImageIcon ("img/keycap" + delete + ".png"));
			
			setRolloverIcon (new ImageIcon ("img/rollover" + delete + ".png")); 
			
			setBorder (null);
			
			addMouseListener (new MouseAdapter ()
			{
 				public void mouseClicked (MouseEvent event)
				{
					int length = string.length ();
					
					if (length == 0)
					{
						
					}
					
					else if (length == 1)
					{
						string = "";
						
						field.setText ("");
					}
					
					else
					{
						string = string.substring (0, length - 1);
					
						field.setText ("" + string);
					}
				}
			});
		}
	}
	
	//stores the information about the left arrow buttons on the keyboard
	//left arrow buttons highlight orange when the left arrow buttons is rolled over
	//left arrow buttons changes the numeric keyboard to the alphabetic keyboard
	
	private class LeftButton extends JButton
	{
		LeftButton (String left)
		{
			setIcon (new ImageIcon ("img/keycap" + left + ".png"));
			
			setRolloverIcon (new ImageIcon ("img/rollover" + left + ".png")); 
			
			setBorder (null);
			
			addMouseListener (new MouseAdapter ()
			{
				public void mouseClicked (MouseEvent event)
				{
					Numeric.this.dispose ();
					
					JFrame frame = new Alphabetic ();
					
					frame.setLocationRelativeTo (null);
					
					frame.setSize (240, 375);
					
					frame.setResizable (false);
					
					frame.setVisible (true);
				}
			});
		}
	}
	
	//displays the alphabetic keyboard on the screen
	
	public static void main (String [] array)
	{		
		JFrame frame = new Numeric ();
		
		frame.setLocationRelativeTo (null);
		
		frame.setSize (240, 375);
		
		frame.setResizable (false);
		
		frame.setVisible (true);
	}
}