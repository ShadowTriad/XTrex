/**
 * @version 08/03/18
 * @author Faith Yemofio
 */

import java.awt.*;

import java.util.*;

import javax.swing.*;

/**
 * In Where To mode:
 * The screen displays the users destination (place name or post code) and either an alphabetic or a numeric keypad.
 * The + and - buttons are used to cycle either forward or backwards through the buttons on the keypad which highlight orange when cycled through.
 * The select button is used to add the orange highlighted button on the keypad to the display if the orange highlighted button is a character button, delete the last character from the display if the orange highlighted button is a DEL button or switch the keypad to either an alphabetic or a numeric keypad if the orange highlighted button is an arrow button.
 */

//class WhereTo extends jPanel so the mode can be displayed on the screen of the XTrex

class WhereTo extends JPanel
{
	//stores the destination displayed on the keypad

	private static String address = "";
	
	//stores the orange highlighted button displayed on the keypad
	
	public int button = 0;
	
	//stores the keypad displayed on the XTrex
	//the alphabetic keypad is displayed on the XTrex when set to true
	//the numeric keypad is displayed on the XTrex when set to false
	
	public boolean mode = false;
	
	//stores the buttons on the alphabetic keypad
	
	public ArrayList <Keycap> keycaps1 = new ArrayList <Keycap> (28);
	
	//stores the buttons on the numeric keypad
	
	public ArrayList <Keycap> keycaps2 = new ArrayList <Keycap> (12);
	
	//stores the information about the buttons on the keypads
	
	public Keycap buttonA = new Keycap ("A", 11, 52);
	
	public Keycap buttonB = new Keycap ("B", 65, 52);
		
	public Keycap buttonC = new Keycap ("C", 121, 52);
		
	public Keycap buttonD = new Keycap ("D", 177, 52);
		
	public Keycap buttonE = new Keycap ("E", 11, 94);
		
	public Keycap buttonF = new Keycap ("F", 65, 94);
		
	public Keycap buttonG = new Keycap ("G", 121, 94);
		
	public Keycap buttonH = new Keycap ("H", 177, 94);
		
	public Keycap buttonI = new Keycap ("I", 11, 136);
		
	public Keycap buttonJ = new Keycap ("J", 65, 136);
		
	public Keycap buttonK= new Keycap ("K", 121, 136);
		
	public Keycap buttonL = new Keycap ("L", 177, 136);
	
	public Keycap buttonM = new Keycap ("M", 11, 177);
	
	public Keycap buttonN = new Keycap ("N", 65, 177);
	
	public Keycap buttonO = new Keycap ("O", 121, 177);
	
	public Keycap buttonP = new Keycap ("P", 177, 177);
	
	public Keycap buttonQ = new Keycap ("Q", 11, 219);
	
	public Keycap buttonR = new Keycap ("R", 65, 219);
	
	public Keycap buttonS = new Keycap ("S", 121, 219);
	
	public Keycap buttonT = new Keycap ("T", 177, 219);
	
	public Keycap buttonU = new Keycap ("U", 11, 262);
	
	public Keycap buttonV = new Keycap ("V", 65, 262);
	
	public Keycap buttonW = new Keycap ("W", 121, 262);
	
	public Keycap buttonX = new Keycap ("X", 177, 262);
	
	public Keycap buttonY = new Keycap ("Y", 11, 303);
	
	public Keycap buttonZ = new Keycap ("Z", 65, 303);
	
	public Keycap button_ = new Keycap ("_", 121, 303);
	
	public Keycap buttonRIG = new Keycap ("RIG", 177, 303);
	
	public Keycap button1 = new Keycap ("1", 9, 52);
	
	public Keycap button2 = new Keycap ("2", 82, 52);
		
	public Keycap button3 = new Keycap ("3", 157, 52);
		
	public Keycap button4 = new Keycap ("4", 9, 114);
		
	public Keycap button5 = new Keycap ("5", 82, 114);
		
	public Keycap button6 = new Keycap ("6",  157, 114);
		
	public Keycap button7 = new Keycap ("7", 9, 174);
		
	public Keycap button8 = new Keycap ("8", 82, 174);
		
	public Keycap button9 = new Keycap ("9", 157, 174);
		
	public Keycap button0 = new Keycap ("0", 9, 228);
		
	public Keycap buttonDEL = new Keycap ("DEL", 82, 228);
		
	public Keycap buttonLEF = new Keycap ("LEF", 9, 282);
	
	//sets up the class so the mode can be displayed on the screen of the XTrex
	//adds the buttons on the alphabetic keypad to the alphabetic keypad buttons list
	//adds the buttons on the numeric keypad to the numeric keypad buttons list
	
	public WhereTo ()
	{
		keycaps1.add (buttonA);
		
		keycaps1.add (buttonB);
		
		keycaps1.add (buttonC);
		
		keycaps1.add (buttonD);
		
		keycaps1.add (buttonE);
		
		keycaps1.add (buttonF);
		
		keycaps1.add (buttonG);
		
		keycaps1.add (buttonH);
		
		keycaps1.add (buttonI);
		
		keycaps1.add (buttonJ);
		
		keycaps1.add (buttonK);
		
		keycaps1.add (buttonL);
		
		keycaps1.add (buttonM);
		
		keycaps1.add (buttonN);
		
		keycaps1.add (buttonO);
		
		keycaps1.add (buttonP);
		
		keycaps1.add (buttonQ);
		
		keycaps1.add (buttonR);
		
		keycaps1.add (buttonS);
		
		keycaps1.add (buttonT);
		
		keycaps1.add (buttonU);
		
		keycaps1.add (buttonV);
		
		keycaps1.add (buttonW);
		
		keycaps1.add (buttonX);
		
		keycaps1.add (buttonY);
		
		keycaps1.add (buttonZ);
		
		keycaps1.add (button_);
		
		keycaps1.add (buttonRIG);
		
		keycaps2.add (button1);
		
		keycaps2.add (button2);
		
		keycaps2.add (button3);
		
		keycaps2.add (button4);
		
		keycaps2.add (button5);
		
		keycaps2.add (button6);
		
		keycaps2.add (button7);
		
		keycaps2.add (button8);
		
		keycaps2.add (button9);
		
		keycaps2.add (button0);
		
		keycaps2.add (buttonDEL);
		
		keycaps2.add (buttonLEF);
	}
	
	//plus method is used to cycle forwards through the buttons on the keypad
	//traverses the buttons in the list of buttons on a keypad
	//when the method reaches the end of the list, the method goes back to the beginning of the list
	
	public void plusButton ()
	{
		if (mode == true)
		{
			if (button == 27)
			{
				button = 0;
			}
			
			else
			{
				button = button + 1;
			}
		}
		
		if (mode == false)
		{
			if (button == 11)
			{
				button = 0;
			}
			
			else
			{
				button = button + 1;
			}
		}
	}
	
	//minus method is used to cycle backwards through the buttons on the keypad
	//traverses the buttons in the list of buttons on a keypad
	//when the method reaches the beginning of the list, the method goes forward to the end of the list
	
	public void minusButton ()
	{
		if (mode == true)
		{
			if (button == 0)
			{
				button = 27;
			}
			
			else
			{
				button = button - 1;
			}
		}
		
		if (mode == false)
		{
			if (button == 0)
			{
				button = 11;
			}
			
			else
			{
				button = button - 1;
			}
		}
	}
	
	//select method is used to add the orange highlighted button on the keypad to the display if the orange highlighted button is a character button
	//select method is used to delete the last character from the display if the orange highlighted button is a delete button
	//select method is used to switch the keypad to either an alphabetic or a numeric keypad if the orange highlighted button is an arrow button
	
	public void selectButton ()
	{
		if (mode == true)
		{			
			if ((keycaps1.get (button)).getName () == "RIG")
			{
				mode = false;
				
				button = 0;
			}
			
			else
			{
				address = address + (keycaps1.get (button)).getName ();
			}
		}
		
		if (mode == false)
		{
			if ((keycaps2.get (button)).getName () == "DEL")
			{			
				if (address.length () == 0)
				{
					
				}
				
				else if (address.length () == 1)
				{
					address = "";
				}
				
				else
				{
					address = address.substring (0, address.length () - 1);
				}
			}
			
			else if ((keycaps2.get (button)).getName () == "LEF")
			{
				mode = true;
				
				button = 0;
			}
			
			else
			{
				address = address + (keycaps2.get (button)).getName ();
			}
		}
	}
	
	//paint component method is used to continuously display the screen on the Xtrex
	
	public void paintComponent (Graphics graphics)
	{
		if (mode == true)
		{
			//draws the background on the screen
			
			(new ImageIcon ("img/background.png")).paintIcon(this, graphics, 0, 0);
			
			//draws the text on the screen
			
			graphics.setColor (Color.black);
			
			graphics.setFont (new Font ("Arial", Font.PLAIN, 27));
			
			//draws the destination on the display
			
			graphics.drawString (address, 16, 34);
			
			//draws the buttons on the keypad
			
			for (int index = 0; index<=27; index = index + 1)
			{
				//draws the orange highlighted button on the keypad
				
				if (index == button)
				{
					(new ImageIcon ("img/rollover" + (keycaps1.get (index)).getName () + ".png")).paintIcon (this, graphics, (keycaps1.get (index)).getX (), (keycaps1.get (index)).getY ());
				}
				
				//draws the non orange highlighted buttons on the keypad
				
				else
				{
					(new ImageIcon ("img/keycap" + (keycaps1.get (index)).getName () + ".png")).paintIcon (this, graphics, (keycaps1.get (index)).getX (), (keycaps1.get (index)).getY ());
				}
			}
		}
		
		if (mode == false)
		{
			//draws the background on the screen
			
			(new ImageIcon ("img/background2.png")).paintIcon (this, graphics, 0, 0);
			
			//draws the text on the screen
			
			graphics.setColor (Color.black);
			
			graphics.setFont (new Font ("Arial", Font.PLAIN, 27));
			
			//draws the destination on the display
			
			graphics.drawString (address, 16, 34);
			
			//draws the buttons on the keypad
			
			for (int index = 0; index<=11; index = index + 1)
			{
				//draws the orange highlighted button on the keypad
				
				if (index == button)
				{
					(new ImageIcon ("img/rollover" + (keycaps2.get (index)).getName () + ".png")).paintIcon (this, graphics, (keycaps2.get (index)).getX (), (keycaps2.get (index)).getY ());
				}
				
				//draws the non orange highlighted buttons on the keypad
				
				else
				{
					(new ImageIcon ("img/keycap" + (keycaps2.get (index)).getName () + ".png")).paintIcon (this, graphics, (keycaps2.get (index)).getX (), (keycaps2.get (index)).getY ());
				}
			}
		}
		
		//continuously redraws the screen on the Xtrex
		
		repaint ();
	}
}