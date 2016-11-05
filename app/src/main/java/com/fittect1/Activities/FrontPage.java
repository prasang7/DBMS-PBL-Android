package com.fittect1.Activities;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.fittect1.R;

/**
 * Created by prasang on 20/6/16.
 */
public class FrontPage extends Activity {

    Button bt_signup, bt_login;
    ImageButton ib_facebook, ib_googlePlus;
    TextView skipLogin, slogan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        init();

        setFonts();

        ib_facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                facebookLogin();
            }
        });

        ib_googlePlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                googlePlusLogin();
            }
        });

        bt_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup();
            }
        });

        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    void signup() {
        startActivity(new Intent(FrontPage.this, Signup.class));
    }

    void login() {
        startActivity(new Intent(FrontPage.this, Login.class));
    }

    void facebookLogin() {
        Toast.makeText(FrontPage.this, "Login with facebook pressed!", Toast.LENGTH_SHORT).show();
    }

    void googlePlusLogin() {
        Toast.makeText(FrontPage.this, "Login with google plus pressed!", Toast.LENGTH_SHORT).show();
    }

    void init() {
        setContentView(R.layout.activity_frontpage);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        skipLogin = (TextView)findViewById(R.id.tv_frontpage_skipLogin);
        slogan = (TextView)findViewById(R.id.tv_frontpage_slogan1);

        bt_signup = (Button)findViewById(R.id.bt_frontpage_signup);
        bt_login = (Button)findViewById(R.id.bt_frontpage_login);

        ib_facebook = (ImageButton)findViewById(R.id.ib_frontpage_facebook);
        ib_googlePlus = (ImageButton)findViewById(R.id.ib_frontpage_googleplus);
    }

    void setFonts() {
        Typeface MontLight = Typeface.createFromAsset(getApplication().getAssets(), "Montserrat-Light.otf");
        Typeface MontUltraLight = Typeface.createFromAsset(getApplication().getAssets(), "Montserrat-UltraLight.otf");

        bt_signup.setTypeface(MontLight);
        bt_login.setTypeface(MontLight);
        slogan.setTypeface(MontLight);
        skipLogin.setTypeface(MontUltraLight);
    }
}




/*
01000101 01100011 01101000 01110100 01100101 00100000 01101100 01101001 01100101 01100010 01100101
 */