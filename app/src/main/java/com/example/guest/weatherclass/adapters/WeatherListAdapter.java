package com.example.guest.weatherclass.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.guest.weatherclass.R;
import com.example.guest.weatherclass.models.Weather;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Guest on 11/30/16.
 */
public class WeatherListAdapter extends RecyclerView.Adapter<WeatherListAdapter.WeatherViewHolder>  {
    private ArrayList<Weather> mWeathers = new ArrayList<>();
    private Context mContext;

    public WeatherListAdapter(Context context, ArrayList<Weather> weathers) {
        mContext = context;
        mWeathers = weathers;
    }

    @Override
    public WeatherListAdapter.WeatherViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.weather_list_item, parent, false);
        WeatherViewHolder viewHolder = new WeatherViewHolder(view);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(WeatherListAdapter.WeatherViewHolder holder, int position){
        holder.bindWeather(mWeathers.get(position));
    }
    @Override
    public int getItemCount(){
        return mWeathers.size();
    }

    public class WeatherViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.nameTextView) TextView mNameTextView;
        @Bind(R.id.descriptionTextView) TextView mDescriptionTextView;
        @Bind(R.id.tempTextView) TextView mTempTextView;
        @Bind(R.id.humidityTextView) TextView mHumidityTextView;
        @Bind(R.id.windSpeedTextView) TextView mWindSpeedTextView;
        @Bind(R.id.pressureTextView) TextView mPressureTextView;
        @Bind(R.id.cloudsTextView) TextView mCloudsTextView;
        @Bind(R.id.visibilityTextView) TextView mVisibilityTextView;

        private Context mContext;

        public WeatherViewHolder(View itemView){
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        public void bindWeather(Weather weather){
            mNameTextView.setText(weather.getName());
            mDescriptionTextView.setText(weather.getDescription());
            mTempTextView.setText(weather.getTemperature());
            mHumidityTextView.setText(weather.getHumidity());
            mWindSpeedTextView.setText(weather.getWind());
            mPressureTextView.setText(weather.getPressure());
            mCloudsTextView.setText(weather.getCloud());
            mVisibilityTextView.setText(weather.getVisibility());
        }
    }
}
