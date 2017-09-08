package com.codenza.dp.programs;

import android.net.Uri;
import android.os.Bundle;
import android.support.customtabs.CustomTabsIntent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

public class CustomTabs extends AppCompatActivity {
    MainActivity mf;
    final String CUSTOM_TAB_PACKAGE_NAME = "com.android.chrome";
    Uri uri = Uri.parse("http://codenza.us/category/explanations/");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customtab);
        mf.navItemIndex = 4444;
        Uri uri = Uri.parse("http://codenza.us/category/explanations/");
        // create an intent builder

        CustomTabsIntent.Builder intentBuilder = new CustomTabsIntent.Builder();
        intentBuilder.addDefaultShareMenuItem();
        intentBuilder.setToolbarColor(ContextCompat.getColor(this, R.color.colorPrimary));
        intentBuilder.setSecondaryToolbarColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));
        CustomTabsIntent customTabsIntent = intentBuilder.build();
        customTabsIntent.launchUrl(this, Uri.parse("http://codenza.us/category/explanations/"));
    }
}
