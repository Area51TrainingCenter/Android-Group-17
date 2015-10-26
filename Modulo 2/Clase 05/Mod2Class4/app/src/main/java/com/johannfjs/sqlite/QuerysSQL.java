package com.johannfjs.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.johannfjs.models.Articulo;
import com.johannfjs.utils.Querys;

import java.util.ArrayList;

/**
 * Created by johannfjs on 21/10/2015.
 */
public class QuerysSQL {
    private ManageOpenHelper dbConexion;

    public QuerysSQL(Context context) {
        dbConexion = new ManageOpenHelper(context);
    }

    public void insertarArticulos(Articulo articulo) {
        SQLiteDatabase db = dbConexion.getWritableDatabase();
        db.execSQL(
                "INSERT INTO " + Querys.TB_ARTICULOS +
                        "(" + Querys.C_TITULO + "," +
                        Querys.C_DESCRIPCION + "," +
                        Querys.C_CATEGORIA + ") VALUES('" +
                        articulo.getTitulo() + "','" +
                        articulo.getDescripcion() + "','" +
                        articulo.getCategoria() + "')"
        );
    }

    public ArrayList<Articulo> obtenerArticulos() {
        SQLiteDatabase db = dbConexion.getReadableDatabase();
        Cursor cursor = db.rawQuery(
                "SELECT * FROM " + Querys.TB_ARTICULOS,
                null
        );
        ArrayList<Articulo> lista = null;
        if (cursor != null) {
            if (cursor.getCount() > 0) {
                lista = new ArrayList<>();
                if (cursor.moveToFirst()) {
                    do {
                        Articulo item = new Articulo(
                                cursor.getString(cursor.getColumnIndex(Querys.C_TITULO)),
                                cursor.getString(cursor.getColumnIndex(Querys.C_DESCRIPCION)),
                                cursor.getString(cursor.getColumnIndex(Querys.C_CATEGORIA))
                        );
                        lista.add(item);
                    } while (cursor.moveToNext());
                }
            }
        }
        return lista;
    }
}
