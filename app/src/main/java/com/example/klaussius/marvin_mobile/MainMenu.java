package com.example.klaussius.marvin_mobile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Main menu activity
 * @author Klaussius
 */
public class MainMenu extends AppCompatActivity {

    Button btTournaments;
    Button btHosts;
    Button btRankings;
    Button btMessages;
    Button btProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        //Button for Tournaments
        btTournaments = (Button)findViewById(R.id.btTournaments);
        btTournaments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchTournaments();
            }
        });
        //Button for Hosts
        btHosts = (Button)findViewById(R.id.btHosts);
        btHosts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchHosts();
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

    }

    /**
     * Launch tournaments activity
     */
    public void launchTournaments(){
        Intent myIntent = new Intent(this,ListTournaments.class);
        startActivity(myIntent);
    }

    /**
     * Launch hosts activity
     */
    public void launchHosts(){
        Intent myIntent = new Intent(this,ListHosts.class);
        startActivity(myIntent);
    }

    /**
     * Launch rankings activity
     */
    public void launchRankings(){
        Intent myIntent = new Intent(this,Working.class);
        startActivity(myIntent);
    }

    /**
     * Launch messages activity
     */
    public void launchMessages(){
        Intent myIntent = new Intent(this,Working.class);
        startActivity(myIntent);
    }

    /**
     * Launch profiles activity
     */
    public void launchProfile(){
        Intent myIntent = new Intent(this,Working.class);
        startActivity(myIntent);
    }
}
