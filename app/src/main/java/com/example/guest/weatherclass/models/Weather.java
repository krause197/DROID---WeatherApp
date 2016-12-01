package com.example.guest.weatherclass.models;

import java.util.ArrayList;

/**
 * Created by Guest on 11/29/16.
 */
public class Weather {
    private String mName;
    private String mDescription;
    private String mTemperature;
    private String mHumidity;
    private String mPressure;
    private String mWind;
    private String mCloud;
    private String mVisibility;
    private String mImageUrl;


    public Weather (String name, String description, String temperature, String humidity, String pressure, String wind, String cloud, String visibility, String imageUrl){
        this.mName = name;
        this.mDescription = description;
        this.mTemperature = temperature;
        this.mHumidity = humidity;
        this.mPressure = pressure;
        this.mWind = wind;
        this.mCloud = cloud;
        this.mVisibility = visibility;
        this.mImageUrl = imageUrl;

    }

    public String getName(){
        return mName;
    }
    public String getDescription(){
        return mDescription;
    }
    public String getTemperature(){
        return mTemperature;
    }
    public String getHumidity(){
        return mHumidity;
    }
    public String getPressure(){
        return mPressure;
    }
    public String getWind(){
        return mWind;
    }
    public String getCloud(){
        return mCloud;
    }
    public String getVisibility(){
        return mVisibility;
    }
    public String getImageUrl(){ return mImageUrl; }

}
