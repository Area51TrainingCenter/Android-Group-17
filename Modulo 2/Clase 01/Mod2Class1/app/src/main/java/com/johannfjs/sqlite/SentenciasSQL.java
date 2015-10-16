package com.johannfjs.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

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
        if (cursor != null) {
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
}
