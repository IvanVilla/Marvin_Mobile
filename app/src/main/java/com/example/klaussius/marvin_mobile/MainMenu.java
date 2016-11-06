package com.example.klaussius.marvin_mobile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Main menu activity
 */
public class MainMenu extends AppCompatActivity {

    Button btHosts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        btHosts = (Button)findViewById(R.id.btHosts);
        btHosts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchHosts();
            }
        });
    }

    public void launchHosts(){
        Intent myIntent = new Intent(this,Hosts.class);
        startActivity(myIntent);
    }
}
