package com.johannfjs.aplicacion;

import android.app.Application;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.johannfjs.sqlite.SentenciaSQL;

/**
 * Created by johannfjs on 16/11/2015.
 */
public class Configuracion extends Application {
    public static final String TAG = Configuracion.class.getSimpleName();
    private static Configuracion mInstance;
    private RequestQueue mRequestQueue;
    public static SentenciaSQL sentenciaSQL;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;

        sentenciaSQL = new SentenciaSQL(getApplicationContext());

        Fresco.initialize(getApplicationContext());
    }

    public static synchronized Configuracion getInstance() {
        return mInstance;
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        }
        return mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req, String tag) {
        req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        getRequestQueue().add(req);
    }

    public <T> void addToRequestQueue(Request<T> req) {
        req.setTag(TAG);
        getRequestQueue().add(req);
    }

    public void cancelPendingRequests(Object tag) {
        if (mRequestQueue != null) {
            mRequestQueue.cancelAll(tag);
        }
    }
}
