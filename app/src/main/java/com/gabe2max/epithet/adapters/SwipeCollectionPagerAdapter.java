package com.gabe2max.epithet.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.gabe2max.epithet.BatchLoader;
import com.gabe2max.epithet.CommunityView;
import com.gabe2max.epithet.ProfileView;

import java.util.ArrayList;
import java.util.List;

public class SwipeCollectionPagerAdapter extends FragmentPagerAdapter {
    List<Fragment> views;
    List<String> titles;
    public SwipeCollectionPagerAdapter(FragmentManager fragmentManager){
        super(fragmentManager);
        views = new ArrayList<>();
        titles = new ArrayList<>();
        views.add(new ProfileView());
        titles.add("Profile");
        views.add(new BatchLoader());
        titles.add("Label");
        views.add(new CommunityView());
        titles.add("Community");
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
        return titles.get(position);
    }
}
