package com.example.matheus.instituicoes;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AdapterPersonUnidade extends BaseAdapter {

    private Unidade classUnidade;
    private List<Unidade> unidades = new ArrayList<>();
    private Activity activity;

    public  AdapterPersonUnidade(List<Unidade> unidades, Activity activity){
        this.unidades = unidades;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        if(unidades != null){
            return unidades.size();
        } else {
            return 0;
        }
    }

    @Override
    public Object getItem(int i) {
        return unidades.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0l;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        TextView nome;


        View view2 = activity.getLayoutInflater()
                .inflate(R.layout.activity_adapter_personalizado, viewGroup, false);

        //Pegando referência da view
        nome = (TextView) view2.findViewById(R.id.nomeCursoAdapter);

        Unidade unidade = unidades.get(i);

        //Populando as views
        nome.setText(unidade.getNome());

        return view2;
    }
}
