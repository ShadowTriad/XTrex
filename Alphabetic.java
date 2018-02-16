import java.awt.Color;

import java.awt.event.MouseAdapter;

import java.awt.event.MouseEvent;

import java.awt.TextField;

import javax.swing.ImageIcon;

import javax.swing.JButton;

import javax.swing.JFrame;

import javax.swing.JLabel;

public class Alphabetic extends JFrame
{
	private static String string = "";
		
	public final TextField display = new TextField ();
	
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
	
	private class RightButton extends JButton
	{
		RightButton (String right)
		{
			setIcon (new ImageIcon ("keycap" + right + ".png"));
			
			setBorder (null);
			
			addMouseListener (new MouseAdapter ()
			{
				public void mouseClicked (MouseEvent event)
				{
					
				}
			});
		}
	}
	
	public Alphabetic ()
	{
		setTitle ("Alphabetic");
		
		setContentPane (new JLabel (new ImageIcon ("background.png")));
		
		setLayout (null);
		
		display.setBounds (14, 12, 208, 25);
		
		add (display);
		
		buttonA.setBounds (11, 52, 52, 40);
		
		add (buttonA);
		
		buttonB.setBounds (65, 52, 54, 40);
		
		add (buttonB);
		
		buttonC.setBounds (121, 52, 54, 40);
		
		add (buttonC);
		
		buttonD.setBounds (177, 52, 52, 40);
		
		add (buttonD);
		
		buttonE.setBounds (11, 94, 52, 40);
		
		add (buttonE);
		
		buttonF.setBounds (65, 94, 54, 40);
		
		add (buttonF);
		
		buttonG.setBounds (121, 94, 54, 40);
		
		add (buttonG);
		
		buttonH.setBounds (177, 94, 52, 40);
		
		add (buttonH);
		
		buttonI.setBounds (11, 136, 52, 40);
		
		add (buttonI);
		
		buttonJ.setBounds (65, 136, 54, 40);
		
		add (buttonJ);
		
		buttonK.setBounds (121, 136, 54, 40);
		
		add (buttonK);
		
		buttonL.setBounds (177, 136, 52, 40);
		
		add (buttonL);
		
		buttonM.setBounds (11, 177, 52, 41);
		
		add (buttonM);
		
		buttonN.setBounds (65, 177, 54, 41);
		
		add (buttonN);
		
		buttonO.setBounds (121, 177, 54, 41);
		
		add (buttonO);
		
		buttonP.setBounds (177, 177, 52, 41);
		
		add (buttonP);
		
		buttonQ.setBounds (11, 219, 52, 41);
		
		add (buttonQ);
		
		buttonR.setBounds (65, 219, 54, 41);
		
		add (buttonR);
		
		buttonS.setBounds (121, 219, 54, 41);
		
		add (buttonS);
		
		buttonT.setBounds (177, 219, 52, 41);
		
		add (buttonT);
		
		buttonU.setBounds (11, 262, 52, 39);
		
		add (buttonU);
		
		buttonV.setBounds (65, 262, 54, 39);
		
		add (buttonV);
		
		buttonW.setBounds (121, 262, 54, 39);
		
		add (buttonW);
		
		buttonX.setBounds (177, 262, 52, 39);
		
		add (buttonX);
		
		buttonY.setBounds (11, 303, 52, 38);
		
		add (buttonY);
		
		buttonZ.setBounds (65, 303, 54, 38);
		
		add (buttonZ);
		
		button_.setBounds (121, 303, 54, 38);
		
		add (button_);
		
		buttonRIG.setBounds (177, 303, 52, 38);
		
		add (buttonRIG);
		
	}
	
	public static void main (String [] array)
	{
		JFrame frame = new Alphabetic ();
		
		frame.setLocationRelativeTo (null);
		
		frame.setSize (240, 375);
		
		frame.setResizable (false);
		
		frame.setVisible (true);
	}
}