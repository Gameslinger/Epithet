package com.gabe2max.epithet.ImageLabel;

import android.util.JsonWriter;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

/**
 * Created by Owner on 11/5/2018.
 */

public class ImageWriter {
    private final String path;
    public ImageWriter(String path){
        this.path = path;
    }

    public boolean writeResponses(List<LabelImage> images){
        try {
            JsonWriter jsonWriter = new JsonWriter(new OutputStreamWriter(new FileOutputStream(new File(this.path + "/response.json"))));
            jsonWriter.beginArray();
            for(LabelImage image : images){
                writeResponse(image,jsonWriter);
            }
            jsonWriter.endArray();
            jsonWriter.flush();
            jsonWriter.close();
            return true;
        }catch(IOException ex){
            Log.e("ImageWriter","Could not write responses");
        }
        return false;
    }
    public void writeResponse(LabelImage image, JsonWriter jsonWriter) throws IOException{
        jsonWriter.beginObject();
        jsonWriter.name("image_name");
        jsonWriter.value(image.getImageName());
        jsonWriter.name("response");
        jsonWriter.value(image.getResponse());
        jsonWriter.endObject();
    }
}
