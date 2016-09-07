package com.example.ace.anotherretrofitsample.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ACE on 30-08-2016.
 */
public class City {
    @SerializedName("coord")
    private Coord coord;
    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private String name;
    @SerializedName("population")
    private String population;
    @SerializedName("country")
    private String country;

    public Coord getCoord ()
    {
        return coord;
    }

    public void setCoord (Coord coord)
    {
        this.coord = coord;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getPopulation ()
    {
        return population;
    }

    public void setPopulation (String population)
    {
        this.population = population;
    }

    public String getCountry ()
    {
        return country;
    }

    public void setCountry (String country)
    {
        this.country = country;
    }


}
