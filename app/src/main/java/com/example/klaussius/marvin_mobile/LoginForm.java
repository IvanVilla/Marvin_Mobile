package com.example.klaussius.marvin_mobile;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import data.QueryExistsUser;
import tools.LogIn;

/**
 * Activity with a login form
 * @author Iván Villa
 */
public class LoginForm extends AppCompatActivity {

    Button btLogin,btSignIn;
    EditText etName;
    EditText etPassword;

    /**
     * On create
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        // If we have one logged user, we go to profile directly
        if(loadUserName()!="null"){
            // If there is user with that name
            QueryExistsUser queryExistsUser = new QueryExistsUser(loadUserName());
            queryExistsUser.executeQuery();
            if (queryExistsUser.getExists()){
                startActivity(new Intent(this, Profile.class));
            }
        }
    }

    /**
     * On create: build our controls
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_menu, menu);

        // Text Fields
        etName = (EditText)findViewById(R.id.etName);
        etPassword = (EditText)findViewById(R.id.etPassword);
        // LoginForm button and listener
        btLogin = (Button)findViewById(R.id.btLogin);
        btLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                login();
            }
        });
        // Sign in button and listener
        btSignIn = (Button)findViewById(R.id.btSignIn);
        btSignIn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                signIn();
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Clean the form
     */
    public void clearForm(){
        etName.setText("");
        etPassword.setText("");
    }

    /**
     * Go to login action
     */
    public void login(){
        String userName = etName.getText().toString();
        String userPassword = etPassword.getText().toString();
        // If there is user with that name
        QueryExistsUser queryExistsUser = new QueryExistsUser(userName);
        queryExistsUser.executeQuery();
        if (queryExistsUser.getExists()){
            // We try the user/password combination
            LogIn myLogin = new LogIn(userName,userPassword);
            if (myLogin.login()){
                saveUserName(userName);
                startActivity(new Intent(this, Profile.class));
            } else {
                toastMessage(getString(R.string.incorrectLogin));
                etPassword.setText("");
            }
        } else {
            toastMessage(getString(R.string.userDoesntExists));
        }
    }

    /**
     * SignIn action
     */
    public void signIn(){
        clearForm();
        startActivity(new Intent(this, SignInForm.class));
    }

    /**
     * Store the username we are using on sharedpreferences
     */
    public void saveUserName(String username){
        Log.i("Shared name",username);
        SharedPreferences prefs = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("marvinName",username);
        editor.commit();
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
        Log.i("SharedPreferences","Loading Username");
        SharedPreferences prefs = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        return prefs.getString("marvinName","");
    }

    /**
     * Testing feeature
     */
    public void testFeature() {
    }
}