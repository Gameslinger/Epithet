package com.gabe2max.epithet.batchGetter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.widget.Toast;

import com.gabe2max.epithet.ImageLabel.ImageDownloader;
import com.gabe2max.epithet.ImageLabel.ImageListener;
import com.gabe2max.epithet.adapters.BatchItem;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Owner on 11/22/2018.
 */

public class MocBatchFinder implements BatchFinder {
    String path;
    public MocBatchFinder(String path){
        this.path = path;
    }

    @Override
    public List<BatchItem> getItems() {
        List<BatchItem> items = new ArrayList<>();
        items.add(new BatchItem(BitmapFactory.decodeFile(this.path+"/batchImages/grumpycat.jpg"),"Cats", "4","400", "cats"));
        items.add(new BatchItem(BitmapFactory.decodeFile(this.path+"/batchImages/cake.jpg"),"Cakes","4","400", "cakes"));
        items.add(new BatchItem(BitmapFactory.decodeFile(this.path+"/batchImages/camel.jpeg"),"Desert Animals","5","500", "desert"));
        items.add(new BatchItem(BitmapFactory.decodeFile(this.path+"/batchImages/vader.jpeg"),"Star Wars","5","500", "starwars"));
        return items;
    }

    @Override
    public void getBatch(BatchItem bi, String path, ImageListener callback) throws IOException {
        ImageDownloader imageDownloader = new ImageDownloader(path+"/"+bi.getDirectory(),callback);
            imageDownloader.execute();
        }
    }
