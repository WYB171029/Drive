package com.example.drive;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoPlay3Activity extends AppCompatActivity {
    private VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videoplay3);
        videoView = findViewById(R.id.videoview);
        videoView.setVideoURI(Uri.parse("http://maiche.hynews.net/2019-06-23/e6fba37d14bf4f138850c38b066d5da0.low.mp4"));
        videoView.start();
        videoView.setMediaController(new MediaController(this));
    }
}
