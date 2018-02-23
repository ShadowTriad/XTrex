/**
 * @version 22/02/18
 * @author Faith Yemofio
 */

import java.awt.Color;

import java.awt.event.MouseAdapter;

import java.awt.event.MouseEvent;

import java.awt.Color;

import java.awt.TextField;

import javax.swing.ImageIcon;

import javax.swing.JButton;

import javax.swing.JFrame;

import javax.swing.JLabel;

/**
 * Numeric is a simulation of the alphabetic keypad in Where To mode and show the planed functionality of the mode.
 * In Where To mode:
 * The screen displays the users destination (place name or post code) and either an alphabetic or a numeric keypad.
 * The + and - buttons are used to cycle either forward or backwards through the buttons on the keypad which highlight orange when cycled through.
 * The select button is used to add the orange highlighted button on the keypad to the display if the orange highlighted button is a character button, delete the last character from the display if the orange highlighted button is a DEL button or switch the keypad to either an alphabetic or a numeric keypad if the orange highlighted button is an arrow button.
 */

//class Numeric extends jFrame so the mode can use clickable buttons and text display

public class Numeric extends JFrame
{
	//stores the destination displayed on the keypad
	
	private static String string = "";
	
	//stores the destination display
		
	public final TextField field = new TextField ();
	
	//stores the buttons on the keypad
	
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
	
	//sets up the class so the simulation can be displayed
	//adds the buttons and the displays to the simulation
	
	public Numeric ()
	{
		setTitle ("Numeric");
		
		//displays the background on the simulation
		
		setContentPane (new JLabel (new ImageIcon ("img/background2.png")));
		
		setLayout (null);
		
		//displays the destination on the simulation
		
		field.setBounds (14, 12, 208, 25);
		
		add (field);
		
		//displays the buttons on the simulation
		
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
	
	//sets up the class so the simulation can be displayed
	//adds the buttons and the displays to the simulation
	//sets the destination to the destination in the argument
	
	public Numeric (String string)
	{
		//sets the destination
		
		this.string = string;
		
		field.setText (string);
		
		setTitle ("Numeric");
		
		//displays the background on the simulation
		
		setContentPane (new JLabel (new ImageIcon ("img/background2.png")));
		
		setLayout (null);
		
		//displays the destination on the simulation
		
		field.setBounds (14, 12, 208, 25);
		
		add (field);
		
		//displays the buttons on the simulation
		
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
	
	//stores the information about the character buttons on the keypads
	//buttons highlight orange when rolled over
	//button adds the character to the display
	
	private class CharacterButton extends JButton
	{
		CharacterButton (String character)
		{
			setIcon (new ImageIcon ("img/keycap" + character + ".png"));
			
			setRolloverIcon (new ImageIcon ("img/rollover" + character + ".png")); 
			
			setBorder (null);
			
			addMouseListener (new MouseAdapter ()
			{
				public void mouseClicked (MouseEvent event)
				{
					setBackground (Color.orange);
					
					string = string + character;
					
					field.setText("" + string);
				}
			});
		}
	}
	
	//stores the information about the delete button on the keypad
	//button highlights orange when rolled over
	//button deletes the last character from the display
	
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
	
	//stores the information about the arrow button on the keypad
	//button highlights orange when rolled over
	//button switches the keypad to the alphabetic keypad
	
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
					
					JFrame frame = new Alphabetic (string);
					
					frame.setLocationRelativeTo (null);
					
					frame.setSize (240, 375);
					
					frame.setResizable (false);
					
					frame.setVisible (true);
				}
			});
		}
	}
	
	//displays the simulation
	
	public static void main (String [] array)
	{
		//creates a simulation and displays the simulation
		
		JFrame frame = new Numeric ();
		
		frame.setLocationRelativeTo (null);
		
		frame.setSize (240, 375);
		
		frame.setResizable (false);
		
		frame.setVisible (true);
	}
}