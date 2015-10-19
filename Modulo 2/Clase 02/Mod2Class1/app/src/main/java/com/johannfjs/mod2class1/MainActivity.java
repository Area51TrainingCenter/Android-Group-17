package com.johannfjs.mod2class1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.johannfjs.aplicacion.Configuracion;

public class MainActivity extends AppCompatActivity {
    private TextView lblTexto;
    private Button btnCerrarSesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lblTexto = (TextView) findViewById(R.id.lblTexto);
        btnCerrarSesion = (Button) findViewById(R.id.btnCerrarSesion);

        String correo = "";
        if (Configuracion.sentencias.verificarSesion()) {
            correo = Configuracion.sentencias.obtenerCorreoSesion();
            btnCerrarSesion.setVisibility(View.VISIBLE);
        } else {
            correo = getIntent().getStringExtra("correo");
            btnCerrarSesion.setVisibility(View.GONE);
        }

        String nombre = Configuracion.sentencias.obtenerNombreUsuarioLogueado(correo);
        lblTexto.setText("Bienvenidos\n" + nombre);
    }

    @Override
    protected void onResume() {
        super.onResume();
        btnCerrarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Configuracion.sentencias.eliminarSesion();
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
