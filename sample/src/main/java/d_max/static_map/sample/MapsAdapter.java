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
import d_max.static_map.StaticMap;

import static android.widget.AbsListView.LayoutParams.MATCH_PARENT;

/**
 * @user: Maxim Dybarsky | mdy@ciklum.com
 * @date: 7/31/14
 * @time: 11:51 AM
 */
public class MapsAdapter extends BaseAdapter {

    private static final int SIZE = 400; // px
    private static final int COUNT = 7;
    private static final int MAP_DEFAULT = 0;
    private static final int MAP_SECURE = 1;
    private static final int MAP_ZOOM = 2;
    private static final int MAP_SIZE = 3;
    private static final int MAP_SATELLITE = 4;
    private static final int MAP_HYBRID = 5;
    private static final int MAP_TERRIAN = 6;

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

        switch (position) {
            case MAP_DEFAULT: {
                Config defaultConfig = new Config();
                StaticMap.requestMapImage(context, defaultConfig, callback);
                break;
            }
            case MAP_SECURE: {
                Config config = new Config();
                config.setSecure(true);
                StaticMap.requestMapImage(context, config, callback);
                break;
            }
            case MAP_ZOOM: {
                Config config = new Config();
                config.setZoom(10);
                StaticMap.requestMapImage(context, config, callback);
                break;
            }
            case MAP_SIZE: {
                Config config = new Config();
                config.setImageSize(200, 200);
                StaticMap.requestMapImage(context, config, callback);
                break;
            }
            default:
        }
    }
}
