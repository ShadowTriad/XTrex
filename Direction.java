/**
 * 
 * @author Chris Tyson
 * @version 3.0
 */
public class Direction {

    private TextVal distance;
    private TextVal duration;
    private Coord start_location;
    private Coord end_location;
    private String instruction;

    public class TextVal {

        private String text;
        private int value;

        public String getText() { return this.text; }
        public int getVal() { return this.value; }

    }

    public class Coord {

        private String lat;
        private String lng;

        public String getLatitude() { return this.lat; }
        public String getLongitude() { return this.lng; }

    }

        public String getDistance() {
            return this.distance.getText();
        }
        public String getDuration() {
            return this.duration.getText();
        }
        public String getStartLatitude() {
            return this.start_location.getLatitude();
        }
        public String getStartLongitude() {
            return this.start_location.getLongitude();
        }
        public String getEndLatitude() {
            return this.end_location.getLatitude();
        }
        public String getEndLongitude() {
            return this.end_location.getLongitude();
        }

        public void setInstruction( String instruction ) {
            this.instruction = instruction;
        }

        public String getInstruction() { return this.instruction; }

}
