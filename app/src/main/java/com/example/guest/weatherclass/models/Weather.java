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

public class Forcast {
    private String mTempMax;
    private String mTempMin;
    private String mForcastDescript;
    private String mForcastImageUrl;
    private String mDate;

    public Forcast (String tempMax, String tempMin, String forcastDescript, String forcastImageUrl, String date){
        this.mTempMax = tempMax;
        this.mTempMin = tempMin;
        this.mForcastDescript = forcastDescript;
        this.mForcastImageUrl = forcastImageUrl;
        this.mDate = date;
    }
    public String getTempMax() { return mTempMax;}
    public String getTempMin() { return mTempMin;}
    public String getForcastDescript() { return mForcastDescript;}
    public String getForcastImageUrl() { return mForcastImageUrl;}
    public String getDate() { return mDate;}

}
