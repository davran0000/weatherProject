package com.example.virus.weatherprojecttop.models;

import com.example.virus.weatherprojecttop.models.children.WeatherCountry;
import com.example.virus.weatherprojecttop.models.children.WeatherDescription;
import com.example.virus.weatherprojecttop.models.children.WeatherTemperature;
import com.google.gson.annotations.SerializedName;

public class Weather {
    @SerializedName("name")
    private String currentPositionName;
    @SerializedName("weather")
    private WeatherDescription weatherDescription;
    @SerializedName("main")
    private WeatherTemperature weatherTemperature;
    @SerializedName("sys")
    private WeatherCountry country;

    public String getCurrentPositionName() {
        return currentPositionName;
    }

    public void setCurrentPositionName(String currentPositionName) {
        this.currentPositionName = currentPositionName;
    }

    public WeatherDescription getDescription() {
        return weatherDescription;
    }

    public void setDescription(WeatherDescription description) {
        weatherDescription = description;
    }

    public WeatherTemperature getTemperature() {
        return weatherTemperature;
    }

    public void setTemperature(WeatherTemperature temperature) {
        weatherTemperature = temperature;
    }

    public WeatherCountry getCountry() {
        return country;
    }

    public void setCountry(WeatherCountry country) {
        this.country = country;
    }
}
