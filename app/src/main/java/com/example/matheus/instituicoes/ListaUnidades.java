package com.example.matheus.instituicoes;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import br.com.guerethes.offdroid.query.Restriction;
import br.com.guerethes.offdroid.query.business.QueryOffDroidManager;
import br.ufrn.mobile.credentials.oauth.OAuthSinfo;

import static com.example.matheus.instituicoes.R.layout.activity_lista_unidades;

public class ListaUnidades extends AppCompatActivity {

    private ListView listView;
    private AdapterPersonUnidade adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_lista_unidades);

        listView = (ListView) findViewById(R.id.listaUnidades);

        new UnidadeRetrieveFeedTask().execute();

    }

    //
    class UnidadeRetrieveFeedTask extends AsyncTask<String, Void, List<Unidade>> {

        protected List<Unidade> doInBackground(String... urls) {

            try {
                //
                QueryOffDroidManager queryOffDroidManager = QueryOffDroidManager.from(Unidade.class,  getApplicationContext());
                //"Adiciona uma restrição" para a lista começar do item no valor que é informado, nesse caso o "0"
                queryOffDroidManager.add(Restriction.offSet(0));
                //"Adiciona uma restrição" que informa a quantidade de itens que seram exibidos, começando do item acima (offSet)
                queryOffDroidManager.add(Restriction.limit(50));
                //Retorna um lista de Objetos, nessa caso Unidades
                return (List<Unidade>) queryOffDroidManager.toList();

            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(List<Unidade> unidades) {

            adapter = new AdapterPersonUnidade(unidades, ListaUnidades.this);
            listView.setAdapter(adapter);

            //Evento de clique em um componente do ListView
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Unidade unidade = (Unidade) listView.getItemAtPosition(i);
                    Intent intent = new Intent(getApplicationContext(), InformacoesUnidade.class);
                    intent.putExtra("unidade", unidade);
                    startActivity(intent);
                }
            });
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
