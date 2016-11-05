package com.fittect1.Activities;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.fittect1.R;

/**
 * Created by prasang on 20/6/16.
 */
public class Login extends AppCompatActivity {

    TextView loginEmailHeading, forgotPassword, disclaimer;
    ImageButton ib_facebook, ib_googleplus;
    EditText et_email, et_password;
    Button bt_login;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        init();

        setFonts();

        ib_facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                facebookLogin();
            }
        });

        ib_googleplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                googlePlusLogin();
            }
        });


        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    void login() {
        Toast.makeText(Login.this, "Login pressed!", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(Login.this, LandingPage.class));
    }

    void init() {
        setContentView(R.layout.activity_login);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        loginEmailHeading = (TextView)findViewById(R.id.tv_login_LoginEmailHeading);
        ib_facebook = (ImageButton)findViewById(R.id.ib_login_facebook);
        ib_googleplus = (ImageButton)findViewById(R.id.ib_login_googleplus);

        et_email = (EditText)findViewById(R.id.et_login_email);
        et_password = (EditText)findViewById(R.id.et_login_password);

        bt_login = (Button)findViewById(R.id.bt_login_login);

        forgotPassword = (TextView)findViewById(R.id.tv_login_forgotPassword);
        disclaimer = (TextView)findViewById(R.id.tv_login_disclaimer);
    }

    void setFonts() {
        Typeface MontLight = Typeface.createFromAsset(getApplication().getAssets(), "Montserrat-Light.otf");
        Typeface MontUltraLight = Typeface.createFromAsset(getApplication().getAssets(), "Montserrat-UltraLight.otf");

        loginEmailHeading.setTypeface(MontUltraLight);
        et_email.setTypeface(MontLight);
        et_password.setTypeface(MontLight);
        bt_login.setTypeface(MontLight);
        forgotPassword.setTypeface(MontUltraLight);
        disclaimer.setTypeface(MontUltraLight);
    }

    void facebookLogin() {
        Toast.makeText(Login.this, "Login with facebook...", Toast.LENGTH_SHORT).show();
    }

    void googlePlusLogin() {
        Toast.makeText(Login.this, "Login with Google Plus...", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            Intent i = new Intent(Login.this, FrontPage.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }
}


/*
01000101 01100011 01101000 01110100 01100101 00100000 01101100 01101001 01100101 01100010 01100101
 */