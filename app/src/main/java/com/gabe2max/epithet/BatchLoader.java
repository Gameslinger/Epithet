package com.gabe2max.epithet;

import android.app.Activity;
import android.content.Intent;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.gabe2max.epithet.ImageLabel.ImageListener;
import com.gabe2max.epithet.adapters.BatchItem;
import com.gabe2max.epithet.adapters.BatchListAdapter;
import com.gabe2max.epithet.batchGetter.BatchFinder;
import com.gabe2max.epithet.batchGetter.MocBatchFinder;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class BatchLoader extends Fragment implements ImageListener {
    ListView lv;
    Set<Integer> downloadedBatches = new HashSet<>();
    BatchFinder batchFinder;
    //Please clean!
    BatchLoader bl;
    String path;
    //TODO: Clean this up! Please...
    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        //super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_batch_loader);
        //path = getExternalFilesDir(Environment.getDataDirectory().getAbsolutePath()).getAbsolutePath();
        final View batchLoader = inflater.inflate(R.layout.activity_batch_loader, container, false);
        path = "/storage/emulated/0/Android/data/com.gabe2max.epithet/files/data/";
        Log.w("BatchLoaderz",path);
        batchFinder = new MocBatchFinder(path);
        bl = this;
        lv = (ListView) batchLoader.findViewById(R.id.BatchList);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            //TODO: Move into Batch Getter
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(batchLoader.getContext(),"Downloading Images",Toast.LENGTH_LONG).show();
                try {
                    batchFinder.getBatch((BatchItem) parent.getItemAtPosition(position), path, (ImageListener) bl);
                } catch (IOException e) {
                    Toast.makeText(batchLoader.getContext(),"Failed to download",Toast.LENGTH_LONG).show();
                }
            }
        });

        List<BatchItem> items = batchFinder.getItems();
        BatchListAdapter adapter = new BatchListAdapter(batchLoader.getContext(), items);
        lv.setAdapter(adapter);
        return batchLoader;
    }

    @Override
    public void onComplete(String directory) {
        startActivity(new Intent(bl.getContext(), Label.class).putExtra("directory",directory));
    }
}
