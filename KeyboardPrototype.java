/**
 * @version 23/03/18
 * @author Faith Yemofio
 */

/**
 * program is a prototype of the keyboards in where to mode and implements the planed functionality of the keyboards
 */

//package KeyboardPrototype imports the java awt and java swing packages so the class Keyboard can use clickable buttons and text displays
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.TextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

//class KeyboardPrototype is used to store the information about the buttons and the displays on a keypad
//class KeyboardPrototype extends the jFrame class so the class Keyboard can use clickable buttons and text displays
public class KeyboardPrototype extends JFrame
{	
	public static Constant constant = new Constant ();
	public static String string = "";	
	public static final TextField field = new TextField ("");
	
	//sets up the class so the keyboard can be displayed on the screen
	//displays the destination in the display on the keyboard on the screen	
	public KeyboardPrototype ()
	{		
	}
	
	//stores the information about the character buttons on the keyboard
	//character buttons highlight orange when the character buttons is rolled over
	//character buttons add the character of the button to the destination
	public class CharacterButton extends JButton
	{
		CharacterButton (String character)
		{
			setIcon (new ImageIcon (constant.getIcon () + character + constant.getIconExtenction ()));
			setRolloverIcon (new ImageIcon (constant.getRolloverIcon () + character + constant.getIconExtenction ())); 
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