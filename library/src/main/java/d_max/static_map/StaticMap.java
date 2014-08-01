package d_max.static_map;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

import d_max.static_map.builder.*;

import static d_max.static_map.Callback.*;

/**
 * Provides map image. Uses google static maps api.
 * https://developers.google.com/maps/documentation/staticmaps
 *
 * @user: Maxim Dybarsky | maxim.dybarskyy@gmail.com
 * @date: 7/28/14
 * @time: 4:59 PM
 */
public class StaticMap {

    // URL segments builders
    private static List<Segment> segments = new LinkedList<Segment>();
    static {
        segments.add(new HeadSegment()); // must be first
        segments.add(new MapTypeSegment());
        segments.add(new ScaleSegment());
        segments.add(new MarkerSegment());
        segments.add(new PositionSegment());
    }

    /**
     * Use this method for <b>sync</b> map image loading.
     *
     * @param context context for get string url templates
     * @param config set of map generation params
     * @return map image or null if can't generate(load)
     */
    public static Bitmap requestMapImage(Context context, Config config) {
        try {
            return loadBitmap(buildUrl(check(config), context));
        } catch (MalformedURLException e) {
            /* wrong url */
        } catch (IOException e) {
            /* loading error */
        }
        return null;
    }

    /**
     * Use this method for <b>async</b> map image loading.
     * Based on {@link android.os.AsyncTask}.
     * Callback methods will be called in main thread
     * (at {@link android.os.AsyncTask#onPostExecute(Object)} method).
     *
     * @param context context for get string url templates
     * @param config set of map generation params
     * @param callback class to receive result or error callbacks
     */
    public static void requestMapImage(final Context context, Config config, final Callback callback) {
        AsyncTask<Config, Integer, Bitmap> loader = new AsyncTask<Config, Integer, Bitmap>() {

            @Override
            protected Bitmap doInBackground(Config... configs) {
                try {
                    String url = buildUrl(check(configs[0]), context);
                    return loadBitmap(url);
                } catch (MalformedURLException e) {
                    publishProgress(WRONG_URL);
                } catch (IOException e) {
                    publishProgress(NETWORK_ERROR);
                }
                return null;
            }

            @Override
            protected void onProgressUpdate(Integer... values) {
                int errorCode = values[0];
                if (errorCode > 0) {
                    cancel(true);
                    callback.onFailed(errorCode);
                }
            }

            @Override
            protected void onPostExecute(Bitmap bitmap) {
                if (bitmap != null) callback.onMapGenerated(bitmap);
            }
        };
        loader.execute(config);
    }

    //~

    private static String buildUrl(Config config, Context context) {
        StringBuilder urlBuilder = new StringBuilder();

        for (Segment segment : segments) {
            segment.append(config, urlBuilder, context);
        }

        return urlBuilder.toString();
    }

    private static Bitmap loadBitmap(String url) throws MalformedURLException, IOException {
        InputStream stream = new URL(url).openStream();
        Bitmap result = BitmapFactory.decodeStream(stream);
        stream.close();
        return result;
    }

    private static Config check(Config config) {
        boolean noSize = config.getWidth() == -1 || config.getHeight() == -1;
        if (noSize) throw new IllegalArgumentException("image size not set");

        return config;
    }
}
