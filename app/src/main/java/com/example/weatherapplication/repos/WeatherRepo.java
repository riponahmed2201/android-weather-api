package com.example.weatherapplication.repos;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.weatherapplication.models.CurrentWeatherResponse;
import com.example.weatherapplication.utils.RetrofitClient;
import com.example.weatherapplication.utils.WeatherApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherRepo {
    private WeatherApi weatherApi;

    public WeatherRepo() {
        weatherApi = RetrofitClient.getRetrofitClient().create(WeatherApi.class);
    }

    public MutableLiveData<CurrentWeatherResponse>getCurrentWeatherResponseData(String currentWeatherEndUrl){
        MutableLiveData<CurrentWeatherResponse> currentWeatherResponseMutableLiveData = new MutableLiveData<>();
        weatherApi.getCurrentWeatherData(currentWeatherEndUrl).enqueue(new Callback<CurrentWeatherResponse>() {
            @Override
            public void onResponse(Call<CurrentWeatherResponse> call, Response<CurrentWeatherResponse> response) {
                if (response.isSuccessful()){
                    currentWeatherResponseMutableLiveData.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<CurrentWeatherResponse> call, Throwable t) {
                Log.e("TAG", "onFailure: "+ t.getLocalizedMessage());
            }
        });
        return currentWeatherResponseMutableLiveData;
    }

}
