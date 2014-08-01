package d_max.static_map;

/**
 * @user: Maxim Dybarsky | mdy@ciklum.com
 * @date: 7/31/14
 * @time: 6:26 PM
 */
public class Marker {

    public enum Size {
        tiny, mid, small
    }

    private float latitude = -1;
    private float longitude = -1;
    private String address;
    private String label;
    private String color;
    private Size size;

    Marker() {
        // use package-private scope for to force user
        // to create Marker using Config.addMarker method
    }

    public void setLocation(float latitude, float longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public float getLatitude() {
        return latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public String getAddress() {
        return address;
    }

    public String getLabel() {
        return label;
    }

    public String getColor() {
        return color;
    }

    public Size getSize() {
        return size;
    }
}

