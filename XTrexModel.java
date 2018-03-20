import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import javax.swing.border.LineBorder;
import java.util.HashMap;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;

public class XTrexModel extends Observable {
	private Mode mode;
	String latitude = "50.1"; // will be retrieved from gps later
	String longitude = "-3.1";
	public int zoom = 15;
    public String strZoom = Integer.toString(zoom);  
	public ImageIcon map;
	private String[ ] tiles = {
				"WhereTo", "TripComputer", 
				"Map", "Speech", 
				"Satellite", "About"
				};
	public int index = 0; //??????????????????????????
	
	// need current gps coords, goal gps coords, mode, time, speed..?, language, map
	
	public XTrexModel(Mode mode) {
		setCoords(latitude, longitude);
		setMode(mode);
	}
	
	/*
	* @author Jasmine
	*/
	public void switchMode(Mode newMode){
        mode = newMode;
	}///////////////////////////////////////////
	
	public void setMode(Mode mode) {
		this.mode = mode;
		setChanged();
		notifyObservers(mode);
	}
	public Mode getMode() {
		return mode;
	}

	public void setCoords(String latitude, String longitude) {
		this.latitude  = latitude;
		this.longitude = longitude;
		updateMap();
		setChanged(); ////????????????????????????????????????
		notifyObservers();
		
	}
	public String getLat() {
		return latitude;
	}
	
	public String getLong() {
		return longitude;
	}
	
	public String getZoom() {
		return strZoom;
	}
	
	public void setMap(ImageIcon map) {
		this.map = map;
		setChanged(); ////????????????????????????????????????
		notifyObservers();
		System.out.println("map set");
	}
	public ImageIcon getMap() {
		return map;
	}
	
	// is this constant?
	public String[] getTiles() {
		return tiles;
	}
	
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
		setChanged(); ////????????????????????????????????????
		notifyObservers();
	}
	
		
	
	/* REALLY not happy about putting this functionality in the model but 
	 * was experiencing issues putting it in controller 
	 *
     * Retrieve map data from Google Static Maps.
     * Based on method supplied by David Wakeling.
     */
    private byte[] readData() {
		byte[] response = null;
        String url = (
                "https://maps.googleapis.com/maps/api/staticmap?center=" 
                + getLat() + "," + getLong()
                + "&zoom=" + getZoom()
                + "&size=500x500" 
				+ "&key=AIzaSyBfZkuFHznqWYthnTcstRKpN8Ia6UQUzas" ////////////////////////////////////////////////
                );
        byte[] body = {};
        String[][] headers = {};
		while (response == null) {
			try {
				response = HttpConnect.httpConnect( "GET", url, headers, body );
			} catch (Exception e ) {}; //////////////////////////////////////////////////
		}
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
            //e.printStackTrace(); // CHANGE ////////////////////////////////////////////////////
			System.out.println("H");
        }
    }
	
	public void updateMap() {
		String output = "map.png"; ///////////////////////////////////////////////
		writeData( output, this.readData() ); 
		setMap(new ImageIcon(output));
	}
	
	
}