/**
 * @version 22/02/18
 * @author Chris Tyson
 * @author Faith Yemofio
 * @author Jasmine Cooke
 * @author Oonagh Madden-Wells
 * @author Tilly Porthouse
 */

import javax.swing.*;

import java.awt.*;

public class XTrex extends JFrame
{
    public XTrex ()
    {
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        
        setSize (727, 727);
        
        setResizable (false);
        
        setTitle ("XTrex");
		
        setContentPane (new JLabel (new ImageIcon ("img/xtrex.jpg")));
        
        getContentPane ().setLayout (null);
    }
	
   /*
	* Takes different mode's screen as argument and display on screen.
	*/ 
    private void showScreen (JPanel panel)
    {
        getContentPane ().removeAll ();
        
        this.add (panel);
		
        panel.setSize (new Dimension (240, 353));
        
        panel.setBounds (240, 260, 240, 353);
		
        this.setVisible (true);
    }
	
   /*
	* Currently can check modes manually by changing XTrex.showScreen(arg) argument.
	* Speech mode used here as example; to check other modes, change arg and
	* comment out speech.selectButton();.
	*/
    public static void main (String [] array)
    {
        XTrex XTrex = new XTrex ();
        
        About about = new About ();
        
        Map map = new Map ();
        
        Satellite satellite = new Satellite ();
		
        Speech speech = new Speech ();
        
        TripComputer tripComputer = new TripComputer ();
        
        WhereTo whereTo = new WhereTo ();
		
        XTrex.showScreen (speech);
        
        speech.selectButton ();
    }
}