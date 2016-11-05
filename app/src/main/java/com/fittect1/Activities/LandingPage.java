package com.fittect1.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.fittect1.R;
import com.fittect1.model.User;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

/**
 * Created by prasang on 21/6/16.
 */
public class LandingPage extends AppCompatActivity {

    Realm myRealm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        init();

        initializeRealm();

        showUserDetails();

        // Right now, since we don't have UI of landing page, I'm starting the result activity directly!
        //startActivity(new Intent(LandingPage.this, SearchResult.class));
    }

    void init() {
        setContentView(R.layout.activity_landingpage);
    }


    void showUserDetails() {
        RealmResults<User> results1 =
                myRealm.where(User.class).findAll();

        for(User c:results1) {

            Toast.makeText(LandingPage.this, "NAME: " + c.getName(), Toast.LENGTH_SHORT).show();
        }
    }

    void initializeRealm() {
        myRealm =
                Realm.getInstance(
                        new RealmConfiguration.Builder(getApplicationContext())
                                .name("myRealm_1.realm")
                                .build()
                );
    }

}





