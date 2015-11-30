package com.johannfjs.niv2mod1class7_1;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    private Button btnPlay, btnStop, btnPause;
    private SeekBar sbTiempo;
    private TextView lblTiempoTranscurrido, lblTiempoTotal;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPlay = (Button) findViewById(R.id.btnPlay);
        btnStop = (Button) findViewById(R.id.btnStop);
        btnPause = (Button) findViewById(R.id.btnPause);
        sbTiempo = (SeekBar) findViewById(R.id.sbTiempo);
        lblTiempoTotal = (TextView) findViewById(R.id.lblTiempoTotal);
        lblTiempoTranscurrido = (TextView) findViewById(R.id.lblTiempoTranscurrido);

        mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.cancion);
    }

    @Override
    protected void onResume() {
        super.onResume();

        long tiempoTotal = (long) mediaPlayer.getDuration();
        lblTiempoTotal.setText(String.format(
                "%d min, %d sec",
                TimeUnit.MILLISECONDS.toMinutes(tiempoTotal),
                TimeUnit.MILLISECONDS.toSeconds(tiempoTotal) -
                        TimeUnit.MINUTES.toSeconds(
                                TimeUnit.MILLISECONDS.toMinutes(tiempoTotal)
                        )
        ));

        sbTiempo.setMax(mediaPlayer.getDuration());

        /*
               TimeUnit.MILLISECONDS.toMinutes(tiempoTotal)

               MILLISECONDS es el parametro que esta ingresando
               toMinutes es a lo que se va a convertir

               TimeUnit.MINUTES.toSeconds(
                                TimeUnit.MILLISECONDS.toMinutes(tiempoTotal)
                        )

               MINUTES = TimeUnit.MILLISECONDS.toMinutes(tiempoTotal)
               toSeconds obtenemos los segundo de los minutos MINUTES

        */

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mediaPlayer.isPlaying()) {
                    mediaPlayer.start();
                    sbTiempo.setProgress(0);
                } else
                    mediaPlayer.release();
            }
        });
        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying())
                    mediaPlayer.pause();
            }
        });
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying())
                    mediaPlayer.stop();
            }
        });
    }
}
