package com.example.klaussius.marvin_mobile;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import persistanceDAO.UserDAO.HTTPRequestUserDAO;

/**
 * Activity to test connections
 */
public class TestUsers extends AppCompatActivity {

    public TextView tvHost;
    public String texto="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_users);
        tvHost = (TextView) findViewById(R.id.tvHost);
        HTTPRequestUserDAO myRequest = new HTTPRequestUserDAO();
        myRequest.findAll();
        tvHost.setText("Hay "+myRequest.getUserList().size()+" usuarios.");
    }
}