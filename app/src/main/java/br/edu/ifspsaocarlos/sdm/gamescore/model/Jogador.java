package br.edu.ifspsaocarlos.sdm.gamescore.model;

import android.support.annotation.NonNull;

import java.io.Serializable;

/**
 * Created by Alex Fragoso on 01/12/2017.
 */

public class Jogador implements Serializable, Comparable<Jogador>{
    //variaveis
    String nome;
    int pontuacao;
    int avatar;

    public Jogador(String nome, int pontuacao) {
        this.nome = nome;
        this.pontuacao = pontuacao;
    }

    public Jogador() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    @Override
    public int compareTo(@NonNull Jogador jogador) {

        if (this.pontuacao < jogador.pontuacao) {
            return -1;
        }
        if (this.pontuacao > jogador.pontuacao) {
            return 1;
        }
        return 0;

    }
}
