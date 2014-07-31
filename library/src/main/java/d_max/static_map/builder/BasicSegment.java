package d_max.static_map.builder;

import android.content.Context;

import d_max.static_map.Config;

import static d_max.static_map.R.string.http;
import static d_max.static_map.R.string.https;
import static d_max.static_map.R.string.size;
import static d_max.static_map.R.string.url;

/**
 * @user: Maxim Dybarsky | maxim.dybarskyy@gmail.com
 * @date: 7/31/14
 * @time: 4:02 PM
 */
public class BasicSegment extends Segment {

    @Override
    public void append(Config config, StringBuilder urlBuilder, Context context) {
        urlBuilder.append(context.getString(config.isSecure() ? https : http))
                  .append(context.getString(url))
                  .append(SEPARATOR_QUERY)
                  .append(context.getString(size, config.getWidth(), config.getHeight()));
    }
}
