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

public class Numeric extends JFrame
{
	private static String string = "";
		
	public final TextField field = new TextField ();
	
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
	
	public Numeric ()
	{
		setTitle ("Numeric");
		
		setContentPane (new JLabel (new ImageIcon ("img/background2.png")));
		
		setLayout (null);
		
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
	
	public Numeric (String string)
	{
		this.string = string;
		
		field.setText (string);
		
		setTitle ("Numeric");
		
		setContentPane (new JLabel (new ImageIcon ("img/background2.png")));
		
		setLayout (null);
		
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
	
	public static void main (String [] array)
	{
		JFrame frame = new Numeric ();
		
		frame.setLocationRelativeTo (null);
		
		frame.setSize (240, 375);
		
		frame.setResizable (false);
		
		frame.setVisible (true);
	}
}