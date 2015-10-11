package com.johannfjs.mod1class6_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.johannfjs.adapters.GrillaAdapter;
import com.johannfjs.models.Cupon;
import com.johannfjs.utils.Constantes;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private GridView gvGrilla;
    private GrillaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gvGrilla = (GridView) findViewById(R.id.gvGrilla);

        for (int i = 100; i < 200; i++) {
            Constantes.lista.add(
                    new Cupon(
                            Constantes.lista.size(),
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

        adapter = new GrillaAdapter(MainActivity.this, Constantes.lista);
        gvGrilla.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        gvGrilla.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Estamos enviando la posición al MostrarActivity
                Intent intent = new Intent(MainActivity.this, MostrarActivity.class);
                intent.putExtra("position", position);
                startActivity(intent);
            }
        });
    }
}
