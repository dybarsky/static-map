package d_max.static_map;

import android.content.Context;

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

    private MapType type;
    private boolean secure = false;
    private int zoomRatio = DEFAULT_ZOOM;
    private int scale;
    private int width = DEFAULT_WIDTH;
    private int height = DEFAULT_HEIGHT;
    private float centerLatitude = DEFAULT_LATITUDE;
    private float centerLongitude = DEFAULT_LONGITUDE;

    Config() {}

    String buildUrl(Context context) {
        StringBuilder urlBuilder = new StringBuilder();
        urlBuilder.append(context.getString(secure ? https : http))
                  .append(context.getString(url))
                  .append('?')
                  .append(context.getString(center, centerLatitude, centerLongitude))
                  .append('&')
                  .append(context.getString(zoom, zoomRatio))
                  .append('&')
                  .append(context.getString(size, width, height));

        return urlBuilder.toString();
    }

    //~

    public enum MapType {
        roadmap,
        satellite,
        hybrid,
        terrain
    }

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
        this.type = type;
        return this;
    }
}
