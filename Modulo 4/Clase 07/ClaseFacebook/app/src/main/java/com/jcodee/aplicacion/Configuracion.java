package com.jcodee.aplicacion;

import android.app.Application;

import com.facebook.FacebookSdk;
import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by johannfjs on 14/12/2015.
 */
public class Configuracion extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        FacebookSdk.sdkInitialize(getApplicationContext());
        Fresco.initialize(getApplicationContext());
    }
}
