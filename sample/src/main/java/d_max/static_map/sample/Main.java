package d_max.static_map.sample;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import d_max.static_map.*;

/**
 * @user: Maxim Dybarsky | mdy@ciklum.com
 * @date: 7/29/14
 * @time: 4:22 PM
 */
public class Main extends Activity implements Callback {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    @Override
    protected void onStart() {
        super.onStart();

        imageView = (ImageView) findViewById(R.id.image);
        StaticMap.requestMapImage(this, new Config(), this);
    }

    @Override
    public void onMapGenerated(Bitmap mapImage) {
        imageView.setImageBitmap(mapImage);
    }

    @Override
    public void onFailed(int errorCode) {
        Toast.makeText(this, String.valueOf(errorCode), Toast.LENGTH_SHORT).show();
    }
}
