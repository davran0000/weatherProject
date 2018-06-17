package com.example.virus.weatherprojecttop;

import com.example.virus.weatherprojecttop.models.Weather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Api {
    public final String BASE_URL="http://api.openweathermap.org/";

    @GET("data/2.5/weather")
    public Call<Weather> get(
            @Query("lat") String lat,
            @Query("lon") String lon,
            @Query("appid")String appid);

}
