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

    private boolean goodRead;

    private ImageIcon img;

	public SatelliteView(XTrexController controller, XTrexModel model) {

		this.controller = controller;
		this.model = model;

        this.img = new ImageIcon( "img/noGPSDino.png" );

		model.addObserver( this );

	}

    public void paintComponent( Graphics g ) {
        super.paintComponent(g);


        if ( goodRead ) {
            //draw a white rectangle as background
            g.setColor(Color.white);
            g.fillRect(0,0, 330, 415);

            g.setColor(Color.black);
            g.setFont(new Font("Arial", Font.PLAIN, 30));

            String lat = model.formatCoord( latitude );
            String lon = model.formatCoord( longitude );

            System.out.println(lat);

            //draw the latitude and longitude to the screen
            g.drawString(lat + " " + latDirection, 25, 100);
            g.drawString(lon + " " + lonDirection, 25, 200);

        } else {

            img.paintIcon(this, g, 50, 150);

            g.setColor(Color.black);
            g.setFont(new Font("Arial", Font.PLAIN, 25));
            g.drawString( "Can't find GPS!", 25, 100 );

        }

        model.updateCoordinates();
        repaint();

    }

	public void update( Observable obs, Object obj ) {

        //get fresh data from the model
        this.latitude = model.getLatitude();
        this.latDirection = model.getLatDirection();
        this.longitude = model.getLongitude();
        this.lonDirection = model.getLonDirection();

        this.goodRead = model.getGoodRead();

        //repaint the screen
		repaint();
	}

}
