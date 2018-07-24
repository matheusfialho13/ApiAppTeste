package com.example.matheus.instituicoes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.text.SimpleDateFormat;

import static com.example.matheus.instituicoes.R.layout.activity_informacoes_curso;
import static com.example.matheus.instituicoes.R.layout.activity_informacoes_unidade;

public class InformacoesUnidade extends AppCompatActivity {

    private TextView id;
    private TextView nome;
    private TextView sigla;
    private TextView dataCriacao;
    private TextView telefone;
    private TextView email;

    private Unidade unidade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_informacoes_unidade);

        unidade = (Unidade) getIntent().getExtras().getSerializable("unidade");

        //Pegando referência das views
        id = (TextView) findViewById(R.id.idUnidade);
        nome = (TextView) findViewById(R.id.nomeUnidade);
        sigla = (TextView) findViewById(R.id.siglaUnidade);
        dataCriacao = (TextView) findViewById(R.id.dataCriacaoUnidade);
        telefone = (TextView) findViewById(R.id.telefoneUnidade);
        email = (TextView) findViewById(R.id.emailUnidade);

        String dateString = "";
        if(unidade.getDataCriacao() != null) {
            dateString = new SimpleDateFormat("MM/dd/yyyy").format(unidade.getDataCriacao());
        }

        //Populando XML
        if(unidade.getId() != null) {
            id.setText("Id: " + unidade.getId().toString());
        }
        nome.setText("Nome: " + unidade.getNome());
        sigla.setText("Sigla: " + unidade.getSigla());
        dataCriacao.setText("Data de Criação: " + dateString);
        telefone.setText("Telefones: " + unidade.getTelefones());
        email.setText("Email: " + unidade.getEmail());
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
