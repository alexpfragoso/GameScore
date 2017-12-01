package br.edu.ifspsaocarlos.sdm.gamescore.view;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageButton;

import br.edu.ifspsaocarlos.sdm.gamescore.R;

public class CronometroXadrezActivity extends AppCompatActivity implements View.OnClickListener{

    //VARIÁVEIS

    Chronometer chronometer_jogador_1;
    Chronometer chronometer_jogador_2;
    ImageButton bt_play;
    boolean ch_1 = false;
    long milliseconds_jogador1;
    long milliseconds_jogador2;

    //MÉTODOS
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cronometro_xadrez);

        chronometer_jogador_1 = (Chronometer)findViewById(R.id.chronometer_jogador_1);
        chronometer_jogador_2 = (Chronometer)findViewById(R.id.chronometer_jogador_2);
        bt_play = (ImageButton)findViewById(R.id.bt_cronometro_play);
        bt_play.setOnClickListener(this);

        milliseconds_jogador1 =0;
        milliseconds_jogador2 =0;



    }

    @Override
    public void onClick(View view) {


        if(view == bt_play){

            //ch1==false Significa que o cronometro 1 está parado, o cronometro 2 está contando.
            //Pausa no cronometro 2 e calculo dos millisegundos passados
            //Acerta a base de inicio do cronometro 1 e da Start
            if(ch_1 == false){

                chronometer_jogador_2.stop();
                milliseconds_jogador2 = SystemClock.elapsedRealtime() - chronometer_jogador_2.getBase();

                chronometer_jogador_1.setBase(SystemClock.elapsedRealtime() - milliseconds_jogador1);
                chronometer_jogador_1.start();

                ch_1 = true;
            }else{

                //ch1==true Significa que o cronometro 2 está parado, o cronometro 1 está contando.
                //Pausa no cronometro 1 e calculo dos millisegundos passados
                //Acerta a base de inicio do cronometro 2 e da Start
                if(ch_1 == true){

                    chronometer_jogador_1.stop();
                    milliseconds_jogador1 = SystemClock.elapsedRealtime() - chronometer_jogador_1.getBase();

                    chronometer_jogador_2.setBase(SystemClock.elapsedRealtime() - milliseconds_jogador2);
                    chronometer_jogador_2.start();

                    ch_1 = false;
                }
            }

        }
    }


}
