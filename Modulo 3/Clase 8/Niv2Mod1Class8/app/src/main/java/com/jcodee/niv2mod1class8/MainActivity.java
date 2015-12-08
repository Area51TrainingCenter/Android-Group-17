package com.jcodee.niv2mod1class8;

import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnSonar, btnVibrar, btnSilencio;
    private AudioManager audioManager = null;
    private MediaPlayer mediaPlayer = null;
    private Vibrator vibrator = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSonar = (Button) findViewById(R.id.btnSonar);
        btnVibrar = (Button) findViewById(R.id.btnVibrar);
        btnSilencio = (Button) findViewById(R.id.btnSilencio);

        audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);

        int seleccion = audioManager.getRingerMode();
        switch (seleccion) {
            case AudioManager.RINGER_MODE_NORMAL:
                btnSonar.setBackgroundColor(Color.GREEN);
                break;
            case AudioManager.RINGER_MODE_SILENT:
                btnSilencio.setBackgroundColor(Color.GREEN);
                break;
            case AudioManager.RINGER_MODE_VIBRATE:
                btnVibrar.setBackgroundColor(Color.GREEN);
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        btnSonar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                audioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);

                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, 15, 0);
                //Obtenemos la ruta del sonido
                Uri sonido = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                //Cargamos el sonido en nuestro mediaPlayer para que lo reproduzca
                mediaPlayer = MediaPlayer.create(getApplicationContext(), sonido);
                mediaPlayer.start();

                if (vibrator != null)
                    vibrator.cancel();

                btnSonar.setBackgroundColor(Color.GREEN);
                btnVibrar.setBackgroundColor(Color.RED);
                btnSilencio.setBackgroundColor(Color.RED);
            }
        });
        btnSilencio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                audioManager.setRingerMode(AudioManager.RINGER_MODE_SILENT);

                if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                }

                if (vibrator != null)
                    vibrator.cancel();

                btnSonar.setBackgroundColor(Color.RED);
                btnVibrar.setBackgroundColor(Color.RED);
                btnSilencio.setBackgroundColor(Color.GREEN);
            }
        });
        btnVibrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                audioManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);

                if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                }

                vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
                vibrator.vibrate(3000);

                btnSonar.setBackgroundColor(Color.RED);
                btnVibrar.setBackgroundColor(Color.GREEN);
                btnSilencio.setBackgroundColor(Color.RED);
            }
        });
    }
}
