package com.gabe2max.epithet;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.gabe2max.epithet.ImageLabel.ImageDownloader;
import com.gabe2max.epithet.ImageLabel.ImageListener;

import java.util.concurrent.Callable;

public class BatchLoader extends AppCompatActivity implements ImageListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_batch_loader);
        String path = getExternalFilesDir(Environment.getDataDirectory().getAbsolutePath()).getAbsolutePath();
        ImageDownloader imageDownloader = new ImageDownloader(path, this);
        imageDownloader.execute();
    }

    @Override
    public void onComplete() {
        startActivity(new Intent(this, Label.class));
    }
}
