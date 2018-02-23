/*
*Jasmine
*version 1.0
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Menu extends JPanel{
	//change mode to menu mode;
	
	private String[] tiles = {"WhereTo", "TripComputer", "Map", "Speech", "Satellite", "About"};
	public static int index = 0;
	public PlusButton pb = new PlusButton();
	public MinusButton mb = new MinusButton();
	public SelectButton sb = new SelectButton();
	public OnOffButton ob = new OnOffButton();
	
	
	Menu(){
		setBackground(new Color(0,0,0));
		pb.setBounds(160, 87, 30, 60);
		add(pb);
		mb.setBounds(160, 150, 30, 60);
		add(mb);
		sb.setBounds(160,240, 30, 60);
		add(sb);
		ob.setBounds (420, 132, 50, 50);
		add(ob);
		setVisible(true);
	}
	
	public void paintComponent( Graphics g ) {
		super.paintComponent(g);
		g.setColor(Color.black);
		g.fillRect(0,0, 330, 415);
		(new ImageIcon ("img/tilesWhite.jpeg")).paintIcon(this, g, 0, 20);
		int x = 0;
		int y = 0;
		
		//the following code doesn't work properly yet but it will be fixed
		if(index % 2 == 0){
			x = 0;
			y = (index/2 * 93) + 20;
		}
		
		else{
			x = 122; 
			y = ((index -1)/2 * 93) + 20;
		}
		(new ImageIcon("img/orange" + tiles[index] + "jpeg")).paintIcon(this, g, x, y);
		
	}

	
	class PlusButton extends JButton {
		PlusButton(){

			addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent e){
					//iterates between array values/modes
					
					if(Menu.index == 5){
						Menu.index = 0;
					}
					else{
						Menu.index++;
					}
					repaint();
				};
			});
		}
	}
	
	class MinusButton extends JButton{
		MinusButton(){
			addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent e){
					//iterates between array values/modes
					if(Menu.index == 0){
						Menu.index = 5;
					}
					else{
						Menu.index--;
					}
					repaint();
				
				};
			});
		}
	}
	
	class MenuButton extends JButton{}
	
	class SelectButton extends JButton{
		SelectButton(){
			addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent e){
					/*
					
					XTrex.currentMode = tiles[index];
					changes it to that mode
					
					*/
				};
			});
		}
	}
	
	class OnOffButton extends JButton{
		OnOffButton(){
			addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent e){
					//will change it to the onoff mode
				};
			});
		}
	}
}