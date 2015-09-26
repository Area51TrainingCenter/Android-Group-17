package com.johannfjs.mod1class2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {//implements View.OnClickListener {
    //Declaramos una variable
    private EditText ingreseTexto;
    private Button ejecutar;
    private TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Vinculamos la variable con el componente
        ingreseTexto = (EditText) findViewById(R.id.txtIngreseTexto);
        ejecutar = (Button) findViewById(R.id.btnEjecutar);
        texto = (TextView) findViewById(R.id.lblTexto);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //ingreseTexto.setText("Hola a todos");

        ejecutar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = ingreseTexto.getText().toString();
                texto.setText(text);
            }
        });
    }

    /*
        @Override
        public void onClick(View v) {
            if(v.getId()==R.id.btnEjecutar){

            }
        }
    */
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
