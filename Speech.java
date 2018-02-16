import java.io.File;
import java.io.FileOutputStream;
import java.io.DataOutputStream;
/**
 * Write a description of class Speech here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Speech
{
    // instance variables - replace the example below with your own
    private int x;
    
    public static void main(){
      String TEXT   = "im so ill";
      String LANG   = "en-US";
      String token = renewAccessToken(); 
      //^needs to be done every 10 mins
      createSoundFile(token, TEXT, LANG);
    
    }

    static String renewAccessToken( ) {
       String key1 = "fdae2fd6d16443a5b5901a103293946d";
       String key2 = "69994180d2e34a6b9efd927ade187f67";
      
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
    
    public void show(){
        // load screen and menu and shit
        
    }
}
