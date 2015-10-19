package com.johannfjs.utils;

/**
 * Created by johannfjs on 14/10/2015.
 */
public class ConstanteSQL {
    public static final String DB_NAME = "mod2class1.db";
    public static final int DB_VERSION = 1;

    public static final String TB_USUARIOS = "tb_usuarios";
    public static final String TB_SESION = "tb_sesion";

    public static final String C_NOMBRE = "nombre";
    public static final String C_CORREO = "correo";
    public static final String C_CONTRASENIA = "contrasenia";

    //CREATE TABLE tb_usuarios (nombre TEXT, correo TEXT, contrasenia TEXT)
    public static final String CREAR_TB_USUARIO = "CREATE TABLE " + TB_USUARIOS +
            "(" + C_NOMBRE + " TEXT," +
            C_CORREO + " TEXT," +
            C_CONTRASENIA + " TEXT)";
    public static final String CREAR_TB_SESION = "CREATE TABLE " + TB_SESION +
            "(" + C_CORREO + " TEXT)";

    //DROP TABLE tb_usuarios
    public static final String ELIMINAR_TB_USUARIO = "DROP TABLE " + TB_USUARIOS;
    public static final String ELIMINAR_TB_SESION = "DROP TABLE " + TB_SESION;
}
