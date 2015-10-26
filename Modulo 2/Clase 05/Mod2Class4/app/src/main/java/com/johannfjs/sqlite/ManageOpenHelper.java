package com.johannfjs.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.johannfjs.utils.Querys;

/**
 * Created by johannfjs on 21/10/2015.
 */
public class ManageOpenHelper extends SQLiteOpenHelper {
    public ManageOpenHelper(Context context) {
        super(context, Querys.DB_NAME, null, Querys.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Querys.CREAR_TB_ARTICULOS);
        db.execSQL(Querys.CREAR_TB_IMAGENES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(Querys.ELIMINAR_TB_ARTICULOS);
        db.execSQL(Querys.ELIMINAR_TB_IMAGENES);
        onCreate(db);
    }
}
