package com.gabe2max.epithet;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ProfileView extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        final View profileView = inflater.inflate(R.layout.activity_profile_view, container, false);

        Button editProfile = (Button) profileView.findViewById(R.id.editProfile);
        //Java Version too low for lambda? Why does it work in the label view?
        editProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"This should do something!",Toast.LENGTH_SHORT).show();
            }
        });

        ImageView profilePic = (ImageView) profileView.findViewById(R.id.profilePicture);
        TextView username = (TextView) profileView.findViewById(R.id.userName);
        TextView totalBatches = (TextView) profileView.findViewById(R.id.totalBatches);
        TextView totalPoints = (TextView) profileView.findViewById(R.id.totalPoints);

        profilePic.setImageBitmap(Util.getBitMap("/storage/emulated/0/Android/data/com.gabe2max.epithet/files/data/profilePictures/grandma.jpg"));
        return profileView;
    }
}
