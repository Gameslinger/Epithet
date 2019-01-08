package com.gabe2max.epithet;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;

import com.gabe2max.epithet.user.User;

public abstract class Util {
    public static Bitmap getBitMap(String path){
        if(path == null || path.trim().isEmpty()){
            Log.w("Util","Called with empty path!");
            return null;
        }
        return BitmapFactory.decodeFile(path);
    }
    public static void userToBundle(User user, Bundle bundle){
        bundle.putParcelable("profilepic",user.getProfilePic());
        bundle.putString("username",user.getUsername());
        bundle.putInt("totalbatches",user.getTotalBatches());
        bundle.putLong("totalpoints",user.getTotalPoints());
    }

    public static User getUserFromBundle(Bundle bundle){
        Bitmap profilePic = (Bitmap) bundle.get("profilepic");
        String username = bundle.getString("username");
        int totalbatches = bundle.getInt("totalbatches");
        long totalpoints = bundle.getLong("totalpoints");
        User user = new User(username,profilePic,totalbatches,totalpoints);
        return user;
    }
}
