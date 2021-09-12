package com.example.weatherapplication.utils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static String BASE_URL = "https://api.openweathermap.org/data/2.5/";
    private static Retrofit retrofit;
    public static Retrofit getRetrofitClient(){
        if (retrofit !=null){
            return retrofit;
        }
        return new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
    }
}
