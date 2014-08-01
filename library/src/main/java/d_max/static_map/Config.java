package d_max.static_map;

import java.util.ArrayList;
import java.util.List;

/**
 * @user: Maxim Dybarsky | maxim.dybarskyy@gmail.com
 * @date: 7/28/14
 * @time: 4:59 PM
 */
public class Config {

    public static final Marker[] ARRAY_TEMPLATE = new Marker[0];

    public enum MapType {
        roadmap, satellite, hybrid, terrain
    }

    private MapType mapType;
    private boolean secure = false;
    private int zoomRatio = -1;
    private int scaleRatio;
    private int width = -1;
    private int height = -1;
    private float centerLatitude = -1f;
    private float centerLongitude = -1f;
    private String address;
    private List<Marker> markers = new ArrayList<Marker>();

    public Config setSecure(boolean secure) {
        this.secure = secure;
        return this;
    }

    public Config setCenter(float latitude, float longitude) {
        this.centerLatitude = latitude;
        this.centerLongitude = longitude;
        return this;
    }

    public Config setZoom(int zoomRatio) {
        this.zoomRatio = zoomRatio;
        return this;
    }

    public Config setImageSize(int height, int width) {
        this.width = width;
        this.height = height;
        return this;
    }

    public Config setMapType(MapType type) {
        this.mapType = type;
        return this;
    }

    public Config setScale(int scaleRatio) {
        this.scaleRatio = scaleRatio;
        return this;
    }

    public Config setAddress(String address) {
        this.address = address;
        return this;
    }

    public MapType getMapType() {
        return mapType;
    }

    public boolean isSecure() {
        return secure;
    }

    public int getZoom() {
        return zoomRatio;
    }

    public int getScale() {
        return scaleRatio;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public float getCenterLatitude() {
        return centerLatitude;
    }

    public float getCenterLongitude() {
        return centerLongitude;
    }

    public String getAddress() {
        return address;
    }

    public Marker[] getMarkers() {
        return markers.toArray(ARRAY_TEMPLATE);
    }

    public Marker addMarker() {
        Marker marker = new Marker();
        markers.add(marker);
        return marker;
    }
}
