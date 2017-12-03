package br.edu.ifspsaocarlos.sdm.gamescore.view;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

import br.edu.ifspsaocarlos.sdm.gamescore.R;

public class SorteioActivity extends AppCompatActivity implements View.OnClickListener{

    //VARIAVEIS
    private Button bt_aumenta_intervalo_inicio;
    private Button bt_aumenta_intervalo_final;
    private Button bt_diminui_intervalo_inicio;
    private Button bt_diminui_intervalo_final;
    private Button bt_sorteia;
    private TextView tv_resultado_sorteio;
    private EditText et_intervalo_inicio;
    private EditText et_intervalo_final;
    private int inicio_intervalo = 0;
    private int final_intervalo = 5;
    private int resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sorteio);

        bt_aumenta_intervalo_inicio = (Button)findViewById(R.id.bt_aumenta_1_inicio_intervalo);
        bt_aumenta_intervalo_final = (Button)findViewById(R.id.bt_aumenta_1_final_intervalo);
        bt_diminui_intervalo_inicio = (Button)findViewById(R.id.bt_diminui_1_inicio_intervalo);
        bt_diminui_intervalo_final = (Button)findViewById(R.id.bt_diminui_1_final_intervalo);
        bt_sorteia = (Button)findViewById(R.id.bt_sortear);
        bt_aumenta_intervalo_inicio.setOnClickListener(this);
        bt_aumenta_intervalo_final.setOnClickListener(this);
        bt_diminui_intervalo_inicio.setOnClickListener(this);
        bt_diminui_intervalo_final.setOnClickListener(this);
        bt_sorteia.setOnClickListener(this);
        tv_resultado_sorteio = (TextView)findViewById(R.id.tv_resultado_sorteio);
        et_intervalo_inicio = (EditText)findViewById(R.id.et_inicio_intervalo);
        et_intervalo_inicio.setText(Integer.toString(inicio_intervalo));
        et_intervalo_final = (EditText)findViewById(R.id.et_final_intervalo);
        et_intervalo_final.setText(Integer.toString(final_intervalo));
    }

    @Override
    public void onClick(View view) {

        if(view == bt_sorteia){

            inicio_intervalo = Integer.parseInt(et_intervalo_inicio.getText().toString());
            final_intervalo = Integer.parseInt(et_intervalo_final.getText().toString());

            if(inicio_intervalo < 0){inicio_intervalo=0;}
            if(final_intervalo < 0){final_intervalo=0;}
            if(final_intervalo < inicio_intervalo){final_intervalo=inicio_intervalo;}

            Random randon = new Random();
            resultado = randon.nextInt(((final_intervalo+1)-inicio_intervalo)+inicio_intervalo);
            new CountDownTimer((5000),100) {

                public void onTick(long millisUntilFinished) {
                    Random randonTick = new Random();
                    int i;
                    i = randonTick.nextInt(((final_intervalo+1)-inicio_intervalo)+inicio_intervalo);
                    tv_resultado_sorteio.setText(Integer.toString(i));

                }

                public void onFinish() {
                    tv_resultado_sorteio.setText(Integer.toString(resultado));
                }
            }.start();

        }else{
            if(view == bt_aumenta_intervalo_inicio){
                inicio_intervalo++;
                et_intervalo_inicio.setText(Integer.toString(inicio_intervalo));

            }else{
                if(view == bt_aumenta_intervalo_final){
                    final_intervalo++;
                    et_intervalo_final.setText(Integer.toString(final_intervalo));

                }else{
                    if(view == bt_diminui_intervalo_inicio){
                        inicio_intervalo--;
                        if(inicio_intervalo < 0){inicio_intervalo=0;}
                        et_intervalo_inicio.setText(Integer.toString(inicio_intervalo));

                    }else{
                        if(view == bt_diminui_intervalo_final){
                            final_intervalo--;
                            if(final_intervalo < 0){final_intervalo=0;}
                            et_intervalo_final.setText(Integer.toString(final_intervalo));

                        }

                    }

                }

            }

        }


    }
}
