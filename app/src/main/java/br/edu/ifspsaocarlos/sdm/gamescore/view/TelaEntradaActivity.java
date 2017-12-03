package br.edu.ifspsaocarlos.sdm.gamescore.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import br.edu.ifspsaocarlos.sdm.gamescore.R;

//TelaEntradaActivity é a tela de abertura do aplicativo
//que exibe apenas uma imagem e da acesso a tela principal através de um clique

public class TelaEntradaActivity extends AppCompatActivity implements View.OnClickListener {

    //VARIÁVEIS

    ImageButton im_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_entrada);

        im_button = (ImageButton)findViewById(R.id.imageButton);
        im_button.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        if(view == im_button){
        Intent telaMarcadorIntent = new Intent(this,TelaMarcadoresActivity.class);
        startActivity(telaMarcadorIntent);
        }
    }
}
