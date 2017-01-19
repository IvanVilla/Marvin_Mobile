package com.example.klaussius.marvin_mobile;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import data.QueryDeleteAccount;

/**
 * This class is for confirmation the delete of one account
 */
public class ProfileDeleteConfirmation extends AppCompatActivity {

    Button btTakeMeBack;
    Button btYesDelete;

    /**
     * On create method
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_delete_confirmation);
        // Button for cancel the delection
        btTakeMeBack = (Button)findViewById(R.id.btTakeMeBack);
        btTakeMeBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeThis();
            }
        });
        // Button for confirm the delection
        btYesDelete = (Button)findViewById(R.id.btYesDelete);
        btYesDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteAccount();
            }
        });
    }

    /**
     * This method delete the account on the server side
     */
    public void deleteAccount(){
        QueryDeleteAccount queryDeleteAccount = new QueryDeleteAccount(loadUserName());
        queryDeleteAccount.executeQuery();
        startActivity(new Intent(this,LoginForm.class));
        this.finish();
    }

    /**
     * This method close the activity without changes
     */
    public void closeThis(){
        startActivity(new Intent(this,LoginForm.class));
        this.finish();
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