package com.example.klaussius.marvin_mobile;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import data.QueryTournamentInscription;
import data.QueryUserInTournament;

/**
 * This class show us a tournament with all the data
 */
public class MenuTournament extends AppCompatActivity {

    TextView tvTournamentTitle,tvPublicDes,tvDate,tvMaxPlayers,tvMinPlayers;
    Button btInscription,btDeleteInscription,btClose;
    int tournamentId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_tournament);

        // TextViews
        tvTournamentTitle=(TextView)findViewById(R.id.tvTournamentTitle);
        tvPublicDes=(TextView)findViewById(R.id.tvPublicDes);
        tvDate=(TextView)findViewById(R.id.tvDate);
        tvMaxPlayers=(TextView)findViewById(R.id.tvMaxPlayers);
        tvMinPlayers=(TextView)findViewById(R.id.tvMinPlayers);

        // Buttons
        btInscription=(Button)findViewById(R.id.btInscription);
        btInscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inscription();
            }
        });
        btDeleteInscription=(Button)findViewById(R.id.btDeleteInscription);
        btDeleteInscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteInscription();
            }
        });
        btClose = (Button)findViewById(R.id.btClose);
        btClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                close();
            }
        });

        // Get the data from the intent
        tournamentId=Integer.parseInt(getIntent().getStringExtra("idTournament"));
        tvTournamentTitle.setText(getIntent().getStringExtra("title"));
        tvPublicDes.setText(getIntent().getStringExtra("description"));
        int yyyy = Integer.parseInt(getIntent().getStringExtra("date").split("-")[0]);
        int mm = Integer.parseInt(getIntent().getStringExtra("date").split("-")[1]);
        int dd = Integer.parseInt(getIntent().getStringExtra("date").split("-")[2]+1);
        tvDate.setText(dd+"-"+mm+"-"+yyyy);
        tvMaxPlayers.setText(getIntent().getStringExtra("maxPlayers"));
        tvMinPlayers.setText(getIntent().getStringExtra("minPlayers"));

        Log.i("Data for Tournament",tournamentId+","+tvTournamentTitle.getText().toString()+","+tvPublicDes.getText().toString()+","+tvMaxPlayers.getText().toString()+","+tvMinPlayers.getText().toString());

        QueryUserInTournament queryUserInTournament = new QueryUserInTournament(loadUserName(),tournamentId);
        queryUserInTournament.executeQuery();

        if (queryUserInTournament.getSigned()==true){
            btInscription.setVisibility(View.GONE);
            btDeleteInscription.setVisibility(View.VISIBLE);
        } else {
            btInscription.setVisibility(View.VISIBLE);
            btDeleteInscription.setVisibility(View.GONE);
        }
    }

    /**
     * Closes the activity
     */
    private void close(){
        this.finish();
    }

    /**
     * Sign in the tournament
     */
    private void inscription(){
        new QueryTournamentInscription(loadUserName(),tournamentId,true).executeQuery();
        btInscription.setVisibility(View.GONE);
        btDeleteInscription.setVisibility(View.VISIBLE);
    }

    /**
     * Dissmis participation in the tournament
     */
    private void deleteInscription(){
        new QueryTournamentInscription(loadUserName(),tournamentId,false).executeQuery();
        btDeleteInscription.setVisibility(View.GONE);
        btInscription.setVisibility(View.VISIBLE);
    }

    /**
     * Send a toast message
     * @param message the message
     */
    public void toastMessage(String message){
        Toast toast = Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT);
        toast.show();
    }

    /**
     * Load the username from SharedPreferences
     */
    public String loadUserName(){
        SharedPreferences prefs = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        Log.i("Shared name",prefs.getString("marvinName",""));
        return prefs.getString("marvinName","");
    }
}
