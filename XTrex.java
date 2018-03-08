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
    
    final PlusButton plusButton = new PlusButton ("+");
    
    final MinusButton minusButton = new MinusButton ("-");
    
    final SelectButton selectButton = new SelectButton ("SELECT");
    
    final MenuButton menuButton = new MenuButton ("MENU");
    
    static About about = new About ();
	
    static Map map = new Map ();
	
    static Satellite satellite = new Satellite ();
	
    static Speech speech = new Speech ();
	
    static TripComputer tripComputer = new TripComputer ();
	
    static WhereTo whereTo = new WhereTo ();
    
    static mode currentMode; //purely symbolic for now, does not change what appears on screen
	
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
     * @author Oonagh
     */
    
    private class OnOffButton extends JButton
    {
    	OnOffButton ()
    	{
    		setBorder(new LineBorder(Color.RED));
    		
    		setContentAreaFilled(false);
    		
            setOpaque(false);
            
            addMouseListener ( new MouseAdapter ()
            {
            	public void mouseClicked (MouseEvent evenet)
            	{
                    if (currentMode == mode.OnOff)
                    {
                    	currentMode = mode.Menu;
                    }
                    
                    else
                    {
                        currentMode = mode.OnOff;
                    }
                }
            });
        }
    }
	
    /*
     * @author Oonagh
     * @author Faith
     */
    
    private class PlusButton extends JButton
    {
        PlusButton (String plus)
        {
            setBorder(new LineBorder(Color.RED));
    		
    		setContentAreaFilled(false);
    		
            setOpaque(false);
            
            addMouseListener ( new MouseAdapter ()
            {
            	public void mouseClicked (MouseEvent evenet)
            	{
                    if (currentMode == mode.WhereT0)
                    {
                    	whereTo.plus ();
					}
                }
            });
        }
    }
    
    /*
     * @author Oonagh
     * @author Faith
     */
    
    private class MinusButton extends JButton
    {
        MinusButton (String plus)
        {
            setBorder(new LineBorder(Color.RED));
    		
    		setContentAreaFilled(false);
    		
            setOpaque(false);
            
            addMouseListener ( new MouseAdapter ()
            {
            	public void mouseClicked (MouseEvent evenet)
            	{
                    if (currentMode == mode.WhereT0)
                    {
                    	whereTo.minus ();
					}
                }
            });
        }
    }

    /*
     * @author Oonagh
     */
     
    private class SelectButton extends JButton
    {
        SelectButton (String plus)
        {
            setBorder(new LineBorder(Color.RED));
    		
    		setContentAreaFilled(false);
    		
            setOpaque(false);
            
            addMouseListener ( new MouseAdapter ()
            {
            	public void mouseClicked (MouseEvent evenet)
            	{
					
                }
            });
        }
    }
    
    /*
     * @author Oonagh
     */
    
    private class MenuButton extends JButton
    {
        MenuButton (String plus)
        {
            setBorder(new LineBorder(Color.RED));
    		
    		setContentAreaFilled(false);
    		
            setOpaque(false);
            
            addMouseListener ( new MouseAdapter ()
            {
            	public void mouseClicked (MouseEvent evenet)
            	{
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