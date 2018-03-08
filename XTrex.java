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

import java.awt.event.MouseAdapter;

import java.awt.event.MouseEvent;

import javax.swing.border.LineBorder;


public class XTrex extends JFrame
{
    final OnOffButton onOffButton = new OnOffButton();
    
    final PlusMinusButton plusButton = new PlusMinusButton ("+");
    
    final PlusMinusButton minusButton = new PlusMinusButton ("-");
    
    final SelectButton selectButton = new SelectButton ("SELECT");
    
    final MenuButton menuButton = new MenuButton ("MENU");
    
    static About about = new About ();
	
    static Map map = new Map ();
	
    static Satellite satellite = new Satellite ();
	
    static Speech speech = new Speech ();
	
    static TripComputer tripComputer = new TripComputer ();
	
    static WhereTo whereTo = new WhereTo ();
    
    static mode currentMode; //purely symbolic for now, does not change what appears on screen - @Oonagh
	
    public XTrex ()
    {
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

        setSize (727, 727);

        setResizable (false);

        setTitle ("XTrex");

        setContentPane (new JLabel (new ImageIcon ("img/xtrex.jpg")));

        getContentPane ().setLayout (null);

        onOffButton.setBounds ( 417, 114, 62, 62);
        
        add (onOffButton);

        plusButton.setBounds (155, 70, 40, 50);
        
        add (plusButton);

        minusButton.setBounds (155, 135, 40, 50);
        
        add (minusButton);
        
        selectButton.setBounds (145, 225, 60, 70);
        
        add (selectButton);
        
        menuButton.setBounds (515, 75, 50, 70);
        
        add (menuButton);
    }

    /*
     * Not sure if this is the way in which we'll represent the mode being changed but this is just a suggestion for now.
     * 
     * @author Oonagh
     * 
     */
    private class OnOffButton extends JButton {
        OnOffButton() {
            setBorder(new LineBorder(Color.RED));
            //setBorderPainted(false);
            setContentAreaFilled(false);
            setOpaque(false);
            addMouseListener( new MouseAdapter() {
                    public void mouseClicked( MouseEvent me) {
                        if (currentMode == mode.OnOff) {
                            currentMode = mode.Menu;
                        } else {
                            currentMode = mode.OnOff;
                        }
                    }
                });
        }
    }

     /*
     * This might be a really weird way of doing this. I could just as easily make 'plusbutton' and 'minusbutton' classes seperately but idk if it makes a difference. 
     * 
     * @author Oonagh
     * 
     */
    private class PlusMinusButton extends JButton {
        PlusMinusButton(String text) {
            super(text);
            setBorder(new LineBorder(Color.RED));
            //setBorderPainted(false);
            setFont(new Font("Arial", Font.BOLD, 16));
            setForeground(Color.RED);
            setContentAreaFilled(false);
            setOpaque(false);
            addMouseListener( new MouseAdapter() {
                    public void mouseClicked( MouseEvent me) {
                        switch (text) {
                            case "+": 
                                if (currentMode == mode.WhereTo)
                                {
                                	whereTo.plus ();
                                }
                                
                            case "-": 
                                if (currentMode == mode.WhereTo)
                                {
                                	whereTo.plus ();
                                }
                        }
                    } 
                });
        }
    }

     /*
     * 
     * @author Oonagh
     * 
     */
    private class SelectButton extends JButton {
        SelectButton(String text) {
            super(text);
            setBorder(new LineBorder(Color.RED));
            //setBorderPainted(false);
            setFont(new Font("Arial", Font.BOLD, 12));
            setForeground(Color.RED);
            setContentAreaFilled(false);
            setOpaque(false);
            addMouseListener( new MouseAdapter() {
                    public void mouseClicked( MouseEvent me) {
                        // do whatever select in this mode does
                    } 
                });
        }
    }
    
     /*
     * 
     * @author Oonagh
     * 
     */
    private class MenuButton extends JButton {
        MenuButton(String text) {
            super(text);
            setBorder(new LineBorder(Color.RED));
            //setBorderPainted(false);
            setFont(new Font("Arial", Font.BOLD, 12));
            setForeground(Color.RED);
            setContentAreaFilled(false);
            setOpaque(false);
            addMouseListener( new MouseAdapter() {
                    public void mouseClicked( MouseEvent me) {
                        currentMode = mode.Menu;
                    } 
                });
        }
    }
    
    /*
     * Takes different mode's screen as argument and display on screen.
     */ 
    private void showScreen (JPanel panel)
    {
        //getContentPane ().removeAll (); //need a solution to this

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
        currentMode = mode.OnOff;
        
        XTrex XTrex = new XTrex ();
		
        XTrex.showScreen (about);
		
        //speech.selectButton ();
    }
}