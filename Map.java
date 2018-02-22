import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.awt.*;
import javax.swing.*;

// url for google static maps:
// https://maps.googleapis.com/maps/api/staticmap?center=50.718412,-3.53389&zoom=15&size=600x600
//https://maps.googleapis.com/maps/api/staticmap?center=50.718412,-3.53389&zoom=15&size=600x600&markers=color:blue%7Clabel:S%7C50.718412,-3.53389

/*
need to be passed the current gps coordinates 
 */

public class Map extends JPanel {
    private GPS gps = new GPS();
    public static String output = "output.png";     
    public static String latitude;  
    public static String longitude;   
    public int zoom = 15;
    public String ZOOM = Integer.toString(zoom);        /* 0 .. 21           */   
    public ImageIcon map;

    /*
     *
     */
    public Map() {
        repaint();

    }

    /*
     * use when + button is pressed
     */
    public void zoomIn() {
        System.out.println(zoom);

        zoom = zoom + 1; 
        ZOOM = Integer.toString(zoom);
    }

    /*
     * use when - button is pressed
     */
    public void zoomOut() {
        zoom = zoom - 1;
        ZOOM = Integer.toString(zoom);
        // call read and write to update image

    }

    public void updateCoords() {
        latitude = gps.getLatitude();
        longitude = gps.getLongitude();
    }

    //***************

    private byte[] readData() {

        final String method = "GET"; // use of final?? is this necessary?
        final String url = (
                "https://maps.googleapis.com/maps/api/staticmap?center=" 
                + latitude + "," + longitude
                + "&zoom=" + ZOOM
                + "&size=240x353"
            );
        final byte[] body = {};
        final String[][] headers = {};
        byte[] response = HttpConnect.httpConnect( method, url, headers, body );
        return response;
    }

    //*************************
    /*
     * Write map data.
     */
    private void writeData( String file, byte[] data ) {
        try {
            OutputStream os = new FileOutputStream( file );
            os.write( data, 0, data.length );
            os.close();
        } catch ( IOException e ) {
            e.printStackTrace(); 
            System.exit( 1 ); // ??????????
        }
    }

    public void paintComponent( Graphics g ) {
        super.paintComponent(g);
        this.updateCoords();
        
        final byte[] data = this.readData(); 
        this.writeData( output, data ); 
        map = new ImageIcon("output.png");
        
        map.paintIcon(this, g, 0, 0);
        g.setColor(Color.red);
        g.fillOval(116, 173, 8, 8);
    }
}