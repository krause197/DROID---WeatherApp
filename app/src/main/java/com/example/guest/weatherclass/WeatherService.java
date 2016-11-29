package com.example.guest.weatherclass;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Guest on 11/29/16.
 */
public class WeatherService {
    public static void findWeather (String location, Callback callback){
        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.API_BASE_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.YOUR_QUERY_PARAMETER, location);
        urlBuilder.addQueryParameter(Constants.API_KEY_QUERY_PARAMETER, Constants.Weather_Token_Key);
        urlBuilder.addQueryParameter(Constants.API_KEY_UNITS_PARAMETER, "imperial");
        String url = urlBuilder.build().toString();

        Log.v("WeatherService.java", url);

        Request request= new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);

    }

    public ArrayList<Weather> processResults(Response response){
        ArrayList<Weather> weathers = new ArrayList<>();

        try {
            String jsonData = response.body().string();
            if (response.isSuccessful()){
                JSONObject weatherJSON = new JSONObject(jsonData);
                String name = weatherJSON.getString("name");
                String description = weatherJSON.getString("weather.description");
                int temperature = weatherJSON.getInt("main.temp");
                int humidity = weatherJSON.getInt("main.humidity");
                int pressure = weatherJSON.getInt("main.pressure");
                int wind = weatherJSON.getInt("wind.speed");
                int cloud = weatherJSON.getInt("clouds.all");
                int visibility = weatherJSON.getInt("visibility");
                String rain = weatherJSON.optString("rain.3h", "No rain in last 3hrs");
                String snow = weatherJSON.optString("snow.3h", "No snow in last 3hrs");

                Weather weather = new Weather(name, description, temperature, humidity, pressure, wind, cloud, visibility, rain, snow);
                weathers.add(weather);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return weathers;
    }
}
