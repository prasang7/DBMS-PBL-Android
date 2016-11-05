package com.fittect1.Activities;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
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
public class Signup extends AppCompatActivity {

    TextView signupEmailHeading, forgotPassword, disclaimer;
    ImageButton ib_facebook, ib_googleplus;
    EditText et_name, et_email, et_password;
    Button bt_signup;

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

        bt_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup();
            }
        });
    }

    void signup() {
        Toast.makeText(Signup.this, "Sign Up pressed!", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(Signup.this, LandingPage.class));
    }

    void init() {
        setContentView(R.layout.activity_signup);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        signupEmailHeading = (TextView)findViewById(R.id.tv_signup_SignupEmailHeading);
        ib_facebook = (ImageButton)findViewById(R.id.ib_signup_facebook);
        ib_googleplus = (ImageButton)findViewById(R.id.ib_signup_googleplus);

        et_name = (EditText)findViewById(R.id.et_signup_name);
        et_email = (EditText)findViewById(R.id.et_signup_email);
        et_password = (EditText)findViewById(R.id.et_signup_password);

        bt_signup = (Button)findViewById(R.id.bt_signup_signup);

        forgotPassword = (TextView)findViewById(R.id.tv_signup_forgotPassword);
        disclaimer = (TextView)findViewById(R.id.tv_signup_disclaimer);
    }

    void setFonts() {
        Typeface MontLight = Typeface.createFromAsset(getApplication().getAssets(), "Montserrat-Light.otf");
        Typeface MontUltraLight = Typeface.createFromAsset(getApplication().getAssets(), "Montserrat-UltraLight.otf");

        signupEmailHeading.setTypeface(MontUltraLight);
        et_name.setTypeface(MontLight);
        et_email.setTypeface(MontLight);
        et_password.setTypeface(MontLight);
        bt_signup.setTypeface(MontLight);
        forgotPassword.setTypeface(MontUltraLight);
        disclaimer.setTypeface(MontUltraLight);
    }

    void facebookLogin() {
        Toast.makeText(Signup.this, "Login with facebook...", Toast.LENGTH_SHORT).show();
    }

    void googlePlusLogin() {
        Toast.makeText(Signup.this, "Login with Google Plus...", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            Intent i = new Intent(Signup.this, FrontPage.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }
}