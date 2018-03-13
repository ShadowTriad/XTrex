/**
 * @version 23/03/18
 * @author Faith Yemofio
 */

/**
 * program is a prototype of the keyboards in where to mode and implements the planed functionality of the keyboards
 */

//package Keyboard imports the java awt and java swing packages so the class Keyboard can use clickable buttons and text displays

import java.awt.event.MouseAdapter;

import java.awt.event.MouseEvent;

import java.awt.TextField;

import javax.swing.ImageIcon;

import javax.swing.JButton;

import javax.swing.JFrame;

//class Keyboard extends the jFrame class so the class Keyboard can use clickable buttons and text displays

public class Keyboard extends JFrame
{	
	public static String string = "";
			
	public final TextField field = new TextField ("");
	
	//sets up the class so the keyboard can be displayed on the screen
	//displays the destination in the display on the keyboard on the screen
			
	public Keyboard ()
	{		
		
	}
	
	//stores the information about the character buttons on the keyboard
	//character buttons highlight orange when the character buttons is rolled over
	//character buttons add the character of the button to the destination
	
	public class CharacterButton extends JButton
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
					string = string + character;
					
					field.setText("" + string);
				}
			});
		}
	}
}