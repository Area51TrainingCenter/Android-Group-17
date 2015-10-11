package com.johannfjs.mod1class6;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.johannfjs.adapters.ListaAdapter;
import com.johannfjs.models.Imagenes;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView lvLista;
    private ListaAdapter adapter;
    private ArrayList<Imagenes> lista = new ArrayList<Imagenes>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvLista = (ListView) findViewById(R.id.lvLista);

        for (int i = 1; i <= 100; i++) {
            lista.add(new Imagenes(
                    i,
                    "http://johannfjs.com/android/images/HDPackSuperiorWallpapers424_0" + (i < 10 ? ("0" + i) : i) + ".jpg",
                    "Imagen " + i,
                    "La clase de android - La clase de android - La clase de android - La clase de android - La clase de android - La clase de android - La clase de android - La clase de android - La clase de android - La clase de android - La clase de android - La clase de android - La clase de android - La clase de android - La clase de android - La clase de android - La clase de android - ",
                    "12/02/2015"
            ));
        }

        adapter = new ListaAdapter(MainActivity.this, lista);
        lvLista.setAdapter(adapter);
    }
}
