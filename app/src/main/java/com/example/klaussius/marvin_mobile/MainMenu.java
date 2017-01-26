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

/**
 * Main menu activity
 * @author Iván Villa
 */
public class MainMenu extends AppCompatActivity {

    Button btFutureTournaments, btRankings, btMessages, btProfile, btLogOut, btInProgressTournaments;
    TextView hello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        //TextView hello!
        hello = (TextView)findViewById(R.id.tvHello);
        hello.setText("Hello "+loadUserName()+"!");
        //Button for Tournaments
        btFutureTournaments = (Button)findViewById(R.id.btFutureTournaments);
        btFutureTournaments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchTournaments();
            }
        });
        //Button for Rankings
        btRankings = (Button)findViewById(R.id.btRankings);
        btRankings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchRankings();
            }
        });
        //Button for Messages
        btMessages = (Button)findViewById(R.id.btMessages);
        btMessages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchMessages();
            }
        });
        //Button for Profiles
        btProfile = (Button)findViewById(R.id.btProfile);
        btProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchProfile();
            }
        });
        //Button for LogOut
        btLogOut = (Button)findViewById(R.id.btLogOut);
        btLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });
        //Button for tournaments in progress
        btInProgressTournaments = (Button)findViewById(R.id.btInProgressTournaments);
        btInProgressTournaments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inProgressTournaments();
            }
        });
    }

    /**
     * Launch tournaments activity
     */
    public void launchTournaments(){
        Intent myIntent = new Intent(this,ListTournaments.class);
        startActivity(myIntent);
    }

    /**
     * Launch rankings activity
     */
    public void launchRankings(){
        startActivity(new Intent(this,Working.class));
    }

    /**
     * Launch messages activity
     */
    public void launchMessages(){
        startActivity(new Intent(this,Working.class));
    }

    /**
     * Launch profile activity
     */
    public void launchProfile(){
        startActivity(new Intent(this,Profile.class));
    }

    /**
     * Open in progress tournaments
     */
    public void inProgressTournaments(){
        startActivity(new Intent(this,ListTournamentsInProgress.class));
    }

    /**
     * Finish the activity, clean the SharedPreferences Username
     */
    public void logout(){
        Log.i("SharedPreferences","Cleaning Username");
        SharedPreferences prefs = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("marvinName","null");
        editor.commit();
        startActivity( new Intent(this,LoginForm.class));
        this.finish();
    }

    /**
     * Load the username from SharedPreferences
     */
    public String loadUserName(){
        Log.i("SharedPreferences","Loading Username");
        SharedPreferences prefs = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        return prefs.getString("marvinName","");
    }
}
