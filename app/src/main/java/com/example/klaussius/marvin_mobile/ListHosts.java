package com.example.klaussius.marvin_mobile;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import model.host.TournamentHost;
import serverData.QueryHosts;

/**
 * Activity that get the hosts
 * @author Klaussius
 */
public class ListHosts extends AppCompatActivity {

    public TextView tvContent;
    public QueryHosts myData;


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
            myData = new QueryHosts();
            myData.findAll();
            return "done";
        }
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            String texto = "";
            for (TournamentHost tHost:myData.queryResult){
                texto = texto + tHost.getId()+": "+tHost.getName()+"\n";
            }
            tvContent.setText(texto);
        }
    }
}