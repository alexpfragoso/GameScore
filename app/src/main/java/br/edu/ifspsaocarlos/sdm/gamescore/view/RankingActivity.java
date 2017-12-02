package br.edu.ifspsaocarlos.sdm.gamescore.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import br.edu.ifspsaocarlos.sdm.gamescore.R;
import br.edu.ifspsaocarlos.sdm.gamescore.adapter.JogadorArrayAdapter;
import br.edu.ifspsaocarlos.sdm.gamescore.model.ComparadorPontuacao;
import br.edu.ifspsaocarlos.sdm.gamescore.model.Jogador;

import static android.R.attr.id;

/**
 * Created by Alex Fragoso on 01/12/2017.
 */


public class RankingActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    //VARIÁVEIS
    private ListView listView_jogadores;
    private List<Jogador> lista_de_jogadores;
    private JogadorArrayAdapter jogadorArrayAdapter;

    private final int CADASTRO_NOVO_JOGADOR = 0;
    private final int ATUALIZAR_JOGADOR = 1;
    private final String JOGADOR_ADICIONADO = "novo jogador";
    private final String JOGADOR_ATUALIZADO = "jogador atualizado";
    private final String JOGADOR_REMOVIDO = "jogador removido";
    private  final String JOGADOR_PARA_ATUALIZAR="jogador para atualizar";
    //MÉTODOS

    private void inicializaListaJogadores() {
        if (lista_de_jogadores == null) {

            lista_de_jogadores = new ArrayList<>();
            lista_de_jogadores.add(new Jogador("Alex",3));
            lista_de_jogadores.add(new Jogador("Maria",2));
            lista_de_jogadores.add(new Jogador("João",1));

        }
    }




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        inicializaListaJogadores();

        jogadorArrayAdapter = new JogadorArrayAdapter(RankingActivity.this, lista_de_jogadores);
        listView_jogadores = (ListView) findViewById(R.id.lv_jogadores);
        listView_jogadores.setAdapter(jogadorArrayAdapter);
        listView_jogadores.setOnItemClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.item_menu_adicionar_jogador:
                Intent novoJogadorIntent = new Intent(this,NovoJogadorActivity.class);
                startActivityForResult(novoJogadorIntent,CADASTRO_NOVO_JOGADOR);
                break;

            case R.id.item_menu_limpar_ranking:
                lista_de_jogadores.clear();
                jogadorArrayAdapter.notifyDataSetChanged();
                Toast.makeText(this,"Ranking limpo!",Toast.LENGTH_SHORT).show();

                break;

            default:
                return false;
        }
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        //chamar a tela de AtualizaJogador para atualizar ou Remover
        Jogador jogador = jogadorArrayAdapter.getItem(i);

        Intent atualizarJogadorIntent = new Intent(this, Atualizar_Remover_JogadorActivity.class);

        atualizarJogadorIntent.putExtra(JOGADOR_PARA_ATUALIZAR,jogador);
        startActivityForResult(atualizarJogadorIntent,ATUALIZAR_JOGADOR);



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == CADASTRO_NOVO_JOGADOR){
            //Cadastra novo jogador no ranking
            if(resultCode == RESULT_OK){
                Jogador novoJogador = (Jogador)data.getSerializableExtra(JOGADOR_ADICIONADO);
                lista_de_jogadores.add(novoJogador);
                Collections.sort (lista_de_jogadores, new ComparadorPontuacao());
                jogadorArrayAdapter.notifyDataSetChanged();
                Toast.makeText(this,"Novo jogador adicionado!",Toast.LENGTH_SHORT).show();
            }

        }else{
            if(requestCode == ATUALIZAR_JOGADOR){
                //Atualiza jogador do ranking
                if(resultCode == RESULT_OK){
                    Jogador jogador = (Jogador)data.getSerializableExtra(JOGADOR_ATUALIZADO);
                    int i = buscaJogador(jogador.getNome());
                    lista_de_jogadores.get(i).setNome(jogador.getNome());
                    lista_de_jogadores.get(i).setPontuacao(jogador.getPontuacao());
                    Collections.sort (lista_de_jogadores, new ComparadorPontuacao());
                    jogadorArrayAdapter.notifyDataSetChanged();
                    Toast.makeText(this,"Jogador atualizado!",Toast.LENGTH_SHORT).show();
                }else{
                    //Remove jogador do ranking
                    if(resultCode == RESULT_CANCELED){
                        Jogador jogador = (Jogador)data.getSerializableExtra(JOGADOR_REMOVIDO);
                        int i = buscaJogador(jogador.getNome());
                        lista_de_jogadores.remove(i);
                        Collections.sort (lista_de_jogadores, new ComparadorPontuacao());
                        jogadorArrayAdapter.notifyDataSetChanged();
                        Toast.makeText(this,"Jogador removido!",Toast.LENGTH_SHORT).show();
                    }
                }

            }
        }
    }

    public int buscaJogador(String nome) {
        int i=0;
        for (Jogador jogador : lista_de_jogadores) {

            if (jogador.getNome().compareTo(nome) == 0) {
                return i;
            }
            i++;
        }

        return -1;
    }



}
