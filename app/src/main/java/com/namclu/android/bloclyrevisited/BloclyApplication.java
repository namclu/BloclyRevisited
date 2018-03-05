package com.namclu.android.bloclyrevisited;

import android.app.Application;

import com.namclu.android.bloclyrevisited.api.DataSource;

/**
 * Created by namlu on 04-Mar-18.
 */

public class BloclyApplication extends Application {

    private static BloclyApplication sharedInstance;
    private DataSource dataSource;

    public static BloclyApplication getSharedInstance() {
        return sharedInstance;
    }

    public static DataSource getSharedDataSource() {
        return BloclyApplication.getSharedInstance().getDataSource();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sharedInstance = this;
        dataSource = new DataSource();
    }

    public DataSource getDataSource() {
        return dataSource;
    }
}
