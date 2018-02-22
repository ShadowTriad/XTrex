/**
 * Screen to display current GPS coordinates.
 *
 * @version 22/02/18
 * @author Chris Tyson
 */

import javax.swing.*;
import java.awt.*;

class Satellite extends JPanel {

    GPS gps;

    public Satellite() {

        repaint();

        this.gps = new GPS();
    }

    public void paintComponent( Graphics g ) {
        //draw the lat and lon coords onto the JPanel

        super.paintComponent(g);

        String lat = gps.getLatitude();
        String lon = gps.getLongitude();

        setBackground(new Color(243,213,12));

        g.setColor(Color.white);
        g.fillRect(0,0, 330, 415);

        g.setColor(Color.black);
        g.setFont(new Font("Arial", Font.PLAIN, 30));
        g.drawString(lon + "  N", 50, 100);
        g.drawString(lat + "  W", 50, 200);

        //repaint();
    }

}
