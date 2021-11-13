package com.sadek.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;

import com.sadek.myapplication.R;
import com.sadek.myapplication.helper.LocaleHelper;

import java.util.Locale;

import io.paperdb.Paper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setAppLocale("en");
        setContentView(R.layout.activity_main);

        Paper.init(MainActivity.this);

//        String language = Paper.book().read("language");
//        if (language == null) {
//            Paper.book().write("language", "en");
//        }
//
//        updateView((String) Paper.book().read("language"));
    }

    private void updateView(String language) {
        Context context = LocaleHelper.setLocale(MainActivity.this, language);
        Resources resources = context.getResources();
    }

//    @Override
//    protected void attachBaseContext(Context newBase) {
//        super.attachBaseContext(LocaleHelper.onAttach(newBase, "en"));
//    }

    private void setAppLocale(String localeCode){
        Resources resources = getResources();
        DisplayMetrics dm = resources.getDisplayMetrics();
        Configuration config = resources.getConfiguration();
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.JELLY_BEAN_MR1){
            config.setLocale(new Locale(localeCode.toLowerCase()));
        } else {
            config.locale = new Locale(localeCode.toLowerCase());
        }
        resources.updateConfiguration(config, dm);
    }
}