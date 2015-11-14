package com.johannfjs.application;

import android.app.Application;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by johannfjs on 13/11/2015.
 */
public class Configuracion extends Application {
    //Obtiene el nombre de la clase
    public static final String TAG = Configuracion.class.getSimpleName();
    //Instancia de la clase actual
    private static Configuracion mInstance;
    //Para poder encolar nuestras peticiones
    private RequestQueue mRequestQueue;

    @Override
    public void onCreate() {
        super.onCreate();
        //Instanciar nuestra variable de tipo Configuracion
        mInstance = this;
    }

    //Obtener nuestra instancia creada
    public static synchronized Configuracion getInstance() {
        return mInstance;
    }

    //Obtener la respuesta del servicio
    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        }
        return mRequestQueue;
    }

    //Sirven para encolar las peticiones del Web Services
    public <T> void addToRequestQueue(Request<T> req, String tag) {
        req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        getRequestQueue().add(req);
    }

    public <T> void addToRequestQueue(Request<T> req) {
        req.setTag(TAG);
        getRequestQueue().add(req);
    }

    //Sirve para cancelar peticiones
    public void cancelPendingRequests(Object tag) {
        if (mRequestQueue != null) {
            mRequestQueue.cancelAll(tag);
        }
    }
}
