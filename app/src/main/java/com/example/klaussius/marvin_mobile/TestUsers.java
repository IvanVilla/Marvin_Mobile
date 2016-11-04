package com.example.klaussius.marvin_mobile;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.List;

import model.user.User;
import persistance.UserDAO.HTTPRequestUserDAO;

/**
 * Activity to test connections
 */
public class TestUsers extends AppCompatActivity {

    public TextView tvHost;
    public String texto="Lista de Users...\n";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_users);
        tvHost = (TextView)findViewById(R.id.tvHost);
        try {
            takeTheHostList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        tvHost.setText(this.texto);
    }

    public void takeTheHostList() throws Exception {
        HTTPRequestUserDAO requestUser = new HTTPRequestUserDAO();
        List<User> users = requestUser.findAll();
        this.texto=this.texto+"\nHay "+users.size()+" usuarios.";
    }
}