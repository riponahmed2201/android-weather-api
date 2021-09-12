package com.example.weatherapplication.ui.current;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.weatherapplication.models.CurrentWeatherResponse;
import com.example.weatherapplication.repos.WeatherRepo;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CurrentViewModel extends ViewModel {

   private WeatherRepo weatherRepo;

    public CurrentViewModel() {
      weatherRepo = new WeatherRepo();
    }

    public MutableLiveData<CurrentWeatherResponse> getCurrentWeatherResponseData(String currentWeatherEndUrl){
        return weatherRepo.getCurrentWeatherResponseData(currentWeatherEndUrl);
    }
}