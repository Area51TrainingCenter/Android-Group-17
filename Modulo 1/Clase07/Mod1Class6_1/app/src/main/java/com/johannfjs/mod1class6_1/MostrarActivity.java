package com.johannfjs.mod1class6_1;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.johannfjs.models.Cupon;
import com.johannfjs.utils.Constantes;
import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * Created by johannfjs on 07/10/2015.
 */
public class MostrarActivity extends Activity {
    protected ImageLoader imageLoader = ImageLoader.getInstance();
    private ImageView ivImagen;
    private TextView lblTitulo;
    private TextView lblSubtitulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);

        ivImagen = (ImageView) findViewById(R.id.ivImagen);
        lblTitulo = (TextView) findViewById(R.id.lblTitulo);
        lblSubtitulo = (TextView) findViewById(R.id.lblSubtitulo);

        if (getIntent().hasExtra("position")) {
            int posicion = getIntent().getIntExtra("position", -1);
            Cupon item = Constantes.lista.get(posicion);

            imageLoader.displayImage(item.getRutaImagen(), ivImagen);
            lblTitulo.setText(item.getTitulo());
            lblSubtitulo.setText(item.getSubtitulo());
        }
    }
}
