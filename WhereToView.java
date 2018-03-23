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

//imports the java awt, java util and java swing packages so the class can use screens and views
import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;

//extends jPanel and implements Observer so the class can use screens and views
public class WhereToView extends JPanel implements Observer
{
	private XTrexController controller;
	private XTrexModel model;
	private Constant constant;
	private String address;
	private int highlightedButton;
	private Keyboard keyboard;
	private ArrayList <Keycap> alphabeticButtons;
	private ArrayList <Keycap> numericButtons;
	
	//sets up the class so the view can be displayed on the screen
	public WhereToView (XTrexController controller, XTrexModel model)
	{
		this.controller = controller;
		this.model = model;
		constant = model.getConstant ();
		address = model.getAddress ();
		highlightedButton = model.getHighlightedButton ();
		keyboard = model.getKeyboard ();
		alphabeticButtons = model.getAlphabeticButtons ();
		numericButtons = model.getNumericButtons ();
		model.addObserver (this);
	}
	
	//updates the view when either the address, highlighted button or keyboard change
	public void update (Observable observable, Object object)
	{
		address = model.getAddress ();
		highlightedButton = model.getHighlightedButton ();
		keyboard = model.getKeyboard ();
		repaint ();
	}
	
	//updates the screen when either the address, highlighted button or keyboard change
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