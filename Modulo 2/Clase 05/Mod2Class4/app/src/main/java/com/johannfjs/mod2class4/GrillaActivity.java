package com.johannfjs.mod2class4;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.johannfjs.adapters.GrillaAdapter;
import com.johannfjs.aplication.Configuracion;
import com.johannfjs.models.Articulo;
import com.johannfjs.sliding.BaseActivity;

import java.util.ArrayList;

public class GrillaActivity extends BaseActivity {
    private LinearLayout llMenu;
    private TextView lblTexto;
    private GridView gvGrilla;
    private GrillaAdapter adapter;
    private ArrayList<Articulo> lista;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grilla);
        llMenu = (LinearLayout) findViewById(R.id.llMenu);
        lblTexto = (TextView) findViewById(R.id.lblTexto);
        gvGrilla = (GridView) findViewById(R.id.gvGrilla);

        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/Pacifico.ttf");
        lblTexto.setTypeface(typeface);
    }

    @Override
    protected void onStart() {
        super.onStart();
        lista = Configuracion.querysSQL.obtenerArticulos();
        if (lista == null)
            lista = new ArrayList<Articulo>();
        adapter = new GrillaAdapter(getApplicationContext(), lista);
        gvGrilla.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        llMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggle();
            }
        });
    }
}
