package com.example.guest.weatherclass.models;

/**
 * Created by Guest on 11/30/16.
 */
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
