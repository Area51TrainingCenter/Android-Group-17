package com.johannfjs.mod2class4;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.johannfjs.aplication.Configuracion;
import com.johannfjs.models.Articulo;
import com.johannfjs.sliding.BaseActivity;

public class RegistrarActivity extends BaseActivity {
    private LinearLayout llMenu;
    private TextView lblTexto;
    private EditText txtTitulo, txtDescripcion;
    private Spinner spCategoria;
    private Button btnRegistrar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        txtTitulo = (EditText) findViewById(R.id.txtTitulo);
        txtDescripcion = (EditText) findViewById(R.id.txtDescripcion);
        spCategoria = (Spinner) findViewById(R.id.spCategoria);
        btnRegistrar = (Button) findViewById(R.id.btnRegistrar);

        llMenu = (LinearLayout) findViewById(R.id.llMenu);
        lblTexto = (TextView) findViewById(R.id.lblTexto);
        lblTexto.setText("Registrar");

        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/Pacifico.ttf");
        lblTexto.setTypeface(typeface);
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
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtTitulo.getText().toString().equals("")) {
                    txtTitulo.setError("Ingrese Titulo");
                } else if (txtDescripcion.getText().toString().equals("")) {
                    txtDescripcion.setError("Ingrese Descripción");
                } else if (!txtTitulo.getText().toString().equals("")
                        && !txtDescripcion.getText().toString().equals("")) {
                    Articulo item = new Articulo(
                            txtTitulo.getText().toString(),
                            txtDescripcion.getText().toString(),
                            spCategoria.getSelectedItem().toString()
                    );
                    Configuracion.querysSQL.insertarArticulos(item);
                    Toast.makeText(getApplicationContext(), "Registro exitoso", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Ingrese todos los datos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
