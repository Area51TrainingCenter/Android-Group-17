package com.johannfjs.mod1class4_1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.johannfjs.adapters.ListaAdapter;
import com.johannfjs.utils.Constantes;

/**
 * Created by johannfjs on 02/10/15.
 */
public class ListaActivity extends AppCompatActivity {
    private ListView lvLista;
    private ListaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        lvLista = (ListView) findViewById(R.id.lvLista);

        adapter = new ListaAdapter(ListaActivity.this, Constantes.lista);
        lvLista.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onResume() {
        super.onResume();
        lvLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                /*Toast.makeText(getApplicationContext(),
                        "posicion->" + position +
                                "\nNombre->" + Constantes.lista.get(position).getNombre(),
                        Toast.LENGTH_SHORT).show();*/
                Intent intent = new Intent(ListaActivity.this, MainActivity.class);
                intent.putExtra("position", position);
                startActivity(intent);
            }
        });
    }
}
