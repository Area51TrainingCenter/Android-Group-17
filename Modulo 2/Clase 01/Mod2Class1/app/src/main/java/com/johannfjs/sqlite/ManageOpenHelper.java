package com.johannfjs.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.johannfjs.utils.ConstanteSQL;

/**
 * Created by johannfjs on 14/10/2015.
 */
public class ManageOpenHelper extends SQLiteOpenHelper {
    public ManageOpenHelper(Context context) {
        super(context, ConstanteSQL.DB_NAME, null, ConstanteSQL.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ConstanteSQL.CREAR_TB_USUARIO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion == 1) {
            db.execSQL(ConstanteSQL.ELIMINAR_TB_USUARIO);
            onCreate(db);
        }
    }
}
