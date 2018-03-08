import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.awt.*;
import javax.swing.*;
import java.lang.Math;
// comments: dont bury constants, 


/* 
 * Map class for the Map Mode of the XTrex. Utilises the HttpConnect class
 * by David Wakeling and extends JPanel so it can be displayed.
 * Retrieves a Google Static Map for the coordinates supplied by GPS and 
 * saves as an ImageIcon with a central circle marker (displaying current dummy location)
 * so it can be displayed on the XTrex JFrame.
 * Has light functionality to allow for the zoom of the image to increase/decrease when required.
 *
 * @author Oonagh
 * @version 1.0
 */

public class Map extends JPanel {
    //private int screenHeight = 353; // put somewhere else accessible to all  
    //private int screenWidth = 240; // move
    private GPS gps = new GPS();
    public static String output = "map.png";     
    public static String latitude = "50.7225";  
    public static String longitude = "3.5299";   
    public int zoom = 20;
    public String strZoom = Integer.toString(zoom);        /* 0 .. 21           */   
    public ImageIcon map;
    public static double goalLat = 51.51;
    public static double goalLong = 0.1277;

    /*
     * Constructor
     */
    public Map() {
        repaint();
    }

    /*
     * Use when + button is pressed. Functionality to update image must be added.
     */
    public void zoomIn() {
        if (zoom > 0){
            zoom -= 1; 
            strZoom = Integer.toString(zoom);
        }
    }

    /*
     * Use when - button is pressed. Functionality to update image must be added.
     */
    public void zoomOut() {
        if (zoom < 0) {
            zoom += 1; 
            strZoom = Integer.toString(zoom);
        }
    }

    /*
     * Currently retrieves dummy 'current coordinates' 
     */
    public void updateCoords() {
        latitude = gps.getLatitude();
        longitude = gps.getLongitude();
    }

    /*
     * Retrieve map data from Google Static Maps.
     * Based on method supplied by David Wakeling.
     */
    private byte[] readData() {
        String url = (
                "https://maps.googleapis.com/maps/api/staticmap?center=" 
                + "50.7226" + "," + "-3.529"
                + "&zoom=" + strZoom
                + "&size=" + Constants.STRWIDTH + "x" + Constants.STRHEIGHT
                );
        final byte[] body = {};
        final String[][] headers = {};
        byte[] response = HttpConnect.httpConnect( "GET", url, headers, body );
        return response;
    }

    /*
     * Write map data to file so image can be used.
     * Based on method supplied by David Wakeling.
     */
    private void writeData( String file, byte[] data ) {
        try {
            OutputStream os = new FileOutputStream( file );
            os.write( data, 0, data.length );
            os.close();
        } catch ( IOException e ) {
            e.printStackTrace(); 
            System.exit( 1 ); 
        }
    }
    
    public double getDirection() { 
        double cLat  = Double.parseDouble(latitude);  
        double cLong = Double.parseDouble(longitude);
        double theta = Math.atan2(Math.sin(goalLong-cLong)*Math.cos(goalLat),
                       Math.cos(cLat)*Math.sin(goalLat)-Math.sin(cLat)*Math.cos(goalLat)*Math.cos(goalLong-cLong));
        theta = (Math.toDegrees(theta)+360)%360;
        return theta;
    }
    
    /*
     * Method to display map on screen with red marker in centre.
     */
    public void paintComponent( Graphics g ) {
        this.updateCoords();

        super.paintComponent(g);

        final byte[] data = this.readData(); 
        this.writeData( output, data ); 
        map = new ImageIcon(output);

        map.paintIcon(this, g, 0, 0);
        this.redDot(g);
        
        repaint();
    }
    
    //it is possible this is nonsense? bit mystified
    private void redDot(Graphics g) {
        g.setColor(Color.red);
        
        int dotSize = zoom/2;
        g.fillOval(Constants.SCREENWIDTH/2-dotSize/2, Constants.SCREENHEIGHT/2-dotSize/2, dotSize, dotSize); //make less ugly
    }
}