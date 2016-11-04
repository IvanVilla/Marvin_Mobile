package com.example.klaussius.marvin_mobile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMenu extends AppCompatActivity {

    Button btHostTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        btHostTest = (Button)findViewById(R.id.btHostTest);
        btHostTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchHosts();
            }
        });
    }

    public void launchHosts(){
        Intent myIntent = new Intent(this,TestHost.class);
        startActivity(myIntent);
    }
}
