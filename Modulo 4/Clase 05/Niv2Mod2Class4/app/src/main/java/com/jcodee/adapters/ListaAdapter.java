package com.jcodee.adapters;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodee.models.Ropa;
import com.jcodee.niv2mod2class4.R;

import java.util.ArrayList;

/**
 * Created by johannfjs on 09/12/2015.
 */
public class ListaAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Ropa> lista;

    public ListaAdapter(Context context, ArrayList<Ropa> lista) {
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
        TextView lblDescripcion;
        SimpleDraweeView ivImagen;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.lblDescripcion = (TextView) convertView.findViewById(R.id.lblDescripcion);
            viewHolder.ivImagen = (SimpleDraweeView) convertView.findViewById(R.id.ivImagen);
            convertView.setTag(viewHolder);
        }
        viewHolder = (ViewHolder) convertView.getTag();
        viewHolder.lblDescripcion.setText(lista.get(position).getDescripcion());
        viewHolder.ivImagen.setImageURI(Uri.parse(lista.get(position).getUrlImagen()));
        return convertView;
    }
}
