package com.gsorce.recyclerviewexample;
/*
 * Copyright (C) 2015 Giuseppe Sorce.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/**
 * Created by Giuseppe Sorce on 23/03/15.
 */

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


public class CountriesAdapter extends RecyclerView.Adapter<CountriesAdapter.MyViewHolder> {


    private ArrayList<String> countries;
    private int previousPosition;

    public CountriesAdapter(ArrayList<String> countries) {
        this.countries = countries;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.country_item, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder viewHolder, int position) {
        viewHolder.mCountryText.setText(countries.get(position));
        if(position > previousPosition){
            new AnimationUtils().animate(viewHolder,true);
        }else{
            new AnimationUtils().animate(viewHolder,false);
        }
        previousPosition= position;
    }


    @Override
    public int getItemCount() {
        return countries.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView mCountryText;

        public MyViewHolder(View itemView) {
            super(itemView);
            mCountryText = (TextView) itemView.findViewById(R.id.tvCountry);
        }
    }
}
