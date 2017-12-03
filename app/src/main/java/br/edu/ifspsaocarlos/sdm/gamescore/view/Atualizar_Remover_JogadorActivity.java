package br.edu.ifspsaocarlos.sdm.gamescore.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.edu.ifspsaocarlos.sdm.gamescore.R;
import br.edu.ifspsaocarlos.sdm.gamescore.model.Jogador;

//Essa Activity permite a RankingActivity obter os dados por meio de uma intent
// para a atualização ou remoção de um jogador da listView implementda pela RankingActivity

public class Atualizar_Remover_JogadorActivity extends AppCompatActivity implements View.OnClickListener{

    //VARIAVEIS

    private Button bt_atualizar;
    private Button bt_cancelar_atualizacao;
    private Button bt_mais;
    private Button bt_menos;
    private Button bt_remover;
    private EditText et_nome_jogador;
    private EditText et_pontuacao_jogador;
    private int pontuacao;
    private Jogador jogador;
    String nome_antigo;

    private final String JOGADOR_REMOVIDO = "jogador removido";
    private final String JOGADOR_ATUALIZADO = "jogador atualizado";
    private final String JOGADOR_PARA_ATUALIZAR = "jogador para atualizar";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atualizar__remover__jogador);

        jogador = (Jogador) getIntent().getSerializableExtra(JOGADOR_PARA_ATUALIZAR);

        bt_remover = (Button)findViewById(R.id.bt_remover_jogador);
        bt_remover.setOnClickListener(this);
        bt_atualizar = (Button)findViewById(R.id.bt_atualizar);
        bt_atualizar.setOnClickListener(this);
        bt_cancelar_atualizacao = (Button)findViewById(R.id.bt_cancelar_atualizacao);
        bt_cancelar_atualizacao.setOnClickListener(this);
        bt_mais = (Button) findViewById(R.id.bt_mais_pontos);
        bt_mais.setOnClickListener(this);
        bt_menos =(Button) findViewById(R.id.bt_menos_pontos);
        bt_menos.setOnClickListener(this);
        et_nome_jogador = (EditText)findViewById(R.id.et_nome_jogador_atualiza);
        et_pontuacao_jogador = (EditText) findViewById(R.id.et_pontuacao_jogador_atualiza);

        et_nome_jogador.setText(jogador.getNome());
        nome_antigo = et_nome_jogador.getText().toString();
        et_pontuacao_jogador.setText(Integer.toString(jogador.getPontuacao()));

        pontuacao = Integer.parseInt(et_pontuacao_jogador.getText().toString());


    }

    @Override
    public void onClick(View view) {
        if(view == bt_atualizar){


            String nome;
            int pontuacao;
            nome = et_nome_jogador.getText().toString();
            pontuacao = Integer.parseInt(et_pontuacao_jogador.getText().toString());
            Jogador jogadorAtualizado = new Jogador(nome,pontuacao);
            jogadorAtualizado.setNomeAntigo(nome_antigo);
            Intent resultadoIntent = new Intent();
            resultadoIntent.putExtra(JOGADOR_ATUALIZADO,jogadorAtualizado);
            setResult(RESULT_OK,resultadoIntent);
            finish();

        }else{
            if(view == bt_cancelar_atualizacao){
                Intent returnIntent = new Intent();
                setResult(RESULT_CANCELED, returnIntent);
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

                    } else {
                        if (view == bt_remover) {
                            Intent resultadoIntent = new Intent();
                            resultadoIntent.putExtra(JOGADOR_REMOVIDO, jogador);
                            setResult(RESULT_FIRST_USER, resultadoIntent);
                            finish();

                        }
                    }
                }
            }
        }

    }
}
