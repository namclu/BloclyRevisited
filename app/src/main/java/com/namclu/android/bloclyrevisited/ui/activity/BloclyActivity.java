package com.namclu.android.bloclyrevisited.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
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

        // Setting up a GridLayoutManager
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        GridLayoutManager.SpanSizeLookup spanSizeLookup = new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (position % 4 == 0) {
                    return 3;
                } else
                    return 1;
            }
        };
        gridLayoutManager.setSpanSizeLookup(spanSizeLookup);

        RecyclerView recyclerView = findViewById(R.id.rv_activity_blocly);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL));
        recyclerView.setAdapter(itemAdapter);
    }
}
