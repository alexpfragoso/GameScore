package br.edu.ifspsaocarlos.sdm.gamescore.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import br.edu.ifspsaocarlos.sdm.gamescore.R;

public class TelaMarcadoresActivity extends AppCompatActivity implements View.OnClickListener{

    //VARIÁVEIS

    ImageButton bt_jogar_dados;
    ImageButton bt_cronometrar;
    ImageButton bt_roleta;
    ImageButton bt_cara_coroa;
    ImageButton bt_ranking;

    //MÉTODOS
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_marcadores);

        bt_jogar_dados = (ImageButton)findViewById(R.id.bt_dado);
        bt_jogar_dados.setOnClickListener(this);
        bt_cronometrar = (ImageButton)findViewById(R.id.bt_cronometro_xadrez);
        bt_cronometrar.setOnClickListener(this);
        bt_roleta = (ImageButton)findViewById(R.id.bt_roleta);
        bt_roleta.setOnClickListener(this);
        bt_cara_coroa = (ImageButton)findViewById(R.id.bt_cara_ou_coroa);
        bt_cara_coroa.setOnClickListener(this);
        bt_ranking = (ImageButton)findViewById(R.id.bt_ranking);
        bt_ranking.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if(view == bt_jogar_dados){

            Intent jogarDadosIntent = new Intent(this,JogarDadosActivity.class);
            startActivity(jogarDadosIntent);

        }else{

            if(view == bt_cronometrar){

                Intent cronometrarIntent = new Intent(this,CronometroXadrezActivity.class);
                startActivity(cronometrarIntent);

            }else{

                if(view == bt_roleta){

                    Intent roletaIntent = new Intent(this,RoletaActivity.class);
                    startActivity(roletaIntent);

                }else{

                    if(view == bt_cara_coroa){

                        Intent caraCoroaIntent = new Intent(this,CaraCoroaActivity.class);
                        startActivity(caraCoroaIntent);

                    }else{

                        if(view == bt_ranking){

                            Intent rankingIntent = new Intent(this,RankingActivity.class);
                            startActivity(rankingIntent);

                        }
                    }
                }
            }
        }
    }
}
