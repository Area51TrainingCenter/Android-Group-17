package com.johannfjs.mod2class7_1;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText txtNombre, txtApellido;
    private Button btnGrabar, btnObtener;
    private TextView lblTexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtApellido = (EditText) findViewById(R.id.txtApellido);
        btnGrabar = (Button) findViewById(R.id.btnGrabar);
        btnObtener = (Button) findViewById(R.id.btnObtener);
        lblTexto = (TextView) findViewById(R.id.lblTexto);
    }

    @Override
    protected void onResume() {
        super.onResume();
        btnGrabar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = getSharedPreferences("class7_1", MODE_PRIVATE).edit();
                editor.putString("nombre", txtNombre.getText().toString());
                editor.putString("apellido", txtApellido.getText().toString());
                editor.commit();
                //editor.clear();
                //editor.commit();
            }
        });

        btnObtener.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("class7_1", MODE_PRIVATE);
                String nombre = sharedPreferences.getString("nombre", null);
                String apellido = sharedPreferences.getString("apellido", null);

                lblTexto.setText("Nombre->" + nombre + "\nApellido->" + apellido);
            }
        });
    }
}
