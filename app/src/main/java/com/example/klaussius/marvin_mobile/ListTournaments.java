package com.example.klaussius.marvin_mobile;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import model.tournament.Tournament;
import serverData.QueryTournaments;

/**
 * Activity that get the hosts
 * @author Klaussius
 */
public class ListTournaments extends AppCompatActivity {

    public TextView tvContent;
    public QueryTournaments myData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_hots);
        tvContent = (TextView) findViewById(R.id.tvContent);
        new leerDatos().execute();
    }

    private class leerDatos extends AsyncTask<String,Void,String> {
        @Override
        protected String doInBackground(String... strings) {
            myData = new QueryTournaments();
            myData.findAll();
            return "done";
        }
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            String texto = "";
            for (Tournament tournament:myData.queryResult){
                texto = texto + tournament.getId()+": "+tournament.getName()+"\n";
            }
            tvContent.setText(texto);
        }
    }
}
