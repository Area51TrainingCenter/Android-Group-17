package com.johannfjs.mod1class4_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.johannfjs.adapters.ListaAdapter;
import com.johannfjs.models.Persona;
import com.johannfjs.utils.Constantes;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText txtNombre, txtApellido, txtEdad;
    private Button btnGrabar, btnListado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtApellido = (EditText) findViewById(R.id.txtApellido);
        txtEdad = (EditText) findViewById(R.id.txtEdad);
        btnGrabar = (Button) findViewById(R.id.btnGrabar);
        btnListado = (Button) findViewById(R.id.btnListado);
        btnGrabar.setTag(-1);


        if (getIntent() != null) {
            if (getIntent().hasExtra("position")) {
                int posicion = getIntent().getIntExtra("position", -1);
                if (posicion > -1) {
                    Persona item = Constantes.lista.get(posicion);
                    txtNombre.setText(item.getNombre());
                    txtApellido.setText(item.getApellido());
                    txtEdad.setText(item.getEdad());
                    btnGrabar.setTag(posicion);
                    btnGrabar.setText(getResources().getString(R.string.modificar));
                }
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        btnGrabar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int valor = (int) btnGrabar.getTag();
                if (valor == -1) {
                    Constantes.lista.add(
                            new Persona(
                                    txtNombre.getText().toString(),
                                    txtApellido.getText().toString(),
                                    txtEdad.getText().toString()
                            )
                    );
                    txtNombre.setText("");
                    txtApellido.setText("");
                    txtEdad.setText("");
                    txtNombre.requestFocus();
                } else {
                    Constantes.lista.get(valor).setNombre(txtNombre.getText().toString());
                    Constantes.lista.get(valor).setApellido(txtApellido.getText().toString());
                    Constantes.lista.get(valor).setEdad(txtEdad.getText().toString());
                    btnGrabar.setTag(-1);
                    finish();
                }


                //adapter.notifyDataSetChanged();
            }
        });
        btnListado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListaActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
