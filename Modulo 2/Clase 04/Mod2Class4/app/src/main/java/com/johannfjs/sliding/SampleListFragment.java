package com.johannfjs.sliding;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.johannfjs.mod2class4.GrillaActivity;
import com.johannfjs.mod2class4.ListarActivity;
import com.johannfjs.mod2class4.R;
import com.johannfjs.mod2class4.RegistrarActivity;

/**
 * Created by johannfjs on 19/10/2015.
 */
public class SampleListFragment extends ListFragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.list, null);
        return root;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        SampleAdapter adapter = new SampleAdapter(getActivity());
        adapter.add(new SampleItem("Registrar", android.R.drawable.ic_menu_search));
        adapter.add(new SampleItem("Listar", android.R.drawable.ic_menu_search));
        adapter.add(new SampleItem("Grillas", android.R.drawable.ic_menu_search));
        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Intent intent = null;
        switch (position) {
            case 0:
                intent = new Intent(getActivity(), RegistrarActivity.class);
                break;
            case 1:
                intent = new Intent(getActivity(), ListarActivity.class);
                break;
            case 2:
                intent = new Intent(getActivity(), GrillaActivity.class);
                break;
        }

        if (intent != null) {
            startActivity(intent);
            getActivity().finish();
        }
    }

    private class SampleItem {
        public String tag;
        public int iconRes;

        public SampleItem(String tag, int iconRes) {
            this.tag = tag;
            this.iconRes = iconRes;
        }
    }

    public class SampleAdapter extends ArrayAdapter<SampleItem> {

        public SampleAdapter(Context context) {
            super(context, 0);
        }

        class ViewHolder {
            ImageView icon;
            TextView title;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder = null;
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.row, null);
                viewHolder = new ViewHolder();
                viewHolder.icon = (ImageView) convertView.findViewById(R.id.row_icon);
                viewHolder.title = (TextView) convertView.findViewById(R.id.row_title);
                convertView.setTag(viewHolder);
            }
            viewHolder = (ViewHolder) convertView.getTag();
            viewHolder.icon.setImageResource(getItem(position).iconRes);
            viewHolder.title.setText(getItem(position).tag);
            return convertView;
        }
    }
}