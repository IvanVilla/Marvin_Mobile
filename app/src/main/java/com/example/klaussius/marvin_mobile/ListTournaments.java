package com.example.klaussius.marvin_mobile;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
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
    public Button TakeMeBack;

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
        tvContent = (TextView) findViewById(R.id.tvContent);
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
            String texto = "";
            for (Tournament tournament:myData.getQueryResult()){
                texto = texto + tournament.getId()+": "+tournament.getName()+"\n"+tournament.getPublicDes()+"\n\n";
            }
            tvContent.setText(texto);
        }
    }

    private void takeMeBack(){
        this.finish();
    }
}
