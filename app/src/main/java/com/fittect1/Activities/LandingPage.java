package com.fittect1.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
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

    TextView tv_userdetails;
    Button bt_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        init();

        initializeRealm();

        showUserDetails();

        bt_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LandingPage.this, SearchResult.class));
            }
        });
    }

    void init() {
        setContentView(R.layout.activity_landingpage);
        tv_userdetails = (TextView) findViewById(R.id.tv_landing_page_userdetails);
        bt_next = (Button) findViewById(R.id.bt_landing_page_next);
    }


    void showUserDetails() {
        RealmResults<User> results1 =
                myRealm.where(User.class).findAll();

        String userDetails = "";

        for(User c:results1) {

            userDetails = "";
            userDetails = "Name: " + c.getName() + "\nEmail: " + c.getEmail();
        }

        tv_userdetails.setText(userDetails);
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





