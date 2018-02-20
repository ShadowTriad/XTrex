import javax.swing.*;

import java.awt.*;

class WhereTo2 extends JPanel
{ 
	private static String address = "CHAGFORD";
	
	public WhereTo2 ()
	{
		
	}
	
	public WhereTo2 (String address)
	{
		this.address = address;
	}
	
	public void paintComponent (Graphics graphics)
	{	
		(new ImageIcon ("background2.png")).paintIcon(this, graphics, 0, 0);
		
		graphics.setColor (Color.black);
		
		graphics.setFont (new Font ("Arial", Font.PLAIN, 27));
		
		graphics.drawString(address, 16, 34);
		
		(new ImageIcon ("keycap1.png")).paintIcon(this, graphics, 9, 52);
		
		(new ImageIcon ("keycap2.png")).paintIcon(this, graphics, 82, 52);
		
		(new ImageIcon ("keycap3.png")).paintIcon(this, graphics, 157, 52);
		
		(new ImageIcon ("keycap4.png")).paintIcon(this, graphics, 9, 114);
		
		(new ImageIcon ("keycap5.png")).paintIcon(this, graphics, 82, 114);
		
		(new ImageIcon ("keycap6.png")).paintIcon(this, graphics, 157, 114);
		
		(new ImageIcon ("keycap7.png")).paintIcon(this, graphics, 9, 174);
		
		(new ImageIcon ("keycap8.png")).paintIcon(this, graphics, 82, 174);
		
		(new ImageIcon ("keycap9.png")).paintIcon(this, graphics, 157, 174);
		
		(new ImageIcon ("keycap0.png")).paintIcon(this, graphics, 9, 228);
		
		(new ImageIcon ("keycapDEL.png")).paintIcon(this, graphics, 82, 228);
		
		(new ImageIcon ("keycapLEF.png")).paintIcon(this, graphics, 9, 282);
	}
}