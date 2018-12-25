package com.gabe2max.epithet;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

public abstract class Util {
    public static Bitmap getBitMap(String path){
        if(path == null || path.trim().isEmpty()){
            Log.w("Util","Called with empty path!");
            return null;
        }
        return BitmapFactory.decodeFile(path);
    }
}
