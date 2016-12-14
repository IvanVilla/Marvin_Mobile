package com.example.klaussius.marvin_mobile;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

import data.QueryTournaments;
import model.tournament.Tournament;

/**
 * Activity that get the hosts
 * @author Iván Villa
 */
public class ListTournaments extends AppCompatActivity {

    public QueryTournaments myData;
    public Button TakeMeBack;
    public ListView lvContent;

    /**
     * OnCreate: assigns our controls
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Showing the content
        setContentView(R.layout.activity_list_tournaments);
        //Button to take back
        TakeMeBack = (Button)findViewById(R.id.btTakeMeBack);
        TakeMeBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takeMeBack();
            }
        });
        //Content
        lvContent = (ListView)findViewById(R.id.lvContent);
        //Retrieve data
        new leerDatos().execute();
    }

    /**
     * Async class to read server data
     */
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
            mostrarDatos(myData.getQueryResult());
        }
    }

    private void mostrarDatos(List<Tournament> datos){
        // Paso los datos a un ListView
        String textos[]=new String[myData.getQueryResult().size()];
        for (int i = 0; i<textos.length; i++){
            textos[i] = myData.getQueryResult().get(i).getName()+"\n"+myData.getQueryResult().get(i).getPublicDes();
        }
        ArrayAdapter<String> itemsAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,textos);
        lvContent.setAdapter(itemsAdapter);
    }

    private void takeMeBack(){
        this.finish();
    }
}
