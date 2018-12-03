package com.gabe2max.epithet.batchGetter;

import android.widget.Toast;

import com.gabe2max.epithet.ImageLabel.ImageDownloader;
import com.gabe2max.epithet.ImageLabel.ImageListener;
import com.gabe2max.epithet.adapters.BatchItem;

import java.io.IOException;
import java.util.List;

/**
 * Created by Owner on 11/22/2018.
 */

public class MocBatchFinder implements BatchFinder {

    @Override
    public List<BatchItem> getItems() {
        //TODO: Add Moc BatchItem
    }

    @Override
    public void getBatch(BatchItem bi, String path, ImageListener callback) throws IOException {
        ImageDownloader imageDownloader = new ImageDownloader(path+"/"+bi.getDirectory(),callback);
            imageDownloader.execute();
        }
    }
