import javax.swing.*;
import java.awt.*;
import javax.swing.border.LineBorder;
import java.util.Observable;
import java.util.Observer;

import java.awt.Graphics;
import java.awt.Graphics2D;

public class MapView extends ModeView implements Observer {
	public XTrexController controller;
	public XTrexModel model;
	private String latitude;
	private String longitude;
	
	private int zoom; 
	private ImageIcon map;
	private Direction last;
	private double rad;
	
	public MapView(XTrexController controller, XTrexModel model) {
		this.controller = controller;
		this.model = model;
		this.latitude = model.getLatitude();
		this.longitude = model.getLongitude();
		
		this.zoom = model.getZoom();
		this.map = model.getMap();
		this.rad = 0;
		
		model.addObserver( this );
		repaint();
	}
	
	private void redDot(Graphics g) {
        g.setColor(Color.red);
        int dotSize = zoom/2;
        g.fillOval(Constants.SCREENWIDTH/2 - dotSize/2, Constants.SCREENHEIGHT/2 - dotSize/2, dotSize, dotSize); 
    }
	
	/*
     * Method to display map on screen with red marker in centre.
     */
    public void paintComponent( Graphics g ) {
		super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.rotate(rad, Constants.SCREENWIDTH/2, Constants.SCREENHEIGHT/2);
		
        map.paintIcon(this, g2, Constants.SCREENWIDTH/2 - 250, Constants.SCREENHEIGHT/2 - 250); //add to constants		
        this.redDot(g2);
    }
	
	public void update( Observable obs, Object obj ) {
		rad = model.getRadians();
		System.out.println(rad);
		
		zoom = model.getZoom();
		this.map.getImage().flush();
       
		repaint();
	}
}