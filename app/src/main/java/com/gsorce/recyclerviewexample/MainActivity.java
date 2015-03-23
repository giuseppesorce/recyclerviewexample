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
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.Arrays;


public class MainActivity extends ActionBarActivity {

    private Toolbar toolbar;
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private ArrayList<String> countries;
    private CountriesAdapter mAdapter;
    private boolean spanned = false;
    private boolean vertical = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //get and setup toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        toolbar.setNavigationIcon(R.mipmap.ic_ab_drawer);
        // create arratlist from array string
        countries = new ArrayList<String>(Arrays.asList(getResources()
                .getStringArray(R.array.countries)));
        // get recyclerview
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        // 
        mRecyclerView.setHasFixedSize(true);
        // create Adapter
        mAdapter = new CountriesAdapter(countries);
        // create LinearLayoutManager: default orientation is LinearLayout.VERTICAL
        mLayoutManager = new LinearLayoutManager(this);
       // set layout manager
        mRecyclerView.setLayoutManager(mLayoutManager);
        // set default animator
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        // set custom adapter
        mRecyclerView.setAdapter(mAdapter);
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.grid) {
            GridLayoutManager manager;
            if (!spanned) {
                manager = new GridLayoutManager(this, 2);
                spanned = true;
            } else {
                spanned = false;
                manager = new GridLayoutManager(this, 3);

                manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                    @Override
                    public int getSpanSize(int position) {
                        return (3 - position % 3);
                    }
                });
            }

            mRecyclerView.setLayoutManager(manager);
            return true;
        }
        if (id == R.id.list) {

            if (vertical) {
                vertical = false;
                mLayoutManager.setOrientation(LinearLayout.HORIZONTAL);
            } else {
                vertical = true;
                mLayoutManager.setOrientation(LinearLayout.VERTICAL);
            }
            mRecyclerView.setLayoutManager(mLayoutManager);


        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}
