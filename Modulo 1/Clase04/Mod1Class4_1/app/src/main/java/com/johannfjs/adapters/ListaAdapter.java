package com.johannfjs.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.johannfjs.mod1class4_1.R;
import com.johannfjs.models.Persona;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by johannfjs on 30/09/15.
 */
public class ListaAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Persona> lista;

    public ListaAdapter(Context context, ArrayList<Persona> lista) {
        this.context = context;
        this.lista = lista;
    }

    //Saber cuantos elementos hay en nuestra lista
    @Override
    public int getCount() {
        return lista.size();
    }

    //Obtener un item de nuestra lista según la posición
    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    //Obtener el id de un item de nuestra lista según la posición
    @Override
    public long getItemId(int position) {
        return 0;
    }

    //Se dibuja y se integra con el código todo el item
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_list, parent, false);
        }
        TextView lblNombre = (TextView) convertView.findViewById(R.id.lblNombre);
        TextView lblApellido = (TextView) convertView.findViewById(R.id.Apellido);
        TextView lblEdad = (TextView) convertView.findViewById(R.id.lblEdad);

        Persona item = (Persona) getItem(position);
        lblNombre.setText(item.getNombre());
        lblApellido.setText(item.getApellido());
        lblEdad.setText(item.getEdad());

        return convertView;
    }
}
