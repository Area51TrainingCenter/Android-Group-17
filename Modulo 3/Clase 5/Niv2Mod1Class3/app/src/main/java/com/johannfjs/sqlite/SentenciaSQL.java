package com.johannfjs.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.johannfjs.models.Especialidad;
import com.johannfjs.models.Persona;
import com.johannfjs.utils.Constant;

/**
 * Created by johannfjs on 18/11/2015.
 */
public class SentenciaSQL {
    private ManageOpenHelper dbConexion;

    public SentenciaSQL(Context context) {
        dbConexion = new ManageOpenHelper(context);
    }

    public void insertarRegistros(Persona persona) {
        SQLiteDatabase db = dbConexion.getWritableDatabase();

        try {
            db.beginTransaction();
            db.execSQL(
                    "INSERT INTO " + Constant.TB_PERSONA + "(" +
                            Constant.C_CODIGO + "," +
                            Constant.C_NOMBRE + "," +
                            Constant.C_TELEFONO_FIJO + "," +
                            Constant.C_CELULAR + "," +
                            Constant.C_LATITUD + "," +
                            Constant.C_LONGITUD + "," +
                            Constant.C_RUTA_IMAGEN + "," +
                            Constant.C_TIPO + "," +
                            Constant.C_DISTANCIA + "," +
                            Constant.C_VIP + "," +
                            Constant.C_CODIGO_DEPARTAMENTO + "," +
                            Constant.C_DEPARTAMENTO + "," +
                            Constant.C_CODIGO_PROVINCIA + "," +
                            Constant.C_PROVINCIA + "," +
                            Constant.C_CODIGO_DISTRITO + "," +
                            Constant.C_DISTRITO + ") VALUES('" +
                            persona.getCodigo() + "','" +
                            persona.getNombre() + "','" +
                            persona.getTelefonoFijo() + "','" +
                            persona.getCelular() + "','" +
                            persona.getLatitud() + "','" +
                            persona.getLongitud() + "','" +
                            persona.getRutaImagen() + "','" +
                            persona.getTipo() + "','" +
                            persona.getDistancia() + "','" +
                            persona.getVip() + "','" +
                            persona.getCodigoDepartamento() + "','" +
                            persona.getDepartamento() + "','" +
                            persona.getCodigoProvincia() + "','" +
                            persona.getProvincia() + "','" +
                            persona.getCodigoDistrito() + "','" +
                            persona.getDistrito() + "')"
            );

            if (persona.getListaEspecialidades().size() > 0) {
                for (Especialidad itemEspecialidad : persona.getListaEspecialidades()) {
                    db.execSQL(
                            "INSERT INTO " + Constant.TB_ESPECIALIDAD + "(" +
                                    Constant.C_CODIGO + "," +
                                    Constant.C_NOMBRE + "," +
                                    Constant.C_CODIGO_PERSONA + ") VALUES('" +
                                    itemEspecialidad.getCodigo() + "','" +
                                    itemEspecialidad.getNombre() + "','" +
                                    persona.getCodigo() + "')"
                    );
                }
            }

            db.setTransactionSuccessful();
        } catch (Exception e) {

        } finally {
            db.endTransaction();
        }
    }
}
