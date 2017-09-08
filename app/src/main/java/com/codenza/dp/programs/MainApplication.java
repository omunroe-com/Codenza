package com.codenza.dp.programs;

import android.app.Application;

import com.facebook.FacebookSdk;

public class MainApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        FacebookSdk.sdkInitialize(getApplicationContext());
    }
}
