package com.gabe2max.epithet;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CommunityView extends Fragment {

@Override
public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
    final View communityView = inflater.inflate(R.layout.activity_community_view, container, false);

    return communityView;
    }
}
