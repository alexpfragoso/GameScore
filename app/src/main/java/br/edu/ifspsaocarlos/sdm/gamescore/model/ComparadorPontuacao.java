package br.edu.ifspsaocarlos.sdm.gamescore.model;

import android.support.annotation.NonNull;

import java.util.Comparator;

/**
 * Created by Alex Fragoso on 02/12/2017.
 */

//classe implementada para comparação de pontuação entre
//jogadores na lista de jogadores que preenche o ranking de pontos

public class ComparadorPontuacao implements Comparator<Jogador> {

    public int compare(Jogador j1, Jogador j2) {
        if (j1.getPontuacao() < j2.getPontuacao()) return 1;
        else if (j1.getPontuacao() > j2.getPontuacao()) return -1;
        else return 0;
    }

}
