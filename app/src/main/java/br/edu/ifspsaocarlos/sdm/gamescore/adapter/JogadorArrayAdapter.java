package br.edu.ifspsaocarlos.sdm.gamescore.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import br.edu.ifspsaocarlos.sdm.gamescore.R;
import br.edu.ifspsaocarlos.sdm.gamescore.model.Jogador;

/**
 * Created by Alex Fragoso on 01/12/2017.
 */

public class JogadorArrayAdapter extends ArrayAdapter<Jogador> {

    private LayoutInflater inflater;

    public JogadorArrayAdapter(@NonNull Context context, @NonNull List<Jogador> lista_jogadores) {
        super(context, R.layout.item_lista_jogadores, lista_jogadores);
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Holder holder = null;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_lista_jogadores, null);

            holder = new Holder();

            holder.nomeJogadorTextView = (TextView) convertView.findViewById(R.id.tv_nome_jogador);
            holder.pontuacaoJogadorTextView = (TextView) convertView.findViewById(R.id.tv_pontuacao_jogador);

            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }

        Jogador jogador = getItem(position);

        holder.nomeJogadorTextView.setText(jogador.getNome());
        holder.pontuacaoJogadorTextView.setText(Integer.toString(jogador.getPontuacao()));

        return convertView;
    }


    private static class Holder {
        public TextView nomeJogadorTextView;
        public TextView pontuacaoJogadorTextView;
    }
}
