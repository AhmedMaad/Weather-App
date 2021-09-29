package com.maad.weatherapp;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CallableInterface {

    @GET("/data/2.5/onecall?lat=30.0131&lon=31.2089&exclude=minutely,hourly,current&units=metric&appid=e0d008a472d038e5c02bc7df0ab25c14")
    Call<ParentModel> getWeather();

}
