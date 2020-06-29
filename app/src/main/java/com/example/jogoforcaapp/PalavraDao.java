package com.example.jogoforcaapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PalavraDao {

    private ConexaoPalavra conexao;
    private SQLiteDatabase banco;

    private String[] columns = {conexao.COLUMM_ID,
                                conexao.COLUMM_PALAVRA,
                                conexao.COLUMM_DICA};

    public PalavraDao(Context context){
        conexao = new ConexaoPalavra(context);
        banco = conexao.getWritableDatabase();
    }

    public void close(){
        conexao.close();
    }

    public String inserir(Palavra palavra){
        ContentValues values = new ContentValues();
        long resultado;

        values.put(conexao.COLUMM_PALAVRA, palavra.getPalavra());
        values.put(conexao.COLUMM_DICA, palavra.getDica());

        resultado = banco.insert(conexao.TABLE_PALAVRA, null, values);

        if (resultado == -1){
            return "Erro ao cadastrar palavra";
        }else{
            return "Palavra cadastrada com sucesso";
        }
    }

    public void excluir(Palavra palavra){
        long resultado;

        resultado = banco.delete(conexao.TABLE_PALAVRA,
                conexao.COLUMM_ID + " =?", new String[]{palavra.getId().toString()});
    }

    public Palavra buscarPalavraSorteada(){
        Random random = new Random();

        Cursor cursor = banco.query(conexao.TABLE_PALAVRA, columns, null,
                null,null,null,
                null, null);

        Integer position = random.nextInt(cursor.getCount());

        if (position == 0){
            position += 1;
        }

        if (!cursor.moveToPosition(position))
            return null;

        Palavra palavra = new Palavra();
        palavra.setId(cursor.getInt(0));
        palavra.setPalavra(cursor.getString(1));
        palavra.setDica(cursor.getString(2));
        return palavra;
    }

    public List<Palavra> selecionarTodasPalavras(){
        List<Palavra> palavras = new ArrayList<>();

        Cursor cursor = banco.query(conexao.TABLE_PALAVRA, columns, null,
                null,null,null,
                null, null);

        while (cursor.moveToNext()){
            Palavra palavra = new Palavra();
            palavra.setId(cursor.getInt(0));
            palavra.setPalavra(cursor.getString(1));
            palavra.setDica(cursor.getString(2));

            palavras.add(palavra);
        }
        return palavras;
    }
}
