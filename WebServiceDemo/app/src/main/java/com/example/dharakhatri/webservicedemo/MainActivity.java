package com.example.dharakhatri.webservicedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.dharakhatri.webservicedemo.api.RetrofitApi;
import com.example.dharakhatri.webservicedemo.model.CountryListResponse;
import com.example.dharakhatri.webservicedemo.model.CountryModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recycler_view;
    RecyclerViewAdapter adapter;
    List<CountryModel> countryList = new ArrayList<CountryModel>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RetrofitApi.setUp(getApplication(), "https://restcountries.eu/rest/v1/all/");

        loadData();

        recycler_view = (RecyclerView) findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recycler_view.setLayoutManager(mLayoutManager);
        recycler_view.setItemAnimator(new DefaultItemAnimator());



    }

    private void loadData() {
        Call<List<CountryModel>> call = RetrofitApi.getService().getCountries();
        call.enqueue(new Callback<List<CountryModel>>() {
            @Override
            public void onResponse(Call<List<CountryModel>> call, Response<List<CountryModel>> response) {

                countryList = response.body();
                setupUi();
            }

            @Override
            public void onFailure(Call<List<CountryModel>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Failure", Toast.LENGTH_LONG).show();
            }
        });

    }

    private void setupUi() {

        adapter = new RecyclerViewAdapter(countryList);
        recycler_view.setAdapter(adapter);

    }
}
