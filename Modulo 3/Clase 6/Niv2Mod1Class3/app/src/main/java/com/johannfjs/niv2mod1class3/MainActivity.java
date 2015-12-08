package com.johannfjs.niv2mod1class3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.johannfjs.adapters.ListaAdapter;
import com.johannfjs.aplicacion.Configuracion;
import com.johannfjs.models.Especialidad;
import com.johannfjs.models.Persona;
import com.johannfjs.service.GPSTracker;
import com.johannfjs.utils.Constant;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button btnObtener, btnVerMapa;
    private ListView lvLista;
    private LinearLayout llLista, llCargando;
    private ListaAdapter adapter;
    public static ArrayList<Persona> lista = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnObtener = (Button) findViewById(R.id.btnObtener);
        btnVerMapa = (Button) findViewById(R.id.btnVerMapa);
        lvLista = (ListView) findViewById(R.id.lvLista);

        llLista = (LinearLayout) findViewById(R.id.llLista);
        llCargando = (LinearLayout) findViewById(R.id.llCargando);
    }

    @Override
    protected void onResume() {
        super.onResume();
        btnVerMapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MapasActivity.class);
                startActivity(intent);
            }
        });
        btnObtener.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llCargando.setVisibility(View.VISIBLE);

                try {
                    GPSTracker gpsTracker = new GPSTracker(MainActivity.this);

                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("longitud", gpsTracker.getLongitude());
                    jsonObject.put("latitud", gpsTracker.getLatitude());

                    JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                            Request.Method.POST,
                            Constant.URL,
                            jsonObject,
                            new Response.Listener<JSONArray>() {
                                @Override
                                public void onResponse(JSONArray response) {
                                    //Log.d("TAG", response.toString());
                                    try {
                                        for (int i = 0; i < response.length(); i++) {
                                            JSONObject jsonDatos = response.getJSONObject(i);
                                            Persona persona = new Persona();

                                            if (jsonDatos.has("lh_codigo"))
                                                persona.setCodigo(jsonDatos.getString("lh_codigo"));

                                            if (jsonDatos.has("lh_nombre"))
                                                persona.setNombre(jsonDatos.getString("lh_nombre"));

                                            if (jsonDatos.has("lh_celular"))
                                                persona.setCelular(jsonDatos.getString("lh_celular"));

                                            if (jsonDatos.has("lh_tel_fijo"))
                                                persona.setTelefonoFijo(jsonDatos.getString("lh_tel_fijo"));

                                            if (jsonDatos.has("lh_latitude"))
                                                persona.setLatitud(jsonDatos.getString("lh_latitude"));

                                            if (jsonDatos.has("lh_longitud"))
                                                persona.setLongitud(jsonDatos.getString("lh_longitud"));

                                            if (jsonDatos.has("lh_img_resultado"))
                                                persona.setRutaImagen(jsonDatos.getString("lh_img_resultado"));

                                            ArrayList<Especialidad> listaEspecialidad = new ArrayList<Especialidad>();
                                            if (jsonDatos.has("per_especialidad")) {
                                                JSONArray jsonEspecialidad = jsonDatos.optJSONArray("per_especialidad");
                                                if (jsonEspecialidad != null && jsonEspecialidad.length() > 0) {
                                                    for (int j = 0; j < jsonEspecialidad.length(); j++) {
                                                        JSONObject jsonEspecialidadData = jsonEspecialidad.getJSONObject(j);
                                                        Especialidad especialidad = new Especialidad(
                                                                jsonEspecialidadData.getString("esp_codigo"),
                                                                jsonEspecialidadData.getString("esp_nombre")
                                                        );
                                                        listaEspecialidad.add(especialidad);
                                                    }
                                                }
                                            }

                                            persona.setListaEspecialidades(listaEspecialidad);
                                            Configuracion.sentenciaSQL.insertarRegistros(persona);
                                            lista.add(persona);
                                        }
                                        adapter = new ListaAdapter(getApplicationContext(), lista);
                                        lvLista.setAdapter(adapter);

                                        llCargando.setVisibility(View.GONE);
                                        lvLista.setVisibility(View.VISIBLE);
                                    } catch (Exception e) {
                                        Log.d("TAG", "error");
                                    }
                                }
                            },
                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {

                                }
                            }
                    );
                    Configuracion.getInstance().addToRequestQueue(jsonArrayRequest);
                } catch (Exception e) {

                }
            }
        });

        lvLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, MapasActivity.class);
                intent.putExtra("latitud", lista.get(position).getLatitud());
                intent.putExtra("longitud", lista.get(position).getLongitud());
                intent.putExtra("posicion", position);
                startActivity(intent);
            }
        });
    }
}