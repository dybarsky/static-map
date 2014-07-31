package d_max.static_map.builder;

import android.content.Context;

import d_max.static_map.Config;

import static d_max.static_map.R.string.type;

/**
 * @user: Maxim Dybarsky | mdy@ciklum.com
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

