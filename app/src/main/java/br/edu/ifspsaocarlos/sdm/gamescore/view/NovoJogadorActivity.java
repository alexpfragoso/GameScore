package br.edu.ifspsaocarlos.sdm.gamescore.view;

import android.content.Intent;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import br.edu.ifspsaocarlos.sdm.gamescore.R;
import br.edu.ifspsaocarlos.sdm.gamescore.model.Jogador;

//Essa Activity pega os dados do novo jogador e retorna para a RankingActivity usar.

public class NovoJogadorActivity extends AppCompatActivity implements View.OnClickListener{


    //VARIAVEIS

    private Button bt_salvar;
    private Button bt_cancelar;
    private Button bt_mais;
    private Button bt_menos;
    private EditText et_nome_jogador;
    private EditText et_pontuacao_jogador;
    private Jogador novo_jogador;
    private int pontuacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_jogador);

        bt_salvar = (Button)findViewById(R.id.bt_salvar_novo_jogador);
        bt_salvar.setOnClickListener(this);
        bt_cancelar = (Button)findViewById(R.id.bt_cancelar_novo_jogador);
        bt_cancelar.setOnClickListener(this);
        bt_mais = (Button) findViewById(R.id.bt_mais);
        bt_mais.setOnClickListener(this);
        bt_menos =(Button) findViewById(R.id.bt_menos);
        bt_menos.setOnClickListener(this);
        et_nome_jogador = (EditText)findViewById(R.id.et_nome_jogador);
        et_pontuacao_jogador = (EditText) findViewById(R.id.et_pontuacao_novo_jogador);
        pontuacao = Integer.parseInt(et_pontuacao_jogador.getText().toString());

    }

    @Override
    public void onClick(View view) {

        if(view == bt_salvar){

            String nome;
            int pontuacao;
            nome = et_nome_jogador.getText().toString();
            pontuacao = Integer.parseInt(et_pontuacao_jogador.getText().toString());
            novo_jogador = new Jogador(nome,pontuacao);

            Intent resultadoIntent = new Intent();
            resultadoIntent.putExtra("novo jogador",novo_jogador);
            setResult(RESULT_OK,resultadoIntent);
            finish();
        }else{
            if(view == bt_cancelar){
                finish();
            }
            else {
                if (view == bt_mais) {
                    pontuacao = pontuacao + 1;
                    et_pontuacao_jogador.setText(Integer.toString(pontuacao));

                } else {
                    if (view == bt_menos) {
                        pontuacao = pontuacao - 1;
                        et_pontuacao_jogador.setText(Integer.toString(pontuacao));

                    }
                }
            }

        }

    }


}
