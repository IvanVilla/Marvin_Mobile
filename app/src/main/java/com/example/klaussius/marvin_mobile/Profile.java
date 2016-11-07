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

import model.user.User;
import simulateServer.QueryUserProfile;

public class Profile extends AppCompatActivity {

    Button btEdit;
    Button btExit;
    TextView tvUsername;
    TextView tvUserPassword;
    TextView tvEmail;

    //Retrieve server data
    QueryUserProfile myData;

    //My User
    User myUser;

    /**
     * OnCreate initializes our parameters
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        //Get data from server
        myData = new QueryUserProfile();
        myUser=myData.getUser(loadUserName());
        //TextViews
        tvUsername = (TextView)findViewById(R.id.tvUsername);
        tvUserPassword = (TextView)findViewById(R.id.tvUserPassword);
        tvEmail = (TextView)findViewById(R.id.tvEMail);
        //Fill the fields
        tvUsername.setText(myUser.getPublicName());
        tvUserPassword.setText(myUser.getPassword());
        tvEmail.setText(myUser.geteMail());
        //Button to edit
        btEdit = (Button)findViewById(R.id.btEdit);
        btEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit();
            }
        });
        //Button to exit
        btExit = (Button)findViewById(R.id.btExit);
        btExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exit();
            }
        });
    }

    /**
     * Load the username from SharedPreferences
     */
    public String loadUserName(){
        Log.i("SharedPreferences","Loading Username");
        SharedPreferences prefs = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        return prefs.getString("marvinName","");
    }

    /**
     * Begins the edit activity
     */
    private void edit(){
        Intent myIntent = new Intent(this,Working.class);
        startActivity(myIntent);
    }

    /**
     * Finish current activity
     */
    private void exit(){
        this.finish();
    }
}
