package com.gabe2max.epithet.user;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;

public class User implements Comparable{
    final String username;
    final Bitmap profilePic;
    final int totalBatches;
    final long totalPoints;

    public User(String username, Bitmap profilePic, int totalBatches, long totalPoints) {
        this.username = username;
        this.profilePic = profilePic;
        this.totalBatches = totalBatches;
        this.totalPoints = totalPoints;
    }

    public String getUsername() {
        return username;
    }

    public Bitmap getProfilePic() {
        return profilePic;
    }

    public int getTotalBatches() {
        return totalBatches;
    }

    public long getTotalPoints() {
        return totalPoints;
    }

    @Override
    public int compareTo(@NonNull Object o) {
        if(o instanceof User){
            User other = (User) o;
            //Is casting naughty?
            return (int)(other.totalPoints-this.totalPoints);
        }
        return 0;
    }
}
