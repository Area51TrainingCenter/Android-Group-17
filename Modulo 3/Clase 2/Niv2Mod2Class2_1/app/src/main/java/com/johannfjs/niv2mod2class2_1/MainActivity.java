package com.johannfjs.niv2mod2class2_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.johannfjs.aplicacion.Configuracion;
import com.johannfjs.utils.Contantes;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    private Button btnObtener;
    private TextView lblResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnObtener = (Button) findViewById(R.id.btnObtener);
        lblResultado = (TextView) findViewById(R.id.lblTexto);
    }

    @Override
    protected void onResume() {
        super.onResume();
        btnObtener.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                        Contantes.API_USERS,
                        new Response.Listener<JSONArray>() {
                            @Override
                            public void onResponse(JSONArray jsonArray) {
                                try {
                                    String resultado = "";
                                    for (int i = 0; i < jsonArray.length(); i++) {
                                        JSONObject jsonObject = jsonArray.getJSONObject(i);

                                        if (jsonObject.has("id"))
                                            resultado += "\n" + jsonObject.optInt("id");
                                        // Si se trae null se cae
                                        //resultado += "\n" + jsonObject.getString("id");

                                        resultado += "\n" + jsonObject.getString("name");
                                        resultado += "\n" + jsonObject.getString("username");
                                        resultado += "\n" + jsonObject.getString("email");

                                        if (jsonObject.has("address")) {
                                            JSONObject jsonAddress = jsonObject.optJSONObject("address");
                                            if (jsonAddress != null) {
                                                resultado += "\n" + jsonAddress.getString("street");
                                                resultado += "\n" + jsonAddress.getString("suite");
                                                resultado += "\n" + jsonAddress.getString("city");
                                                resultado += "\n" + jsonAddress.getString("zipcode");

                                                if (jsonAddress.has("geo")) {
                                                    JSONObject jsonGeo = jsonAddress.optJSONObject("geo");
                                                    if (jsonGeo != null) {
                                                        resultado += "\n" + jsonGeo.getString("lat");
                                                        resultado += "\n" + jsonGeo.getString("lng");
                                                    }
                                                }
                                            }
                                        }
                                        resultado += "\n" + jsonObject.getString("phone");
                                        resultado += "\n" + jsonObject.getString("website");
                                        if (jsonObject.has("company")) {
                                            JSONObject jsonCompany = jsonObject.optJSONObject("company");
                                            resultado += "\n" + jsonCompany.getString("name");
                                            resultado += "\n" + jsonCompany.getString("catchPhrase");
                                            resultado += "\n" + jsonCompany.getString("bs");
                                        }

                                        resultado += "\n-----------";
                                    }
                                    lblResultado.setText(resultado);
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

    private String validarJson(JSONObject jsonObject, String cadena) throws JSONException {
        if (jsonObject.has(cadena)) {
            String dato = jsonObject.optString(cadena);
            if (dato != null) {
                if (dato.trim().length() > 0) {
                    return jsonObject.getString(cadena);
                }
            }
        }
        return "";
    }
}
