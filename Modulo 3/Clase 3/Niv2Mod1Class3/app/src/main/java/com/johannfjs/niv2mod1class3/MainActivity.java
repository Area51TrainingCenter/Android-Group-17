package com.johannfjs.niv2mod1class3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.android.volley.toolbox.JsonArrayRequest;
import com.johannfjs.aplicacion.Configuracion;

public class MainActivity extends AppCompatActivity {
    private Button btnObtener;
    private ListView lvLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnObtener = (Button) findViewById(R.id.btnObtener);
        lvLista = (ListView) findViewById(R.id.lvLista);
    }

    @Override
    protected void onResume() {
        super.onResume();
        btnObtener.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(

                );
                Configuracion.getInstance().addToRequestQueue(jsonArrayRequest);

            }
        });
    }
}
