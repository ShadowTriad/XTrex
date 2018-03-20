/*
*@author Jasmine Green Cooke
*version 1.0
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.util.Observable;
import java.util.Observer;

public class OnOffView extends JPanel implements Observer {

	private XTrexController controller;
	private XTrexModel model;

	public OnOffView(XTrexController controller, XTrexModel model) {
		this.controller = controller;
		this.model = model;
		
		model.addObserver( this );
	
	}

	public void paintComponent( Graphics g ) {
        super.paintComponent(g);
        g.setColor(Color.black);
        g.fillRect(0,0, 240, 353);		
    }
	
	public void update( Observable obs, Object obj ) {
		repaint();
	}


}