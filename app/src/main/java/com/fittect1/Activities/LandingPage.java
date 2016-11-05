package com.fittect1.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.fittect1.R;

/**
 * Created by prasang on 21/6/16.
 */
public class LandingPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        init();

        // Right now, since we don't have UI of landing page, I'm starting the result activity directly!
        startActivity(new Intent(LandingPage.this, SearchResult.class));
    }

    void init() {
        setContentView(R.layout.activity_landingpage);
    }
}





