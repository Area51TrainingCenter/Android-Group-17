package com.jcodee.niv2mod2class4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.jcodee.adapters.ListaAdapter;
import com.jcodee.models.Ropa;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText txtRopa;
    private Button btnListar, btnConsultar;
    private ListView lvLista;
    private ListaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtRopa = (EditText) findViewById(R.id.txtRopa);
        btnListar = (Button) findViewById(R.id.btnListar);
        btnConsultar = (Button) findViewById(R.id.btnConsultar);
        lvLista = (ListView) findViewById(R.id.lvLista);

    }

    @Override
    protected void onResume() {
        super.onResume();
        btnListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("ropa");
                query.findInBackground(new FindCallback<ParseObject>() {
                    @Override
                    public void done(List<ParseObject> list, ParseException e) {
                        ArrayList<Ropa> lista = new ArrayList<Ropa>();
                        for (ParseObject item : list) {
                            lista.add(new Ropa(
                                    item.getString("descripcion"),
                                    item.getParseFile("ruta_imagen").getUrl()
                            ));
                        }
                        adapter = new ListaAdapter(getApplicationContext(), lista);
                        lvLista.setAdapter(adapter);
                    }
                });
            }
        });
    }
}
