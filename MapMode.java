import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
/* oonagh's
 * tbh a lot of this stuff probably will change if integrated w 
 * other functionality but thats just life i guess.
 * kinda ganked from the maps workshop
 * CURRENTLY DEPENDS ON BEING IN THE SAME FILE AS WAKELING'S Httpconnect.java FILE, WILL MAKE MY OWN SOON!!
 */


// url for google static maps:
// https://maps.googleapis.com/maps/api/staticmap?center=50.718412,-3.53389&zoom=15&size=600x600

public class MapMode {
	public static String OUTPUT = "output.png"; // Output file       
	public static String LATITUDE;  
	public static String LONGITUDE;   
	public int zoom;
	public static String ZOOM;        /* 0 .. 21           */
	public static String SIZE = "612x612";         // can define once we get gui
	
   /*
	* probably will have to change what type the args are
	*/
	public MapMode(int L1, int L2, int z) {
		LATITUDE = Integer.toString(L1); 
		LONGITUDE = Integer.toString(L2);
		zoom = z;
		ZOOM = Integer.toString(zoom);
	
	}
 
	/*
	* use when + button is pressed
	* get rid of printlns
	*/
	public void zoomIn() {
		System.out.println(zoom);
		
		zoom = zoom + 1; // probably should be more than 1
		ZOOM = Integer.toString(zoom);
		System.out.println(ZOOM);
		// call read and write to update image
	};
 
	/*
	* use when - button is pressed
	* get rid of printlns
	*/
	public void zoomOut() {
		
		System.out.println(zoom);
		zoom = zoom - 1;
		ZOOM = Integer.toString(zoom);
		
		System.out.println(ZOOM);
		// call read and write to update image
	  
	};	
	
	
	//***************
	
	static byte[] readData() {
								
		final String method = "GET"; // use of final?? is this necessary?
		final String url = ( "https://maps.googleapis.com/maps/api/staticmap"
						+ "?" + "center" + "=" + LATITUDE + "," + LONGITUDE
						+ "&" + "zoom"   + "=" + ZOOM
						+ "&" + "size"   + "=" + SIZE // can set size soon
						); // can i just get rid of some of the concats?
		final byte[] body = {};
		final String[][] headers = {};
		byte[] response = HttpConnect.httpConnect( method, url, headers, body );
		return response;
	}
	
	//*************************
  /*
   * Write map data.
   */
	static void writeData( String file, byte[] data ) {
		try {
		OutputStream os = new FileOutputStream( file );
		os.write( data, 0, data.length );
		os.close();
		} catch ( IOException ex ) {
		ex.printStackTrace(); System.exit( 1 );
		}
	}
  
  
	//***************
	
	public static void main( String[] argv) {
		MapMode m = new MapMode(53, 0, 15);
		m.zoomIn();
		
		final byte[] data = m.readData(); 
		m.writeData( OUTPUT, data ); 
		
		
	
		
		
	}
}