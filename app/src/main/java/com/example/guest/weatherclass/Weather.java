package com.example.guest.weatherclass;

/**
 * Created by Guest on 11/29/16.
 */
public class Weather {
    private String mName;
    private String mDescription;
    private int mTemperature;
    private int mHumidity;
    private int mPressure;
    private int mWind;
    private int mCloud;
    private int mVisibility;
    private String mRain;
    private String mSnow;

    public Weather (String name, String description, int temperature, int humidity, int pressure, int wind, int cloud, int visibility, String rain, String snow){
        this.mName = name;
        this.mDescription = description;
        this.mTemperature = temperature;
        this.mHumidity = humidity;
        this.mPressure = pressure;
        this.mWind = wind;
        this.mCloud = cloud;
        this.mVisibility = visibility;
        this.mRain = rain;
        this.mSnow = snow;
    }

    public String getName(){
        return mName;
    }
    public String getDescription(){
        return mDescription;
    }
    public int getTemperature(){
        return mTemperature;
    }
    public int getHumidity(){
        return mHumidity;
    }
    public int getPressure(){
        return mPressure;
    }
    public int getWind(){
        return mWind;
    }
    public int getCloud(){
        return mCloud;
    }
    public int getVisibility(){
        return mVisibility;
    }
    public String getRain(){
        return mRain;
    }
    public String getSnow(){
        return mSnow;
    }
}
