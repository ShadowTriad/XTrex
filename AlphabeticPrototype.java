/**
 * @version 23/03/18
 * @author Faith Yemofio
 */

/**
 * program is a prototype of the alphabetic keyboard in where to mode and implements the planed functionality of the alphabetic keyboard
 */

//package AlphabeticPrototype imports the java awt and java swing packages so the class Alphabetic can use clickable buttons and text displays
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.TextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

//class AlphabeticPrototype is used to store the information about the buttons and the displays on a keypad
//class AlphabeticPrototype extends the Keyboard class so the class Alphabetic can use character buttons and destination displays
public class AlphabeticPrototype extends KeyboardPrototype
{
	public final CharacterButton buttonA = new CharacterButton ("A");
	public final CharacterButton buttonB = new CharacterButton ("B");
	public final CharacterButton buttonC = new CharacterButton ("C");
	public final CharacterButton buttonD = new CharacterButton ("D");
	public final CharacterButton buttonE = new CharacterButton ("E");
	public final CharacterButton buttonF = new CharacterButton ("F");
	public final CharacterButton buttonG = new CharacterButton ("G");
	public final CharacterButton buttonH = new CharacterButton ("H");
	public final CharacterButton buttonI = new CharacterButton ("I");
	public final CharacterButton buttonJ = new CharacterButton ("J");
	public final CharacterButton buttonK = new CharacterButton ("K");
	public final CharacterButton buttonL = new CharacterButton ("L");
	public final CharacterButton buttonM = new CharacterButton ("M");
	public final CharacterButton buttonN = new CharacterButton ("N");
	public final CharacterButton buttonO = new CharacterButton ("O");
	public final CharacterButton buttonP = new CharacterButton ("P");
	public final CharacterButton buttonQ = new CharacterButton ("Q");
	public final CharacterButton buttonR = new CharacterButton ("R");
	public final CharacterButton buttonS = new CharacterButton ("S");
	public final CharacterButton buttonT = new CharacterButton ("T");
	public final CharacterButton buttonU = new CharacterButton ("U");
	public final CharacterButton buttonV = new CharacterButton ("V");
	public final CharacterButton buttonW = new CharacterButton ("W");
	public final CharacterButton buttonX = new CharacterButton ("X");
	public final CharacterButton buttonY = new CharacterButton ("Y");
	public final CharacterButton buttonZ = new CharacterButton ("Z");
	public final CharacterButton button_ = new CharacterButton ("_");
	public final RightButton buttonRIG = new RightButton ("RIG");
	
	//sets up the class so the alphabetic keyboard can be displayed on the screen
	//displays the character buttons and the right arrow buttons on the keyboard on the screen
	//displays the destination in the display on the keyboard on the screen
	public AlphabeticPrototype ()
	{
		setTitle (constant.getWhereTo ());
		setContentPane (new JLabel (new ImageIcon (constant.getAlphabeticBackground ())));
		setLayout (null);
		field.setText(string);
		field.setBounds (constant.getWhereToColumn0 (), constant.getWhereToRow0 (), constant.getWhereToWidth0 (), constant.getWhereToHeight0 ());
		add (field);	
		buttonA.setBounds (constant.getAlphabeticColumn1 (), constant.getAlphabeticRow1 (), constant.getAlphabeticWidth1 (), constant.getAlphabeticHeight1 ());
		add (buttonA);
		buttonB.setBounds (constant.getAlphabeticColumn2 (), constant.getAlphabeticRow1 (), constant.getAlphabeticWidth2 (), constant.getAlphabeticHeight1 ());
		add (buttonB);
		buttonC.setBounds (constant.getAlphabeticColumn3 (), constant.getAlphabeticRow1 (), constant.getAlphabeticWidth2 (), constant.getAlphabeticHeight1 ());
		add (buttonC);
		buttonD.setBounds (constant.getAlphabeticColumn4 (), constant.getAlphabeticRow1 (), constant.getAlphabeticWidth1 (), constant.getAlphabeticHeight1 ());
		add (buttonD);
		buttonE.setBounds (constant.getAlphabeticColumn1 (), constant.getAlphabeticRow2 (), constant.getAlphabeticWidth1 (), constant.getAlphabeticHeight1 ());
		add (buttonE);
		buttonF.setBounds (constant.getAlphabeticColumn2 (), constant.getAlphabeticRow2 (), constant.getAlphabeticWidth2 (), constant.getAlphabeticHeight1 ());
		add (buttonF);
		buttonG.setBounds (constant.getAlphabeticColumn3 (), constant.getAlphabeticRow2 (), constant.getAlphabeticWidth2 (), constant.getAlphabeticHeight1 ());
		add (buttonG);
		buttonH.setBounds (constant.getAlphabeticColumn4 (), constant.getAlphabeticRow2 (), constant.getAlphabeticWidth1 (), constant.getAlphabeticHeight1 ());
		add (buttonH);
		buttonI.setBounds (constant.getAlphabeticColumn1 (), constant.getAlphabeticRow3 (), constant.getAlphabeticWidth1 (), constant.getAlphabeticHeight1 ());
		add (buttonI);
		buttonJ.setBounds (constant.getAlphabeticColumn2 (), constant.getAlphabeticRow3 (), constant.getAlphabeticWidth2 (), constant.getAlphabeticHeight1 ());
		add (buttonJ);
		buttonK.setBounds (constant.getAlphabeticColumn3 (), constant.getAlphabeticRow3 (), constant.getAlphabeticWidth2 (), constant.getAlphabeticHeight1 ());
		add (buttonK);
		buttonL.setBounds (constant.getAlphabeticColumn4 (), constant.getAlphabeticRow3 (), constant.getAlphabeticWidth1 (), constant.getAlphabeticHeight1 ());
		add (buttonL);
		buttonM.setBounds (constant.getAlphabeticColumn1 (), constant.getAlphabeticRow4 (), constant.getAlphabeticWidth1 (), constant.getAlphabeticHeight2 ());
		add (buttonM);
		buttonN.setBounds (constant.getAlphabeticColumn2 (), constant.getAlphabeticRow4 (), constant.getAlphabeticWidth2 (), constant.getAlphabeticHeight2 ());
		add (buttonN);
		buttonO.setBounds (constant.getAlphabeticColumn3 (), constant.getAlphabeticRow4 (), constant.getAlphabeticWidth2 (), constant.getAlphabeticHeight2 ());
		add (buttonO);
		buttonP.setBounds (constant.getAlphabeticColumn4 (), constant.getAlphabeticRow4 (), constant.getAlphabeticWidth1 (), constant.getAlphabeticHeight2 ());
		add (buttonP);
		buttonQ.setBounds (constant.getAlphabeticColumn1 (), constant.getAlphabeticRow5 (), constant.getAlphabeticWidth1 (), constant.getAlphabeticHeight2 ());
		add (buttonQ);
		buttonR.setBounds (constant.getAlphabeticColumn2 (), constant.getAlphabeticRow5 (), constant.getAlphabeticWidth2 (), constant.getAlphabeticHeight2 ());
		add (buttonR);
		buttonS.setBounds (constant.getAlphabeticColumn3 (), constant.getAlphabeticRow5 (), constant.getAlphabeticWidth2 (), constant.getAlphabeticHeight2 ());
		add (buttonS);
		buttonT.setBounds (constant.getAlphabeticColumn4 (), constant.getAlphabeticRow5 (), constant.getAlphabeticWidth1 (), constant.getAlphabeticHeight2 ());
		add (buttonT);
		buttonU.setBounds (constant.getAlphabeticColumn1 (), constant.getAlphabeticRow6 (), constant.getAlphabeticWidth1 (), constant.getAlphabeticHeight3 ());
		add (buttonU);
		buttonV.setBounds (constant.getAlphabeticColumn2 (), constant.getAlphabeticRow6 (), constant.getAlphabeticWidth2 (), constant.getAlphabeticHeight3 ());
		add (buttonV);
		buttonW.setBounds (constant.getAlphabeticColumn3 (), constant.getAlphabeticRow6 (), constant.getAlphabeticWidth2 (), constant.getAlphabeticHeight3 ());
		add (buttonW);
		buttonX.setBounds (constant.getAlphabeticColumn4 (), constant.getAlphabeticRow6 (), constant.getAlphabeticWidth1 (), constant.getAlphabeticHeight3 ());
		add (buttonX);
		buttonY.setBounds (constant.getAlphabeticColumn1 (), constant.getAlphabeticRow7 (), constant.getAlphabeticWidth1 (), constant.getAlphabeticHeight4 ());
		add (buttonY);
		buttonZ.setBounds (constant.getAlphabeticColumn2 (), constant.getAlphabeticRow7 (), constant.getAlphabeticWidth2 (), constant.getAlphabeticHeight4 ());
		add (buttonZ);
		button_.setBounds (constant.getAlphabeticColumn3 (), constant.getAlphabeticRow7 (), constant.getAlphabeticWidth2 (), constant.getAlphabeticHeight4 ());
		add (button_);
		buttonRIG.setBounds (constant.getAlphabeticColumn4 (), constant.getAlphabeticRow7 (), constant.getAlphabeticWidth1 (), constant.getAlphabeticHeight4 ());
		add (buttonRIG);
	}
	
	//stores the information about the right arrow buttons on the keyboard
	//right arrow buttons highlight orange when the right arrow buttons is rolled over
	//right arrow buttons changes the alphabetic keyboard to the numeric keyboard
	public class RightButton extends JButton
	{
		RightButton (String right)
		{
			setIcon (new ImageIcon (constant.getIcon () + right + constant.getIconExtenction ()));
			setRolloverIcon (new ImageIcon (constant.getRolloverIcon () + right + constant.getIconExtenction ()));
			setBorder (null);
			addMouseListener (new MouseAdapter ()
			{
				public void mouseClicked (MouseEvent event)
				{
					AlphabeticPrototype.this.dispose ();
					JFrame frame = new NumericPrototype ();
					frame.setLocationRelativeTo (null);
					frame.setSize (constant.getWhereToWidth (), constant.getWhereToHeight ());
					frame.setResizable (false);
					frame.setVisible (true);
				}
			});
		}
	}
	
	//displays the alphabetic keyboard on the screen
	public static void main (String [] array)
	{
		JFrame frame = new AlphabeticPrototype ();
		frame.setLocationRelativeTo (null);
		frame.setSize (constant.getWhereToWidth (), constant.getWhereToHeight ());
		frame.setResizable (false);
		frame.setVisible (true);
	}
}