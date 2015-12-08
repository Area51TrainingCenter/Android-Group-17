package com.jcodee.niv2mod1class8_1;

import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private Button btnGrabar, btnDetener, btnReproducir, btnPausar;
    private String fileName = "";
    private MediaRecorder mediaRecorder = null;
    private MediaPlayer mediaPlayer = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        fileName = Environment.getExternalStorageDirectory().getAbsolutePath() + "/audio.3gp";
    }

    private void init() {
        LinearLayout ll = new LinearLayout(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        layoutParams.gravity = Gravity.CENTER;
        layoutParams.setMargins((int) getResources().getDimension(R.dimen.activity_horizontal_margin),
                (int) getResources().getDimension(R.dimen.activity_vertical_margin),
                (int) getResources().getDimension(R.dimen.activity_horizontal_margin),
                (int) getResources().getDimension(R.dimen.activity_vertical_margin));
        ll.setLayoutParams(layoutParams);
        ll.setOrientation(LinearLayout.VERTICAL);

        btnGrabar = new Button(this);
        LinearLayout.LayoutParams layoutParamsGrabar = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        btnGrabar.setLayoutParams(layoutParamsGrabar);
        btnGrabar.setText("Grabar Audio");
        ll.addView(btnGrabar);

        btnDetener = new Button(this);
        LinearLayout.LayoutParams layoutParamsDetener = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        btnDetener.setLayoutParams(layoutParamsDetener);
        btnDetener.setText("Detener Audio");
        ll.addView(btnDetener);

        FrameLayout fl = new FrameLayout(this);
        LinearLayout.LayoutParams layoutParamsFrame = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        fl.setLayoutParams(layoutParamsFrame);

        LinearLayout llHijo = new LinearLayout(this);
        FrameLayout.LayoutParams layoutParamsHijo = new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParamsHijo.gravity = Gravity.BOTTOM;
        llHijo.setLayoutParams(layoutParamsHijo);
        llHijo.setOrientation(LinearLayout.VERTICAL);

        btnReproducir = new Button(this);
        LinearLayout.LayoutParams layoutParamsReproducir = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        btnReproducir.setLayoutParams(layoutParamsReproducir);
        btnReproducir.setText("Reproducir Audio");
        llHijo.addView(btnReproducir);

        btnPausar = new Button(this);
        LinearLayout.LayoutParams layoutParamsPausar = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        btnPausar.setLayoutParams(layoutParamsPausar);
        btnPausar.setText("Pausar Audio");
        llHijo.addView(btnPausar);

        fl.addView(llHijo);
        ll.addView(fl);

        setContentView(ll);
    }

    @Override
    protected void onResume() {
        super.onResume();
        btnGrabar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaRecorder = new MediaRecorder();
                mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
                mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
                mediaRecorder.setOutputFile(fileName);
                mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);

                try {
                    mediaRecorder.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                mediaRecorder.start();
            }
        });
        btnDetener.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaRecorder.stop();
                mediaRecorder.release();
                mediaRecorder = null;
            }
        });

        btnReproducir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer = new MediaPlayer();
                try {
                    mediaPlayer.setDataSource(fileName);
                    mediaPlayer.prepare();
                    mediaPlayer.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        btnPausar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.release();
                mediaPlayer = null;
            }
        });
    }
}
