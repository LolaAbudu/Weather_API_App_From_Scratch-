package org.pursuit.weatherapiappfromscratch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import android.support.v7.widget.RecyclerView;

import org.pursuit.weatherapiappfromscratch.model.Periods;
import org.pursuit.weatherapiappfromscratch.model.Weather;
import org.pursuit.weatherapiappfromscratch.networks.RetrofitSingleton;
import org.pursuit.weatherapiappfromscratch.networks.WeatherService;
import org.pursuit.weatherapiappfromscratch.rv.WeatherAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RecyclerView recyclerView = findViewById(R.id.recycler_view);

        Retrofit retrofit = RetrofitSingleton.getOneInstance();
        WeatherService weatherService = retrofit.create(WeatherService.class);
        Call<Weather>weatherCall = weatherService.getWeather();
        weatherCall.enqueue(new Callback<Weather>() {
            @Override
            public void onResponse(Call<Weather> call, Response<Weather> response) {
                List<Periods> periodsList = response.body().getResponse().get(0).getPeriods();
                Log.d("TAG", "onResponse" + response.body().getResponse().get(0));

                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
                WeatherAdapter weatherAdapter = new WeatherAdapter(periodsList);
                recyclerView.setLayoutManager(linearLayoutManager);
                recyclerView.setAdapter(weatherAdapter);
            }

            @Override
            public void onFailure(Call<Weather> call, Throwable t) {
                Log.d("TAG", "onFailure" + t.toString());
            }
        });

    }
}
