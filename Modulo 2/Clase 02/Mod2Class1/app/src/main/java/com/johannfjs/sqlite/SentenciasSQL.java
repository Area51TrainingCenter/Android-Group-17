package com.johannfjs.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.johannfjs.models.Usuario;
import com.johannfjs.utils.ConstanteSQL;

/**
 * Created by johannfjs on 14/10/2015.
 */
public class SentenciasSQL {
    private ManageOpenHelper dbConexion;

    public SentenciasSQL(Context context) {
        dbConexion = new ManageOpenHelper(context);
    }

    public void registrarUsuario(Usuario usuario) {
        SQLiteDatabase db = dbConexion.getWritableDatabase();
        //INSERT INTO tb_usuarios(nombre,correo,contrasenia)values('nombre','correo','contrasenia')
        db.execSQL(
                "INSERT INTO " + ConstanteSQL.TB_USUARIOS +
                        "(" + ConstanteSQL.C_NOMBRE + "," +
                        ConstanteSQL.C_CORREO + "," +
                        ConstanteSQL.C_CONTRASENIA + ") VALUES('" +
                        usuario.getNombre() + "','" +
                        usuario.getCorreo() + "','" +
                        usuario.getContrasenia() + "')"
        );
    }

    public Usuario obtenerUsuario(Usuario usuario) {
        Usuario resultado = null;
        SQLiteDatabase db = dbConexion.getReadableDatabase();
        //SELECT * FROM tb_usuarios WHERE correo='correo' and contrasenia='contrasenia'
        Cursor cursor = db.rawQuery(
                "SELECT * FROM " + ConstanteSQL.TB_USUARIOS + " WHERE " + ConstanteSQL.C_CORREO + "='" +
                        usuario.getCorreo() + "' AND " + ConstanteSQL.C_CONTRASENIA + "='" +
                        usuario.getContrasenia() + "'",
                null
        );
        //verificamos que nuestro cursor no este vacío
        if (cursor != null && cursor.getCount() > 0) {
            //Saltamos la primera línea (cabecera)
            if (cursor.moveToFirst()) {
                do {
                    resultado = new Usuario();
                    //Obtenemos los datos
                    //cursor.getString -> obtenemos el dato por el indice
                    //cursor.getColumnIndex -> obtenemos el indice por el nombre de la columna
                    resultado.setNombre(cursor.getString(cursor.getColumnIndex(ConstanteSQL.C_NOMBRE)));
                    resultado.setCorreo(cursor.getString(cursor.getColumnIndex(ConstanteSQL.C_CORREO)));
                    //Recorremos los resultados
                } while (cursor.moveToNext());
            }
        }
        return resultado;
    }

    public void registrarSesion(String correo) {
        SQLiteDatabase db = dbConexion.getWritableDatabase();
        //INSERT INTO tb_sesion (correo)values('correo')
        String sql = "INSERT INTO " + ConstanteSQL.TB_SESION +
                "(" + ConstanteSQL.C_CORREO + ") VALUES('" +
                correo + "')";
        Log.d("SQL", sql);
        db.execSQL(
                sql
        );
    }

    public void eliminarSesion() {
        SQLiteDatabase db = dbConexion.getWritableDatabase();
        //DELETE FROM tb_sesion
        db.execSQL(
                "DELETE FROM " + ConstanteSQL.TB_SESION
        );
    }

    public String obtenerNombreUsuarioLogueado(String correo) {
        String nombre = "";
        SQLiteDatabase db = dbConexion.getReadableDatabase();
        //SELECT nombre FROM tb_usuarios where correo='correo'
        Cursor cursor = db.rawQuery(
                "SELECT " + ConstanteSQL.C_NOMBRE + " FROM " + ConstanteSQL.TB_USUARIOS +
                        " WHERE " + ConstanteSQL.C_CORREO + "='" + correo + "'",
                null
        );
        if (cursor != null && cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                do {
                    nombre = cursor.getString(cursor.getColumnIndex(ConstanteSQL.C_NOMBRE));
                } while (cursor.moveToNext());
            }
        }
        return nombre;
    }

    public boolean verificarSesion() {
        SQLiteDatabase db = dbConexion.getReadableDatabase();
        Cursor cursor = db.rawQuery(
                "SELECT * FROM " + ConstanteSQL.TB_SESION,
                null
        );
        /*
        if (cursor != null && cursor.getCount() > 0)
            return true;
        return false;
        */
        return (cursor != null ? (cursor.getCount() > 0 ? true : false) : false);
    }

    public String obtenerCorreoSesion() {
        String correo = "";
        SQLiteDatabase db = dbConexion.getReadableDatabase();
        Cursor cursor = db.rawQuery(
                "SELECT " + ConstanteSQL.C_CORREO + " FROM " + ConstanteSQL.TB_SESION,
                null
        );
        if (cursor != null && cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                do {
                    correo = cursor.getString(cursor.getColumnIndex(ConstanteSQL.C_CORREO));
                } while (cursor.moveToNext());
            }
        }
        return correo;
    }
}
