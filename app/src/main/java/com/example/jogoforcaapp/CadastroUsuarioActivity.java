package com.example.jogoforcaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CadastroUsuarioActivity extends AppCompatActivity {

    private UsuarioDao dao;
    private EditText etnome;
    private EditText etemail;
    private EditText etsenha;
    private Button btcadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_usuario);

        etnome = (EditText) findViewById(R.id.etnome);
        etemail = (EditText) findViewById(R.id.etemail);
        etsenha = (EditText) findViewById(R.id.etsenha);
        btcadastrar = (Button) findViewById(R.id.btcadastrar);
        dao = new UsuarioDao(getBaseContext());

        btcadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Usuario usuario = new Usuario();

                usuario.setNome(etnome.getText().toString());
                usuario.setEmail(etemail.getText().toString());
                usuario.setSenha(etsenha.getText().toString());

                String resultado;

                resultado = dao.inserir(usuario);
                Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_SHORT).show();
            }
        });
    }
}