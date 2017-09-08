package com.codenza.dp.programs;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.TextView;

/**
 * Created by Divyendra on 8/16/2016.
 */

public class Splash extends Activity {

    private static int SPLASH_TIME_OUT = 1500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        Typeface myTypeface = Typeface.createFromAsset(getAssets(),"MYRIADAT.TTF");
        TextView myTextview = (TextView)findViewById(R.id.textview1);
        myTextview.setTypeface(myTypeface);
        TextView myTextview2 = (TextView)findViewById(R.id.textview2);
        myTextview2.setTypeface(myTypeface);

        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                Intent i = new Intent(Splash.this, MainActivity.class);
                startActivity(i);

                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);

    }
}
