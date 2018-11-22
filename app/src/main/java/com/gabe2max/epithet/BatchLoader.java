package com.gabe2max.epithet;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.gabe2max.epithet.ImageLabel.ImageDownloader;
import com.gabe2max.epithet.ImageLabel.ImageListener;
import com.gabe2max.epithet.batchGetter.BatchGetter;
import com.gabe2max.epithet.batchGetter.MocBatchFinder;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.logging.Logger;


public class BatchLoader extends AppCompatActivity implements ImageListener {
    ListView lv;
    Set<Integer> downloadedBatches = new HashSet<>();

    //TODO: Clean this up!
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_batch_loader);

        final BatchGetter bg = new MocBatchFinder();


        final Activity batchLoader = this;

        lv = (ListView) findViewById(R.id.BatchList);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String directory = bg.getBatch((String) parent.getItemAtPosition(position));
                final String path = getExternalFilesDir(Environment.getDataDirectory().getAbsolutePath()).getAbsolutePath();
                ImageDownloader imageDownloader = new ImageDownloader(path+"/"+directory, (ImageListener) batchLoader);
                imageDownloader.execute();
            }
        });
        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.sample_list_item_view, bg.getNames());

        lv.setAdapter(adapter);

    }

    @Override
    public void onComplete(String directory) {

        startActivity(new Intent(this, Label.class).putExtra("directory",directory));

    }
}
