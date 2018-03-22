import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import javax.swing.border.LineBorder;

import java.util.Observable;
import java.util.Observer;

public class XTrexView extends JFrame implements Observer {
	
    public final OnOffButton onOffButton = new OnOffButton();
    public final PlusButton plusButton = new PlusButton("+");
    public final MinusButton minusButton = new MinusButton("-");
    public final SelectButton selectButton = new SelectButton("SELECT");
    public final MenuButton menuButton = new MenuButton("MENU"); 
	private HashMap<Mode, JPanel> screens = new HashMap<Mode, JPanel>(); 
   
	
    private XTrexController controller;
    private XTrexModel model;
    private OnOffView onOff;
    private MenuView menu;
    private MapView map;
    private SpeechView speech;
    private WhereToView whereTo;
    private TripComputerView tripComputer;
	
	private Mode mode;
	
    public XTrexView(XTrexController controller, XTrexModel model) {
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setSize(Constants.FRAME_SIZE, Constants.FRAME_SIZE);
	    setResizable(false);
	    setTitle("XTrex");
	    setContentPane(new JLabel(new ImageIcon (Constants.IMAGE_FILE)));
	    getContentPane().setLayout(null);
	    
	    onOffButton.setBounds(417, 114, 62, 62); //do we need to store these values as constants? //////////////////////
	    add(onOffButton);
	    onOffButton.addActionListener(controller);
	    
	    plusButton.setBounds(155, 70, 40, 50);
	    add(plusButton);
	    plusButton.addActionListener(controller);
	    
	    minusButton.setBounds(155, 135, 40, 50);
	    add(minusButton);
	    minusButton.addActionListener(controller);
	    
	    selectButton.setBounds(145, 225, 60, 70);
	    add(selectButton);
	    selectButton.addActionListener(controller);
	    
	    menuButton.setBounds(515, 75, 50, 70);
	    add (menuButton);
	    menuButton.addActionListener(controller);
	    
	    this.controller = controller;
	    this.model = model;
		this.mode = model.getMode();
	    
	    model.addObserver(this);
	    onOff = new OnOffView(controller, model);
	    menu = new MenuView(controller, model);
	    map = new MapView(controller, model);
		speech = new SpeechView(controller, model);
		whereTo = new WhereToView(controller, model);
		tripComputer = new TripComputerView(controller, model);
	    
		screens.put(Mode.ONOFF, onOff);
		screens.put(Mode.MENU, menu);
		screens.put(Mode.MAP, map);
		screens.put(Mode.SPEECH, speech);
		screens.put(Mode.WHERETO, whereTo);
		screens.put(Mode.TRIPCOMPUTER, tripComputer);
		
		showScreen(onOff);
	}
	
/*
     * Takes different modes screen as argument and display on screen.
     */
    private void showScreen(JPanel panel)
    {
	    this.add(panel);
	    //panel.setSize(new Dimension(240, 353));
	    panel.setBounds(240, 260, 240, 353);
	    panel.setVisible(true);
    }
	
	private void switchMode(Mode newMode) {
		JPanel currentScreen = screens.get(mode);
        JPanel nextScreen = screens.get( newMode );
		this.mode = newMode;

		//move to controller later?
		
		getContentPane().remove(currentScreen);
        //showScreen( nextScreen );
        //getContentPane().remove( currentScreen );
        showScreen( nextScreen );
		
	}
	
     /*
     * @author Oonagh
     */
    private class OnOffButton extends JButton{
    	OnOffButton(){
		setBorder(new LineBorder(Color.RED));
    		setContentAreaFilled(false);
		setOpaque(false);
			
        }
    }
    
     /*
     * @author Oonagh
     * @author Faith
     */
    private class PlusButton extends JButton {
        PlusButton(String plus){
            setBorder(new LineBorder(Color.RED));
            setContentAreaFilled(false);
            setOpaque(false);
        }
    }	
	
    /*
     * @author Oonagh
     * @author Faith
     */
    private class MinusButton extends JButton{
        MinusButton(String minus){
            setBorder(new LineBorder(Color.RED));
            setContentAreaFilled(false);
            setOpaque(false);
        }
    }
	
     /*
     * @author Oonagh
     */
    private class SelectButton extends JButton{
        SelectButton(String select){
            setBorder(new LineBorder(Color.RED));
            setContentAreaFilled(false);
            setOpaque(false);
        }
    }

	
    /*
     * @author Oonagh
     * @author Jasmine
     */
    private class MenuButton extends JButton{
        MenuButton(String label){
            setBorder(new LineBorder(Color.RED));
            setContentAreaFilled(false);
            setOpaque(false);
        }
    }

	public void update(Observable obs, Object obj){
		//need to check whether the mode has actually been changed?
		System.out.println(mode);
		System.out.println(model.getMode());
		if (mode != model.getMode()) {
			Mode newMode = model.getMode();
			System.out.println(newMode);
			switchMode( newMode );
			screens.get(newMode).repaint(); 
		}
	}
	
}
