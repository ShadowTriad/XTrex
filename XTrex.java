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

import java.util.HashMap;

public class XTrex extends JFrame
{
    private final OnOffButton onOffButton = new OnOffButton();

    private final PlusButton plusButton = new PlusButton ("+");

    private final MinusButton minusButton = new MinusButton ("-");

    private final SelectButton selectButton = new SelectButton ("SELECT");

    private final MenuButton menuButton = new MenuButton ("MENU");

    private About about = new About ();

    private Map map = new Map ();

    public static Menu menu = new Menu ();

    private OnOff onOff = new OnOff ();

    private Satellite satellite = new Satellite ();

    private Speech speech = new Speech ();

    private TripComputer tripComputer = new TripComputer ();

    private WhereTo whereTo = new WhereTo ();

    public static Mode mode;

    private HashMap<Mode, JPanel> screens = new HashMap<Mode, JPanel>();


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

        About about = new About ();

        screens.put(Mode.ABOUT, about);
        screens.put(Mode.MAP, map);
        screens.put(Mode.MENU, menu);
        screens.put(Mode.ONOFF, onOff);
        screens.put(Mode.SATELLITE, satellite);
        screens.put(Mode.SPEECH, speech);
        screens.put(Mode.TRIPCOMPUTER, tripComputer);
        screens.put(Mode.WHERETO, whereTo);

        mode = Mode.ONOFF;
        showScreen(onOff);
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

            addMouseListener (new MouseAdapter()
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
        PlusButton (String label)
        {
            setBorder(new LineBorder(Color.RED));

            setContentAreaFilled(false);

            setOpaque(false);

            addMouseListener (new MouseAdapter()
            {
            	public void mouseClicked (MouseEvent event)
            	{
                    if (mode == Mode.WHERETO)
                    {
                    	whereTo.plusButton();
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
        MinusButton (String label)
        {
            setBorder(new LineBorder(Color.RED));

            setContentAreaFilled(false);

            setOpaque(false);

            addMouseListener (new MouseAdapter()
            {
            	public void mouseClicked (MouseEvent event)
            	{
                    if (mode == Mode.WHERETO)
                    {
                    	whereTo.minusButton();
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
        SelectButton (String label)
        {
            setBorder(new LineBorder(Color.RED));

            setContentAreaFilled(false);

            setOpaque(false);

            addMouseListener (new MouseAdapter()
            {
            	public void mouseClicked (MouseEvent event)
            	{
			if (mode == Mode.WHERETO)
                    	{
                    		whereTo.selectButton ();
                   	 }

			if (mode == Mode.MENU)
			{
				Mode newMode = menu.selectButton();
				switchMode(newMode);
                        	screens.get(newMode).repaint();
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
        MenuButton (String label)
        {
            setBorder(new LineBorder(Color.RED));

            setContentAreaFilled(false);

            setOpaque(false);

            addMouseListener (new MouseAdapter()
            {
            	public void mouseClicked (MouseEvent event)
            	{
			switchMode(Mode.MENU);
			menu.repaint();
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

        JPanel currentScreen = screens.get(mode);
        JPanel nextScreen = screens.get(newMode);

        System.out.print(mode);

        mode = newMode;

        System.out.println(mode);

        showScreen(nextScreen);
        getContentPane().remove(currentScreen);

        showScreen(nextScreen);

	}

    /*
     * Currently can check modes manually by changing XTrex.showScreen(arg) argument.
     * Speech mode used here as example; to check other modes, change arg and
     * comment out speech.selectButton();.
     */

    public static void main (String [] array)
    {
        XTrex xt = new XTrex();
		xt.setVisible(true);

    }
}
