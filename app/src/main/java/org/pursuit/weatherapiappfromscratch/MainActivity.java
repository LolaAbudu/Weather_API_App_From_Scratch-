package org.pursuit.weatherapiappfromscratch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.pursuit.weatherapiappfromscratch.model.Periods;
import org.pursuit.weatherapiappfromscratch.model.Weather;
import org.pursuit.weatherapiappfromscratch.networks.RetrofitSingleton;
import org.pursuit.weatherapiappfromscratch.networks.WeatherService;

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

        Retrofit retrofit = RetrofitSingleton.getOneInstance();
        WeatherService weatherService = retrofit.create(WeatherService.class);
        Call<Weather>weatherCall = weatherService.getWeather();
        weatherCall.enqueue(new Callback<Weather>() {
            @Override
            public void onResponse(Call<Weather> call, Response<Weather> response) {
                List<Periods> periodsList = response.body().getResponse().get(0).getPeriods();
                Log.d("TAG", "onResponse" + response.body().getResponse().get(0));
            }

            @Override
            public void onFailure(Call<Weather> call, Throwable t) {
                Log.d("TAG", "onFailure" + t.toString());
            }
        });

    }
}
