package com.johannfjs.niv2mod1class1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.johannfjs.application.Configuracion;
import com.johannfjs.utils.Constantes;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    private Button btnObtener;
    private EditText txtNombre, txtApellidoPaterno, txtApellidoMaterno, txtCorreo, txtGenero;
    private TextView lblTexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnObtener = (Button) findViewById(R.id.btnObtener);
        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtApellidoPaterno = (EditText) findViewById(R.id.txtApellidoPaterno);
        txtApellidoMaterno = (EditText) findViewById(R.id.txtApellidoMaterno);
        txtCorreo = (EditText) findViewById(R.id.txtCorreo);
        txtGenero = (EditText) findViewById(R.id.txtGenero);
        lblTexto = (TextView) findViewById(R.id.lblTexto);
    }

    @Override
    protected void onResume() {
        super.onResume();

        btnObtener.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                        Constantes.URL_OBTENER_PERSONAS,
                        new Response.Listener<JSONArray>() {
                            @Override
                            public void onResponse(JSONArray jsonArray) {
                                try {
                                    lblTexto.setText(jsonArray.toString());
                                    //Validamos que traiga datos
                                    if (jsonArray.length() > 0) {
                                        String nombre = "";
                                        String apellidoPaterno = "";
                                        String apellidoMaterno = "";
                                        String genero = "";
                                        String correo = "";

                                        //Recorremos el resultado que se ha traído
                                        for (int i = 0; i < jsonArray.length(); i++) {
                                            //Obtenemos un jsonObject de la lista de jsonArray
                                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                                            nombre += jsonObject.getString("nombres") + " ";
                                            apellidoPaterno += jsonObject.getString("apellidoPaterno") + " ";
                                            apellidoMaterno += jsonObject.getString("apellidoMaterno") + " ";
                                            genero += jsonObject.getString("genero") + " ";
                                            correo += jsonObject.getString("correo") + " ";
                                        }
                                        txtNombre.setText(nombre);
                                        txtApellidoPaterno.setText(apellidoPaterno);
                                        txtApellidoMaterno.setText(apellidoMaterno);
                                        txtGenero.setText(genero);
                                        txtCorreo.setText(correo);
                                    }
                                } catch (JSONException e) {

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
                Configuracion.getInstance().addToRequestQueue(jsonArrayRequest);
            }
        });
    }
}
