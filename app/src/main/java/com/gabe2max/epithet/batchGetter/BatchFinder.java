package com.gabe2max.epithet.batchGetter;

import com.gabe2max.epithet.ImageLabel.ImageListener;
import com.gabe2max.epithet.adapters.BatchItem;

import java.io.IOException;
import java.util.List;
import java.util.Set;

/**
 * Created by Owner on 11/22/2018.
 */

public interface BatchFinder {

    /**
     * Gets A list of Batch Names that can be downloaded
     * @return
     */
    List<BatchItem> getItems();
    void getBatch(BatchItem bi, String path, ImageListener callback) throws IOException;
}
