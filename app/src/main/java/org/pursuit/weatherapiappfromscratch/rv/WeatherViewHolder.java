package org.pursuit.weatherapiappfromscratch.rv;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.pursuit.weatherapiappfromscratch.R;
import org.pursuit.weatherapiappfromscratch.model.Periods;

public class WeatherViewHolder extends RecyclerView.ViewHolder {

    private TextView dateTextView;
    private ImageView iconImageView;
    private TextView maxTempTextView;
    private TextView minTempTextView;

    public WeatherViewHolder(@NonNull View itemView) {
        super(itemView);

        dateTextView = itemView.findViewById(R.id.date_text_view);
        iconImageView = itemView.findViewById(R.id.icon_image_view);
        maxTempTextView = itemView.findViewById(R.id.max_temp_text_view);
        minTempTextView = itemView.findViewById(R.id.min_temp_text_view);

    }

    public void onBind(final Periods periods) {

    }
}
