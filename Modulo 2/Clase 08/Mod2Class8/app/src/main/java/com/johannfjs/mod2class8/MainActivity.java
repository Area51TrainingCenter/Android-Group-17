package com.johannfjs.mod2class8;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText txtNombre, txtApellido;
    private Button btnMostrar, btnAlert, btnCustom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtApellido = (EditText) findViewById(R.id.txtApellido);
        btnMostrar = (Button) findViewById(R.id.btnMostrar);
        btnAlert = (Button) findViewById(R.id.btnAlert);
        btnCustom = (Button) findViewById(R.id.btnCustom);
    }

    @Override
    protected void onResume() {
        super.onResume();
        btnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alerBuilder = new AlertDialog.Builder(MainActivity.this);
                alerBuilder.setTitle("Mensaje");
                alerBuilder.setMessage("Contenido");
                alerBuilder.setCancelable(true);
                alerBuilder.show();
            }
        });
        btnAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder aleBuilder = new AlertDialog.Builder(MainActivity.this);
                aleBuilder.setTitle(txtNombre.getText().toString());
                aleBuilder.setMessage(txtApellido.getText().toString());
                aleBuilder.setCancelable(false);
                aleBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });/*
                aleBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });*/
                aleBuilder.setNeutralButton("Intermedio", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                aleBuilder.show();
            }
        });
        btnCustom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialogo);
                dialog.setCancelable(false);
                dialog.getWindow().setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

                TextView lblTitulo, lblMensaje, lblOpcion1, lblOpcion2;
                FrameLayout flOpcion1, flOpcion2;
                LinearLayout llCerrar;

                lblTitulo = (TextView) dialog.findViewById(R.id.lblTexto);
                lblMensaje = (TextView) dialog.findViewById(R.id.lblDescripcion);
                lblOpcion1 = (TextView) dialog.findViewById(R.id.lblOpcion1);
                lblOpcion2 = (TextView) dialog.findViewById(R.id.lblOpcion2);
                flOpcion1 = (FrameLayout) dialog.findViewById(R.id.flOpcion1);
                flOpcion2 = (FrameLayout) dialog.findViewById(R.id.flOpcion2);
                llCerrar = (LinearLayout) dialog.findViewById(R.id.llCerrar);

                lblTitulo.setText(txtNombre.getText().toString());
                lblMensaje.setText(txtApellido.getText().toString());
                lblOpcion1.setText("Aceptar");
                lblOpcion2.setText("Cancelar");

                flOpcion1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                flOpcion2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                llCerrar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });
    }
}
