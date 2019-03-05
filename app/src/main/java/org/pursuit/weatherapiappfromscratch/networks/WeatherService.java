package org.pursuit.weatherapiappfromscratch.networks;

import org.pursuit.weatherapiappfromscratch.model.Weather;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WeatherService {

    String END_POINT = "forecasts/11101?client_id=jYe7jLIIly1LFliPV26EK&client_secret=p2FzYhy9pRf655p1Zw7KWK7WTxAq1NskXXEC8NKd";

    @GET(END_POINT)
    Call<Weather>getWeather();
}
