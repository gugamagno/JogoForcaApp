package com.example.jogoforcaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CadastroPalavraActivity extends AppCompatActivity {

    private PalavraDao dao;
    private EditText etpalavra;
    private EditText etdica;
    private Button btcadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_palavra);

        etpalavra = (EditText) findViewById(R.id.etpalavra);
        etdica = (EditText) findViewById(R.id.etdica);
        btcadastrar = (Button) findViewById(R.id.btcadastrar);
        dao = new PalavraDao(getBaseContext());

        btcadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Palavra palavra = new Palavra();

                palavra.setPalavra(etpalavra.getText().toString());
                palavra.setDica(etdica.getText().toString());

                String resultado;

                resultado = dao.inserir(palavra);
                Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_SHORT).show();
            }
        });
    }
}