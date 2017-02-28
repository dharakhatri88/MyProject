package com.example.dharakhatri.webservicedemo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dharakhatri.webservicedemo.model.CountryModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dharakhatri on 2017-01-22.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    ArrayList<CountryModel> list;

    public RecyclerViewAdapter(List<CountryModel> list){
        this.list = new ArrayList<>(list);
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapter.MyViewHolder holder, int position) {

        CountryModel object = list.get(position);
        holder.txt_title.setText(object.getName());
        holder.txt_description.setText(object.getCapital());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView txt_title, txt_description;

        public MyViewHolder(View view){
            super(view);
            txt_title = (TextView) view.findViewById(R.id.txt_title);
            txt_description = (TextView) view.findViewById(R.id.txt_description);
        }
    }
}
