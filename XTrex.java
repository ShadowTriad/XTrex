/**
 * @version 08/03/18
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
    public final OnOffButton onOffButton = new OnOffButton();
    
    public final PlusButton plusButton = new PlusButton ("+");
    
    public final MinusButton minusButton = new MinusButton ("-");
    
    public final SelectButton selectButton = new SelectButton ("SELECT");
    
    public final MenuButton menuButton = new MenuButton ("MENU");
    
    public static About about = new About ();
	
    public static Map map = new Map ();
	
    public static Menu menu = new Menu ();
	
    public static OnOff onOff = new OnOff ();
	
    public static Satellite satellite = new Satellite ();
	
    public static Speech speech = new Speech ();
	
    public static TripComputer tripComputer = new TripComputer ();
	
    public static WhereTo whereTo = new WhereTo ();
        
    public static Mode mode;
	
    public XTrex ()
    {
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

        setSize (727, 727);

        setResizable (false);

        setTitle ("XTrex");

        setContentPane (new JLabel (new ImageIcon ("img/xtrex.jpg")));

        getContentPane ().setLayout (null);

        onOffButton.setBounds (417, 114, 62, 62);
        
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
	 * @author Jasmine
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
            	public void mouseClicked (MouseEvent event)
            	{
                    if (mode == Mode.ONOFF)
                    {
						switchMode(Mode.MENU);
						menu.repaint();
                    }
                    
                    else
                    {

                    	switchMode(Mode.ONOFF);
						onOff.repaint();
                    }
                }
            });
        }
    }
	
    /*
     * @author Oonagh
     * @author Faith
	 * @author Jasmine
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
            	public void mouseClicked (MouseEvent event)
            	{
                    if (mode == Mode.WHERETO)
                    {
                    	whereTo.plusButton ();
                    }
					
					if(mode == Mode.MENU){
						
						menu.plusButton();
					}
                }
            });
        }
    }
    
    /*
     * @author Oonagh
     * @author Faith
	 * @author Jasmine
     */
    
    private class MinusButton extends JButton
    {
        MinusButton (String minus)
        {
            setBorder(new LineBorder(Color.RED));
            
            setContentAreaFilled(false);
            
            setOpaque(false);
            
            addMouseListener ( new MouseAdapter ()
            {
            	public void mouseClicked (MouseEvent event)
            	{
                    if (mode == Mode.WHERETO)
                    {
                    	whereTo.minusButton ();
                    }
					
					if (mode == Mode.MENU){
						menu.minusButton();
					}
                }
            });
        }
    }

    /*
     * @author Oonagh
	 * @author Jasmine
     */
     
    private class SelectButton extends JButton
    {
        SelectButton (String select)
        {
            setBorder(new LineBorder(Color.RED));
            
            setContentAreaFilled(false);
            
            setOpaque(false);
            
            addMouseListener ( new MouseAdapter ()
            {
            	public void mouseClicked (MouseEvent event)
            	{
					if (mode == Mode.WHERETO)
                    {
                    	whereTo.selectButton ();
                    }
					
					if(mode == Mode.MENU)
					{
						menu.selectButton();
						
						switchMode(mode);
					}
                }
            });
        }
    }
    
    /*
     * @author Oonagh
	 * @author Jasmine
     */
    
    private class MenuButton extends JButton
    {
        MenuButton (String menu)
        {
            setBorder(new LineBorder(Color.RED));
            
            setContentAreaFilled(false);
    		
            setOpaque(false);
            
            addMouseListener ( new MouseAdapter ()
            {
            	public void mouseClicked (MouseEvent event)
            	{
					switchMode(Mode.MENU);
					XTrex.menu.repaint();
                }
            });
        }
    }
    
    /*
     * Takes different modes screen as argument and display on screen.
     */
     
    private void showScreen (JPanel panel)
    {
		this.add (panel);

        panel.setSize (new Dimension (240, 353));

        panel.setBounds (240, 260, 240, 353);

		panel.setVisible (true);
		
    }
	
	/*
	* @author Jasmine
	*/
	
	public void switchMode(Mode newMode){
		mode = newMode;
		System.out.print(mode);
		
		
		switch(this.mode){
			case ABOUT: 		showScreen(about);
								break;
			case MAP: 			showScreen(map);
								break;
			case MENU: 			showScreen(menu);
								break;
			case ONOFF: 		showScreen(onOff);
								break;
			case SATELLITE:		showScreen(satellite);
								break;
			case SPEECH:		showScreen(speech);
								break;
			case TRIPCOMPUTER: 	showScreen(tripComputer);
								break;
			case WHERETO: 		showScreen(whereTo);
								break;
		}
		
	}

    /*
     * Currently can check modes manually by changing XTrex.showScreen(arg) argument.
     * Speech mode used here as example; to check other modes, change arg and
     * comment out speech.selectButton();.
     */
    
    public static void main (String [] array)
    {
        XTrex xt = new XTrex ();
		xt.setVisible(true);
		
    }
}