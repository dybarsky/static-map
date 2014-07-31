package d_max.static_map.builder;

import android.content.Context;

import d_max.static_map.Config;

/**
 * @user: Maxim Dybarsky | mdy@ciklum.com
 * @date: 7/31/14
 * @time: 3:42 PM
 */
public abstract class Segment {

    public abstract void append(Config config, StringBuilder urlBuilder, Context context);

    void appendWithSeparator(StringBuilder str, String data) {
        str.append('&').append(data);
    }

}
