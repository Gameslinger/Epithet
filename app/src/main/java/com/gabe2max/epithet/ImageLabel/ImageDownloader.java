package com.gabe2max.epithet.ImageLabel;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.JsonReader;
import android.util.JsonWriter;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/**
 * Created by Owner on 11/10/2018.
 */

public class ImageDownloader extends AsyncTask<String, Void, Boolean> {

    Map<String,String> urls;
    String directory;
    ImageListener listener;

    public ImageDownloader(String directory, ImageListener listener){
        this.directory = directory;
        this.listener = listener;
        urls = new HashMap<>();
        //TODO: Finish reading in file name and urls to be used to download images
        try{
        JsonReader jsonReader = new JsonReader((new InputStreamReader(new FileInputStream(new File(this.directory+"/labels.json")))));
            String fileName = null;
            String url = null;

            jsonReader.beginArray();
            while(jsonReader.hasNext()){
                jsonReader.beginObject();
                while(jsonReader.hasNext()){
                    String name = jsonReader.nextName();
                    if(name.equals("image_name")){
                        fileName = jsonReader.nextString();
                    } else if(name.equals("url")){
                        url = jsonReader.nextString();
                    } else if(name.equals("labels")){
                        jsonReader.beginArray();
                        while(jsonReader.hasNext())jsonReader.skipValue();
                        jsonReader.endArray();
                    }
                }
                urls.put(fileName,url);
                fileName = null;
                url = null;
                jsonReader.endObject();
            }
            jsonReader.endArray();
        }catch (IOException ex){
            Log.w("Image Downloader","Could not Read Requested File");
            ex.printStackTrace();
        }
    }

    //TODO: Put on seperate thread? What to do if interrupted? Async Task or Futures?
    /*public boolean download() {
        try {
            for (String key : urls.keySet()) {
                HttpURLConnection connection = (HttpURLConnection) new URL(urls.get(key)).openConnection();
                connection.setDoInput(true);
                connection.connect();
                InputStream input = connection.getInputStream();

                File outFile = new File(directory+"/images/"+key);
                OutputStream output = new FileOutputStream(outFile);
                byte[] buffer = new byte[input.available()];
                input.read(buffer);
                output.write(buffer);
                output.flush();
                output.close();
                input.close();
            }

        } catch (IOException ex) {
            Log.e("Image Downloader","Could not download image");
            return false;
        }
        return true;
    }
*/
    //What to do if file exists? Is that a problem?
    @Override
    protected Boolean doInBackground(String... params) {
        try {
            for (String key : urls.keySet()) {
              /*  HttpURLConnection connection = (HttpURLConnection) new URL(urls.get(key)).openConnection();
                connection.setDoInput(true);
                connection.connect();
                InputStream input = connection.getInputStream();
                */
                InputStream input = new BufferedInputStream(new URL(urls.get(key)).openStream());

                File outFile = new File(directory+"/images/"+key);
                OutputStream output = new FileOutputStream(outFile);
                byte[] buffer = new byte[1024];
                int size = 0;
                while((size = input.read(buffer)) != -1){
                    output.write(buffer, 0, size);
                }

                Log.w("ImageDownloader","Downloading image: "+urls.get(key)+" for "+key);
                output.flush();
                output.close();
                input.close();
            }

        } catch (IOException ex) {
            Log.e("Image Downloader","Could not download image");
            ex.printStackTrace();
            return false;
        }
        return true;
    }
    @Override
    protected void onPostExecute(Boolean result) {
        listener.onComplete();
    }

}
