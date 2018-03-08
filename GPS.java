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
    private String time;

    private LinuxUblox7 reader;

    public GPS() {
        this.reader = new LinuxUblox7();

        getCurrentCoordinates();
    }

    public String getLatitude() {
        return this.latitude;
    }

    public String getLongitude() {
        return this.longitude;
    }

    public String getTime() {
        return this.time;
    }

    //update the lat and lon with random values
    public void getCurrentCoordinates() {

        String[] latLonTime = reader.read();

        this.latitude = latLonTime[0];
        this.longitude = latLonTime[1];
        this.time = latLonTime[2];

    }

}
