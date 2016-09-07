package com.example.ace.anotherretrofitsample.rest;

import com.example.ace.anotherretrofitsample.model.WeatherMapMainParser;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ACE on 30-08-2016.
 */
public interface ApiInterface {

    @GET("forecast/daily?q=94043&mode=json&units=metric&cnt=7")
    Call<WeatherMapMainParser> getDailyWeatherReport(@Query("APPID") String appId);

}
