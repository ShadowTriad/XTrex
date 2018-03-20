import javax.swing.*;
import java.awt.*;
import javax.swing.border.LineBorder;

import java.util.Observable;
import java.util.Observer;

public class MapView extends ModeView implements Observer {
	public XTrexController controller;
	public XTrexModel model;
	
	public MapView(XTrexController controller, XTrexModel model) {
		this.controller = controller;
		this.model = model;
		
		model.addObserver( this );
		repaint();
	}
	
	/*
     * Use when + button is pressed. Functionality to update image must be added.
     *
	public void zoomIn() {
        if (zoom > 0){
            zoom -= 1; 
            strZoom = Integer.toString(zoom);
        }
    }
	
	 /*
      * Use when - button is pressed. Functionality to update image must be added.
      *
    public void zoomOut() {
        if (zoom < 0) {
            zoom += 1; 
            strZoom = Integer.toString(zoom);
        }
    }
	*/
	
	public void update( Observable obs, Object obj ) {
		System.out.println(obs);
	}
	
	private void redDot(Graphics g) {
        g.setColor(Color.red);
        int dotSize = Integer.parseInt(model.getZoom())/2;
        g.fillOval(Constants.SCREENWIDTH/2-dotSize/2, Constants.SCREENHEIGHT/2-dotSize/2, dotSize, dotSize); 
    }
	
	/*
     * Method to display map on screen with red marker in centre.
     */
    protected void paintComponent( Graphics g ) {
		super.paintComponent(g);
	
		System.out.println(model.getMap());
        model.getMap().paintIcon(this, g, 0, 0);
        this.redDot(g);
    }
}