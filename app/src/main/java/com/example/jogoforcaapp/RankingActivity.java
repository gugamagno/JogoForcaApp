package com.example.jogoforcaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class RankingActivity extends AppCompatActivity {

    private UsuarioDao dao;
    private ListView lista;
    private ArrayList<Usuario> usuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        lista = (ListView)findViewById(R.id.lvranking);
        dao = new UsuarioDao(getBaseContext());
        usuarios = dao.selecionarTodosUsuarios();

        LayoutInflater inflater = getLayoutInflater();
        ViewGroup header = (ViewGroup)inflater.inflate(R.layout.header_ranking,lista,false);
        lista.addHeaderView(header);

        ArrayAdapter adapter = new UsuarioAdapter(this, usuarios);
        lista.setAdapter(adapter);
    }
}