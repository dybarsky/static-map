package d_max.static_map;

import android.graphics.Bitmap;

/**
 * Implement this interface to receive callbacks in case of
 * using async map generation way.
 * Methods will be called in main thread
 *
 * @user: Maxim Dybarsky | maxim.dybarskyy@gmail.com
 * @date: 7/28/14
 * @time: 5:38 PM
 */
public interface Callback {

    int WRONG_URL = 1;
    int NETWORK_ERROR = 2;

    /**
     * This method will be invoked when map image loaded from google service.
     * @param mapImage static map image
     */
    void onMapGenerated(Bitmap mapImage);

    /**
     * This method will be invoked when map image can't be loaded.
     * @param errorCode code of loading error
     */
    void onFailed(int errorCode);
}
