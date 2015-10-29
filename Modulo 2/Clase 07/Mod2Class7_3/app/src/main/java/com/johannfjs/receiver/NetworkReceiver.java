package com.johannfjs.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

/**
 * Created by johannfjs on 28/10/2015.
 */
public class NetworkReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        boolean verificar = verificarInternet(context);
        if (verificar)
            Toast.makeText(context, "Internet conectado", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(context, "No hay internet", Toast.LENGTH_SHORT).show();
    }

    private boolean verificarInternet(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnectedOrConnecting();
    }
}
