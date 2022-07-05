package com.quwi.apptest;

import android.app.Application;

import dagger.hilt.android.HiltAndroidApp;
import timber.log.Timber;

@HiltAndroidApp
public class QuwiApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        initTimber();
    }

    private void initTimber() {
        if (BuildConfig.DEBUG){
            Timber.plant(new Timber.DebugTree());
        }
    }
}
