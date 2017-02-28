package com.example.dharakhatri.webservicedemo.api;

import android.app.Application;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by dharakhatri on 2017-01-22.
 */

public class RetrofitApi {

    private static Retrofit retrofit;

    public static void setUp(Application application, String baseUrl){

        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static MyApiInterface getService(){
        return retrofit.create(MyApiInterface.class);
    }
}
