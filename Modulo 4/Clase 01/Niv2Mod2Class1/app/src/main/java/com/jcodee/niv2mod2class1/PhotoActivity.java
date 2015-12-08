package com.jcodee.niv2mod2class1;

import android.app.Activity;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;

import com.desmond.squarecamera.ImageUtility;

public class PhotoActivity extends Activity {
    private ImageView ivImagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);

        ivImagen = (ImageView) findViewById(R.id.ivImagen);

        if (getIntent().hasExtra("path")) {
            String path = getIntent().getStringExtra("path");

            Uri uri = Uri.parse(path);
/*
            Bitmap bitmap = ImageUtility.decodeSampledBitmapFromPath(path, 200, 300);
            ivImagen.setImageBitmap(bitmap);
            */
            ivImagen.setImageURI(uri);
        }
    }
}
