package com.stoffe.weatherproject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ProjectService {

   @GET("/getWeather")
    Call<TempModel> getAllTemp();
}
