package com.johannfjs.utils;

/**
 * Created by johannfjs on 18/11/2015.
 */
public class Constant {
    public static final String URL = "http://ayudamedoctor.eldervaz.com/api/home";
    public static final String PARAM_LATITUD = "latitud";
    public static final String PARAM_LONGITUD = "longitud";

    

    public static final int DB_VERSION = 1;
    public static final String DB_NAME = "niv2mod1class3.db";

    public static final String TB_PERSONA = "tb_persona";

    public static final String C_CODIGO = "codigo";
    public static final String C_NOMBRE = "nombre";
    public static final String C_TELEFONO_FIJO = "telefono_fijo";
    public static final String C_CELULAR = "celular";
    public static final String C_LATITUD = "latitud";
    public static final String C_LONGITUD = "longitud";
    public static final String C_RUTA_IMAGEN = "ruta_imagen";
    public static final String C_TIPO = "tipo";
    public static final String C_DISTANCIA = "distancia";
    public static final String C_VIP = "vip";
    public static final String C_CODIGO_DEPARTAMENTO = "codigo_departamento";
    public static final String C_DEPARTAMENTO = "departamento";
    public static final String C_CODIGO_PROVINCIA = "codigo_provincia";
    public static final String C_PROVINCIA = "provincia";
    public static final String C_CODIGO_DISTRITO = "codigo_distrito";
    public static final String C_DISTRITO = "distrito";

    public static final String C_CODIGO_PERSONA = "codigo_persona";

    public static final String TB_ESPECIALIDAD = "tb_especialidad";

    public static final String CREAR_PERSONA = "CREATE TABLE " +
            TB_PERSONA + "(" +
            C_CODIGO + " TEXT," +
            C_NOMBRE + " TEXT," +
            C_TELEFONO_FIJO + " TEXT," +
            C_CELULAR + " TEXT," +
            C_LATITUD + " TEXT," +
            C_LONGITUD + " TEXT," +
            C_RUTA_IMAGEN + " TEXT," +
            C_TIPO + " TEXT," +
            C_DISTANCIA + " TEXT," +
            C_VIP + " TEXT," +
            C_CODIGO_DEPARTAMENTO + " TEXT," +
            C_DEPARTAMENTO + " TEXT," +
            C_CODIGO_PROVINCIA + " TEXT," +
            C_PROVINCIA + " TEXT," +
            C_CODIGO_DISTRITO + " TEXT," +
            C_DISTRITO + " TEXT)";

    public static final String CREAR_ESPECIALIDADES = "CREATE TABLE " +
            TB_ESPECIALIDAD + "(" +
            C_CODIGO + " TEXT," +
            C_NOMBRE + " TEXT," +
            C_CODIGO_PERSONA + " TEXT," +
            "FOREIGN KEY (" + C_CODIGO_PERSONA + ") REFERENCES " + TB_PERSONA + "(" + C_CODIGO + "))";
}
