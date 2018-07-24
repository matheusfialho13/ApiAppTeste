package com.example.matheus.instituicoes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import static com.example.matheus.instituicoes.R.layout.activity_informacoes_curso;
import static com.example.matheus.instituicoes.R.layout.activity_main;

public class InformacoesCurso extends AppCompatActivity {

    private  TextView nome;
    private  TextView nivel;
    private  TextView unidade;
    private  TextView municipio;
    private  TextView tipo;

    private  Curso curso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_informacoes_curso);

        curso = (Curso) getIntent().getExtras().getSerializable("curso");

        //Pegando referência das views
        nome = (TextView) findViewById(R.id.nomeCurso);
        nivel = (TextView) findViewById(R.id.nivelCurso);
        unidade = (TextView) findViewById(R.id.unidadeCurso);
        municipio = (TextView) findViewById(R.id.municipioCurso);
        tipo = (TextView) findViewById(R.id.tipoCurso);

        //Populando XML
        nome.setText("Nome: " + curso.getCurso());
        nivel.setText("Nível: " + curso.getNivel());
        unidade.setText("Unidade: " + curso.getUnidade());
        municipio.setText("Município: " + curso.getMunicipio());
        tipo.setText("Tipo: " + curso.getTipoCurso());
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
