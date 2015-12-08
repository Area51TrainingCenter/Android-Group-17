package com.jcodee.niv2mod2class2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;

import java.util.List;

public class RegistroActivity extends AppCompatActivity {
    private EditText txtDistrito, txtDescripcion;
    private Button btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        txtDistrito = (EditText) findViewById(R.id.txtDistrito);
        txtDescripcion = (EditText) findViewById(R.id.txtDescripcion);
        btnGuardar = (Button) findViewById(R.id.btnGuardar);
    }

    @Override
    protected void onResume() {
        super.onResume();

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseObject parseObject = new ParseObject("distritos");
                parseObject.put("distrito", txtDistrito.getText().toString());
                parseObject.put("descripcion", txtDescripcion.getText().toString());
                parseObject.saveInBackground(new SaveCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e == null) {
                            obtenerDatos();
                        }
                    }
                });
            }
        });
    }

    private void obtenerDatos() {
        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("distritos");
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> list, ParseException e) {
                String datos = "";
                for (ParseObject item : list) {
                    datos += item.getString("distrito");
                    datos += item.getString("descripcion");
                }
                Toast.makeText(getApplicationContext(), datos, Toast.LENGTH_LONG).show();
            }
        });
    }
}
