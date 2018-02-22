/**
 * Generate GPS coordinates that can be used by other screens in the XTrex.
 *
 * @version 22/02/18
 * @author Chris Tyson
 */

import java.lang.Math;
import java.text.DecimalFormat;

public class GPS {

    private String latitude;
    private String longitude;

    public GPS() {
        getCurrentCoordinates();
    }

    public String getLatitude() {
        return this.latitude;
    }

    public String getLongitude() {
        return this.longitude;
    }

    //generate a random latitude enclosed within the UK
    private String randomLatitude() {
        Double lat = 51.5 + Math.random();
        return (new DecimalFormat("###.####")).format(lat);
    }

    //generate a random longitude enclosed within the UK
    private String randomLongitude() {
        Double lon = -1.9 + Math.random() * 1.78;
        return (new DecimalFormat("###.####")).format(lon);
    }

    //update the lat and lon with random values
    private void getCurrentCoordinates() {
        this.latitude  = randomLatitude();
        this.longitude = randomLongitude();
    }

}
