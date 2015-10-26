package com.johannfjs.mod2class4;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.johannfjs.adapters.ListaAdapter;
import com.johannfjs.aplication.Configuracion;
import com.johannfjs.models.Articulo;
import com.johannfjs.sliding.BaseActivity;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ListarActivity extends BaseActivity {
    private LinearLayout llMenu;
    private TextView lblTexto;
    private ListView lvLista;
    private ListaAdapter adapter;
    private ArrayList<Articulo> lista;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);
        llMenu = (LinearLayout) findViewById(R.id.llMenu);
        lblTexto = (TextView) findViewById(R.id.lblTexto);
        lvLista = (ListView) findViewById(R.id.lvLista);

        lblTexto.setText("Listado");

        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/Pacifico.ttf");
        lblTexto.setTypeface(typeface);
    }

    @Override
    protected void onStart() {
        super.onStart();
        lista = Configuracion.querysSQL.obtenerArticulos();
        if (lista == null)
            lista = new ArrayList<Articulo>();
        adapter = new ListaAdapter(getApplicationContext(), lista);
        lvLista.setAdapter(adapter);
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
