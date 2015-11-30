package com.johannfjs.niv2mod1class7;

import android.content.res.Configuration;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    private Button btnPlay, btnStop;
    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //if (savedInstanceState == null) {
        videoView = (VideoView) findViewById(R.id.videoView);
        //http://johannfjs.com/videos/

        MediaController mediaController = new MediaController(MainActivity.this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(Uri.parse(getResources().getString(R.string.video_url)));

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            btnPlay = (Button) findViewById(R.id.btnPlay);
            btnStop = (Button) findViewById(R.id.btnStop);
        } else if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            videoView.start();
        }
        //}

        if (getResources().getBoolean(R.bool.orientacion_portrait)) {
            Toast.makeText(getApplicationContext(), "True", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "False", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            btnPlay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    videoView.start();
                }
            });
            btnStop.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (videoView.isPlaying())
                        videoView.pause();
                }
            });
        } else if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {

        }
    }
}
