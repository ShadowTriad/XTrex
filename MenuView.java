/*
*@author Jasmine Green Cooke
*version 22/03/2018
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.util.Observable;
import java.util.Observer;

public class MenuView extends JPanel implements Observer{
	private XTrexController controller;
	private XTrexModel model;
	
	
	public MenuView(XTrexController controller, XTrexModel model){
		this.controller = controller;
		this.model = model;
		
		model.addObserver(this);
		setLayout(null);
		setBackground(new Color(0,0,0));
		setVisible(true);

	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.black);
		g.fillRect(0,0, 330, 415);
		(new ImageIcon("img/tilesWhite.jpeg")).paintIcon(this, g, 0, 20); //move to constants
		int x = 0;
		int y = 0;

		if(model.getIndex() % 2 == 0){
			x = 0;
			y = (model.getIndex()/2 * 97) + 20;
		}

		else{
			x = 120;
			y = ((model.getIndex()-1)/2 * 97) + 20;
		}
		(new ImageIcon("img/orange" + model.getTiles()[model.getIndex()] + ".jpeg")).paintIcon(this, g, x, y); 
		
	}
	
	public void update(Observable obs, Object obj){
		repaint();
	}
}
