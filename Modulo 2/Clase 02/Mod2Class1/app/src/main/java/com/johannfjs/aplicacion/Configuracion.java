package com.johannfjs.aplicacion;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.johannfjs.sqlite.SentenciasSQL;

/**
 * Created by johannfjs on 14/10/2015.
 */
public class Configuracion extends Application {
    public static SentenciasSQL sentencias;

    @Override
    public void onCreate() {
        super.onCreate();
        sentencias = new SentenciasSQL(getApplicationContext());
    }
}
