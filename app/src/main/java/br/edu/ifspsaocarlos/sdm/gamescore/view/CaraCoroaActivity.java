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

import br.edu.ifspsaocarlos.sdm.gamescore.R;



public class CaraCoroaActivity extends AppCompatActivity implements View.OnClickListener{

    //VARIÁVEIS

    Button bt_jogar_cara_coroa;
    ImageView iv_moeda_1real;
    private AnimationDrawable mAnimation;
    boolean moedaGirando = false;
    int resultado;

    //MÉTODOS

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cara_coroa);

        bt_jogar_cara_coroa = (Button)findViewById(R.id.bt_lancar_moeda);
        bt_jogar_cara_coroa.setOnClickListener(this);
        iv_moeda_1real = (ImageView)findViewById(R.id.moeda_1real);
        iv_moeda_1real.setBackgroundResource(R.drawable.animation_moeda);

    }

    @Override
    public void onClick(View view) {

        iv_moeda_1real.setImageDrawable(null);
        iv_moeda_1real.setBackgroundResource(R.drawable.animation_moeda);

        mAnimation = (AnimationDrawable)iv_moeda_1real.getBackground();

        if(view == bt_jogar_cara_coroa && moedaGirando==false){


            mAnimation.start();
            moedaGirando = true;
            Random randon = new Random();
            resultado = randon.nextInt(2);
           // Toast.makeText(this,"Resultado: "+ resultado, Toast.LENGTH_SHORT).show();


            new CountDownTimer(5000,1000) {

                public void onTick(long millisUntilFinished) {

                }

                public void onFinish() {
                    mAnimation.stop();
                    moedaGirando = false;
                    switch (resultado) {

                        case 0:
                            iv_moeda_1real.setImageResource(R.drawable.moeda9_coroa);


                            break;
                        case 1:
                            iv_moeda_1real.setImageResource(R.drawable.moeda25_cara);


                            break;

                        default:
                            iv_moeda_1real.setBackgroundResource(R.drawable.animation_moeda);

                            break;
                    }

                }
            }.start();



        }


    }



}
