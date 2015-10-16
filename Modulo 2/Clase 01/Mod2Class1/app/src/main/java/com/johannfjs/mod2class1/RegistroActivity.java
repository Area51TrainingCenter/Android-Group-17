package com.johannfjs.mod2class1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.johannfjs.aplicacion.Configuracion;
import com.johannfjs.models.Usuario;

public class RegistroActivity extends AppCompatActivity {
    private EditText txtNombre, txtCorreo, txtContrasenia;
    private Button btnRegistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtCorreo = (EditText) findViewById(R.id.txtCorreo);
        txtContrasenia = (EditText) findViewById(R.id.txtContrasenia);
        btnRegistro = (Button) findViewById(R.id.btnRegistro);
    }

    @Override
    protected void onResume() {
        super.onResume();
        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!txtNombre.getText().toString().trim().equals("")
                        && !txtCorreo.getText().toString().trim().equals("")
                        && !txtContrasenia.getText().toString().trim().equals("")) {
                    Usuario usuario = new Usuario();
                    usuario.setNombre(txtNombre.getText().toString());
                    usuario.setCorreo(txtCorreo.getText().toString());
                    usuario.setContrasenia(txtContrasenia.getText().toString());
                    Configuracion.sentencias.registrarUsuario(usuario);
                    Toast.makeText(getApplicationContext(), "Usuario creado", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), "Error, complete todos los campos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
