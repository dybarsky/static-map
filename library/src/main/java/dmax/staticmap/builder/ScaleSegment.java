package dmax.staticmap.builder;

import android.content.Context;

import dmax.staticmap.Config;

import static dmax.staticmap.R.string.scale;

/**
 * Class for append maps scale param url segment.
 *
 * @user: Maxim Dybarsky | maxim.dybarskyy@gmail.com
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

