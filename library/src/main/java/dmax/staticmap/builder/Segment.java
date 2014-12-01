package dmax.staticmap.builder;

import android.content.Context;

import dmax.staticmap.Config;

/**
 * Class for building google static map service url.
 * {@link dmax.staticmap.StaticMap StaticMap} class invokes set of Segment class inheritors
 * one by one. Each inheritor appends its own part of url based on it's responsibility.
 *
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
