package com.gabe2max.epithet;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;

import com.gabe2max.epithet.adapters.SwipeCollectionPagerAdapter;

public class TabView extends FragmentActivity {
    SwipeCollectionPagerAdapter swipeCollectionPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final ActionBar actionBar = getActionBar();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_view);
        swipeCollectionPagerAdapter = new SwipeCollectionPagerAdapter(getSupportFragmentManager());
        ViewPager pager = (ViewPager) findViewById(R.id.view_pager);

        pager.setAdapter(swipeCollectionPagerAdapter);
    }
}
