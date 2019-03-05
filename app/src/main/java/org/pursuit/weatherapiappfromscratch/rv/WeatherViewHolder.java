package org.pursuit.weatherapiappfromscratch.rv;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.squareup.picasso.Picasso;

import org.pursuit.weatherapiappfromscratch.R;
import org.pursuit.weatherapiappfromscratch.model.Periods;

public class WeatherViewHolder extends RecyclerView.ViewHolder {

    private TextView dateTextView;
    private ImageView iconImageView;
    private TextView maxTempTextView;
    private TextView minTempTextView;
    private ToggleButton toggleButton;

    public WeatherViewHolder(@NonNull View itemView) {
        super(itemView);

        dateTextView = itemView.findViewById(R.id.date_text_view);
        iconImageView = itemView.findViewById(R.id.icon_image_view);
        maxTempTextView = itemView.findViewById(R.id.max_temp_text_view);
        minTempTextView = itemView.findViewById(R.id.min_temp_text_view);
        toggleButton = itemView.findViewById(R.id.toggleButton);
    }

    public void onBind(final Periods periods) {

        String dateString = "Date: " + periods.getDateTimeISO().substring(0,10);
        String maxTempString = "High: " + String.valueOf(periods.getMaxTempF() + " F");
        String minTempString = "Low: " + String.valueOf(periods.getMinTempF() + "F");

        dateTextView.setText(dateString);
        maxTempTextView.setText(maxTempString);
        minTempTextView.setText(minTempString);

        if(periods.getIcon().equals("pcloudy.png")){
            Picasso.get().load(R.drawable.pcloudy).into(iconImageView);
        }else if(periods.getIcon().equals("wintrymix.png")){
            Picasso.get().load(R.drawable.wintrymix).into(iconImageView);
        }


//        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked){
//                    //toggleButton.setTextOff("Show Farenheit");
//                    maxTempTextView.setText(periods.getMaxTempC());
//                    minTempTextView.setText(periods.getMinTempC());
//                }else{
//                    //toggleButton.setTextOn("Show Celcius");
//                    maxTempTextView.setText(periods.getMaxTempF());
//                    minTempTextView.setText(periods.getMinTempF());
//                }
//            }
//        });
    }
}
