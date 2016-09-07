package com.example.ace.anotherretrofitsample.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ace.anotherretrofitsample.R;
import com.example.ace.anotherretrofitsample.model.ListAll;

import java.text.SimpleDateFormat;
import java.util.List;


/**
 * Created by ACE on 30-08-2016.
 */
public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder>{

    private String cityName,humidity,pressure,maxTemp,minTemp,weather_desc,dateOfForecast,cloudStatus;
    private  int rowLayout;
    private Context context;

    private List<ListAll> listAlls;


//    public WeatherAdapter(String name, String dt, String pressure, String cloudStr, String minTempStr, String maxTempStr, String descStr,String humidity, int rowLayout, Context context) {
//        this.cityName=name;
//        this.dateOfForecast=dt;
//        this.pressure=pressure;
//        this.cloudStatus=cloudStr;
//        this.minTemp=minTempStr;
//        this.maxTemp=maxTempStr;
//        this.weather_desc=descStr;
//        this.rowLayout=rowLayout;
//        this.humidity=humidity;
//        this.context=context;
//
//    }


    public WeatherAdapter(String name, List<ListAll> listAlls, int rowLayout, Context context) {
        this.context = context;
        this.listAlls = listAlls;
        this.cityName = name;
        this.rowLayout = rowLayout;
    }



    public static class WeatherViewHolder extends RecyclerView.ViewHolder {
        LinearLayout weatherLayout;
        TextView cityNameTitle;
        TextView humidityText,pressureText,minTempText,maxTempText,descriptionText,cloudText,dateText;



        public WeatherViewHolder(View v) {
            super(v);
            weatherLayout = (LinearLayout) v.findViewById(R.id.rowLayout);
            cityNameTitle = (TextView) v.findViewById(R.id.cityName);
            dateText = (TextView) v.findViewById(R.id.dateOfforecast);
            maxTempText = (TextView) v.findViewById(R.id.maxTemp);
            minTempText = (TextView) v.findViewById(R.id.minTemp);
            pressureText = (TextView) v.findViewById(R.id.pressureStatus);
            humidityText = (TextView) v.findViewById(R.id.humidityStatus);
            descriptionText = (TextView) v.findViewById(R.id.description);
            cloudText = (TextView) v.findViewById(R.id.cloudStatus);
        }
    }

    

    @Override
    public WeatherViewHolder onCreateViewHolder(ViewGroup parent,
                                              int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new WeatherViewHolder(view);
    }


    @Override
    public void onBindViewHolder(WeatherViewHolder holder, final int position) {




        ListAll listAll = listAlls.get(position);
        holder.cityNameTitle.setText("City: " + cityName);
        holder.dateText.setText("Date: "+formatDate(Long.valueOf(listAll.getDt())));
        holder.maxTempText.setText("Max Temp: "+listAll.getTemp().getMax());
        holder.minTempText.setText("Min Temp: "+listAll.getTemp().getMin());
        holder.descriptionText.setText("Description: "+listAll.getWeather().get(0).getDescription()+" "+listAll.getWeather().get(0).getMain());
        holder.cloudText.setText("Cloud: "+listAll.getClouds());
        holder.pressureText.setText("Pressure: "+listAll.getPressure());
        holder.humidityText.setText("Humidility: "+listAll.getHumidity());


    }

    @Override
    public int getItemCount() {
        return listAlls.size();
    }


    private String  formatDate(long  time) {
        SimpleDateFormat shortenedDateFormat = new SimpleDateFormat("EEE MMM dd");
        return shortenedDateFormat.format(time);

    }
}

