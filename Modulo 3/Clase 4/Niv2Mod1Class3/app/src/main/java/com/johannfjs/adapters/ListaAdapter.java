package com.johannfjs.adapters;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.johannfjs.models.Especialidad;
import com.johannfjs.models.Persona;
import com.johannfjs.niv2mod1class3.R;

import java.util.ArrayList;

/**
 * Created by johannfjs on 18/11/2015.
 */
public class ListaAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Persona> lista;

    public ListaAdapter(Context context, ArrayList<Persona> lista) {
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
        return Integer.parseInt(lista.get(position).getCodigo());
    }

    static class ViewHolder {
        SimpleDraweeView ivImagen;
        TextView lblNombre, lblCelular, lblTelefonoFijo, lblEspecialidades, lblLatitud, lblLongitud;
        LinearLayout llNombre, llCelular, llTelefonoFijo, llEspecialidades, llLatitud, llLongitud;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.ivImagen = (SimpleDraweeView) convertView.findViewById(R.id.ivImagen);
            viewHolder.lblNombre = (TextView) convertView.findViewById(R.id.lblNombre);
            viewHolder.lblCelular = (TextView) convertView.findViewById(R.id.lblCelular);
            viewHolder.lblTelefonoFijo = (TextView) convertView.findViewById(R.id.lblTelefonoFijo);
            viewHolder.lblEspecialidades = (TextView) convertView.findViewById(R.id.lblEspecialidades);
            viewHolder.lblLatitud = (TextView) convertView.findViewById(R.id.lblLatitud);
            viewHolder.lblLongitud = (TextView) convertView.findViewById(R.id.lblLongitud);
            viewHolder.llNombre = (LinearLayout) convertView.findViewById(R.id.llNombre);
            viewHolder.llCelular = (LinearLayout) convertView.findViewById(R.id.llCelular);
            viewHolder.llTelefonoFijo = (LinearLayout) convertView.findViewById(R.id.llTelefonoFijo);
            viewHolder.llEspecialidades = (LinearLayout) convertView.findViewById(R.id.llEspecialidades);
            viewHolder.llLatitud = (LinearLayout) convertView.findViewById(R.id.llLatitud);
            viewHolder.llLongitud = (LinearLayout) convertView.findViewById(R.id.llLongitud);

            convertView.setTag(viewHolder);
        }

        viewHolder = (ViewHolder) convertView.getTag();

        Persona item = (Persona) getItem(position);

        if (item.getNombre() != null && item.getNombre().length() > 0) {
            viewHolder.lblNombre.setText(item.getNombre());
            viewHolder.llNombre.setVisibility(View.VISIBLE);
        } else {
            viewHolder.lblNombre.setVisibility(View.GONE);
        }

        if (item.getCelular() != null && item.getCelular().length() > 0) {
            viewHolder.lblCelular.setText(item.getCelular());
            viewHolder.llCelular.setVisibility(View.VISIBLE);
        } else {
            viewHolder.llCelular.setVisibility(View.GONE);
        }

        if (item.getTelefonoFijo() != null && item.getTelefonoFijo().length() > 0) {
            viewHolder.lblTelefonoFijo.setText(item.getTelefonoFijo());
            viewHolder.llTelefonoFijo.setVisibility(View.VISIBLE);
        } else {
            viewHolder.llTelefonoFijo.setVisibility(View.GONE);
        }

        if (item.getLatitud() != null && item.getLatitud().length() > 0) {
            viewHolder.lblLatitud.setText(item.getLatitud());
            viewHolder.llLatitud.setVisibility(View.VISIBLE);
        } else {
            viewHolder.llLatitud.setVisibility(View.GONE);
        }

        if (item.getLongitud() != null && item.getLongitud().length() > 0) {
            viewHolder.lblLongitud.setText(item.getLongitud());
            viewHolder.llLongitud.setVisibility(View.VISIBLE);
        } else {
            viewHolder.llLongitud.setVisibility(View.GONE);
        }

        if (item.getListaEspecialidades().size() > 0) {
            String especialidades = "";
            for (Especialidad itemEspecialidad : item.getListaEspecialidades()) {
                especialidades += itemEspecialidad.getNombre() + ",";
            }
            especialidades = especialidades.substring(0, especialidades.length() - 1);
            viewHolder.lblEspecialidades.setText(especialidades);
            viewHolder.llEspecialidades.setVisibility(View.VISIBLE);
        } else {
            viewHolder.llEspecialidades.setVisibility(View.GONE);
        }

        if (item.getRutaImagen() != null)
            viewHolder.ivImagen.setImageURI(Uri.parse(item.getRutaImagen()));

        return convertView;
    }
}
