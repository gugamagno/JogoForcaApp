package com.example.jogoforcaapp;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class UsuarioAdapter extends ArrayAdapter<Usuario> {

    private final ArrayList<Usuario> usuarios;
    private final Context context;

    public UsuarioAdapter(Context context, ArrayList<Usuario> usuarios){
        super(context,R.layout.linha_usuarios,usuarios);
        this.context = context;
        this.usuarios = usuarios;
    }

    @Override
    public int getCount() {
        return usuarios.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.linha_usuarios, parent, false);
        Usuario usuario = usuarios.get(position);

        ImageView ivavatar = (ImageView) view.findViewById(R.id.ivavatar);
        TextView tvnome = (TextView) view.findViewById(R.id.tvnome);
        TextView tvpontos = (TextView) view.findViewById(R.id.tvpontos);

        LinearLayout llusuario = (LinearLayout) view.findViewById(R.id.lllinhausuarios);

        switch (position){
            case 0:
                ivavatar.setImageResource(R.mipmap.ic_launcher_ouro);
                break;
            case 1:
                ivavatar.setImageResource(R.mipmap.ic_launcher_prata);
                break;
            case 2:
                ivavatar.setImageResource(R.mipmap.ic_launcher_bronze);
                break;
            default:
                break;
        }

        if (position%2 ==0) {
            llusuario.setBackgroundColor(Color.parseColor("#CCCCCC"));
        }

        tvnome.setText(usuario.getNome());
        tvpontos.setText(usuario.getPontos() + " PONTOS");
        return view;
    }
}
