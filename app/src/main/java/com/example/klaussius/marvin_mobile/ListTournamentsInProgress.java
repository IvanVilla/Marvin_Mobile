package com.example.klaussius.marvin_mobile;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import data.QueryTournamentsByStatus;
import model.tournament.Tournament;

public class ListTournamentsInProgress extends AppCompatActivity {

    public QueryTournamentsByStatus queryTournamentsByStatus;
    public Button TakeMeBack;
    public ListView lvContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_tournaments_in_progress);
        //Button to take back
        TakeMeBack = (Button) findViewById(R.id.btTakeMeBack);
        TakeMeBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takeMeBack();
            }
        });
        //Content
        lvContent = (ListView) findViewById(R.id.lvContent);
        //Retrieve data
        new readBeginnedTournament().execute();
    }

    /**
     * Show the tournament list
     * @param datos
     */
    private void mostrarDatos(final List<Tournament> datos){
        // Paso los datos a un ListView
        String textos[]=new String[queryTournamentsByStatus.getQueryResult().size()];
        for (int i = 0; i<textos.length; i++){
            Tournament tournament = queryTournamentsByStatus.getQueryResult().get(i);
            textos[i]=tournament.getName();
            Log.i("Insertado torneo",textos[i]);
        }
        ArrayAdapter<String> itemsAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,textos);
        lvContent.setAdapter(itemsAdapter);
        lvContent.setClickable(true);
        lvContent.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ListTournamentsInProgress.this,TournamentProgress.class);
                intent.putExtra("round","0");
                startActivity(intent);
            }
        });
    }

    /**
     * Async class to read server data
     */
    private class readBeginnedTournament extends AsyncTask<String,Void,String> {
        @Override
        protected String doInBackground(String... strings) {
            queryTournamentsByStatus = new QueryTournamentsByStatus("beggined");
            queryTournamentsByStatus.executeQuery();
            return "done";
        }
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if(queryTournamentsByStatus.getQueryResult().size()>0){
                mostrarDatos(queryTournamentsByStatus.getQueryResult());
            } else {
                toastMessage(getString(R.string.noData));
            }
        }
    }

    /**
     * Take us back
     */
    private void takeMeBack(){
        startActivity(new Intent(this,MainMenu.class));
        this.finish();
    }

    /**
     * Show a message
     * @param message message
     */
    public void toastMessage(String message){
        Toast toast = Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT);
        toast.show();
    }
}
