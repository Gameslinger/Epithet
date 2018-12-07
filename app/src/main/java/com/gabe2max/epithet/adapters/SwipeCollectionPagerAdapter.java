package com.gabe2max.epithet.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;

import com.gabe2max.epithet.BatchLoader;

import java.util.ArrayList;
import java.util.List;

public class SwipeCollectionPagerAdapter extends FragmentPagerAdapter {
    List<Fragment> views;
    public SwipeCollectionPagerAdapter(FragmentManager fragmentManager){
        super(fragmentManager);
        views = new ArrayList<>();

        views.add(new BatchLoader());

    }

    @Override
    public Fragment getItem(int position) {
        if(position >= views.size()) return null;
        return views.get(position);
    }

    @Override
    public int getCount() {
        return views.size();
    }

    @Override
    public CharSequence getPageTitle(int position){
        return "TODO!!!";
    }
}
