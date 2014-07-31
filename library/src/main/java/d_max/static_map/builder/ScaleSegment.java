package d_max.static_map.builder;

import android.content.Context;

import d_max.static_map.Config;

import static d_max.static_map.R.string.scale;

/**
 * @user: Maxim Dybarsky | mdy@ciklum.com
 * @date: 7/31/14
 * @time: 4:13 PM
 */
public class ScaleSegment extends Segment {

    @Override
    public void append(Config config, StringBuilder urlBuilder, Context context) {
        int scaleRatio = config.getScale();
        if (scaleRatio != 0) {
            appendWithSeparator(urlBuilder, context.getString(scale, scaleRatio));
        }
    }
}

