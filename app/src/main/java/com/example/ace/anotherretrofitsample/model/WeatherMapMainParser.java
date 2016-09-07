package com.example.ace.anotherretrofitsample.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by ACE on 30-08-2016.
 */
public class WeatherMapMainParser {
    @SerializedName("message")
    private String message;
    @SerializedName("cnt")
    private String cnt;
    @SerializedName("cod")
    private String cod;
    @SerializedName("list")
   // private List[] list;
    private List<ListAll> listAllList;
    @SerializedName("city")
    private City city;

    public List<ListAll> getListAllList() {
        return listAllList;
    }

    public void setListAllList(List<ListAll> listAllList) {
        this.listAllList = listAllList;
    }

    public String getMessage ()
    {

        return message;
    }

    public void setMessage (String message)
    {
        this.message = message;
    }

    public String getCnt ()
    {
        return cnt;
    }

    public void setCnt (String cnt)
    {
        this.cnt = cnt;
    }

    public String getCod ()
    {
        return cod;
    }

    public void setCod (String cod)
    {
        this.cod = cod;
    }



    public City getCity ()
    {
        return city;
    }

    public void setCity (City city)
    {
        this.city = city;
    }


}
