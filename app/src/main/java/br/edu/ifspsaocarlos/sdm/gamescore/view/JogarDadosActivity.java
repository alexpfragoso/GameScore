package br.edu.ifspsaocarlos.sdm.gamescore.view;

import android.graphics.drawable.AnimationDrawable;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;
import java.util.logging.Handler;

import br.edu.ifspsaocarlos.sdm.gamescore.R;


//A JogarDadosActivity simula um lançamento de um dado de 6 faces
// A animação utiliza o objeto AnimationDrawable que por sua vez
//utiliza a animation.xml definida no diretorio drawable
//O metodo CountDownTimer é utilizado pra controlar o tempo da animação.
//O dado utiliza uma função random para o resultado e outra função random pra
//variar o tempo da animação de dado girando

public class JogarDadosActivity extends AppCompatActivity implements View.OnClickListener{

    //VARIÁVEIS

    private Button bt_jogar_dados;
    private ImageView iv_dado_animado;
    private AnimationDrawable mAnimation;
    boolean dadoGirando = false;
    int resultado;
    int tempoGiroDado;

    //MÉTODOS
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogar_dados);

       bt_jogar_dados = (Button)findViewById(R.id.bt_lancar_dado);
       bt_jogar_dados.setOnClickListener(this);
       iv_dado_animado = (ImageView)findViewById(R.id.iv_dadogif);
       iv_dado_animado.setBackgroundResource(R.drawable.animation);

    }

    @Override
    public void onClick(View view) {

        iv_dado_animado.setImageDrawable(null);
        iv_dado_animado.setBackgroundResource(R.drawable.animation);

        mAnimation = (AnimationDrawable)iv_dado_animado.getBackground();

        if(view == bt_jogar_dados && dadoGirando==false){


            mAnimation.start();
            dadoGirando = true;
            Random randon = new Random();
            resultado = randon.nextInt(6);
            tempoGiroDado = randon.nextInt(3);
            //Toast.makeText(this,"Resultado: "+ resultado +" Tempo Girando: " + tempoGiroDado, Toast.LENGTH_SHORT).show();


            new CountDownTimer((tempoGiroDado*2000)+1000,1000) {

                public void onTick(long millisUntilFinished) {

                }

                public void onFinish() {
                    mAnimation.stop();
                    dadoGirando = false;
                    switch (resultado) {

                        case 0:
                            iv_dado_animado.setImageResource(R.drawable.dice_1);


                            break;
                        case 1:
                            iv_dado_animado.setImageResource(R.drawable.dice_2);


                            break;
                        case 2:
                            iv_dado_animado.setImageResource(R.drawable.dice_3);


                            break;
                        case 3:
                            iv_dado_animado.setImageResource(R.drawable.dice_4);


                            break;
                        case 4:
                            iv_dado_animado.setImageResource(R.drawable.dice_5);


                            break;
                        case 5:
                            iv_dado_animado.setImageResource(R.drawable.dice_6);


                            break;
                        default:
                            iv_dado_animado.setBackgroundResource(R.drawable.animation);

                            break;
                    }



                }
            }.start();



        }


    }
}
