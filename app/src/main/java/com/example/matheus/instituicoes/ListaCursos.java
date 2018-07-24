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

import br.com.guerethes.offdroid.query.business.QueryOffDroidManager;
import br.ufrn.mobile.credentials.oauth.OAuthSinfo;

import static com.example.matheus.instituicoes.R.layout.activity_lista_cursos;

public class ListaCursos extends AppCompatActivity {

    private ListView listView;
    private AdapterPersonalizado adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_lista_cursos);

        listView = (ListView) findViewById(R.id.listaCursos);

        new RetrieveFeedTask().execute();

    }

    class RetrieveFeedTask extends AsyncTask<String, Void, List<Curso>> {

        protected List<Curso> doInBackground(String... urls) {

            try {
                boolean acesso = OAuthSinfo.authenticate(getApplicationContext());
                if(acesso)
                    Log.d("Teste", "Acesso concedido");
                else
                    Log.d("Teste", "Acesso negado");



                QueryOffDroidManager queryOffDroidManager = QueryOffDroidManager.from(Curso.class,  getApplicationContext());
                return (List<Curso>) queryOffDroidManager.toList();

            } catch (Exception e) {
                e.printStackTrace();
            }
            Log.d("Teste", "AccessToken: "+OAuthSinfo.getAccessToken(ListaCursos.this));
            Log.d("Teste", "Authorization: "+OAuthSinfo.getAuthorization(ListaCursos.this));
            Log.d("Teste", "RefreshToken: "+OAuthSinfo.getRefreshToken(ListaCursos.this));
            Log.d("Teste", "ExpiresIn: "+OAuthSinfo.getExpiresIn(ListaCursos.this));

            return null;
        }

        @Override
        protected void onPostExecute(List<Curso> cursos) {

            adapter = new AdapterPersonalizado(cursos, ListaCursos.this);
            listView.setAdapter(adapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Curso curso = (Curso) listView.getItemAtPosition(i);
                    Intent intent = new Intent(getApplicationContext(), InformacoesCurso.class);
                    intent.putExtra("curso", curso);
                    startActivity(intent);
                }
            });

            /*
            ArrayAdapter<Curso> adapter = new ArrayAdapter<Curso>(ListaCursos.this, android.R.layout.simple_list_item_1, cursos);
            listView.setAdapter(adapter);
            */

        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
