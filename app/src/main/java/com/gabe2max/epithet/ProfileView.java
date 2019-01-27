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

import com.gabe2max.epithet.user.User;
import com.gabe2max.epithet.user.UserManager;

public class ProfileView extends Fragment {
    //User lastUser = null;//Old method when passing user in bundle...
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
        //Populate profile view...
        /*

        Old: TODO: View has to save user from first creation so that arguments can be cleared...
        If arguments aren't cleared then going to recent apps crashes the app...
         */
        /*if(lastUser == null) {
            lastUser = Util.getUserFromBundle(getArguments());
            getArguments().clear();
        }*/
        if(getArguments() == null) return profileView;
        String name = getArguments().getString("username");

        if(!name.equals(UserManager.INSTANCE.getCurrentUser().getUsername())){
            editProfile.setVisibility(View.INVISIBLE);
        }
        User user = UserManager.INSTANCE.getUserByUsername(name);
        profilePic.setImageBitmap(user.getProfilePic());
        username.setText(user.getUsername());
        //TODO: Change? Error: can't find resource, works after tostring...
        totalBatches.setText("Total Batches: "+Integer.toString(user.getTotalBatches()));
        totalPoints.setText("Total Points: "+Long.toString(user.getTotalPoints()));
        return profileView;
    }
}
