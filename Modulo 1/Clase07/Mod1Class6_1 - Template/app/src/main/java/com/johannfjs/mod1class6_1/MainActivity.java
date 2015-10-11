package com.johannfjs.mod1class6_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import com.johannfjs.adapters.GrillaAdapter;
import com.johannfjs.models.Cupon;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private GridView gvGrilla;
    private GrillaAdapter adapter;
    private ArrayList<Cupon> lista = new ArrayList<Cupon>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gvGrilla = (GridView) findViewById(R.id.gvGrilla);

        for (int i = 100; i < 200; i++) {
            lista.add(
                    new Cupon(
                            lista.size(),
                            "http://johannfjs.com/android/images/HDPackSuperiorWallpapers424_" + i + ".jpg",
                            "Titulo " + i,
                            "Subtitulo " + i,
                            (100 + i) + " km",
                            String.valueOf(1 + i),
                            "S/." + (10 + i),
                            "S/." + (5 + i)
                    )
            );
        }

        adapter = new GrillaAdapter(MainActivity.this, lista);
        gvGrilla.setAdapter(adapter);
    }

}
