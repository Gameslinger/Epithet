package com.gabe2max.epithet.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.gabe2max.epithet.ProfileView;
import com.gabe2max.epithet.R;
import com.gabe2max.epithet.UserViewActivity;
import com.gabe2max.epithet.Util;
import com.gabe2max.epithet.user.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.zip.Inflater;

public class CommunityListAdapter extends BaseAdapter {
    Context context;
    List<User> users;

    public CommunityListAdapter(Context context, List<User> users){
        this.users = users;
        Collections.sort(this.users);
        this.context = context;
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int position) {
        return users.get(position);
    }

    @Override
    public long getItemId(int position) {
        return users.get(position).hashCode();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View listItemView = inflater.inflate(R.layout.fragment_community_item,parent,false);
        TextView placeText = (TextView) listItemView.findViewById(R.id.placeText);
        TextView placeUsername = (TextView) listItemView.findViewById(R.id.placeUsername);
        TextView placePoints = (TextView) listItemView.findViewById(R.id.placePoints);
        ImageView profilePic = (ImageView) listItemView.findViewById(R.id.placeProfilePicture);

        int place = (position + 1)%10;
        String placeStr = ""+(position+1);
        //Set place postfix and color
        //TODO: "fade" black to gray farther down list?
        switch (place){
            case 1:
                placeStr += "st";
                placeText.setTextColor(listItemView.getResources().getColor(R.color.firstPlace));
                break;
            case 2:
                placeText.setTextColor(listItemView.getResources().getColor(R.color.secondPlace));
                placeStr += "nd";
                break;
            case 3:
                placeText.setTextColor(listItemView.getResources().getColor(R.color.thirdPlace));
                placeStr += "rd";
                break;
            default:
                placeStr += "th";
        }

        final User user = users.get(position);
        placeText.setText(placeStr);
        placeUsername.setText(user.getUsername());
        placePoints.setText("Points: "+user.getTotalPoints());
        profilePic.setImageBitmap(user.getProfilePic());

        listItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: Create intent? to open profile for item...
                Intent viewProfileIntent = new Intent(context,UserViewActivity.class);
                Bundle profileBundle = new Bundle();
                //Util.userToBundle(user,profileBundle);
                profileBundle.putString("username",user.getUsername());
                viewProfileIntent.putExtras(profileBundle);
                context.startActivity(viewProfileIntent);
            }
        });

        return listItemView;
    }
}
