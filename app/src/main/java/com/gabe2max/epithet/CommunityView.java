package com.gabe2max.epithet;

import android.os.UserManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.gabe2max.epithet.adapters.CommunityListAdapter;
import com.gabe2max.epithet.user.MocUserManager;

public class CommunityView extends Fragment {

@Override
public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
    final View communityView = inflater.inflate(R.layout.activity_community_view, container, false);
    ListView communityList = (ListView) communityView.findViewById(R.id.placeList);
    CommunityListAdapter communityListAdapter = new CommunityListAdapter(communityView.getContext(), com.gabe2max.epithet.user.UserManager.INSTANCE.getUsers());
    communityList.setAdapter(communityListAdapter);

    return communityView;
    }
}
