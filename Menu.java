/*
*@author Jasmine Green Cooke
*version 1.0
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Menu extends JPanel {
	
	public Mode mode = Mode.MENU;
	private String[] tiles = {"WhereTo", "TripComputer", "Map", "Speech", "Satellite", "About"};
	public int index = 0;
	
	Menu(){
		index = 0;
		setLayout(null);
		setBackground(new Color(0,0,0));
		setVisible(true);
		
	}
	
	
	public void paintComponent( Graphics g ) {
		super.paintComponent(g);
		g.setColor(Color.black);
		g.fillRect(0,0, 330, 415);
		(new ImageIcon ("img/tilesWhite.jpeg")).paintIcon(this, g, 0, 20);
		int x = 0;
		int y = 0;
		
		if(index % 2 == 0){
			x = 0;
			y = (index/2 * 97) + 20;
		}
		
		else{
			x = 120; 
			y = ((index -1)/2 * 97) + 20;
		}
		(new ImageIcon("img/orange" + tiles[index] + ".jpeg")).paintIcon(this, g, x, y);
	}

	public void plusButton(){
		if(index == 5){
			index = 0;
		}
		else{
			index++;
		}
		repaint();
	}
	
	public void minusButton (){
		if(index == 0){
			index = 5;
		}
		else{
			index--;
		}
		repaint();
	}
	
	public void selectButton(){
		int i =0;
		for(Mode m: Mode.values()){
			if(index == i){
				XTrex.mode = m;
				break;
			}
			i++;
		}
	}
	
}