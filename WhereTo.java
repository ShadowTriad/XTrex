/**
 * @version 23/03/18
 * @author Faith Yemofio
 */

/**
 * In Where To mode:
 * The screen displays the place name or post code of the address in a display and either an alphabetic or a numeric keyboard.
 * The + button and the - button are used to cycle either forward or backwards through the buttons on the keyboard which highlight orange when cycled through.
 * The select button is used to either add the orange highlighted button on the keyboard to the address in the display if the orange highlighted button is a character button, delete the last character from the address in the display if the orange highlighted button is a DEL button or switch the alphabetic or the numeric keyboard displayed to the alphabetic or the numeric keyboard not displayed if the orange highlighted button is an arrow button.
 */

//imports the java awt, java swing and java util packages so the class can use screens and lists
import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

//extends jPanel so the class can use screens
public class WhereTo extends JPanel
{
	private static Constant constant = new Constant ();
	private static String address = "";
	private int highlightedButton = 0;
	private Keyboard keyboard = Keyboard.ALPHABETIC;
	private ArrayList <Keycap> alphabeticButtons = new ArrayList <Keycap> (constant.getAlphabeticButtons ());
	private ArrayList <Keycap> numericButtons = new ArrayList <Keycap> (constant.getNumericButtons ());
	private Keycap buttonA = new Keycap ("A", constant.getAlphabeticColumn1 (), constant.getAlphabeticRow1 ());
	private Keycap buttonB = new Keycap ("B", constant.getAlphabeticColumn2 (), constant.getAlphabeticRow1 ());
	private Keycap buttonC = new Keycap ("C", constant.getAlphabeticColumn3 (), constant.getAlphabeticRow1 ());
	private Keycap buttonD = new Keycap ("D", constant.getAlphabeticColumn4 (), constant.getAlphabeticRow1 ());
	private Keycap buttonE = new Keycap ("E", constant.getAlphabeticColumn1 (), constant.getAlphabeticRow2 ());
	private Keycap buttonF = new Keycap ("F", constant.getAlphabeticColumn2 (), constant.getAlphabeticRow2 ());
	private Keycap buttonG = new Keycap ("G", constant.getAlphabeticColumn3 (), constant.getAlphabeticRow2 ());
	private Keycap buttonH = new Keycap ("H", constant.getAlphabeticColumn4 (), constant.getAlphabeticRow2 ());
	private Keycap buttonI = new Keycap ("I", constant.getAlphabeticColumn1 (), constant.getAlphabeticRow3 ());
	private Keycap buttonJ = new Keycap ("J", constant.getAlphabeticColumn2 (), constant.getAlphabeticRow3 ());
	private Keycap buttonK = new Keycap ("K", constant.getAlphabeticColumn3 (), constant.getAlphabeticRow3 ());
	private Keycap buttonL = new Keycap ("L", constant.getAlphabeticColumn4 (), constant.getAlphabeticRow3 ());
	private Keycap buttonM = new Keycap ("M", constant.getAlphabeticColumn1 (), constant.getAlphabeticRow4 ());
	private Keycap buttonN = new Keycap ("N", constant.getAlphabeticColumn2 (), constant.getAlphabeticRow4 ());
	private Keycap buttonO = new Keycap ("O", constant.getAlphabeticColumn3 (), constant.getAlphabeticRow4 ());
	private Keycap buttonP = new Keycap ("P", constant.getAlphabeticColumn4 (), constant.getAlphabeticRow4 ());
	private Keycap buttonQ = new Keycap ("Q", constant.getAlphabeticColumn1 (), constant.getAlphabeticRow5 ());
	private Keycap buttonR = new Keycap ("R", constant.getAlphabeticColumn2 (), constant.getAlphabeticRow5 ());
	private Keycap buttonS = new Keycap ("S", constant.getAlphabeticColumn3 (), constant.getAlphabeticRow5 ());
	private Keycap buttonT = new Keycap ("T", constant.getAlphabeticColumn4 (), constant.getAlphabeticRow5 ());
	private Keycap buttonU = new Keycap ("U", constant.getAlphabeticColumn1 (), constant.getAlphabeticRow6 ());
	private Keycap buttonV = new Keycap ("V", constant.getAlphabeticColumn2 (), constant.getAlphabeticRow6 ());
	private Keycap buttonW = new Keycap ("W", constant.getAlphabeticColumn3 (), constant.getAlphabeticRow6 ());
	private Keycap buttonX = new Keycap ("X", constant.getAlphabeticColumn4 (), constant.getAlphabeticRow6 ());
	private Keycap buttonY = new Keycap ("Y", constant.getAlphabeticColumn1 (), constant.getAlphabeticRow7 ());
	private Keycap buttonZ = new Keycap ("Z", constant.getAlphabeticColumn2 (), constant.getAlphabeticRow7 ());
	private Keycap button_ = new Keycap ("_", constant.getAlphabeticColumn3 (), constant.getAlphabeticRow7 ());
	private Keycap buttonRIG = new Keycap ("RIG", constant.getAlphabeticColumn4 (), constant.getAlphabeticRow7 ());
	private Keycap button1 = new Keycap ("1", constant.getNumericColumn1 (), constant.getNumericRow1 ());
	private Keycap button2 = new Keycap ("2", constant.getNumericColumn2 (), constant.getNumericRow1 ());
	private Keycap button3 = new Keycap ("3", constant.getNumericColumn3 (), constant.getNumericRow1 ());
	private Keycap button4 = new Keycap ("4", constant.getNumericColumn1 (), constant.getNumericRow2 ());
	private Keycap button5 = new Keycap ("5", constant.getNumericColumn2 (), constant.getNumericRow2 ());
	private Keycap button6 = new Keycap ("6", constant.getNumericColumn3 (), constant.getNumericRow2 ());
	private Keycap button7 = new Keycap ("7", constant.getNumericColumn1 (), constant.getNumericRow3 ());
	private Keycap button8 = new Keycap ("8", constant.getNumericColumn2 (), constant.getNumericRow3 ());
	private Keycap button9 = new Keycap ("9", constant.getNumericColumn3 (), constant.getNumericRow3 ());
	private Keycap button0 = new Keycap ("0", constant.getNumericColumn1 (), constant.getNumericRow4 ());
	private Keycap buttonLEF = new Keycap ("LEF", constant.getNumericColumn1 (), constant.getNumericRow5 ());
	private Keycap buttonDEL = new Keycap ("DEL", constant.getNumericColumn2 (), constant.getNumericRow4 ());
	
	//sets up the class so the mode can be displayed on the screen
	//adds the buttons on the alphabetic keyboard to the alphabetic keyboard buttons list
	//adds the buttons on the numeric keyboard to the numeric keyboard buttons list
	public WhereTo ()
	{
		alphabeticButtons.add (buttonA);
		alphabeticButtons.add (buttonB);
		alphabeticButtons.add (buttonC);
		alphabeticButtons.add (buttonD);
		alphabeticButtons.add (buttonE);
		alphabeticButtons.add (buttonF);
		alphabeticButtons.add (buttonG);
		alphabeticButtons.add (buttonH);
		alphabeticButtons.add (buttonI);
		alphabeticButtons.add (buttonJ);
		alphabeticButtons.add (buttonK);
		alphabeticButtons.add (buttonL);
		alphabeticButtons.add (buttonM);
		alphabeticButtons.add (buttonN);
		alphabeticButtons.add (buttonO);
		alphabeticButtons.add (buttonP);
		alphabeticButtons.add (buttonQ);
		alphabeticButtons.add (buttonR);
		alphabeticButtons.add (buttonS);
		alphabeticButtons.add (buttonT);
		alphabeticButtons.add (buttonU);
		alphabeticButtons.add (buttonV);
		alphabeticButtons.add (buttonW);
		alphabeticButtons.add (buttonX);
		alphabeticButtons.add (buttonY);
		alphabeticButtons.add (buttonZ);
		alphabeticButtons.add (button_);
		alphabeticButtons.add (buttonRIG);
		numericButtons.add (button1);
		numericButtons.add (button2);
		numericButtons.add (button3);
		numericButtons.add (button4);
		numericButtons.add (button5);
		numericButtons.add (button6);
		numericButtons.add (button7);
		numericButtons.add (button8);
		numericButtons.add (button9);
		numericButtons.add (button0);
		numericButtons.add (buttonLEF);
		numericButtons.add (buttonDEL);
	}
	
	//cycles forwards through the buttons on the keyboard
	//traverses the buttons in the list of buttons on a keyboard
	//if the end of the list is reached, it goes back to the beginning of the list
	public void plusButton ()
	{
		if (keyboard == Keyboard.ALPHABETIC)
		{
			if (highlightedButton == constant.getAlphabeticButtons () - 1)
			{
				highlightedButton = 0;
			}
			else
			{
				highlightedButton = highlightedButton + 1;
			}
		}
		else
		{
			if (highlightedButton == constant.getNumericButtons () - 1)
			{
				highlightedButton = 0;
			}
			else
			{
				highlightedButton = highlightedButton + 1;
			}
		}
		repaint ();
	}
	
	//cycles backwards through the buttons on the keyboard
	//traverses the buttons in the list of buttons on a keyboard
	//if the beginning of the list is reached, it goes forward to the end of the list
	public void minusButton ()
	{
		if (keyboard == Keyboard.ALPHABETIC)
		{
			if (highlightedButton == 0)
			{
				highlightedButton = constant.getAlphabeticButtons () - 1;
			}
			else
			{
				highlightedButton = highlightedButton - 1;
			}
		}
		else
		{
			if (highlightedButton == 0)
			{
				highlightedButton = constant.getNumericButtons () - 1;
			}
			else
			{
				highlightedButton = highlightedButton - 1;
			}
		}
		repaint ();
	}
	
	//adds the orange highlighted button on the keyboard to the display if the orange highlighted button is a character button
	//deletes the last character from the display if the orange highlighted button is a delete button
	//switches the keyboard to either an alphabetic or a numeric keyboard if the orange highlighted button is an arrow button
	public void selectButton ()
	{
		if (keyboard == Keyboard.ALPHABETIC)
		{		
			if ((alphabeticButtons.get (highlightedButton)).getName () == "RIG")
			{
				keyboard = Keyboard.NUMERIC;
				highlightedButton = 0;
			}
			else
			{
				address = address + (alphabeticButtons.get (highlightedButton)).getName ();
			}
		}
		else
		{
			if ((numericButtons.get (highlightedButton)).getName () == "DEL")
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
			else if ((numericButtons.get (highlightedButton)).getName () == "LEF")
			{
				keyboard = Keyboard.ALPHABETIC;
				highlightedButton = 0;
			}
			else
			{
				address = address + (numericButtons.get (highlightedButton)).getName ();
			}
		}
		repaint ();
	}
	
	//returns the address in the display on the screen
	public String getAddress ()
	{			
		return address;
	}
	
	//updates the screen
	public void paintComponent (Graphics graphics)
	{
		if (keyboard == Keyboard.ALPHABETIC)
		{
			(new ImageIcon (constant.getAlphabeticBackground ())).paintIcon (this, graphics, 0, 0);
			graphics.setColor (Color.black);
			graphics.setFont (new Font (constant.getTextFont (), Font.PLAIN, constant.getTextSize ()));
			graphics.drawString (address, constant.getWhereToTextColumn (), constant.getWhereToTextRow ());
			for (int index = 0; index <= constant.getAlphabeticButtons () - 1; index = index + 1)
			{
				if (index == highlightedButton)
				{
					(new ImageIcon (constant.getRolloverIcon () + (alphabeticButtons.get (index)).getName () + constant.getIconExtenction ())).paintIcon (this, graphics, (alphabeticButtons.get (index)).getX (), (alphabeticButtons.get (index)).getY ());
				}
				else
				{
					(new ImageIcon (constant.getIcon () + (alphabeticButtons.get (index)).getName () + constant.getIconExtenction ())).paintIcon (this, graphics, (alphabeticButtons.get (index)).getX (), (alphabeticButtons.get (index)).getY ());
				}
			}
		}
		else
		{
			(new ImageIcon (constant.getNumericBackground ())).paintIcon (this, graphics, 0, 0);
			graphics.setColor (Color.black);
			graphics.setFont (new Font (constant.getTextFont (), Font.PLAIN, constant.getTextSize ()));
			graphics.drawString (address, constant.getWhereToTextColumn (), constant.getWhereToTextRow ());
			for (int index = 0; index <= constant.getNumericButtons () - 1; index = index + 1)
			{
				if (index == highlightedButton)
				{
					(new ImageIcon (constant.getRolloverIcon () + (numericButtons.get (index)).getName () + constant.getIconExtenction ())).paintIcon (this, graphics, (numericButtons.get (index)).getX (), (numericButtons.get (index)).getY ());
				}
				else
				{
					(new ImageIcon (constant.getIcon () + (numericButtons.get (index)).getName () + constant.getIconExtenction ())).paintIcon (this, graphics, (numericButtons.get (index)).getX (), (numericButtons.get (index)).getY ());
				}
			}
		}
	}
}