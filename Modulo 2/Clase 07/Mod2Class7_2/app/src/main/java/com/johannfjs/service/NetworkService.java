package com.johannfjs.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by johannfjs on 28/10/2015.
 */
public class NetworkService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private boolean verificarInternet() {
        ConnectivityManager connectivityManager = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnectedOrConnecting();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(getApplicationContext(), "Se inicio el servicio", Toast.LENGTH_SHORT).show();
        if (verificarInternet())
            Toast.makeText(getApplicationContext(), "Internet conectado", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(getApplicationContext(), "Intenet no conectado", Toast.LENGTH_SHORT).show();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(), "El servicio se ha detenido", Toast.LENGTH_SHORT).show();
    }
}
