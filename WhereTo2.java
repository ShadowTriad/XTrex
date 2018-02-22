import java.awt.*;

import java.util.*;

import javax.swing.*;

class WhereTo2 extends JPanel
{ 
	private static String address = "CHAGFORD";
	
	public int button = 0;
	
	public int minimum = 0;
	
	public int maximum = 11;
	
	public ArrayList <Keycap> keycaps = new ArrayList <Keycap> (12);
	
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
		
	public WhereTo2 ()
	{
		keycaps.add (button1);
		
		keycaps.add (button2);
		
		keycaps.add (button3);
		
		keycaps.add (button4);
		
		keycaps.add (button5);
		
		keycaps.add (button6);
		
		keycaps.add (button7);
		
		keycaps.add (button8);
		
		keycaps.add (button9);
		
		keycaps.add (button0);
		
		keycaps.add (buttonDEL);
		
		keycaps.add (buttonLEF);
	}
	
	public WhereTo2 (String address, int minimum, int maximum)
	{
		keycaps.add (button1);
		
		keycaps.add (button2);
		
		keycaps.add (button3);
		
		keycaps.add (button4);
		
		keycaps.add (button5);
		
		keycaps.add (button6);
		
		keycaps.add (button7);
		
		keycaps.add (button8);
		
		keycaps.add (button9);
		
		keycaps.add (button0);
		
		keycaps.add (buttonDEL);
		
		keycaps.add (buttonLEF);
		
		this.address = address;
		
		this.minimum = minimum;
		
		this.maximum = maximum;
	}
	
	public void plus ()
	{
		if (button == maximum)
		{
			button = minimum;
		}
		
		else
		{
			button = button + 1;
		}
	}
	
	public void minus ()
	{
		if (button == minimum)
		{
			button = maximum;
		}
		
		else
		{
			button = button - 1;
		}
	}
	
	public void select ()
	{		
		if ((keycaps.get (button)).getName () == "DEL")
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
		
		else if ((keycaps.get (button)).getName () == "LEF")
		{
			
		}
		
		else
		{
			address = address + (keycaps.get (button)).getName ();
		}
	}
	
	public void paintComponent (Graphics graphics)
	{
		(new ImageIcon ("background2.png")).paintIcon (this, graphics, 0, 0);
		
		graphics.setColor (Color.black);
		
		graphics.setFont (new Font ("Arial", Font.PLAIN, 27));
		
		graphics.drawString (address, 16, 34);
		
		for (int index = 0; index<=11; index = index + 1)
		{
			if (index == button)
			{
				(new ImageIcon ("rollover" + (keycaps.get (index)).getName () + ".png")).paintIcon (this, graphics, (keycaps.get (index)).getX (), (keycaps.get (index)).getY ());
			}
			
			else
			{
				(new ImageIcon ("keycap" + (keycaps.get (index)).getName () + ".png")).paintIcon (this, graphics, (keycaps.get (index)).getX (), (keycaps.get (index)).getY ());
			}
		}
		
		repaint ();
	}
}