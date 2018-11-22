package com.gabe2max.epithet.batchGetter;

import java.util.Set;

/**
 * Created by Owner on 11/22/2018.
 */

public interface BatchGetter {

    /**
     * Gets A list of Batch Names that can be downloaded
     * @return
     */
    String[] getNames();

    /**
     * Gets the "labels.txt" file for the requested batch and returns the directory
     * @param name
     * @return
     */
    String getBatch(String name);
}
