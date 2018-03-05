package com.namclu.android.bloclyrevisited.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.namclu.android.bloclyrevisited.R;
import com.namclu.android.bloclyrevisited.ui.adapter.ItemAdapter;

/**
 * Created by namlu on 03-Mar-18.
 */

public class BloclyActivity extends Activity{

    private ItemAdapter itemAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blocly);

        itemAdapter = new ItemAdapter();

        RecyclerView recyclerView = findViewById(R.id.rv_activity_blocly);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(itemAdapter);
    }
}
