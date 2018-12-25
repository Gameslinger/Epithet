package com.gabe2max.epithet.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.gabe2max.epithet.R;
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

        User user = users.get(position);
        placeText.setText(placeStr);
        placeUsername.setText(user.getUsername());
        placePoints.setText("Points: "+user.getTotalPoints());
        profilePic.setImageBitmap(user.getProfilePic());
        //TODO: OnClickListener to open selected profile....
        return listItemView;
    }
}
