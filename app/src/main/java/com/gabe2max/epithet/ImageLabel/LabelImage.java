package com.gabe2max.epithet.ImageLabel;

import android.graphics.Bitmap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Owner on 11/4/2018.
 */

public class LabelImage {
    private final Bitmap image;
    private final String imageName;
    public String response = "";
    private final List<String> labels = new ArrayList<>();
    public LabelImage(String imageName, Bitmap image, Collection<String> labels){
        this.imageName = imageName;
        this.image = image;
        this.labels.addAll(labels);
    }

    public Bitmap getImage() {
        return image;
    }

    public List<String> getLabels() {
        return labels;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getImageName() {
        return imageName;
    }
}
