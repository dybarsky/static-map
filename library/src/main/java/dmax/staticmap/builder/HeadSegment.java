package dmax.staticmap.builder;

import android.content.Context;

import dmax.staticmap.Config;

import static dmax.staticmap.R.string.http;
import static dmax.staticmap.R.string.https;
import static dmax.staticmap.R.string.size;
import static dmax.staticmap.R.string.url;

/**
 * Class for append url header. Head includes url scheme (http or https),
 * google static map service address, map image size.
 *
 * @user: Maxim Dybarsky | maxim.dybarskyy@gmail.com
 * @date: 7/31/14
 * @time: 4:02 PM
 */
public class HeadSegment extends Segment {

    @Override
    public void append(Config config, StringBuilder urlBuilder, Context context) {
        urlBuilder.append(context.getString(config.isSecure() ? https : http))
                  .append(context.getString(url))
                  .append(SEPARATOR_QUERY)
                  .append(context.getString(size, config.getWidth(), config.getHeight()));
    }
}
