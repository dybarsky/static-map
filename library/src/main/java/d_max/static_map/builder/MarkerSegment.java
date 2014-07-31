package d_max.static_map.builder;

import android.content.Context;

import d_max.static_map.Config;
import d_max.static_map.Marker;

import static d_max.static_map.R.string.markerColor;
import static d_max.static_map.R.string.markerDef;
import static d_max.static_map.R.string.markerLabel;
import static d_max.static_map.R.string.markerSize;

/**
 * @user: Maxim Dybarsky | mdy@ciklum.com
 * @date: 7/31/14
 * @time: 4:13 PM
 */
public class MarkerSegment extends Segment {

    @Override
    public void append(Config config, StringBuilder urlBuilder, Context context) {
        Marker[] markers = config.getMarkers();

        if (markers.length == 0) return;

        for (Marker marker : markers) {
            appendWithSeparator(urlBuilder, context.getString(markerDef));
            appendMarker(marker, urlBuilder, context);
        }
    }

    private void appendMarker(Marker marker, StringBuilder urlBuilder, Context context) {
        String targetAddress = marker.getAddress();

        if (marker.getColor() != null) urlBuilder
                .append(context.getString(markerColor, marker.getColor()))
                .append(SEPARATOR_MARKER);

        if (marker.getSize() != null) urlBuilder
                .append(context.getString(markerSize, marker.getSize().name()))
                .append(SEPARATOR_MARKER);

        if (marker.getLabel() != null) urlBuilder
                .append(context.getString(markerLabel, marker.getLabel()))
                .append(SEPARATOR_MARKER);

        urlBuilder.append(targetAddress != null
                ? targetAddress
                : marker.getLatitude() + "," + marker.getLongitude());
    }
}

