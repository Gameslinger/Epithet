package com.gabe2max.epithet.adapters;


import android.graphics.Bitmap;
import android.util.Log;

public class BatchItem {
    final Bitmap image;
    final String title;
    final String pointValue;
    final String directory;
    final String size;

    public BatchItem(Bitmap image, String title, String size, String pointValue, String directory) {
        this.image = image;
        this.title = title;
        this.size = size;
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

    public String getSize() {
        return size;
    }
}
