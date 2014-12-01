package dmax.staticmap;

import java.util.ArrayList;
import java.util.List;

/**
 * Use this class to set map params and add markers.
 * More details at <a href="https://developers.google.com/maps/documentation/staticmaps">
 * https://developers.google.com/maps/documentation/staticmaps</a>
 *
 * @user: Maxim Dybarsky | maxim.dybarskyy@gmail.com
 * @date: 7/28/14
 * @time: 4:59 PM
 */
public class Config {

    public static final dmax.staticmap.Marker[] ARRAY_TEMPLATE = new dmax.staticmap.Marker[0];

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
    private List<dmax.staticmap.Marker> markers = new ArrayList<dmax.staticmap.Marker>();

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

    public dmax.staticmap.Marker[] getMarkers() {
        return markers.toArray(ARRAY_TEMPLATE);
    }

    public dmax.staticmap.Marker addMarker() {
        dmax.staticmap.Marker marker = new dmax.staticmap.Marker();
        markers.add(marker);
        return marker;
    }
}
