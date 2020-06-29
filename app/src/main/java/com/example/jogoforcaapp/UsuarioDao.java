package com.example.jogoforcaapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class UsuarioDao {

    private ConexaoUsuario conexao;
    private SQLiteDatabase banco;

    private String[] columns = {conexao.COLUMM_ID,
                                conexao.COLUMM_NOME,
                                conexao.COLUMM_EMAIL,
                                conexao.COLUMM_SENHA,
                                conexao.COLUMM_PONTOS };

    public UsuarioDao(Context context){
        conexao = new ConexaoUsuario(context);
        banco = conexao.getWritableDatabase();
    }

    public void close(){
        conexao.close();
    }

    public String inserir(Usuario usuario){
        ContentValues values = new ContentValues();
        long resultado;

        values.put(conexao.COLUMM_NOME, usuario.getNome());
        values.put(conexao.COLUMM_EMAIL, usuario.getEmail());
        values.put(conexao.COLUMM_SENHA, usuario.getSenha());
        values.put(conexao.COLUMM_PONTOS, 0);

        resultado = banco.insert(conexao.TABLE_USUARIO, null, values);

        if (resultado == -1){
            return "Erro ao cadastrar usuário";
        }else{
            return "Usuário cadastrado com sucesso";
        }
    }

    public void excluir(Usuario usuario){
        long resultado;

        resultado = banco.delete(conexao.TABLE_USUARIO,
                conexao.COLUMM_ID + " =?", new String[]{usuario.getId().toString()});
    }

    public void atualizarUsuario(Usuario usuario){
        ContentValues values = new ContentValues();

        values.put(conexao.COLUMM_PONTOS, usuario.getPontos());

        banco.update(conexao.TABLE_USUARIO, values, conexao.COLUMM_ID +
                " =?", new String[]{usuario.getId().toString()});
    }

    public ArrayList<Usuario> selecionarTodosUsuarios(){
        ArrayList<Usuario> usuarios = new ArrayList<>();

        Cursor cursor = banco.query(conexao.TABLE_USUARIO, columns, null,
                null,null,null,
                conexao.COLUMM_PONTOS + " DESC", null);

        while (cursor.moveToNext()){
            Usuario usuario = new Usuario();
            usuario.setId(cursor.getInt(0));
            usuario.setNome(cursor.getString(1));
            usuario.setEmail(cursor.getString(2));
            usuario.setSenha(cursor.getString(3));
            usuario.setPontos(cursor.getInt(4));
            usuarios.add(usuario);
        }
        return usuarios;
    }

    public Usuario selecionarUsuario(String nome, String senha){
        String[] args = {nome,senha};

        Cursor cursor = banco.query(conexao.TABLE_USUARIO, columns,
                conexao.COLUMM_NOME + " =?" + " AND " + conexao.COLUMM_SENHA + " =?", args,
                null,null, null);

        if (cursor.moveToFirst()){
            Usuario usuario = new Usuario();
            usuario.setId(cursor.getInt(0));
            usuario.setNome(cursor.getString(1));
            usuario.setEmail(cursor.getString(2));
            usuario.setSenha(cursor.getString(3));
            usuario.setPontos(cursor.getInt(4));
            return  usuario;
        }
        return null;
    }

    public void drop(){
        banco.execSQL("DROP TABLE IF EXISTS " + conexao.TABLE_USUARIO);
    }
}
