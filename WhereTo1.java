/**
 * @version 22/02/18
 * @author Faith Yemofio
 */

import java.awt.*;

import java.util.*;

import javax.swing.*;

class WhereTo1 extends JPanel
{ 
	private static String address = "CHAGFORD";
	
	public int button = 0;
	
	public int minimum = 0;
	
	public int maximum = 27;
	
	public ArrayList <Keycap> keycaps = new ArrayList <Keycap> (28);
	
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
		
	public WhereTo1 ()
	{
		keycaps.add (buttonA);
		
		keycaps.add (buttonB);
		
		keycaps.add (buttonC);
		
		keycaps.add (buttonD);
		
		keycaps.add (buttonE);
		
		keycaps.add (buttonF);
		
		keycaps.add (buttonG);
		
		keycaps.add (buttonH);
		
		keycaps.add (buttonI);
		
		keycaps.add (buttonJ);
		
		keycaps.add (buttonK);
		
		keycaps.add (buttonL);
		
		keycaps.add (buttonM);
		
		keycaps.add (buttonN);
		
		keycaps.add (buttonO);
		
		keycaps.add (buttonP);
		
		keycaps.add (buttonQ);
		
		keycaps.add (buttonR);
		
		keycaps.add (buttonS);
		
		keycaps.add (buttonT);
		
		keycaps.add (buttonU);
		
		keycaps.add (buttonV);
		
		keycaps.add (buttonW);
		
		keycaps.add (buttonX);
		
		keycaps.add (buttonY);
		
		keycaps.add (buttonZ);
		
		keycaps.add (button_);
		
		keycaps.add (buttonRIG);
	}
	
	public WhereTo1 (String address, int minimum, int maximum)
	{
		keycaps.add (buttonA);
		
		keycaps.add (buttonB);
		
		keycaps.add (buttonC);
		
		keycaps.add (buttonD);
		
		keycaps.add (buttonE);
		
		keycaps.add (buttonF);
		
		keycaps.add (buttonG);
		
		keycaps.add (buttonH);
		
		keycaps.add (buttonI);
		
		keycaps.add (buttonJ);
		
		keycaps.add (buttonK);
		
		keycaps.add (buttonL);
		
		keycaps.add (buttonM);
		
		keycaps.add (buttonN);
		
		keycaps.add (buttonO);
		
		keycaps.add (buttonP);
		
		keycaps.add (buttonQ);
		
		keycaps.add (buttonR);
		
		keycaps.add (buttonS);
		
		keycaps.add (buttonT);
		
		keycaps.add (buttonU);
		
		keycaps.add (buttonV);
		
		keycaps.add (buttonW);
		
		keycaps.add (buttonX);
		
		keycaps.add (buttonY);
		
		keycaps.add (buttonZ);
		
		keycaps.add (button_);
		
		keycaps.add (buttonRIG);
		
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
		if ((keycaps.get (button)).getName () == "RIG")
		{
			
		}
		
		else
		{
			address = address + (keycaps.get (button)).getName ();
		}
	}
	
	public void paintComponent (Graphics graphics)
	{
		(new ImageIcon ("img/background.png")).paintIcon(this, graphics, 0, 0);
		
		graphics.setColor (Color.black);
		
		graphics.setFont (new Font ("Arial", Font.PLAIN, 27));
		
		graphics.drawString (address, 16, 34);
		
		for (int index = 0; index<=27; index = index + 1)
		{
			if (index == button)
			{
				(new ImageIcon ("img/rollover" + (keycaps.get (index)).getName () + ".png")).paintIcon (this, graphics, (keycaps.get (index)).getX (), (keycaps.get (index)).getY ());
			}
			
			else
			{
				(new ImageIcon ("img/keycap" + (keycaps.get (index)).getName () + ".png")).paintIcon (this, graphics, (keycaps.get (index)).getX (), (keycaps.get (index)).getY ());
			}
		}

		repaint ();
	}
}