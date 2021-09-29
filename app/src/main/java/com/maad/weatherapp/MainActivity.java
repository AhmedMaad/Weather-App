package com.maad.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    // Icons: http://openweathermap.org/img/wn/{01d}@2x.png

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getData();
    }

    private void getData() {

        ProgressBar progress = findViewById(R.id.progress);

        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl("https://api.openweathermap.org")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CallableInterface callable = retrofit.create(CallableInterface.class);
        Call<ParentModel> parentModelCall = callable.getWeather();
        parentModelCall.enqueue(new Callback<ParentModel>() {
            @Override
            public void onResponse(Call<ParentModel> call, Response<ParentModel> response) {
                progress.setVisibility(View.INVISIBLE);
                ParentModel parent = response.body();
                ArrayList<DailyWeather> dailyWeather = parent.getDaily();
                for (DailyWeather w : dailyWeather) {
                    Log.d("trace", "Date: " + w.getDate());

                    long millis = w.getDate() * 1000;
                    Date date = new Date(millis);
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
                    String convertedDate = formatter.format(date);
                    Log.d("trace", "Converted Date: " + convertedDate);
                    Log.d("trace", "Min Temp: " + w.getTemp().getMin());
                    Log.d("trace", "Max Temp: " + w.getTemp().getMax());
                    ArrayList<WeatherInfo> weatherInfo = w.getWeather();
                    for (WeatherInfo info : weatherInfo) {
                        Log.d("trace", "Description: " + info.getDescription());
                        Log.d("trace", "Icon: " + info.getIcon());
                    }

                }

            }

            @Override
            public void onFailure(Call<ParentModel> call, Throwable t) {
                progress.setVisibility(View.INVISIBLE);
                Log.d("trace", "Error: " + t.getLocalizedMessage());
            }
        });

    }

}