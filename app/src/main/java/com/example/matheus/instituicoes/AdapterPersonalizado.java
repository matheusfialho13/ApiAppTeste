package com.example.matheus.instituicoes;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AdapterPersonalizado extends BaseAdapter {

    private Curso classCurso;
    private List<Curso> cursos = new ArrayList<>();
    private Activity activity;

    public  AdapterPersonalizado(List<Curso> cursos, Activity activity){
        this.cursos = cursos;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        if(cursos != null){
            return cursos.size();
        } else {
            return 0;
        }
    }

    @Override
    public Object getItem(int i) {
        return cursos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0l;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        TextView nome;


        View view1 = activity.getLayoutInflater()
                .inflate(R.layout.activity_adapter_personalizado, viewGroup, false);

        //Pegando referência da view
        nome = (TextView) view1.findViewById(R.id.nomeCursoAdapter);

        Curso curso = cursos.get(i);

        //Populando as views
        nome.setText(curso.getCurso());

        return view1;
    }
}
