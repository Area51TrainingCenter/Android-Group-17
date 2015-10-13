package com.johannfjs.adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.johannfjs.fragments.DetalleFragment;
import com.johannfjs.utils.Constantes;

/**
 * Created by johannfjs on 12/10/2015.
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        DetalleFragment fragment = new DetalleFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("posicion", position);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getCount() {
        return Constantes.lista.size();
    }
}
