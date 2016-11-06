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
    }

    public void launchTournaments(){
        Intent myIntent = new Intent(this,ListTournaments.class);
        startActivity(myIntent);
    }

    public void launchHosts(){
        Intent myIntent = new Intent(this,ListHosts.class);
        startActivity(myIntent);
    }
}
