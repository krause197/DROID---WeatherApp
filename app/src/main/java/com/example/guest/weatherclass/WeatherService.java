package com.example.guest.weatherclass;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

import java.io.IOException;
import java.sql.Array;
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
            Log.v(TAG, jsonData.toString());
            if (response.isSuccessful()){
                JSONObject weathersJSON = new JSONObject(jsonData);

                String name = weathersJSON.getString("name");
                String description = weathersJSON.getJSONArray("weather").getJSONObject(0).getString("description");
                String temperature = weathersJSON.getJSONObject("main").getDouble("temp")+"";
                String humidity = weathersJSON.getJSONObject("main").getInt("humidity")+"";
                String pressure = weathersJSON.getJSONObject("main").getInt("pressure")+"";
                String wind = weathersJSON.getJSONObject("wind").getDouble("speed")+"";
                String cloud = weathersJSON.getJSONObject("clouds").getInt("all")+"";
                String visibility = weathersJSON.getInt("visibility")+"";

                Log.v(TAG, pressure);

                Weather weather = new Weather(name, description, temperature, humidity, pressure, wind, cloud, visibility);
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
