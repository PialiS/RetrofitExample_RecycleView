package com.example.ace.anotherretrofitsample.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ACE on 30-08-2016.
 */
public class Coord {
    @SerializedName("lon")
    private String lon;
    @SerializedName("lat")
    private String lat;

    public String getLon ()
    {
        return lon;
    }

    public void setLon (String lon)
    {
        this.lon = lon;
    }

    public String getLat ()
    {
        return lat;
    }

    public void setLat (String lat)
    {
        this.lat = lat;
    }


}
