package com.example.klaussius.marvin_mobile;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
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
    public Button takeMeBack;

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
        // Retrieve data
        tvContent = (TextView) findViewById(R.id.tvContent);
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
            String texto = "";
            for (TournamentHost tHost:myData.getQueryResult()){
                texto = texto + tHost.getId()+": "+tHost.getName()+"\n\n";
            }
            tvContent.setText(texto);
        }
    }

    /**
     * Close the activity
     */
    private void takeMeBack(){
        this.finish();
    }
}