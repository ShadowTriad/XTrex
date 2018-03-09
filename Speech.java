import java.io.File;
import java.io.FileOutputStream;
import java.io.DataOutputStream;
import java.util.*;
import java.util.List;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;
import javax.swing.*;
import java.awt.*;
import java.net.URLEncoder;

/**
 *  This class provides the Speech mode to the XTrex. 
 * 
 * @author Tilly 
 * @version 1.0
 */
public class Speech extends JPanel
{
    // languages is a list of languages on offer
    public List<String> languages = Arrays.asList("Off","en-US", "fr-FR","de-DE","It-IT","es-ES");
    final static String currentGPSLocation = "The Forum, Exeter University"; //only used for testing, will get destination from GPS class
    final static String destination = "Cathedral Green, Exeter"; //only used for testing, will get destination from WhereTo class
    final static String region      = "uk";
    final static String mode        = "driving"; //as walking is in beta and is flawed
    
    GPS gps = new GPS();
    
    //languages counter is used to record what language is currently selected
    public int currentLanguageCount = 3;
    
    /*
    *USED FOR TESTING PURPOSES ONLY, has same contents as SelectButton()
    */
    public Speech(){
       //select language when button presed
        //String TEXT   = "In 200 yards, turn left at the next junction";
        //String token = renewAccessToken(); 
        //^needs to be done every 10 mins
        //createSoundFile(token, TEXT,"fr-FR");
        //AudioInputStream stm = setupStream("output.wav");
        //playStream( stm, readStream( stm ) );
        
    }

    /*
     * Creates a screen to be viewed on the XTrex JFrame
     */
    public void paintComponent( Graphics g ) {
        super.paintComponent(g);

        //creating the while background
        g.setColor(Color.white);
        g.fillRect(0,0, 330, 415);
        
        //creates a box in orange if the current language state isn't "Off
        g.setColor(Color.orange);
        if (currentLanguageCount == 1){
            g.fillRect(25, 50, 200, 50);
        } else if (currentLanguageCount == 2){
            g.fillRect(25, 100, 200, 50);
        } else if (currentLanguageCount == 3){
            g.fillRect(25, 150, 200, 50);
        } else if (currentLanguageCount == 4){
            g.fillRect(25, 200, 200, 50);
        } else if (currentLanguageCount == 5){
            g.fillRect(25, 250, 200, 50);
        } 
        
        //draws all the box outlines
        g.setColor(Color.black);
        g.drawRect(25, 50 , 200, 50);
        g.drawRect(25, 100 , 200, 50);
        g.drawRect(25, 150 , 200, 50);
        g.drawRect(25, 200 , 200, 50);
        g.drawRect(25, 250 , 200, 50);
        
        
        //writes the text for each box
        g.setFont(new Font("Arial", Font.PLAIN, 30));
        g.drawString("English",80,90);
        g.drawString("French",80,140);
        g.drawString("German",80,190);
        g.drawString("Italian",80,240);
        g.drawString("Spanish",80,290);

        repaint();
    }
    
     /*
     * Renews the access token for the API
     * WRITTEN BY DAVID WAKELING, 2018
     */
    static String renewAccessToken( ) {
       String key1 = "c7a58cbdf5544b41bd33fe3226a553b1";
       String key2 = "c46407a5cdc0407280999b0487d523d4";
      
       final String method = "POST";
       final String url = "https://api.cognitive.microsoft.com/sts/v1.0/issueToken";
       final byte[] body = {}; 
       final String[][] headers
          = { { "Ocp-Apim-Subscription-Key", key1                          }
            , { "Content-Length"           , String.valueOf( body.length ) }
            };
       byte[] response = HttpConnect.httpConnect( method, url, headers, body );
       return new String( response ); 
    }
  
    /*
     * Creates a sound file with some given text in a given accent
     * WRITTEN BY DAVID WAKELING, 2018
     * edited by Tilly for more specific use
     */
    static void createSoundFile( String token, String text, String lang) {
        String gender = "Female";
        String artist = "(en-GB, Susan, Apollo)";
        
        String name = "output.wav";
        String format = "riff-16khz-16bit-mono-pcm";
      
        final String method = "POST";
        final String url = "https://speech.platform.bing.com/synthesize";
        final byte[] body
          = ( "<speak version='1.0' xml:lang='en-us'>"
            + "<voice xml:lang='" + lang   + "' "
            + "xml:gender='"      + gender + "' "
            + "name='Microsoft Server Speech Text to Speech Voice "
            + artist + "'>"
            + text
            + "</voice></speak>" ).getBytes(); 
        final String[][] headers
          = { { "Content-Type"             , "application/ssml+xml"        }
            , { "Content-Length"           , String.valueOf( body.length ) }
            , { "Authorization"            , "Bearer " + token             }
            , { "X-Microsoft-OutputFormat" , format                        }
            };
        byte[] buffer = HttpConnect.httpConnect( method, url, headers, body );
        
        try {
          File             file = new File( name );
          FileOutputStream fos  = new FileOutputStream( file );
          DataOutputStream dos  = new DataOutputStream( fos ); 
          dos.write( buffer );
          dos.flush();
          dos.close();
        } catch ( Exception ex ) {
          System.out.println( ex ); System.exit( 1 ); 
        }
    }
    
    /*
     * Sets up the input stream
     * WRITTEN BY DAVID WAKELING, 2018
     */
    static AudioInputStream setupStream( String name ) {
     try {
       File             file = new File( name );
       AudioInputStream stm  = AudioSystem.getAudioInputStream( file );
       return stm;
     } catch ( Exception ex ) {
       System.out.println( ex ); System.exit( 1 ); return null;
     }
    }

    /*
     * Plays the file
     * WRITTEN BY DAVID WAKELING, 2018
     */
    static void playStream( AudioInputStream stm, ByteArrayOutputStream bos ) {
        try {
          AudioFormat    af   = stm.getFormat();
          byte[]         ba   = bos.toByteArray();
          DataLine.Info  info = new DataLine.Info( SourceDataLine.class, af );
          SourceDataLine line = (SourceDataLine) AudioSystem.getLine( info );
    
          line.open( af );
          line.start();
          line.write( ba, 0, ba.length );
        } catch ( Exception ex ) {
          System.out.println( ex ); System.exit( 1 );
        }
    }
  
    /*
     * Reads the output stream
     * WRITTEN BY DAVID WAKELING, 2018
     */
    static ByteArrayOutputStream readStream( AudioInputStream stm ) {
        try {
          AudioFormat           af  = stm.getFormat();
          ByteArrayOutputStream bos = new ByteArrayOutputStream();
    
          int  bufferSize = (int) af.getSampleRate() * af.getFrameSize();
          byte buffer[]   = new byte[ bufferSize ];
    
          for (;;) {
            int n = stm.read( buffer, 0, buffer.length );
            if ( n > 0 ) {
               bos.write( buffer, 0, n );
            } else {
              break;
            }
          }
    
          return bos;
        } catch ( Exception ex ) {
          System.out.println( ex ); System.exit( 1 ); return null;
        }
    }
  
    /*
    * Read directions.
    * WRITTEN BY DAVID WAKELING, 2018
    * Edited by Tilly Porthouse for more specific use.
    * Soon this will be used to provide the text to be spoken, unfortunately I haven't got it working for sprint 2.
    */
    public byte[] readDirections( String origin
                              , String destination
                              , String region 
                  , String mode ) {
        try {
          //to be used when I've sorted the JSON
          String lat = gps.getLatitude();
          String lon = gps.getLongitude();
            
          
          final String encOrigin      = URLEncoder.encode( origin,      "UTF-8" ); 
          final String encDestination = URLEncoder.encode( destination, "UTF-8" );
          String language = languages.get(currentLanguageCount);
          language = language.substring(0,2); 
          //the languages array is for the language strings as needed by the text to speech API, 
          //fortunately the directions API just needs the first two characters of these language inputs.
          
          final String method = "GET";
          String url 
            = ( "https://maps.googleapis.com/maps/api/directions/json"
              + "?" + "origin"      + "=" + encOrigin
              + "&" + "destination" + "=" + encDestination
              + "&" + "key"         + "=" + "AIzaSyDaX_hkPxn_qxqMENGZEeSZWX5-Qkcjk8Y" //will need editing occasionally
              + "&" + "region"      + "=" + region
              + "&" + "mode"        + "=" + mode
              + "&" + "language"    + "=" + languages.get(currentLanguageCount)
              );
          
          //this url used for testing
          //url = "https://maps.googleapis.com/maps/api/directions/json?origin=Disneyland&destination=Universal+Studios+Hollywood4&key=AIzaSyDaX_hkPxn_qxqMENGZEeSZWX5-Qkcjk8Y";
          
          final byte[] body
            = {}; 
          final String[][] headers
            = {};
          byte[] response = HttpConnect.httpConnect( method, url, headers, body );
          return response;
        } catch ( Exception ex ) {
          System.out.println( ex ); System.exit( 1 ); return null;
        }
    } 
  
    /*
     * Is prompted by the pushing of the plus button on side of the device.
     * Changes the language by changing the currentLanguageCounter which represents an index of the list of languages.
     */
    public void plusButton(){
        //scroll up when button pressed.
        if (currentLanguageCount == 5){
            currentLanguageCount = 0;
        } else {
            currentLanguageCount += 1;
        }
    }
    
    /*
     * Is prompted by the pushing of the minus button on side of the device.
     * Changes the language by changing the currentLanguageCounter which represents an index of the list of languages.
     */
    public void minusButton(){
        //scroll down when button pressed
        if (currentLanguageCount == 0){
            currentLanguageCount = 5;
        } else {
            currentLanguageCount -= 1;
        }
    }
    
    /*
     * Is prompted by the pushing of the select button on side of the device.
     * Currently this simply says a random direction to the user to demonstrate how it will say directions.
     */
    public void selectButton(){
        //select language when button presed
        String TEXT   = "In 200 yards, turn left at the next junction";
        String token = renewAccessToken(); 
        //^needs to be done every 10 mins
        
        //createSoundFile(token, TEXT,"fr-FR"); //this is for testing
        createSoundFile(token, TEXT, languages.get(currentLanguageCount));
        
        AudioInputStream stm = setupStream("output.wav");
        playStream( stm, readStream( stm ) );
    }
    
}
