/**
* @author Jasmine Green Cooke
* version 14/03/2018
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Menu extends JPanel {

	public Mode mode = Mode.MENU;
	private String[] tiles = {"WhereTo", "TripComputer", "Map", "Speech", "Satellite", "About"};
	public int index = 0;

	/*
	* creates a new Menu object and sets the layout, the background colour and the visibility
	*/
	public Menu(){
		index = 0;
		setLayout(null);
		setBackground(new Color(0,0,0));
		setVisible(true);

	}

	/*
	* paints the JPanel to the screen
	*/
	public void paintComponent( Graphics g ) {
		super.paintComponent(g);
		g.setColor(Color.black);
		g.fillRect(0,0, 330, 415);
		(new ImageIcon ("img/tilesWhite.jpeg")).paintIcon(this, g, 0, 20);
		int x = 0;
		int y = 0;
		
		//replaces the current tile with the highlighted version
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

	/*
	* is used when the plus button on the side of the XTrex is pressed
	* changes the index value, which in turn relates to the tile highlighted
	*/
	public void plusButton(){
		if(index == 5){
			index = 0;
		}
		else{
			index++;
		}
		repaint();
	}
	
	/*
	* is used when the plus button on the side of the XTrex is pressed
	* changes the index value, which in turn relates to the tile highlighted
	*/
	public void minusButton (){
		if(index == 0){
			index = 5;
		}
		else{
			index--;
		}
		repaint();
	}
	
	/*
	* is used when the select button on the side of the XTrex is pressed
	* changes the mode of the XTrex to the one currently highlighted
	*/
	public Mode selectButton() {

		Mode m = Mode.values()[ index ];
		return m;

	}

}
