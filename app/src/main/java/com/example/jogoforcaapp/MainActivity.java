package com.example.jogoforcaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etusuario;
    private EditText etsenha;
    private Button btentrar;
    private TextView tvcadastre;
    private UsuarioDao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dao = new UsuarioDao(getBaseContext());

        etusuario = (EditText) findViewById(R.id.etusuario);
        etsenha = (EditText) findViewById(R.id.etsenha);
        btentrar = (Button) findViewById(R.id.btentrar);
        tvcadastre = (TextView) findViewById(R.id.tvcadastre);

        btentrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = etusuario.getText().toString();
                String senha = etsenha.getText().toString();

                if (nome.isEmpty() || senha.isEmpty()){
                    Toast toast = Toast.makeText(getApplicationContext(),"Todos campos são obrigatórios",Toast.LENGTH_SHORT);
                    toast.show();
                }else {
                    Usuario usuario = dao.selecionarUsuario(nome, senha);

                    if (usuario == null) {
                        Toast toast = Toast.makeText(getApplicationContext(), "Usuário ou senha incorretos", Toast.LENGTH_SHORT);
                        toast.show();
                    }else {

                        Intent intent = new Intent(v.getContext(), InicioActivity.class);
                        intent.putExtra("usuario", usuario);
                        startActivity(intent);
                    }
                }
            }
        });

        tvcadastre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), CadastroUsuarioActivity.class);
                startActivity(intent);
            }
        });
    }
}