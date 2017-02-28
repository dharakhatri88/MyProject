package com.example.dharakhatri.webservicedemo.api;

import com.example.dharakhatri.webservicedemo.model.CountryListResponse;
import com.example.dharakhatri.webservicedemo.model.CountryModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by dharakhatri on 2017-01-22.
 */

public interface MyApiInterface {

    @GET(".")
    Call<List<CountryModel>> getCountries();

}
