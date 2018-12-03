package com.gabe2max.epithet.adapters;


import android.graphics.Bitmap;

public class BatchItem {
    final Bitmap image;
    final String title;
    final String pointValue;
    final String directory;

    public BatchItem(Bitmap image, String title, String pointValue, String directory) {
        this.image = image;
        this.title = title;
        this.pointValue = pointValue;
        this.directory = directory;
    }

    public Bitmap getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getPointValue() {
        return pointValue;
    }

    public String getDirectory() {
        return directory;
    }
}
