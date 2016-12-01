package com.example.guest.weatherclass.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.guest.weatherclass.R;
import com.example.guest.weatherclass.adapters.ForcastListAdapter;
import com.example.guest.weatherclass.adapters.WeatherListAdapter;
import com.example.guest.weatherclass.models.Forcast;
import com.example.guest.weatherclass.models.Weather;
import com.example.guest.weatherclass.services.WeatherService;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class WeatherActivity extends AppCompatActivity {
    public static final String TAG = WeatherActivity.class.getSimpleName();

    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;
    @Bind(R.id.recyclerForcastView) RecyclerView mRecyclerForcastView;

    private WeatherListAdapter mAdapter;
    private ForcastListAdapter mForcastAdapter;

    public ArrayList<Weather> mWeathers = new ArrayList<>();
    public ArrayList<Forcast> mForcasts = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String location = intent.getStringExtra("location");

        getWeather(location);
        getForcast(location);

    }


    private void getWeather(String location) {
        final WeatherService weatherService = new WeatherService();
        weatherService.findWeather(location, new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {


                mWeathers = weatherService.processResults(response);

                WeatherActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mAdapter = new WeatherListAdapter(getApplicationContext(), mWeathers);
                        mRecyclerView.setAdapter(mAdapter);
                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(WeatherActivity.this);
                        mRecyclerView.setLayoutManager(layoutManager);
                        mRecyclerView.setHasFixedSize(true);
                    }
                });
            }

        });

    }

    private void getForcast(String location) {
        final WeatherService weatherService = new WeatherService();
        weatherService.findForcast(location, new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {

                mForcasts = weatherService.processForcastResults(response);

                WeatherActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mForcastAdapter = new ForcastListAdapter(getApplicationContext(), mForcasts);
                        mRecyclerForcastView.setAdapter( mForcastAdapter);
                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(WeatherActivity.this);
                        mRecyclerForcastView.setLayoutManager(layoutManager);
                        mRecyclerForcastView.setHasFixedSize(true);
                    }
                });

            }

        });
    }
}
