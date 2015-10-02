package com.johannfjs.mod1class4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by johannfjs on 30/09/15.
 */
public class SegundoActivity extends AppCompatActivity {
    private Button btnAtras, btnSiguiente;
    private TextView lblTexto;
    private String texto = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundo);
        btnAtras = (Button) findViewById(R.id.btnAtras);
        btnSiguiente = (Button) findViewById(R.id.btnSiguiente);
        lblTexto = (TextView) findViewById(R.id.lblTexto);

        if (getIntent().hasExtra("VALOR")) {
            texto = getIntent().getStringExtra("VALOR");
            lblTexto.setText(texto);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SegundoActivity.this, TercerActivity.class);
                //intent.putExtra("VALOR", texto);

                Bundle bundle = new Bundle();
                bundle.putString("VALOR", texto);
                intent.putExtras(bundle);

                startActivity(intent);
            }
        });
    }
}
