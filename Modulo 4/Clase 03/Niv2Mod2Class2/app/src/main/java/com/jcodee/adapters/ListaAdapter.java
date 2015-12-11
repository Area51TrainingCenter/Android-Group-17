package com.jcodee.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.jcodee.models.Distrito;
import com.jcodee.niv2mod2class2.R;

import java.util.ArrayList;

/**
 * Created by johannfjs on 07/12/2015.
 */
public class ListaAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Distrito> lista;

    public ListaAdapter(Context context, ArrayList<Distrito> lista) {
        this.context = context;
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    static class ViewHolder {
        TextView lblDistrito, lblDescripcion;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_list, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.lblDescripcion = (TextView) convertView.findViewById(R.id.lblDescripcion);
            viewHolder.lblDistrito = (TextView) convertView.findViewById(R.id.lblDistrito);
            convertView.setTag(viewHolder);
        }
        viewHolder = (ViewHolder) convertView.getTag();

        Distrito item = (Distrito) getItem(position);

        viewHolder.lblDistrito.setText(lista.get(position).getDistrito());
        viewHolder.lblDescripcion.setText(lista.get(position).getDescripcion());
        return convertView;
    }
}
