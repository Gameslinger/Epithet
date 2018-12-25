package com.gabe2max.epithet;

import android.media.MediaPlayer;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.gabe2max.epithet.ImageLabel.ImageDownloader;
import com.gabe2max.epithet.ImageLabel.ImageWriter;
import com.gabe2max.epithet.ImageLabel.LabelImage;
import com.gabe2max.epithet.InputReader.ImageReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

public class Label extends AppCompatActivity {
    List<LabelImage> images;
    Iterator<LabelImage> imagesItorator;
    LabelImage currentImage;
    ImageView image;
    List<Button> buttons = new ArrayList<>();

    MediaPlayer mp;
    String path;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_label);

        path = getIntent().getStringExtra("directory");
        image = (ImageView) findViewById(R.id.labelImage);

        mp = MediaPlayer.create(this, R.raw.bell);

        images = new ImageReader(path).readLabelImages();

        if(images == null){
            Toast.makeText(this, "Could not open batch", Toast.LENGTH_SHORT);
            finish();
        }
        imagesItorator = images.iterator();

        //images = new ImageReader(getString(R.string.directory)).readLabelImages().iterator();
        //Put buttons in list:
        buttons.add((Button) findViewById(R.id.button));
        buttons.add((Button) findViewById(R.id.button2));
        buttons.add((Button) findViewById(R.id.button3));
        buttons.add((Button) findViewById(R.id.button4));

        for(Button button : buttons){
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mp.stop();
                    try {
                        mp.prepare();
                    } catch (IOException e) {
                        Log.e("Label","Could not read Sound file");
                    }
                    mp.start();
                    onButtonClick((Button) v);
                }
            });
        }
        setNextImage();
    }

    public void onButtonClick(Button button){
        currentImage.setResponse(button.getText().toString());
        setNextImage();
    }
    public void setNextImage(){
        if(imagesItorator == null || !imagesItorator.hasNext()) {
            ImageWriter imageWriter = new ImageWriter(path);
            imageWriter.writeResponses(images);
            //TODO Submit responses....


            finish();
            return;
        }
        currentImage = imagesItorator.next();
        image.setImageBitmap(currentImage.getImage());

        //Set labels for the images:
        for(int i = 0; i < 4; i++){
            buttons.get(i).setText(currentImage.getLabels().get(i));
        }
    }
}
