package com.gabe2max.epithet.batchGetter;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Owner on 11/22/2018.
 */

public class MocBatchFinder implements BatchGetter {
        static Map batchMap;
        static {
            batchMap = new HashMap<String, String>();
            batchMap.put("Test", "test");
            batchMap.put("Android", "test");
            batchMap.put("Cats", "test");
        }

    @Override
    public String[] getNames() {
        Set<String> set = batchMap.keySet();
        String[] strArr = new String[set.size()];
        int i = 0;
        for (String str : set) {
            strArr[i++] = str;
        }
        return strArr;
    }
    @Override
    public String getBatch(String name) {
        return (String) batchMap.get(name);
    }
}
