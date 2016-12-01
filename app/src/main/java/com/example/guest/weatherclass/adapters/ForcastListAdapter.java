package com.example.guest.weatherclass.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.guest.weatherclass.R;
import com.example.guest.weatherclass.models.Forcast;
import com.example.guest.weatherclass.models.Forcast;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Guest on 11/30/16.
 */
public class ForcastListAdapter  extends RecyclerView.Adapter<ForcastListAdapter.ForcastViewHolder>  {
    private ArrayList<Forcast> mForcasts = new ArrayList<>();

    private Context mContext;

    public ForcastListAdapter(Context context, ArrayList<Forcast> forcasts) {
        mContext = context;
        mForcasts = forcasts;
    }

    @Override
    public ForcastListAdapter.ForcastViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.forcast_list_item, parent, false);
        ForcastViewHolder viewHolder = new ForcastViewHolder(view);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(ForcastListAdapter.ForcastViewHolder holder, int position){
        holder.bindForcast(mForcasts.get(position));
    }
    @Override
    public int getItemCount(){
        return mForcasts.size();
    }


    public class ForcastViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.tempMaxTextView) TextView mTempMaxTextView;

        private Context mContext;

        public ForcastViewHolder(View itemView){
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        public void bindForcast(Forcast forcast){
            mTempMaxTextView.setText("7days forcast max temp: "+ forcast.getTempMax() + " Degree F");
        }
    }
}

