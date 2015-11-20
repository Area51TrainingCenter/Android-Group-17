package com.johannfjs.niv2mod1class2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.johannfjs.adapters.ListaAdapter;
import com.johannfjs.aplicacion.Configuracion;
import com.johannfjs.models.Monedas;
import com.johannfjs.utils.Constantes;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity {
    private Button btnObtener;
    private ListaAdapter adapter;
    private ArrayList<Monedas> lista = new ArrayList<Monedas>();
    private ListView lvLista;
    private TextView lblResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnObtener = (Button) findViewById(R.id.btnObtener);
        lvLista = (ListView) findViewById(R.id.lvLista);
        lblResultado = (TextView) findViewById(R.id.lblResultado);
    }

    @Override
    protected void onResume() {
        super.onResume();

        btnObtener.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                        Request.Method.GET,
                        Constantes.API_VALIDACION,
                        null,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject jsonObject) {
                                //lblResultado.setText(jsonObject.toString());

                                try {
                                    jsonObject.getString("success");

                                    JSONObject jsonQuotes = jsonObject.getJSONObject("quotes");
                                    Iterator iterator = jsonQuotes.keys();
                                    while (iterator.hasNext()) {
                                        String key = (String) iterator.next();
                                        String value = jsonQuotes.getString(key);
                                        lista.add(new Monedas(key, value));
                                    }
                                    adapter = new ListaAdapter(getApplicationContext(), lista);
                                    lvLista.setAdapter(adapter);
                                } catch (Exception e) {

                                }
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError volleyError) {

                            }
                        }
                );
                Configuracion.getInstance().addToRequestQueue(jsonObjectRequest);

            }
        });
    }
}
