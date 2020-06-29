package com.example.jogoforcaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class InicioActivity extends AppCompatActivity {

    private Button btiniciar;
    private ImageView ivranking;
    private ImageView ivaddpalavra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        btiniciar = (Button) findViewById(R.id.btiniciar);
        ivranking = (ImageView) findViewById(R.id.ivranking);
        ivaddpalavra = (ImageView) findViewById(R.id.ivaddpalavra);

        btiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Usuario usuario = (Usuario) getIntent().getSerializableExtra("usuario");

                Intent intent = new Intent(view.getContext(), ForcaActivity.class);
                intent.putExtra("usuario", usuario);
                startActivity(intent);
            }
        });

        ivranking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), RankingActivity.class);
                startActivity(intent);
            }
        });

        ivaddpalavra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ListaPalavraActivity.class);
                startActivity(intent);
            }
        });
    }
}