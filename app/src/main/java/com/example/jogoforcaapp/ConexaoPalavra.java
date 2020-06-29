package com.example.jogoforcaapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ConexaoPalavra extends SQLiteOpenHelper {

    public static final String TABLE_PALAVRA = "palavra";
    public static final String COLUMM_ID = "id";
    public static final String COLUMM_PALAVRA = "palavra";
    public static final String COLUMM_DICA = "dica";
    private static final String DATABASE_NAME = "palavra.db";
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_CREATE = "create table " + TABLE_PALAVRA + "(" +
            COLUMM_ID + " integer primary key autoincrement, " +
            COLUMM_PALAVRA + " text not null," +
            COLUMM_DICA + " text not null);";

    public ConexaoPalavra(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PALAVRA);
        onCreate(db);
    }
}
