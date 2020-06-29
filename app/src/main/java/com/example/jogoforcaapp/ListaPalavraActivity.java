package com.example.jogoforcaapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListaPalavraActivity extends AppCompatActivity {

    private PalavraDao dao;
    private ListView lista;
    private List<Palavra> palavras;
    private List<Palavra> palavrasFiltradas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_palavra);

        lista = (ListView)findViewById(R.id.lvlistapalavra);
        dao = new PalavraDao(getBaseContext());
        palavras = dao.selecionarTodasPalavras();
        palavrasFiltradas.addAll(palavras);

        LayoutInflater inflater = getLayoutInflater();
        ViewGroup header = (ViewGroup)inflater.inflate(R.layout.header_listapalavra,lista,false);
        lista.addHeaderView(header);

        ArrayAdapter<Palavra> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, palavrasFiltradas);
        lista.setAdapter(adapter);

        registerForContextMenu(lista);
    }

    @Override
    protected void onResume() {
        super.onResume();
        palavras = dao.selecionarTodasPalavras();
        palavrasFiltradas.clear();
        palavrasFiltradas.addAll(palavras);
        lista.invalidateViews();
    }

    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu, view, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_linhalistapalavra, menu);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_listapalavra, menu);
        return true;
    }

    public void cadastrar(MenuItem item){
        Intent intent = new Intent(this, CadastroPalavraActivity.class);
        startActivity(intent);
    }

    public void excluir(MenuItem item){
        AdapterView.AdapterContextMenuInfo menuInfo =
                (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        Integer posicao = menuInfo.position;
        posicao -= 1;
        final Palavra palavraExcluir = palavrasFiltradas.get(posicao);

        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("ATENÇÃO")
                .setMessage("DESEJA REALMENTE EXCLUIR?")
                .setNegativeButton("NÃO", null)
                .setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        palavrasFiltradas.remove(palavraExcluir);
                        palavras.remove(palavraExcluir);
                        dao.excluir(palavraExcluir);
                        lista.invalidateViews();
                    }
                }).create();
        dialog.show();
    }
}