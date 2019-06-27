package com.example.drive;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoPlay2Activity extends AppCompatActivity {
    private VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videoplay2);


        videoView = findViewById(R.id.videoview);
        videoView.setVideoURI(Uri.parse("http://maiche.hynews.net/2019-06-21/f60bdec2dca54f5a807555b096b3fce8.low.mp4"));
        videoView.start();
        videoView.setMediaController(new MediaController(this));
    }
}
