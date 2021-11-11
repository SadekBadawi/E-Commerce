package com.sadek.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SwitchCompat;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import com.sadek.myapplication.R;

import io.paperdb.Paper;

public class WelcomeActivity extends AppCompatActivity {
    private TextView txtLite, txtDark;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Paper.init(WelcomeActivity.this);

        boolean mode = Paper.book().read("mode", false);

        if (mode) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }

        //تكرار
        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            setTheme(R.style.Theme_Dark);
        } else {
            setTheme(R.style.Theme_Lite);
        }

        setContentView(R.layout.activity_welcome);

        txtLite = (TextView) findViewById(R.id.txtLite);
        txtDark = (TextView) findViewById(R.id.txtDark);

        txtLite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                Paper.book().write("mode", false);
                setTheme(R.style.Theme_Lite);

                finishAffinity();
                Intent intent = new Intent(WelcomeActivity.this, WelcomeActivity.class);
                startActivity(intent);
                finish();
            }
        });

        txtDark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                Paper.book().write("mode", true);
                setTheme(R.style.Theme_Dark);

                finishAffinity();
                Intent intent = new Intent(WelcomeActivity.this, WelcomeActivity.class);
                startActivity(intent);
                finish();
            }
        });

        Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), SliderActivity.class);
                startActivity(intent);
                finish();
            }
        }, 3000);
    }
}