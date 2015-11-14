package com.johannfjs.niv2mod1class1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.johannfjs.application.Configuracion;
import com.johannfjs.utils.Constantes;

import org.json.JSONArray;

public class LoginActivity extends AppCompatActivity {
    private EditText txtCorreo, txtContrasenia;
    private Button btnValidar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtCorreo = (EditText) findViewById(R.id.txtCorreo);
        txtContrasenia = (EditText) findViewById(R.id.txtContrasenia);
        btnValidar = (Button) findViewById(R.id.btnValidar);
    }

    @Override
    protected void onResume() {
        super.onResume();
        btnValidar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                        Constantes.URL_VALIDAR_USUARIO + Constantes.CORREO + txtCorreo.getText().toString() +
                                Constantes.CONTRASENIA + txtContrasenia.getText().toString(),
                        new Response.Listener<JSONArray>() {
                            @Override
                            public void onResponse(JSONArray jsonArray) {
                                if (jsonArray.length() > 0) {
                                    Toast.makeText(getApplicationContext(), "Trajo datos", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(getApplicationContext(), "No trajo datos", Toast.LENGTH_SHORT).show();
                                }
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError volleyError) {

                            }
                        }
                );
                Configuracion.getInstance().addToRequestQueue(jsonArrayRequest);
            }
        });
    }
}
