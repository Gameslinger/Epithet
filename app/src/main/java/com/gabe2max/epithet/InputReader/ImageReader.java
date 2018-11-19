package com.gabe2max.epithet.InputReader;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.renderscript.RenderScript;
import android.util.JsonReader;
import android.util.Log;

import com.gabe2max.epithet.ImageLabel.LabelImage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Created by Owner on 11/4/2018.
 */

public class ImageReader {
    private final String path;
    public ImageReader(String path){
        this.path = path;
    }
    //https://alvinalexander.com/source-code/android/android-how-load-image-file-and-set-imageview
    //https://developer.android.com/reference/android/util/JsonReader

    private Map<String,Bitmap> getImages(){
        Map<String,Bitmap> imageMap = new HashMap();
        File directory = new File(path+"/images");
        String[] images = directory.list();
        Log.w("ImageReader", directory.getAbsolutePath());
        //TODO: Fix empty list:
        for(String image : images){
            imageMap.put(image, BitmapFactory.decodeFile(path+"/images/"+image));
        }
        return imageMap;
    }

    private LabelImage readLabelImage(Map<String,Bitmap> imageMap, JsonReader reader) throws IOException{
        String imageName = null;
        List<String> labels = new ArrayList<>();

            reader.beginObject();
            while(reader.hasNext()){
                String name = reader.nextName();
                if(name.equals("image_name")){
                imageName = reader.nextString();
                    Log.w("ImageReader",imageName);
                } else if(name.equals("labels")){
                    reader.beginArray();
                    while(reader.hasNext()){
                        labels.add(reader.nextString());
                    }
                    reader.endArray();
                } else if (name.equals("url")){
                    reader.skipValue();
                }

            }
            reader.endObject();
        Bitmap image = imageMap.get(imageName);
        if(image == null) return null;
        return new LabelImage(imageName, image,labels);
    }

    public List<LabelImage> readLabelImages(){
        List<LabelImage> images = new ArrayList<>();

        Map<String, Bitmap> imageMap = getImages();
        try {
        JsonReader reader = new JsonReader(new InputStreamReader(new FileInputStream(new File(this.path+"/labels.json"))));

            reader.beginArray();
            while (reader.hasNext()) {
                LabelImage image = readLabelImage(imageMap,reader);
                if(image != null){
                    images.add(image);
                }
            }
            reader.endArray();

        }catch (IOException ex){
            Log.e("ImageReader","Could not read labels.json!");
        }
        return images;
    }
}
