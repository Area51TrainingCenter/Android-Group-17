package com.johannfjs.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.johannfjs.models.Monedas;
import com.johannfjs.niv2mod1class2.R;

import java.util.ArrayList;

/**
 * Created by johannfjs on 16/11/2015.
 */
public class ListaAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Monedas> lista;

    public ListaAdapter(Context context, ArrayList<Monedas> lista) {
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
        TextView lblKey, lblValue;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.lblKey = (TextView) convertView.findViewById(R.id.lblKey);
            viewHolder.lblValue = (TextView) convertView.findViewById(R.id.lblValue);
            convertView.setTag(viewHolder);
        }
        viewHolder = (ViewHolder) convertView.getTag();

        Monedas item = (Monedas) getItem(position);
        viewHolder.lblKey.setText(item.getKey());
        viewHolder.lblValue.setText(item.getValue());

        return convertView;
    }
}
