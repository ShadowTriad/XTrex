import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/*
 * Linux Ublox7 reader.
 *
 * David Wakeling, 2018.
 */
public class LinuxUblox7 {
    final static String FILE_NAME = "/dev/ttyACM0";
    final static int    BUFF_SIZE = 1024;

    /*
    * Reader.
    */
    public String[] read() {
        try {
            FileInputStream in = new FileInputStream( new File( FILE_NAME ) );
            byte[] buffer      = new byte[ BUFF_SIZE ];
            String s;
            int n;

            boolean gotGPS = false;

            while ( ( n = in.read( buffer ) ) > -1 && !gotGPS ) {
                s = new String( buffer, 0, n );
                //process GLL sentences
                if ( s.startsWith("$GPGLL") ) {

                    if ( !s.contains(",,") ) {

                        String[] latLonTime = parseGPS( s );

                        if ( latLonTime != null ) {
                            return latLonTime;
                        }

                    } else {
                        //bad gps read
                        return null;
                    }
                }
            }

            } catch ( Exception ex ) {
              System.out.println( ex ); System.exit( 1 );
            }
            return null;
        }

    private double processLatLon( String num, String dir,
                                         boolean isLat ) {

        //split the string on the dot
        int splitPoint = num.indexOf(".") - 2;
        String l1 = num.substring( 0, splitPoint );
        String l2 = num.substring( splitPoint, num.length() );

        //calculate the actual lat / lon value
        double l = Double.parseDouble(l1);
        l += Double.parseDouble(l2) / 60;

        //work out and add the direction aspect
        if ( isLat ) {

            if ( dir.equals("S") ) {
                l *= -1;
            }

        } else {

            if ( dir.equals("W") ) {
                l *= -1;
            }

        }

        return l;
    }

    private String[] parseGPS( String s ) {

        //split the string up into a list
        String[] gll = s.split(",");

        double lat = processLatLon( gll[1], gll[2], true );
        double lon = processLatLon( gll[3], gll[4], false );

        String latitude = String.format( "%.6f", lat );
        String latDirection = gll[2];
        String longitude = String.format( "%.6f", lon );
        String lonDirection = gll[4];
        String time = gll[5].substring(0, 6);

        String[] gpsData = {latitude,  latDirection,
                            longitude, lonDirection,
                            time};

        return gpsData;

    }

}
