package com.sadek.myapplication.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.sadek.myapplication.R;
import com.sadek.myapplication.activity.SliderActivity;
import com.sadek.myapplication.models.ViewPagerModel;

import java.util.List;

public class AdapterViewPager extends PagerAdapter {
    private ImageView imgItemViewPaper;
    private TextView txtTitleItemViewPager, txtBodyItemViewPager;

    private LayoutInflater inflater;
    private Context context;
    private List<ViewPagerModel> viewPagerModel;
    private SliderActivity activity;

    public AdapterViewPager(Context context, List<ViewPagerModel> viewPagerModel) {
        this.context = context;
        this.viewPagerModel = viewPagerModel;
        activity = (SliderActivity) context;
    }

    @Override
    public int getCount() {
        return viewPagerModel.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.item_view_pager, container, false);

        imgItemViewPaper = (ImageView) itemView.findViewById(R.id.imgItemViewPaper);
        txtTitleItemViewPager = (TextView) itemView.findViewById(R.id.txtTitleItemViewPager);
        txtBodyItemViewPager = (TextView) itemView.findViewById(R.id.txtBodyItemViewPager);

        ViewPagerModel viewPager = viewPagerModel.get(position);

        imgItemViewPaper.setImageResource(viewPager.getImage());
        txtTitleItemViewPager.setText(viewPager.getTitle());
        txtBodyItemViewPager.setText(viewPager.getBody());

        ((ViewPager) container).addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ((ViewPager) container).removeView((View) object);
    }

    public void add(List<ViewPagerModel> viewPagerModel) {
        this.viewPagerModel = viewPagerModel;
    }
}
