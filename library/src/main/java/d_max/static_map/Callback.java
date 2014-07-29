package d_max.static_map;

import android.graphics.Bitmap;

/**
 * @user: Maxim Dybarsky | mdy@ciklum.com
 * @date: 7/28/14
 * @time: 5:38 PM
 */
public interface Callback {

    int WRONG_URL = 1;
    int NETWORK_ERROR = 2;

    void onMapGenerated(Bitmap mapImage);

    void onFailed(int errorCode);
}
