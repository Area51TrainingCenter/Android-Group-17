package com.johannfjs.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.johannfjs.mod1class6_1.R;
import com.johannfjs.models.Cupon;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by johannfjs on 05/10/15.
 */
public class GrillaAdapter extends ArrayAdapter<Cupon> {
    protected ImageLoader imageLoader=ImageLoader.getInstance();
    Context context;
    ArrayList<Cupon> lista;

    public GrillaAdapter(Context context, ArrayList<Cupon> objects) {
        super(context, 0, objects);
        this.context = context;
        this.lista = objects;
    }

    static class ViewHolder {
        TextView lblTitulo, lblSubtitulo, lblDistancia, lblLikes, lblPrecio1, lblPrecio2;
        ImageView ivImagen;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_grid, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.lblTitulo = (TextView) convertView.findViewById(R.id.lblTitulo);
            viewHolder.lblSubtitulo = (TextView) convertView.findViewById(R.id.lblSubTitulo);
            viewHolder.lblDistancia = (TextView) convertView.findViewById(R.id.lblDistancia);
            viewHolder.lblLikes = (TextView) convertView.findViewById(R.id.lblLikes);
            viewHolder.lblPrecio1 = (TextView) convertView.findViewById(R.id.lblPrecio1);
            viewHolder.lblPrecio2 = (TextView) convertView.findViewById(R.id.lblPrecio2);
            viewHolder.ivImagen = (ImageView) convertView.findViewById(R.id.ivImagen);
            convertView.setTag(viewHolder);
        }
        viewHolder = (ViewHolder) convertView.getTag();
        Cupon item = lista.get(position);
        viewHolder.lblTitulo.setText(item.getTitulo());
        viewHolder.lblSubtitulo.setText(item.getSubtitulo());
        viewHolder.lblDistancia.setText(item.getDistancia());
        viewHolder.lblLikes.setText(item.getLikes());
        viewHolder.lblPrecio1.setText(item.getPrecio1());
        viewHolder.lblPrecio2.setText(item.getPrecio2());

        imageLoader.displayImage(item.getRutaImagen(), viewHolder.ivImagen);

        return convertView;
    }
}
