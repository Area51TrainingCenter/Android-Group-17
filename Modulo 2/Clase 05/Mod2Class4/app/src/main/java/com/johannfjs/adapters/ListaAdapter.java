package com.johannfjs.adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.johannfjs.mod2class4.R;
import com.johannfjs.models.Articulo;
import com.nostra13.universalimageloader.core.ImageLoader;

import org.w3c.dom.Text;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by johannfjs on 23/10/2015.
 */
public class ListaAdapter extends BaseAdapter {
    protected ImageLoader imageLoader = ImageLoader.getInstance();
    private Context context;
    private ArrayList<Articulo> lista;

    public ListaAdapter(Context context, ArrayList<Articulo> lista) {
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
        CircleImageView ivImagen;
        TextView lblTitulo, lblCategoria, lblDescripcion;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_list, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.ivImagen = (CircleImageView) convertView.findViewById(R.id.ivImagen);
            viewHolder.lblTitulo = (TextView) convertView.findViewById(R.id.lblTitulo);
            viewHolder.lblDescripcion = (TextView) convertView.findViewById(R.id.lblDescripcion);
            viewHolder.lblCategoria = (TextView) convertView.findViewById(R.id.lblCategoria);

            Typeface typeface = Typeface.createFromAsset(context.getAssets(), "fonts/Pacifico.ttf");
            viewHolder.lblTitulo.setTypeface(typeface);
            viewHolder.lblDescripcion.setTypeface(typeface);
            viewHolder.lblCategoria.setTypeface(typeface);

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
