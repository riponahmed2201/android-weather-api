package com.example.weatherapplication.utils;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.text.SimpleDateFormat;
import java.util.Date;

public class WeatherUtils {

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static String getFormattedDate(long data){
     return new SimpleDateFormat("dd-MM-YYYY").format(new Date(data*1000));
    }
    public static String getImageUrl(String icon){
    return "https://openweathermap.org/img/wn/"+ icon +"@2x.png";
    }

}
