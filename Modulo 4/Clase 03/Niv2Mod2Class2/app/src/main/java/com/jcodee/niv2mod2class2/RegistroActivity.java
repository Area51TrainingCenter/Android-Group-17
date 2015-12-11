package com.jcodee.niv2mod2class2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.jcodee.adapters.ListaAdapter;
import com.jcodee.models.Distrito;
import com.parse.DeleteCallback;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;

import java.util.ArrayList;
import java.util.List;

public class RegistroActivity extends AppCompatActivity {
    private EditText txtDistrito, txtDescripcion, txtObjectId;
    private Button btnGuardar, btnEliminar, btnBuscar, btnModificar, btnListar;
    private ListView lvLista;
    private ListaAdapter adapter;
    private ArrayList<Distrito> lista = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        txtDistrito = (EditText) findViewById(R.id.txtDistrito);
        txtDescripcion = (EditText) findViewById(R.id.txtDescripcion);
        btnGuardar = (Button) findViewById(R.id.btnGuardar);
        lvLista = (ListView) findViewById(R.id.lvLista);
        btnEliminar = (Button) findViewById(R.id.btnEliminar);
        btnBuscar = (Button) findViewById(R.id.btnBuscar);
        btnModificar = (Button) findViewById(R.id.btnModificar);
        btnListar = (Button) findViewById(R.id.btnListar);
        txtObjectId = (EditText) findViewById(R.id.txtObjectId);

        adapter = new ListaAdapter(getApplicationContext(), lista);
        lvLista.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseObject parseObject = new ParseObject("distritos");
                parseObject.put("distrito", txtDistrito.getText().toString());
                parseObject.put("descripcion", txtDescripcion.getText().toString());
                parseObject.saveInBackground(new SaveCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e == null) {
                            obtenerDatos();
                        }
                    }
                });
            }
        });

        btnListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                obtenerDatos();
            }
        });

        lvLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Distrito item = lista.get(position);
                txtObjectId.setText(item.getObjectId());
                txtDescripcion.setText(item.getDescripcion());
                txtDistrito.setText(item.getDistrito());
            }
        });

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtObjectId.getText().toString().trim().length() > 0) {
                    ParseObject parseObject = new ParseObject("distritos");
                    parseObject.setObjectId(txtObjectId.getText().toString());
                    parseObject.deleteInBackground(new DeleteCallback() {
                        @Override
                        public void done(ParseException e) {
                            if (e == null) {
                                Toast.makeText(getApplicationContext(),
                                        "Se elimino correctamente", Toast.LENGTH_SHORT).show();
                                obtenerDatos();
                            }
                        }
                    });
                }
            }
        });

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("distritos");
                if (txtDistrito.getText().toString().length() > 0)
                    query.whereEqualTo("distrito", txtDistrito.getText().toString());
                if (txtDescripcion.getText().toString().length() > 0)
                    query.whereEqualTo("descripcion", txtDescripcion.getText().toString());

                query.findInBackground(new FindCallback<ParseObject>() {
                    @Override
                    public void done(List<ParseObject> list, ParseException e) {
                        if (e == null) {
                            lista.clear();
                            if (list.size() > 0) {
                                for (ParseObject item : list) {
                                    lista.add(new Distrito(item.getString("distrito"), item.getString("descripcion"), item.getObjectId()));
                                }
                                adapter.notifyDataSetChanged();
                            }
                        }
                    }
                });
            }
        });

        btnModificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseObject parseObject = new ParseObject("distritos");
                parseObject.setObjectId(txtObjectId.getText().toString());
                parseObject.put("distrito", txtDistrito.getText().toString());
                parseObject.put("descripcion", txtDescripcion.getText().toString());
                parseObject.saveInBackground(new SaveCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e == null) {
                            Toast.makeText(getApplicationContext(),
                                    "Se modifico correctamente", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        lvLista.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if (visibleItemCount == totalItemCount) {
                    lista.add(new Distrito("pruebaaa","pruebaaa","object"));
                    obtenerDatos();
                }
            }
        });
    }

    private void obtenerDatos() {
        lista.clear();
        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("distritos");
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> list, ParseException e) {
                //String datos = "";
                for (ParseObject item : list) {
                    //datos += item.getString("distrito");
                    //datos += item.getString("descripcion");
                    lista.add(new Distrito(item.getString("distrito"), item.getString("descripcion"), item.getObjectId()));
                }
                //Toast.makeText(getApplicationContext(), datos, Toast.LENGTH_LONG).show();
                adapter.notifyDataSetChanged();
            }
        });
    }
}
