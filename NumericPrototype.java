/**
 * @version 23/03/18
 * @author Faith Yemofio
 */

/**
 * program is a prototype of the numeric keyboard in where to mode and implements the planed functionality of the numeric keyboard
 */

//package NumericPrototype imports the java awt and java swing packages so the class Numeric can use clickable buttons and text displays
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.TextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

//class NumericPrototype is used to store the information about the buttons and the displays on a keypad
//class NumericPrototype extends the Keyboard class so the class Numeric can use character buttons and destination displays
public class NumericPrototype extends KeyboardPrototype
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
	public final LeftButton buttonLEF = new LeftButton ("LEF");
	public final DeleteButton buttonDEL = new DeleteButton ("DEL");
	
	//sets up the class so the numeric keyboard can be displayed on the screen
	//displays the character buttons, delete buttons and left arrow buttons on the keyboard on the screen
	//displays the destination in the display on the keyboard on the screen
	public NumericPrototype ()
	{
		setTitle (constant.getWhereTo ());
		setContentPane (new JLabel (new ImageIcon (constant.getNumericBackground ())));
		setLayout (null);
		field.setText(string);
		field.setBounds (constant.getWhereToColumn0 (), constant.getWhereToRow0 (), constant.getWhereToWidth0 (), constant.getWhereToHeight0 ());
		add (field);
		button1.setBounds (constant.getNumericColumn1 (), constant.getNumericRow1 (), constant.getNumericWidth1 (), 61);
		add (button1);
		button2.setBounds (constant.getNumericColumn2 (), constant.getNumericRow1 (), constant.getNumericWidth2 (), 61);
		add (button2);
		button3.setBounds (constant.getNumericColumn3 (), constant.getNumericRow1 (), constant.getNumericWidth2 (), 61);
		add (button3);
		button4.setBounds (constant.getNumericColumn1 (), constant.getNumericRow2 (), constant.getNumericWidth1 (), 59);
		add (button4);
		button5.setBounds (constant.getNumericColumn2 (), constant.getNumericRow2 (), constant.getNumericWidth2 (), 59);
		add (button5);
		button6.setBounds (constant.getNumericColumn3 (), constant.getNumericRow2 (), constant.getNumericWidth2 (), 59);
		add (button6);
		button7.setBounds (constant.getNumericColumn1 (), constant.getNumericRow3 (), constant.getNumericWidth1 (), 53);
		add (button7);
		button8.setBounds (constant.getNumericColumn2 (), constant.getNumericRow3 (), constant.getNumericWidth2 (), 53);
		add (button8);
		button9.setBounds (constant.getNumericColumn3 (), constant.getNumericRow3 (), constant.getNumericWidth2 (), 53);
		add (button9);
		button0.setBounds (constant.getNumericColumn1 (), constant.getNumericRow4 (), constant.getNumericWidth1 (), 53);
		add (button0);
		buttonDEL.setBounds (constant.getNumericColumn2 (), constant.getNumericRow4 (), constant.getNumericWidth3 (), 116);
		add (buttonDEL);
		buttonLEF.setBounds (constant.getNumericColumn1 (), constant.getNumericRow5 (), constant.getNumericWidth1 (), 62);
		add (buttonLEF);
	}
	
	//stores the information about the left arrow buttons on the keyboard
	//left arrow buttons highlight orange when the left arrow buttons is rolled over
	//left arrow buttons changes the numeric keyboard to the alphabetic keyboard
	private class LeftButton extends JButton
	{
		LeftButton (String left)
		{
			setIcon (new ImageIcon (constant.getIcon () + left + constant.getIconExtenction ()));
			setRolloverIcon (new ImageIcon (constant.getRolloverIcon () + left + constant.getIconExtenction ()));
			setBorder (null);
			addMouseListener (new MouseAdapter ()
			{
				public void mouseClicked (MouseEvent event)
				{
					NumericPrototype.this.dispose ();
					JFrame frame = new AlphabeticPrototype ();
					frame.setLocationRelativeTo (null);
					frame.setSize (constant.getWhereToWidth (), constant.getWhereToHeight ());
					frame.setResizable (false);
					frame.setVisible (true);
				}
			});
		}
	}
	
	//stores the information about the delete buttons on the keyboard
	//delete buttons highlight orange when the delete buttons is rolled over
	//delete buttons remove the last character added to the destination from the destination
	private class DeleteButton extends JButton
	{
		DeleteButton (String delete)
		{
			setIcon (new ImageIcon (constant.getIcon () + delete + constant.getIconExtenction ()));
			setRolloverIcon (new ImageIcon (constant.getRolloverIcon () + delete + constant.getIconExtenction ()));
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
	
	//displays the alphabetic keyboard on the screen
	public static void main (String [] array)
	{
		JFrame frame = new NumericPrototype ();
		frame.setLocationRelativeTo (null);
		frame.setSize (constant.getWhereToWidth (), constant.getWhereToHeight ());
		frame.setResizable (false);
		frame.setVisible (true);
	}
}