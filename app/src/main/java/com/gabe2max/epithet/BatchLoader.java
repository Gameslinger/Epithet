package com.gabe2max.epithet;

import android.app.Activity;
import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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


public class BatchLoader extends AppCompatActivity implements ImageListener {
    ListView lv;
    Set<Integer> downloadedBatches = new HashSet<>();
    BatchFinder batchFinder;

    //TODO: Clean this up! Please...
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_batch_loader);

        batchFinder = new MocBatchFinder();


        final Activity batchLoader = this;

        lv = (ListView) findViewById(R.id.BatchList);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            //TODO: Move into Batch Getter
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(batchLoader,"Downloading Images",Toast.LENGTH_LONG).show();
                try {
                    batchFinder.getBatch((BatchItem) parent.getItemAtPosition(position), getExternalFilesDir(Environment.getDataDirectory().getAbsolutePath()).getAbsolutePath(), (ImageListener) batchLoader);
                } catch (IOException e) {
                    Toast.makeText(batchLoader,"Failed to download",Toast.LENGTH_LONG).show();
                }
            }
        });

        //TODO create list:
        List<BatchItem> items = batchFinder.getItems();
        BatchListAdapter adapter = new BatchListAdapter(this, items);
        lv.setAdapter(adapter);

    }

    @Override
    public void onComplete(String directory) {
        startActivity(new Intent(this, Label.class).putExtra("directory",directory));

    }
}
