package com.johannfjs.sliding;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.johannfjs.fragments.HomeFragment;
import com.johannfjs.fragments.PagesFragment;
import com.johannfjs.fragments.PeopleFragment;
import com.johannfjs.mod2class2.MainActivity;
import com.johannfjs.mod2class2.R;

/**
 * Created by johannfjs on 19/10/2015.
 */
public class SampleListFragment extends ListFragment {

    //Fragmento-------
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.list, null);
        return root;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        SampleAdapter adapter = new SampleAdapter(getActivity());
        adapter.add(new SampleItem("Home", android.R.drawable.ic_menu_search));
        adapter.add(new SampleItem("People", android.R.drawable.ic_menu_search));
        //if(Configuracion.sentencias.validarUsuario) {
        adapter.add(new SampleItem("Pages", android.R.drawable.ic_menu_search));
        //}
        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Fragment fragment = null;

        switch (position) {
            case 0:
                fragment = new HomeFragment();
                break;
            case 1:
                if (1 == 0) {
                    fragment = new PeopleFragment();
                }
                break;
            case 2:
                fragment = new PagesFragment();
                break;
        }

        if (fragment != null) {
            switchFragment(fragment);
        } else {
            Toast.makeText(getActivity(),"Debe de ingresar primero",Toast.LENGTH_SHORT).show();
        }
    }

    private void switchFragment(Fragment fragment) {
        if (getActivity() == null)
            return;

        if (getActivity() instanceof MainActivity) {
            MainActivity fca = (MainActivity) getActivity();
            fca.switchContent(fragment);
        }
    }

    //-------
    //Modelo--------
    private class SampleItem {
        public String tag;
        public int iconRes;

        public SampleItem(String tag, int iconRes) {
            this.tag = tag;
            this.iconRes = iconRes;
        }
    }

    //--------
    //Adapter------
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
    //------
}