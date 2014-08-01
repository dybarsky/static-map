package d_max.static_map.builder;

import android.content.Context;

import d_max.static_map.Config;

/**
 * @user: Maxim Dybarsky | maxim.dybarskyy@gmail.com
 * @date: 7/31/14
 * @time: 3:42 PM
 */
public abstract class Segment {

    char SEPARATOR_QUERY = '?';
    char SEPARATOR_ARGS = '&';
    char SEPARATOR_MARKER = '|';
    char SEPARATOR_LOCATION = ',';

    public abstract void append(Config config, StringBuilder urlBuilder, Context context);

    void appendWithSeparator(StringBuilder str, String data) {
        str.append(SEPARATOR_ARGS).append(data);
    }
}
