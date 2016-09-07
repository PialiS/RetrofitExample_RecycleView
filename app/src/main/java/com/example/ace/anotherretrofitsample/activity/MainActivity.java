package com.example.ace.anotherretrofitsample.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.ace.anotherretrofitsample.R;
import com.example.ace.anotherretrofitsample.adapter.WeatherAdapter;
import com.example.ace.anotherretrofitsample.model.ListAll;
import com.example.ace.anotherretrofitsample.model.Temp;
import com.example.ace.anotherretrofitsample.model.Weather;
import com.example.ace.anotherretrofitsample.model.WeatherMapMainParser;
import com.example.ace.anotherretrofitsample.rest.ApiClient;
import com.example.ace.anotherretrofitsample.rest.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private final static String APID = "dd2090acc3c2f60d81f399453b473f6d";

    List<ListAll> listAlls;
    Temp temp;
    List<Weather> weather;
    String cityName, pressure, dt, descStr, cloudStr, maxTempStr, minTempStr, mainStr, humidity, finalDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (APID.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please obtain your API KEY from themoviedb.org first!", Toast.LENGTH_LONG).show();
            return;
        }

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.movies_recycler_view);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());


        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<WeatherMapMainParser> call = apiService.getDailyWeatherReport(APID);

        call.enqueue(new Callback<WeatherMapMainParser>() {
            @Override
            public void onResponse(Call<WeatherMapMainParser> call, Response<WeatherMapMainParser> response) {

                if (response != null) {
                    cityName = response.body().getCity().getName();

                    listAlls = new ArrayList<ListAll>();
                    listAlls = response.body().getListAllList();
                    for (int i = 0; i < listAlls.size(); i++) {
                        dt = listAlls.get(i).getDt();
                        long dateTime;

                        //     dateTime = dayTime.setJulianDay(julianStartDay+i);
                        //  finalDate=formatDate(Long.valueOf(dt));


                        pressure = listAlls.get(i).getPressure();
                        cloudStr = listAlls.get(i).getClouds();
                        humidity = listAlls.get(i).getHumidity();
                        temp = new Temp();
                        temp = listAlls.get(i).getTemp();
                        minTempStr = temp.getMin();
                        maxTempStr = temp.getMax();
                        // String dayTempStr=temp.getDay();
                        //  String nightTempStr=temp.getNight();
                        weather = new ArrayList<Weather>();
                        weather = listAlls.get(i).getWeather();
                        for (int j = 0; j < weather.size(); j++) {
                            descStr = weather.get(j).getDescription();
                            mainStr = weather.get(j).getMain();

//                            recyclerView.setAdapter(new WeatherAdapter(cityName, finalDate, pressure, cloudStr, minTempStr, maxTempStr, descStr,humidity,
//                                   R.layout.list_item_weather, getApplicationContext()));


                            recyclerView.setAdapter(new WeatherAdapter(cityName, listAlls,
                                    R.layout.list_item_weather, getApplicationContext()));


                        }


                    }


                }


            }

            @Override
            public void onFailure(Call<WeatherMapMainParser> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });


    }


}
