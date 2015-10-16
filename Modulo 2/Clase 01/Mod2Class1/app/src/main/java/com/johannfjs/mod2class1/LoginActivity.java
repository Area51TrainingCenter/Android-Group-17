package com.johannfjs.mod2class1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.johannfjs.aplicacion.Configuracion;
import com.johannfjs.models.Usuario;

public class LoginActivity extends AppCompatActivity {
    private EditText txtCorreo, txtContrasenia;
    private Button btnLogin;
    private LinearLayout llRegistrarse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txtCorreo = (EditText) findViewById(R.id.txtCorreo);
        txtContrasenia = (EditText) findViewById(R.id.txtContrasenia);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        llRegistrarse = (LinearLayout) findViewById(R.id.llRegistrarse);
    }

    @Override
    protected void onResume() {
        super.onResume();
        llRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegistroActivity.class);
                startActivity(intent);
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!txtCorreo.getText().toString().trim().equals("")
                        && !txtContrasenia.getText().toString().trim().equals("")) {
                    Usuario usuario = new Usuario();
                    usuario.setCorreo(txtCorreo.getText().toString());
                    usuario.setContrasenia(txtContrasenia.getText().toString());
                    Usuario resultado = Configuracion.sentencias.obtenerUsuario(usuario);
                    if (resultado != null) {
                        Toast.makeText(getApplicationContext(), "Login correcto", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                        finish();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Ingrese todos los datos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
