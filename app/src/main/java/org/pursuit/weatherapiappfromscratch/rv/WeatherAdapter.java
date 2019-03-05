package org.pursuit.weatherapiappfromscratch.rv;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.pursuit.weatherapiappfromscratch.R;
import org.pursuit.weatherapiappfromscratch.model.Periods;

import java.util.List;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherViewHolder> {
    private List<Periods> periodsList;

    public WeatherAdapter(List<Periods> periodsList) {
        this.periodsList = periodsList;
    }

    @NonNull
    @Override
    public WeatherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View childview = LayoutInflater.from(parent.getContext()).inflate(R.layout.weather_itemview, parent, false);
        return new WeatherViewHolder(childview);
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherViewHolder weatherViewHolder, int position) {
        weatherViewHolder.onBind(periodsList.get(position));
    }

    @Override
    public int getItemCount() {
        return periodsList.size();
    }
}
