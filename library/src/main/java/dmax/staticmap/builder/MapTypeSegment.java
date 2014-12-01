package dmax.staticmap.builder;

import android.content.Context;

import dmax.staticmap.Config;

import static dmax.staticmap.R.string.type;

/**
 * Class for append maps type param url segment.
 *
 * @user: Maxim Dybarsky | maxim.dybarskyy@gmail.com
 * @date: 7/31/14
 * @time: 4:02 PM
 */
public class MapTypeSegment extends Segment {

    @Override
    public void append(Config config, StringBuilder urlBuilder, Context context) {
        Config.MapType mapType = config.getMapType();
        if (mapType != null) {
            appendWithSeparator(urlBuilder, context.getString(type, mapType.name()));
        }
    }
}

