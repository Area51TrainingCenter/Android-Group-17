package com.jcodee.aplicacion;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.parse.Parse;

/**
 * Created by johannfjs on 09/12/2015.
 */
public class Configuracion extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Parse.initialize(getApplicationContext(),
                "8Xm0e5odRmR0kuwPrlohYwAnHwwQnHyK1SrZ63u5",
                "DFkaw97gm9lCbAWNk97CUoy0JSQemXMLqW7I7krn");

        Fresco.initialize(getApplicationContext());
    }
}
