package com.johannfjs.aplication;

import android.app.Application;

import com.johannfjs.sqlite.QuerysSQL;

/**
 * Created by johannfjs on 21/10/2015.
 */
public class Configuracion extends Application {
    public static QuerysSQL querysSQL;

    @Override
    public void onCreate() {
        super.onCreate();
        querysSQL = new QuerysSQL(getApplicationContext());
    }
}
