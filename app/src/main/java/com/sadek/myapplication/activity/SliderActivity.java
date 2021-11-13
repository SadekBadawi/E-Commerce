package com.sadek.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.sadek.myapplication.R;
import com.sadek.myapplication.adapter.AdapterViewPager;
import com.sadek.myapplication.models.ViewPagerModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import io.paperdb.Paper;

public class SliderActivity extends AppCompatActivity {
    private ViewPager viewPagerActivitySlider;
    //    private CircleIndicator circleIndicatorActivityDetails;
    private TextView txtNumberSliderActivitySlider;
    private TextView txtNextSliderActivitySlider;

    private AdapterViewPager adapterViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Paper.init(SliderActivity.this);

        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES){
            setTheme(R.style.Theme_Dark);
        }
        else {
            setTheme(R.style.Theme_Lite);
        }

        setContentView(R.layout.activity_slider);

        findViewByIdes();

        settingViewPager();

        txtNextSliderActivitySlider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getItemViewPager(+1) >= 3) {
                    Intent intent = new Intent(SliderActivity.this, ChoseLoginActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    viewPagerActivitySlider.setCurrentItem(getItemViewPager(+1), true);
                }
            }
        });

        viewPagerActivitySlider.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public void onPageScrollStateChanged(int state) {
            }

            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            public void onPageSelected(int position) {
                txtNumberSliderActivitySlider.setText(String.valueOf(position + 1));
            }
        });
    }

    private void findViewByIdes() {
        viewPagerActivitySlider = (ViewPager) findViewById(R.id.viewPagerActivitySlider);

        txtNumberSliderActivitySlider = (TextView) findViewById(R.id.txtNumberSliderActivitySlider);
//        circleIndicatorActivityDetails = (CircleIndicator) findViewById(R.id.circleIndicatorActivityDetails);

        txtNextSliderActivitySlider = (TextView) findViewById(R.id.txtNextSliderActivitySlider);
    }

    private void settingViewPager() {
        List<ViewPagerModel> viewPagerModelList = new ArrayList<>();

        viewPagerModelList.add(new ViewPagerModel(R.drawable.ic_slider1, "Browse all the Category", "Contrary to popular belief, Lorem Ipsum is not simply rand"));
        viewPagerModelList.add(new ViewPagerModel(R.drawable.ic_slider2, "Amazing Discounts & Offers", "Contrary to popular belief, Lorem Ipsum is not simply rand"));
        viewPagerModelList.add(new ViewPagerModel(R.drawable.ic_slider3, "Delivery in 30 min", "Contrary to popular belief, Lorem Ipsum is not simply rand"));

        adapterViewPager = new AdapterViewPager(SliderActivity.this, viewPagerModelList);
        viewPagerActivitySlider.setAdapter(adapterViewPager);
//        circleIndicatorActivityDetails.setViewPager(viewPagerActivitySlider);
    }

    private int getItemViewPager(int position) {
        return viewPagerActivitySlider.getCurrentItem() + position;
    }
}