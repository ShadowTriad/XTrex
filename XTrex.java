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
	
    private void showScreen (JPanel panel)
    {
        getContentPane ().removeAll ();
        
        this.add (panel);
		
        panel.setSize (new Dimension (240, 353));
        
        panel.setBounds (240, 260, 240, 353);
		
        this.setVisible (true);
    }
		
    public static void main (String [] array)
    {
        XTrex XTrex = new XTrex ();
        
        About about = new About ();
        
        Satellite satellite = new Satellite ();
		
        Speech speech = new Speech ();
        
        WhereTo whereTo = new WhereTo ();
		
		TripComputer tripComputer = new tripComputer ();
		
        XTrex.showScreen (speech);
        
        speech.selectButton ();
    }
}