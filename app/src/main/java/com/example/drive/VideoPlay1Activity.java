package com.example.drive;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoPlay1Activity extends AppCompatActivity {
    private VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videoplay1);

        videoView = findViewById(R.id.videoview);
        videoView.setVideoURI(Uri.parse("http://maiche.hynews.net/2019-06-14/b447966654044967993b39929d2eb2b7.low.mp4"));
        videoView.start();
        videoView.setMediaController(new MediaController(this));
    }
}
