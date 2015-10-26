package com.johannfjs.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.johannfjs.mod2class4.R;
import com.johannfjs.models.Articulo;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;

/**
 * Created by johannfjs on 23/10/2015.
 */
public class GrillaAdapter extends ArrayAdapter<Articulo> {
    protected ImageLoader imageLoader = ImageLoader.getInstance();
    private Context context;
    private ArrayList<Articulo> lista;

    public GrillaAdapter(Context context, ArrayList<Articulo> objects) {
        super(context, 0, objects);
        this.context = context;
        this.lista = objects;
    }

    static class ViewHolder {
        ImageView ivImagen;
        TextView lblTitulo, lblDescripcion, lblCategoria;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_grid, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.ivImagen = (ImageView) convertView.findViewById(R.id.ivImagen);
            viewHolder.lblTitulo = (TextView) convertView.findViewById(R.id.lblTitulo);
            viewHolder.lblDescripcion = (TextView) convertView.findViewById(R.id.lblDescripcion);
            viewHolder.lblCategoria = (TextView) convertView.findViewById(R.id.lblCategoria);
            convertView.setTag(viewHolder);
        }
        viewHolder = (ViewHolder) convertView.getTag();
        Articulo item = (Articulo) getItem(position);
        viewHolder.lblTitulo.setText(item.getTitulo());
        viewHolder.lblDescripcion.setText(item.getDescripcion());
        viewHolder.lblCategoria.setText(item.getCategoria());

        imageLoader.displayImage(
                "http://johannfjs.com/android/images/HDPackSuperiorWallpapers424_" +
                        (String.valueOf(position).length() == 1 ?
                                ("00" + position) : (String.valueOf(position).length() == 2 ?
                                ("0" + position) : position)) + ".jpg",
                viewHolder.ivImagen
        );

        return convertView;
    }
}
