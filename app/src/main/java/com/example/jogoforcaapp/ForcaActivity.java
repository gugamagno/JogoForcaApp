package com.example.jogoforcaapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ForcaActivity extends AppCompatActivity {

    private ImageView ivforca;
    private TextView tvpalavra;
    private TextView tvdica;
    private Palavra palavrasecreta;
    private String palavratraco;
    private String palavracompara;
    private UsuarioDao dao;
    private PalavraDao palavradao;

    ImageView ivbta, ivbtb, ivbtc, ivbtd, ivbte, ivbtf, ivbtg,
            ivbth, ivbti, ivbtj, ivbtk, ivbtl, ivbtm, ivbtn,
            ivbto, ivbtp, ivbtq, ivbtr, ivbts, ivbtt, ivbtu,
            ivbtv, ivbtw, ivbtx, ivbty, ivbtz;

    Character letra;
    Boolean existeletra;
    Integer contador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forca);

        dao = new UsuarioDao(this);
        palavradao = new PalavraDao(this);

        ivforca = (ImageView) findViewById(R.id.ivforca);
        tvpalavra = (TextView) findViewById(R.id.tvpalavra);
        tvdica = (TextView) findViewById(R.id.tvdica);

        ivbta = (ImageView) findViewById(R.id.ivbta);
        ivbtb = (ImageView) findViewById(R.id.ivbtb);
        ivbtc = (ImageView) findViewById(R.id.ivbtc);
        ivbtd = (ImageView) findViewById(R.id.ivbtd);
        ivbte = (ImageView) findViewById(R.id.ivbte);
        ivbtf = (ImageView) findViewById(R.id.ivbtf);
        ivbtg = (ImageView) findViewById(R.id.ivbtg);
        ivbth = (ImageView) findViewById(R.id.ivbth);
        ivbti = (ImageView) findViewById(R.id.ivbti);
        ivbtj = (ImageView) findViewById(R.id.ivbtj);
        ivbtk = (ImageView) findViewById(R.id.ivbtk);
        ivbtl = (ImageView) findViewById(R.id.ivbtl);
        ivbtm = (ImageView) findViewById(R.id.ivbtm);
        ivbtn = (ImageView) findViewById(R.id.ivbtn);
        ivbto = (ImageView) findViewById(R.id.ivbto);
        ivbtp = (ImageView) findViewById(R.id.ivbtp);
        ivbtq = (ImageView) findViewById(R.id.ivbtq);
        ivbtr = (ImageView) findViewById(R.id.ivbtr);
        ivbts = (ImageView) findViewById(R.id.ivbts);
        ivbtt = (ImageView) findViewById(R.id.ivbtt);
        ivbtu = (ImageView) findViewById(R.id.ivbtu);
        ivbtv = (ImageView) findViewById(R.id.ivbtv);
        ivbtw = (ImageView) findViewById(R.id.ivbtw);
        ivbtx = (ImageView) findViewById(R.id.ivbtx);
        ivbty = (ImageView) findViewById(R.id.ivbty);
        ivbtz = (ImageView) findViewById(R.id.ivbtz);

        contador = 1;
        palavrasecreta = palavradao.buscarPalavraSorteada();

        palavratraco = "";

        for (int x = 0; x < palavrasecreta.getPalavra().length(); x++) {
            palavratraco += " _ ";
        }

        tvpalavra.setText(palavratraco);
        tvdica.setText(palavrasecreta.getDica());

        ivbta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                efetuarJogada(v);
            }
        });

        ivbtb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                efetuarJogada(v);
            }
        });

        ivbtc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                efetuarJogada(v);
            }
        });

        ivbtd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                efetuarJogada(v);
            }
        });

        ivbte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                efetuarJogada(v);
            }
        });

        ivbtf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                efetuarJogada(v);
            }
        });

        ivbtg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                efetuarJogada(v);
            }
        });

        ivbth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                efetuarJogada(v);
            }
        });

        ivbti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                efetuarJogada(v);
            }
        });

        ivbtj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                efetuarJogada(v);
            }
        });

        ivbtk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                efetuarJogada(v);
            }
        });

        ivbtl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                efetuarJogada(v);
            }
        });

        ivbtm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                efetuarJogada(v);
            }
        });

        ivbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                efetuarJogada(v);
            }
        });

        ivbto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                efetuarJogada(v);
            }
        });

        ivbtp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                efetuarJogada(v);
            }
        });

        ivbtq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                efetuarJogada(v);
            }
        });

        ivbtr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                efetuarJogada(v);
            }
        });

        ivbts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                efetuarJogada(v);
            }
        });

        ivbtt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                efetuarJogada(v);
            }
        });

        ivbtu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                efetuarJogada(v);
            }
        });

        ivbtv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                efetuarJogada(v);
            }
        });

        ivbtw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                efetuarJogada(v);
            }
        });

        ivbtx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                efetuarJogada(v);
            }
        });

        ivbty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                efetuarJogada(v);
            }
        });

        ivbtz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                efetuarJogada(v);
            }
        });
    }

    public void iniciaJogo(){
        contador = 1;
        palavrasecreta = palavradao.buscarPalavraSorteada();

        palavratraco = "";

        for (int x = 0; x < palavrasecreta.getPalavra().length(); x++) {
            palavratraco += " _ ";
        }

        tvpalavra.setText(palavratraco);
        tvdica.setText(palavrasecreta.getDica());

        ivbta.setEnabled(true);
        ivbta.setAlpha(0xFF);
        ivbtb.setEnabled(true);
        ivbtb.setAlpha(0xFF);
        ivbtc.setEnabled(true);
        ivbtc.setAlpha(0xFF);
        ivbtd.setEnabled(true);
        ivbtd.setAlpha(0xFF);
        ivbte.setEnabled(true);
        ivbte.setAlpha(0xFF);
        ivbtf.setEnabled(true);
        ivbtf.setAlpha(0xFF);
        ivbtg.setEnabled(true);
        ivbtg.setAlpha(0xFF);
        ivbth.setEnabled(true);
        ivbth.setAlpha(0xFF);
        ivbti.setEnabled(true);
        ivbti.setAlpha(0xFF);
        ivbtj.setEnabled(true);
        ivbtj.setAlpha(0xFF);
        ivbtk.setEnabled(true);
        ivbtk.setAlpha(0xFF);
        ivbtl.setEnabled(true);
        ivbtl.setAlpha(0xFF);
        ivbtm.setEnabled(true);
        ivbtm.setAlpha(0xFF);
        ivbtn.setEnabled(true);
        ivbtn.setAlpha(0xFF);
        ivbto.setEnabled(true);
        ivbto.setAlpha(0xFF);
        ivbtp.setEnabled(true);
        ivbtp.setAlpha(0xFF);
        ivbtq.setEnabled(true);
        ivbtq.setAlpha(0xFF);
        ivbtr.setEnabled(true);
        ivbtr.setAlpha(0xFF);
        ivbts.setEnabled(true);
        ivbts.setAlpha(0xFF);
        ivbtt.setEnabled(true);
        ivbtt.setAlpha(0xFF);
        ivbtu.setEnabled(true);
        ivbtu.setAlpha(0xFF);
        ivbtv.setEnabled(true);
        ivbtv.setAlpha(0xFF);
        ivbtw.setEnabled(true);
        ivbtw.setAlpha(0xFF);
        ivbtx.setEnabled(true);
        ivbtx.setAlpha(0xFF);
        ivbty.setEnabled(true);
        ivbty.setAlpha(0xFF);
        ivbtz.setEnabled(true);
        ivbtz.setAlpha(0xFF);

        ivforca.setImageResource(R.drawable.forca1);
    }

    public void efetuarJogada(View v){

        switch (v.getId()) {
            case R.id.ivbta:
                letra = 'A';
                ivbta.setEnabled(false);
                ivbta.setAlpha(0x3F);
                break;
            case R.id.ivbtb:
                letra = 'B';
                ivbtb.setEnabled(false);
                ivbtb.setAlpha(0x3F);
                break;
            case R.id.ivbtc:
                letra = 'C';
                ivbtc.setEnabled(false);
                ivbtc.setAlpha(0x3F);
                break;
            case R.id.ivbtd:
                letra = 'D';
                ivbtd.setEnabled(false);
                ivbtd.setAlpha(0x3F);
                break;
            case R.id.ivbte:
                letra = 'E';
                ivbte.setEnabled(false);
                ivbte.setAlpha(0x3F);
                break;
            case R.id.ivbtf:
                letra = 'F';
                ivbtf.setEnabled(false);
                ivbtf.setAlpha(0x3F);
                break;
            case R.id.ivbtg:
                letra = 'G';
                ivbtg.setEnabled(false);
                ivbtg.setAlpha(0x3F);
                break;
            case R.id.ivbth:
                letra = 'H';
                ivbth.setEnabled(false);
                ivbth.setAlpha(0x3F);
                break;
            case R.id.ivbti:
                letra = 'I';
                ivbti.setEnabled(false);
                ivbti.setAlpha(0x3F);
                break;
            case R.id.ivbtj:
                letra = 'J';
                ivbtj.setEnabled(false);
                ivbtj.setAlpha(0x3F);
                break;
            case R.id.ivbtk:
                letra = 'K';
                ivbtk.setEnabled(false);
                ivbtk.setAlpha(0x3F);
                break;
            case R.id.ivbtl:
                letra = 'L';
                ivbtl.setEnabled(false);
                ivbtl.setAlpha(0x3F);
                break;
            case R.id.ivbtm:
                letra = 'M';
                ivbtm.setEnabled(false);
                ivbtm.setAlpha(0x3F);
                break;
            case R.id.ivbtn:
                letra = 'N';
                ivbtn.setEnabled(false);
                ivbtn.setAlpha(0x3F);
                break;
            case R.id.ivbto:
                letra = 'O';
                ivbto.setEnabled(false);
                ivbto.setAlpha(0x3F);
                break;
            case R.id.ivbtp:
                letra = 'P';
                ivbtp.setEnabled(false);
                ivbtp.setAlpha(0x3F);
                break;
            case R.id.ivbtq:
                letra = 'Q';
                ivbtq.setEnabled(false);
                ivbtq.setAlpha(0x3F);
                break;
            case R.id.ivbtr:
                letra = 'R';
                ivbtr.setEnabled(false);
                ivbtr.setAlpha(0x3F);
                break;
            case R.id.ivbts:
                letra = 'S';
                ivbts.setEnabled(false);
                ivbts.setAlpha(0x3F);
                break;
            case R.id.ivbtt:
                letra = 'T';
                ivbtt.setEnabled(false);
                ivbtt.setAlpha(0x3F);
                break;
            case R.id.ivbtu:
                letra = 'U';
                ivbtu.setEnabled(false);
                ivbtu.setAlpha(0x3F);
                break;
            case R.id.ivbtv:
                letra = 'V';
                ivbtv.setEnabled(false);
                ivbtv.setAlpha(0x3F);
                break;
            case R.id.ivbtw:
                letra = 'W';
                ivbtw.setEnabled(false);
                ivbtw.setAlpha(0x3F);
                break;
            case R.id.ivbtx:
                letra = 'X';
                ivbtx.setEnabled(false);
                ivbtx.setAlpha(0x3F);
                break;
            case R.id.ivbty:
                letra = 'Y';
                ivbty.setEnabled(false);
                ivbty.setAlpha(0x3F);
                break;
            case R.id.ivbtz:
                letra = 'Z';
                ivbtz.setEnabled(false);
                ivbtz.setAlpha(0x3F);
                break;
        }

        existeletra = false;

        for (int x = 0; x < palavrasecreta.getPalavra().length(); x++){

            if (palavrasecreta.getPalavra().charAt(x) == letra) {
                palavratraco = palavratraco.substring(0, 3 * x + 1) + letra + palavratraco.substring(3 * x + 2);
                existeletra = true;
            }
        }

        tvpalavra.setText(palavratraco);
        if (!existeletra){
            contador = contador + 1;
            switch (contador){
                case 2:
                    ivforca.setImageResource(R.drawable.forca2);
                    break;
                case 3:
                    ivforca.setImageResource(R.drawable.forca3);
                    break;
                case 4:
                    ivforca.setImageResource(R.drawable.forca4);
                    break;
                case 5:
                    ivforca.setImageResource(R.drawable.forca5);
                    break;
                case 6:
                    ivforca.setImageResource(R.drawable.forca6);
                    break;
                case 7:
                    ivforca.setImageResource(R.drawable.forca7);
                    break;
                case 8:
                    ivforca.setImageResource(R.drawable.forca8);
                    break;
            }
        }

        palavracompara = palavratraco.replaceAll(" ", "");
        if (palavracompara.equalsIgnoreCase(palavrasecreta.getPalavra())) {
            Usuario usuariointent = (Usuario) getIntent().getSerializableExtra("usuario");

            Usuario usuario = dao.selecionarUsuario(usuariointent.getNome(), usuariointent.getSenha());
            usuario.setPontos(usuario.getPontos() + 1);
            dao.atualizarUsuario(usuario);

            AlertDialog.Builder dialogo = new AlertDialog.Builder(ForcaActivity.this);
            dialogo.setTitle("PARABÉNS");
            dialogo.setMessage("VOCE VENCEU");

            dialogo.setNegativeButton("SAIR", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            dialogo.setPositiveButton("NOVO JOGO", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    iniciaJogo();
                }
            });
            dialogo.show();

        }else{
            if (contador == 8) {
                AlertDialog.Builder dialogo = new AlertDialog.Builder(ForcaActivity.this);
                dialogo.setTitle("NÃO FOI DESSA VEZ");
                dialogo.setMessage("VOCE PERDEU");

                dialogo.setNegativeButton("SAIR", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                dialogo.setPositiveButton("NOVO JOGO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        iniciaJogo();
                    }
                });
                dialogo.show();
            }
        }
    }
}