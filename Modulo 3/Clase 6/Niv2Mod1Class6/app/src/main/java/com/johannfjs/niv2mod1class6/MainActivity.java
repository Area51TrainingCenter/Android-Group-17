package com.johannfjs.niv2mod1class6;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnReproducir, btnDetener;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnReproducir = (Button) findViewById(R.id.btnReproducir);
        btnDetener = (Button) findViewById(R.id.btnDetener)
        ;


    }

    @Override
    protected void onResume() {
        super.onResume();

        btnReproducir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mediaPlayer.isPlaying()) {
                    mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.cancion);
                    mediaPlayer.start();
                } else
                    mediaPlayer.release();
            }
        });

        btnDetener.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying())
                    mediaPlayer.pause();
            }
        });
    }
}
