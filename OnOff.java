/*
*Jasmine
*version 1.0
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class OnOff extends JPanel{
	//change mode to onoff mode
	
	
	 public void paintComponent( Graphics g ) {
        super.paintComponent(g);

        setBackground(new Color(243,213,12));

        g.setColor(Color.black);
        g.fillRect(0,0, 330, 415);
    }
	
	public OnOff(){
		repaint();
		
	}
	
	private class OnOffButton extends JButton{
		OnOffButton(){
		addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				//change current mode to menu mode
			};
		});
		}
	}
}