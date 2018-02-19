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

    private String randomLatitude() {
        Double lat = -90.0 + Math.random() * 180;
        return (new DecimalFormat("###.####")).format(lat);
    }

    private String randomLongitude() {
        Double lon = -180.0 + Math.random() * 360;
        return (new DecimalFormat("###.####")).format(lon);
    }

    private void getCurrentCoordinates() {
        this.latitude  = randomLatitude();
        this.longitude = randomLongitude();
    }

}
