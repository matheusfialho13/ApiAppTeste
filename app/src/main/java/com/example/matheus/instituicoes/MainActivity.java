package com.example.matheus.instituicoes;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Switch;

import com.nostra13.universalimageloader.utils.L;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import EDU.purdue.cs.bloat.tree.SRStmt;
import br.com.guerethes.offdroid.query.business.QueryOffDroidManager;
import br.ufrn.mobile.credentials.oauth.OAuthSinfo;

import static com.example.matheus.instituicoes.R.*;
import static com.example.matheus.instituicoes.R.layout.*;

public class MainActivity extends AppCompatActivity {

    private ListView listaMain;
    private List<String> topicos;
    private ArrayAdapter<String> adapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_main);

        listaMain = (ListView) findViewById(id.listaMain);
        topicos = new ArrayList<>();
        topicos.add("CURSOS");
        topicos.add("UNIDADES");

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, topicos);
        listaMain.setAdapter(adapter);

        listaMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = (String) listaMain.getItemAtPosition(i);
                identificaItem(item);
            }
        });
    }

    private void identificaItem(String item){
        Intent intent = new Intent();
        switch (item){
            case "CURSOS":
                intent = new Intent(getApplicationContext(), ListaCursos.class);
                break;
            case "UNIDADES":
                intent = new Intent(getApplicationContext(), ListaUnidades.class);
                break;
        }
        startActivity(intent);
    }
}