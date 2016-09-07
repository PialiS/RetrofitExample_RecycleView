package com.example.ace.anotherretrofitsample.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ACE on 30-08-2016.
 */
public class Temp {
    @SerializedName("min")
    private String min;
    @SerializedName("eve")
    private String eve;
    @SerializedName("max")
    private String max;
    @SerializedName("morn")
    private String morn;
    @SerializedName("night")
    private String night;
    @SerializedName("day")
    private String day;



    public String getMin ()
    {
        return min;
    }

    public void setMin (String min)
    {
        this.min = min;
    }

    public String getEve ()
    {
        return eve;
    }

    public void setEve (String eve)
    {
        this.eve = eve;
    }

    public String getMax ()
    {
        return max;
    }

    public void setMax (String max)
    {
        this.max = max;
    }

    public String getMorn ()
    {
        return morn;
    }

    public void setMorn (String morn)
    {
        this.morn = morn;
    }

    public String getNight ()
    {
        return night;
    }

    public void setNight (String night)
    {
        this.night = night;
    }

    public String getDay ()
    {
        return day;
    }

    public void setDay (String day)
    {
        this.day = day;
    }


}
