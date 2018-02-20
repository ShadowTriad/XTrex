import javax.swing.*;

import java.awt.*;

class WhereTo1 extends JPanel
{ 
	private static String address = "CHAGFORD";
	
	public WhereTo1 ()
	{
		
	}
	
	public WhereTo1 (String address)
	{
		this.address = address;
	}
	
	public void paintComponent (Graphics graphics)
	{
		graphics.setColor (Color.black);
		
		graphics.fillRect (0, 0, 240, 353);
		
		graphics.setFont (new Font ("Arial", Font.PLAIN, 27));
		
		(new ImageIcon ("background.png")).paintIcon(this, graphics, 0, 0);
		
		graphics.drawString(address, 16, 34);
		
		(new ImageIcon ("keycapA.png")).paintIcon(this, graphics, 11, 52);
		
		(new ImageIcon ("keycapB.png")).paintIcon(this, graphics, 65, 52);
		
		(new ImageIcon ("keycapC.png")).paintIcon(this, graphics, 121, 52);
		
		(new ImageIcon ("keycapD.png")).paintIcon(this, graphics, 177, 52);
		
		(new ImageIcon ("keycapE.png")).paintIcon(this, graphics, 11, 94);
		
		(new ImageIcon ("keycapF.png")).paintIcon(this, graphics, 65, 94);
		
		(new ImageIcon ("keycapG.png")).paintIcon(this, graphics, 121, 94);
		
		(new ImageIcon ("keycapH.png")).paintIcon(this, graphics, 177, 94);
		
		(new ImageIcon ("keycapI.png")).paintIcon(this, graphics, 11, 136);
		
		(new ImageIcon ("keycapJ.png")).paintIcon(this, graphics, 65, 136);
		
		(new ImageIcon ("keycapK.png")).paintIcon(this, graphics, 121, 136);
		
		(new ImageIcon ("keycapL.png")).paintIcon(this, graphics, 177, 136);
		
		(new ImageIcon ("keycapM.png")).paintIcon(this, graphics, 11, 177);
		
		(new ImageIcon ("keycapN.png")).paintIcon(this, graphics, 65, 177);
		
		(new ImageIcon ("keycapO.png")).paintIcon(this, graphics, 121, 177);
		
		(new ImageIcon ("keycapP.png")).paintIcon(this, graphics, 177, 177);
		
		(new ImageIcon ("keycapQ.png")).paintIcon(this, graphics, 11, 219);
		
		(new ImageIcon ("keycapR.png")).paintIcon(this, graphics, 65, 219);
		
		(new ImageIcon ("keycapS.png")).paintIcon(this, graphics, 121, 219);
		
		(new ImageIcon ("keycapT.png")).paintIcon(this, graphics, 177, 219);
		
		(new ImageIcon ("keycapU.png")).paintIcon(this, graphics, 11, 262);
		
		(new ImageIcon ("keycapV.png")).paintIcon(this, graphics, 65, 262);
		
		(new ImageIcon ("keycapW.png")).paintIcon(this, graphics, 121, 262);
		
		(new ImageIcon ("keycapX.png")).paintIcon(this, graphics, 177, 262);
		
		(new ImageIcon ("keycapY.png")).paintIcon(this, graphics, 11, 303);
		
		(new ImageIcon ("keycapZ.png")).paintIcon(this, graphics, 65, 303);
		
		(new ImageIcon ("keycap_.png")).paintIcon(this, graphics, 121, 303);
		
		(new ImageIcon ("keycapRIG.png")).paintIcon(this, graphics, 177, 303);
	}
}