/*
*@author Jasmine Green Cooke
*version 1.0
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Menu extends JPanel {
	
	private String[ ] tiles = {
				"WhereTo", "TripComputer", 
				"Map", "Speech", 
				"Satellite", "About"
				};
	public int index = 0; //??????????????????????????
	
	public Menu( ) {
		index = 0;
		setLayout(null);
		setBackground(new Color(0,0,0));
		setVisible(true);

	}