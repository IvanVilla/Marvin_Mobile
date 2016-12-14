package com.example.klaussius.marvin_mobile;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

import data.QueryHosts;
import model.host.TournamentHost;

/**
 * Activity that get the hosts
 * @author Iván Villa
 */
public class ListHosts extends AppCompatActivity {

    public QueryHosts myData;
    public Button takeMeBack;
    public ListView lvContent;

    /**
     * OnCreate: assigns our controls
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_hots);
        // Button to take back
        takeMeBack = (Button)findViewById(R.id.btTakeMeBack);
        takeMeBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takeMeBack();
            }
        });
        // ListView for the content
        lvContent = (ListView)findViewById(R.id.lvContent);
        // Retrieve data
        new leerDatos().execute();
    }

    /**
     * Async class to read the data from the server
     */
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
            mostrarDatos(myData.getQueryResult());
        }
    }

    private void mostrarDatos(List<TournamentHost> datos){
        // Paso los datos a un ListView
        String textos[]=new String[myData.getQueryResult().size()];
        for (int i = 0; i<textos.length; i++){
            textos[i] = myData.getQueryResult().get(i).getId()+": "+myData.getQueryResult().get(i).getName();
        }
        ArrayAdapter<String> itemsAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,textos);
        lvContent.setAdapter(itemsAdapter);
    }

    /**
     * Close the activity
     */
    private void takeMeBack(){
        this.finish();
    }
}