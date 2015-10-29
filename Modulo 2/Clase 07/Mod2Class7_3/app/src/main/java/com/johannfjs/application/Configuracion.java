package com.johannfjs.application;

import android.app.Application;
import android.content.IntentFilter;
import android.net.ConnectivityManager;

import com.johannfjs.receiver.NetworkReceiver;

/**
 * Created by johannfjs on 28/10/2015.
 */
public class Configuracion extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        IntentFilter intentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(new NetworkReceiver(), intentFilter);
    }
}
