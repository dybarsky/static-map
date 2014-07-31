package d_max.static_map.sample;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;

import d_max.static_map.Callback;
import d_max.static_map.Config;
import d_max.static_map.Marker;
import d_max.static_map.StaticMap;

import static android.widget.AbsListView.LayoutParams.MATCH_PARENT;

/**
 * @user: Maxim Dybarsky | maxim.dybarskyy@gmail.com
 * @date: 7/31/14
 * @time: 11:51 AM
 */
public class MapsAdapter extends BaseAdapter {

    private static final int SIZE = 400; // px
    private static final int MAP_DEFAULT = 0;
    private static final int MAP_SECURE = 1;
    private static final int MAP_ZOOM = 2;
    private static final int MAP_SIZE = 3;
    private static final int MAP_SCALE= 4;
    private static final int MAP_SATELLITE = 5;
    private static final int MAP_HYBRID = 6;
    private static final int MAP_TERRAIN = 7;
    private static final int MAP_ADDRESS = 8;
    private static final int MAP_LOCATION = 9;
    private static final int MAP_MARKER_DEFAULT = 10;
    private static final int MAP_MARKER_ADDRESS = 11;
    private static final int MAP_MARKER_LOCATION = 12;
    private static final int MAP_MARKER_STYLE = 13;
    private static final int COUNT = 14;

    private Context context;
    private Bitmap placeHolder;
    private SparseArray<Bitmap> maps = new SparseArray<Bitmap>();

    public MapsAdapter(Context context) {
        this.context = context;

        try {
            placeHolder = BitmapFactory.decodeStream(context.getAssets().open("placeholder.gif"));
        } catch (IOException e) {
            placeHolder = Bitmap.createBitmap(SIZE, SIZE, Bitmap.Config.ARGB_8888);
            placeHolder.eraseColor(Color.GRAY);
        }
    }

    @Override
    public int getCount() {
        return COUNT;
    }

    @Override
    public Bitmap getItem(int position) {
        return maps.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView image = convertView != null
                ? (ImageView) convertView
                : inflate(context);

        Bitmap map = getItem(position);
        if (map == null) {
            map = placeHolder;
            loadMap(position, image);
        }
        image.setImageBitmap(map);

        return image;
    }

    private ImageView inflate(Context context) {
        ImageView view = new ImageView(context);
        view.setScaleType(ImageView.ScaleType.CENTER);
        view.setLayoutParams(new LayoutParams(MATCH_PARENT, SIZE));
        return view;
    }

    private void loadMap(final int position, final ImageView view) {
        Marker marker;
        Config config = new Config();
        switch (position) {
            case MAP_DEFAULT:
                /* change nothing */
                break;

            case MAP_SECURE:
                config.setSecure(true);
                break;

            case MAP_ZOOM:
                config.setZoom(10);
                break;

            case MAP_SIZE:
                config.setImageSize(200, 200);
                break;

            case MAP_SCALE:
                config.setImageSize(200, 200);
                config.setScale(2);
                break;

            case MAP_SATELLITE:
                config.setMapType(Config.MapType.satellite);
                break;

            case MAP_HYBRID:
                config.setMapType(Config.MapType.hybrid);
                break;

            case MAP_TERRAIN:
                config.setMapType(Config.MapType.terrain);
                break;

            case MAP_ADDRESS:
                config.setAddress("Ukraine");
                break;

            case MAP_LOCATION:
                config.setCenter(50, 0);
                break;

            case MAP_MARKER_DEFAULT:
                config.addMarker();
                break;

            case MAP_MARKER_ADDRESS:
                marker = config.addMarker();
                marker.setAddress("Kyiv");
                break;

            case MAP_MARKER_LOCATION:
                marker = config.addMarker();
                marker.setLocation(50, 2);
                config.setZoom(5);
                break;

            case MAP_MARKER_STYLE:
                marker = config.addMarker();
                marker.setLabel("M");
                marker.setColor("0x00FFFF");
                marker.setSize(Marker.Size.mid);
                config.setZoom(14);
                break;

            default:
        }

        Callback callback = new Callback() {
            @Override
            public void onMapGenerated(Bitmap mapImage) {
                maps.put(position, mapImage);
                view.setImageBitmap(mapImage);
                notifyDataSetChanged();
            }

            @Override
            public void onFailed(int errorCode) {
                Toast.makeText(context,
                        errorCode == WRONG_URL ? "wrong url" : "can't load",
                        Toast.LENGTH_SHORT).show();
            }
        };

        StaticMap.requestMapImage(context, config, callback);
    }
}

