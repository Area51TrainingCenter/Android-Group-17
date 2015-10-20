package com.johannfjs.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.johannfjs.mod2class2.MainActivity;
import com.johannfjs.mod2class2.R;

/**
 * Created by johannfjs on 19/10/2015.
 */
public class HomeFragment extends Fragment {
    private LinearLayout llMenu;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        llMenu = (LinearLayout) root.findViewById(R.id.llMenu);
        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        llMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).toggle();
            }
        });
    }
}
