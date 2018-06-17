package com.example.virus.weatherprojecttop;


import android.widget.TextView;

import com.example.virus.weatherprojecttop.models.Weather;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitCreatorForCurrentLocation {


    public String initializeCurrentLocationDataFromJson(String lat, String lon,String appid){
        final ArrayList<String> names = new ArrayList<>();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Api.BASE_URL).
                addConverterFactory(GsonConverterFactory.create()).build();
        final Api api = retrofit.create(Api.class);
        Call<Weather> call = api.get(appid,lat,lon);

        call.enqueue(new Callback<Weather>() {
            @Override
            public void onResponse(Call<Weather> call, Response<Weather> response) {
                String temp = response.body().getCurrentPositionName().toString();
                names.add(temp);
            }

            @Override
            public void onFailure(Call<Weather> call, Throwable t) {

            }
        });
        return names.get(0);
    }
}



