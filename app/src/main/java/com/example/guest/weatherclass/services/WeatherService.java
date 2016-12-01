package com.example.guest.weatherclass.services;

import android.util.Log;

import com.example.guest.weatherclass.Constants;
import com.example.guest.weatherclass.models.Forcast;
import com.example.guest.weatherclass.models.Weather;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.SimpleDateFormat;
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

    public static final String TAG = WeatherService.class.getSimpleName();

    public static void findWeather(String location, Callback callback){
        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.API_BASE_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.YOUR_QUERY_PARAMETER, location);
        urlBuilder.addQueryParameter(Constants.API_KEY_QUERY_PARAMETER, Constants.Weather_Token_Key);
        urlBuilder.addQueryParameter(Constants.API_KEY_UNITS_PARAMETER, "imperial");
        String url = urlBuilder.build().toString();

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
            Log.v(TAG, "Current Weather: "+ jsonData.toString());
            if (response.isSuccessful()){
                JSONObject weathersJSON = new JSONObject(jsonData);

                String name = weathersJSON.getString("name");
                String description = weathersJSON.getJSONArray("weather").getJSONObject(0).getString("description");
                String imageIcon = weathersJSON.getJSONArray("weather").getJSONObject(0).getString("icon");
                String imageUrl = "http://openweathermap.org/img/w/" + imageIcon + ".png";
                String temperature = weathersJSON.getJSONObject("main").getDouble("temp")+"";
                String humidity = weathersJSON.getJSONObject("main").getInt("humidity")+"";
                String pressure = weathersJSON.getJSONObject("main").getInt("pressure")+"";
                String wind = weathersJSON.getJSONObject("wind").getDouble("speed")+"";
                String cloud = weathersJSON.getJSONObject("clouds").getInt("all")+"";
                int visibilityFeet = weathersJSON.getInt("visibility");
                String visibility = visibilityFeet/5280 + "";

                Weather weather = new Weather(name, description, temperature, humidity, pressure, wind, cloud, visibility, imageUrl);
                weathers.add(weather);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return weathers;
    }

    public static void findForcast(String location, Callback callback){
        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.API_BASE_FORCAST_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.FORCAST_QUERY_PARAMETER, location);
        urlBuilder.addQueryParameter(Constants.API_KEY_DAILY_PARAMETER, "7");
        urlBuilder.addQueryParameter(Constants.API_KEY_QUERY_PARAMETER, Constants.Weather_Token_Key);
        urlBuilder.addQueryParameter(Constants.API_KEY_UNITS_PARAMETER, "imperial");
        String url = urlBuilder.build().toString();

        Request request= new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);

    }
    public ArrayList<Forcast> processForcastResults(Response response){
        ArrayList<Forcast> forcasts = new ArrayList<>();

        try {
            String jsonData = response.body().string();
            Log.v(TAG, "7daysForcast: "+ jsonData);
            if (response.isSuccessful()){
                JSONObject forcastsJSON = new JSONObject(jsonData);
                JSONArray listJSON = forcastsJSON.getJSONArray("list");
                for (int i = 0; i < listJSON.length(); i++) {
                    JSONObject dayJSON = listJSON.getJSONObject(i);
                    String tempMax = dayJSON.getJSONObject("temp").getString("max") + "";
                    String tempMin = dayJSON.getJSONObject("temp").getString("min") + "";
                    String forcastDescript = dayJSON.getJSONArray("weather").getJSONObject(0).getString("description");
                    String forcastIcon = dayJSON.getJSONArray("weather").getJSONObject(0).getString("icon");
                    String forcastImageUrl = "http://openweathermap.org/img/w/" + forcastIcon + ".png";
                    String date = dayJSON.getString("dt") + "";

                    Forcast forcast = new Forcast(tempMax, tempMin, forcastDescript, forcastImageUrl, date);
                    forcasts.add(forcast);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return forcasts;
    }
}
