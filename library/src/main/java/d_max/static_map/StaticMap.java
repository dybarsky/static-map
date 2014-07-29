package d_max.static_map;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import static d_max.static_map.Callback.*;

/**
 * @user: Maxim Dybarsky | mdy@ciklum.com
 * @date: 7/28/14
 * @time: 4:59 PM
 */
public class StaticMap {

    public static Bitmap requestMapImage(Context context, Config config) {
        try {
            return loadBitmap(config.buildUrl(context));
        } catch (MalformedURLException e) {
            /* wrong url */
        } catch (IOException e) {
            /* loading error */
        }
        return null;
    }

    public static void requestMapImage(final Context context, Config config, final Callback callback) {
        AsyncTask<Config, Integer, Bitmap> loader = new AsyncTask<Config, Integer, Bitmap>() {

            @Override
            protected Bitmap doInBackground(Config... config) {
                try {
                    String url = config[0].buildUrl(context);
                    return loadBitmap(url);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                    publishProgress(WRONG_URL);
                } catch (IOException e) {
                    e.printStackTrace();
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
                callback.onMapGenerated(bitmap);
            }
        };
        loader.execute(config);
    }

    //~

    private static Bitmap loadBitmap(String url) throws MalformedURLException, IOException {

        InputStream stream = new URL(url).openStream();
        Bitmap result = BitmapFactory.decodeStream(stream);
        stream.close();
        return result;
    }
}
