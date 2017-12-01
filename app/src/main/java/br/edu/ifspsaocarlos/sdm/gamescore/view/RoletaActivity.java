package br.edu.ifspsaocarlos.sdm.gamescore.view;

import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import br.edu.ifspsaocarlos.sdm.gamescore.R;

import static android.R.color.holo_green_dark;
import static android.R.color.holo_red_dark;

public class RoletaActivity extends AppCompatActivity implements View.OnClickListener{

    //VARIÁVEIS

    Button bt_girar;
    ImageView iv_roleta;
    TextView tv_resultado_roleta;
    private AnimationDrawable mAnimation;
    boolean roletaGirando = false;
    int resultado;
    int resultado_cor;

    //MÉTODOS
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roleta);

        tv_resultado_roleta = (TextView)findViewById(R.id.tv_resultado_roleta);
        bt_girar = (Button)findViewById(R.id.bt_girar);
        bt_girar.setOnClickListener(this);
        iv_roleta = (ImageView)findViewById(R.id.iv_roletagif);
        //iv_roleta.setBackgroundResource(R.drawable.animation_roleta);


        //mAnimation = (AnimationDrawable)iv_roleta.getBackground();
        //mAnimation.start();
    }

    @Override
    public void onClick(View view) {


        iv_roleta.setBackgroundResource(R.drawable.animation_roleta);

        mAnimation = (AnimationDrawable)iv_roleta.getBackground();

        if(view == bt_girar && roletaGirando==false){


            mAnimation.start();
            roletaGirando = true;
            Random randon = new Random();
            resultado = randon.nextInt(38);

            //Toast.makeText(this,"Resultado: "+ resultado +" Cor: " + resultado_cor, Toast.LENGTH_SHORT).show();

            new CountDownTimer(4500,1000) {

                public void onTick(long millisUntilFinished) {

                }

                public void onFinish() {
                    mAnimation.stop();
                    roletaGirando = false;

                    if(resultado == 1 ||resultado == 3 || resultado == 5 ||resultado == 7 || resultado == 9
                            ||resultado == 12 || resultado == 14 ||resultado == 16 ||resultado == 18 || resultado == 19
                            ||resultado == 21 ||resultado == 23 || resultado == 25 ||resultado == 27 ||resultado == 30
                            || resultado == 32 ||resultado == 34 ||resultado == 36){
                        resultado_cor = 1;

                    }else{
                        if(resultado!=0 && resultado!=37) {
                            resultado_cor = 2;
                        }else{
                            if(resultado==0){
                            resultado_cor = 0;
                            }else{resultado_cor = 3;}
                        }

                    }
                    switch (resultado_cor) {

                        case 0:
                            tv_resultado_roleta.setText("0");
                            tv_resultado_roleta.setBackgroundColor(Color.GREEN);
                            break;
                        case 1:
                            tv_resultado_roleta.setText(Integer.toString(resultado));
                            tv_resultado_roleta.setBackgroundColor(Color.RED);
                            break;
                        case 2:
                            tv_resultado_roleta.setText(Integer.toString(resultado));
                            tv_resultado_roleta.setBackgroundColor(Color.BLACK);

                            break;
                        case 3:
                            tv_resultado_roleta.setText("00");
                            tv_resultado_roleta.setBackgroundColor(Color.GREEN);
                            break;

                        default:


                            break;
                    }



                }
            }.start();



        }


    }
}
