package com.example.jogoforcaapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ConexaoUsuario extends SQLiteOpenHelper {

    public static final String TABLE_USUARIO = "usuario";
    public static final String COLUMM_ID = "id";
    public static final String COLUMM_NOME = "nome";
    public static final String COLUMM_EMAIL = "email";
    public static final String COLUMM_SENHA = "senha";
    public static final String COLUMM_PONTOS = "pontos";
    private static final String DATABASE_NAME = "usuario.db";
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_CREATE = "create table " + TABLE_USUARIO + "(" +
            COLUMM_ID + " integer primary key autoincrement, " +
            COLUMM_NOME + " text not null," +
            COLUMM_EMAIL + " text not null, " +
            COLUMM_SENHA + " text not null, " +
            COLUMM_PONTOS + " integer not null);";

    public ConexaoUsuario(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USUARIO);
        onCreate(db);
    }
}
