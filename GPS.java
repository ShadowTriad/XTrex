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
    private String latDirection;

    private String longitude;
    private String lonDirection;

    private String time;

    private LinuxUblox7 reader;

    public GPS() {
        this.reader = new LinuxUblox7();

        getCurrentCoordinates();
    }

    public String getLatitude() {
        return this.latitude;
    }

    public String getLatDirection() {
        return this.latDirection;
    }

    public String getLongitude() {
        return this.longitude;
    }

    public String getLonDirection() {
        return this.lonDirection;
    }

    public String getTime() {
        return this.time;
    }

    public boolean getCurrentCoordinates() {

        String[] gpsData = reader.read();

        if (gpsData == null) {

            return false;

        } else {

            this.latitude     = gpsData[0];
            this.latDirection = gpsData[1];
            this.longitude    = gpsData[2];
            this.lonDirection = gpsData[3];
            this.time         = gpsData[4];

            return true;

        }

    }

}
