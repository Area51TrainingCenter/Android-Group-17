package com.johannfjs.mod1class4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by johannfjs on 30/09/15.
 */
public class TercerActivity extends AppCompatActivity {
    private Button btnAtras, btnVolverInicio;
    private TextView lblTexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tercer);
        btnAtras = (Button) findViewById(R.id.btnAtras);
        btnVolverInicio = (Button) findViewById(R.id.btnVolverInicio);
        lblTexto = (TextView) findViewById(R.id.lblTexto);

        if (getIntent().getExtras() != null) {
            if (getIntent().getExtras().containsKey("VALOR")) {
                String texto = getIntent().getExtras().getString("VALOR");
                lblTexto.setText(texto);
            }
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
        btnVolverInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TercerActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });
    }
}
