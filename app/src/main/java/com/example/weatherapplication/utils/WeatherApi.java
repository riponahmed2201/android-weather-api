package com.example.weatherapplication.utils;

import com.example.weatherapplication.models.CurrentWeatherResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface WeatherApi {
    @GET()
    Call<CurrentWeatherResponse> getCurrentWeatherData(@Url String currentWeatherEndUrl);
}
