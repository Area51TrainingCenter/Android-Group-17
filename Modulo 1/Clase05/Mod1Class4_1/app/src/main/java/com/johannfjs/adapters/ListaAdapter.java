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

    static class ViewHolder {
        TextView lblNombre, lblApellido, lblEdad;
    }

    //Se dibuja y se integra con el código todo el item
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_list, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.lblNombre = (TextView) convertView.findViewById(R.id.lblNombre);
            viewHolder.lblApellido = (TextView) convertView.findViewById(R.id.Apellido);
            viewHolder.lblEdad = (TextView) convertView.findViewById(R.id.lblEdad);
            convertView.setTag(viewHolder);
        }

        viewHolder = (ViewHolder) convertView.getTag();

        Persona item = (Persona) getItem(position);
        viewHolder.lblNombre.setText(item.getNombre());
        viewHolder.lblApellido.setText(item.getApellido());
        viewHolder.lblEdad.setText(item.getEdad());

        return convertView;
    }
}
