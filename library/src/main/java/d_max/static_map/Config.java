package d_max.static_map;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import static d_max.static_map.R.string.*;

/**
 * @user: Maxim Dybarsky | maxim.dybarskyy@gmail.com
 * @date: 7/28/14
 * @time: 4:59 PM
 */
public class Config {

    private static final int DEFAULT_ZOOM = 5;
    private static final int DEFAULT_WIDTH = 400;
    private static final int DEFAULT_HEIGHT = 300;
    private static final float DEFAULT_LATITUDE = 50.4020355f;
    private static final float DEFAULT_LONGITUDE = 30.5326905f;

    private MapType mapType;
    private boolean secure = false;
    private int zoomRatio = DEFAULT_ZOOM;
    private int scaleRatio;
    private int width = DEFAULT_WIDTH;
    private int height = DEFAULT_HEIGHT;
    private float centerLatitude = DEFAULT_LATITUDE;
    private float centerLongitude = DEFAULT_LONGITUDE;
    private String address;
    private List<Marker> markers = new ArrayList<Marker>();

    //~

    public static class Marker {

    }

    public enum MapType {
        roadmap,
        satellite,
        hybrid,
        terrain
    }

    //~

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

    public List<Marker> getMarkers() {
        return markers;
    }
}
