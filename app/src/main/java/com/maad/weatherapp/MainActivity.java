package com.maad.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    // https://api.openweathermap.org/data/2.5/onecall?lat=26.8206&lon=30.8025&exclude=minutely,hourly&units=metric&appid=e0d008a472d038e5c02bc7df0ab25c14
    // Icons: http://openweathermap.org/img/wn/{01d}@2x.png

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}