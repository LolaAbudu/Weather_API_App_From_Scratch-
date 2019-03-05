package org.pursuit.weatherapiappfromscratch.networks;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitSingleton {

    private final static String BASE_URL= "http://api.aerisapi.com/";

    private static Retrofit oneInstance;

    public static Retrofit getOneInstance(){
        if(oneInstance != null){
            return oneInstance;
        }
        oneInstance = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return oneInstance;
    }

    private RetrofitSingleton(){}
}
