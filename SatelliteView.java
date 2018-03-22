import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.util.Observable;
import java.util.Observer;

public class SatelliteView extends JPanel implements Observer {

    private XTrexController controller;
	private XTrexModel model;

    private String latitude;
    private String latDirection;

    private String longitude;
    private String lonDirection;

	public SatelliteView(XTrexController controller, XTrexModel model) {

		this.controller = controller;
		this.model = model;

		model.addObserver( this );

	}

    public void paintComponent( Graphics g ) {
        super.paintComponent(g);

        //draw a white rectangle as background
        g.setColor(Color.white);
        g.fillRect(0,0, 330, 415);

        //set the text to arial black
        g.setColor(Color.black);
        g.setFont(new Font("Arial", Font.PLAIN, 30));

        String lat = model.formatCoord( latitude );
        String lon = model.formatCoord( longitude );

        //draw the latitude and longitude to the screen
        g.drawString(lat + " " + latDirection, 25, 100);
        g.drawString(lon + " " + lonDirection, 25, 200);

    }

	public void update( Observable obs, Object obj ) {

        //get fresh data from the model
        this.latitude = model.getLatitude();
        this.latDirection = model.getLatDirection();
        this.longitude = model.getLongitude();
        this.lonDirection = model.getLonDirection();

        //repaint the screen
		repaint();
	}

}
