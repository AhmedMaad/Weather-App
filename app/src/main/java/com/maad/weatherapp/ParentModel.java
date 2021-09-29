package com.maad.weatherapp;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ParentModel {

    private ArrayList<DailyWeather> daily;

    public ArrayList<DailyWeather> getDaily() {
        return daily;
    }

}

class DailyWeather {

    @SerializedName("dt")
    private long date;
    private Temperature temp;
    private ArrayList<WeatherInfo> weather;

    public long getDate() {
        return date;
    }

    public Temperature getTemp() {
        return temp;
    }

    public ArrayList<WeatherInfo> getWeather() {
        return weather;
    }

}

class Temperature {

    private double min;
    private double max;

    public double getMin() {
        return min;
    }

    public double getMax() {
        return max;
    }

}

class WeatherInfo {

    private String description;
    private String icon;

    public String getDescription() {
        return description;
    }

    public String getIcon() {
        return icon;
    }

}