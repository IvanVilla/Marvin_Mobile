package com.example.klaussius.marvin_mobile;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import zFakeThings.LogInRealData;

/**
 * Activity with a login form
 * @author Klaussius
 */
public class LoginForm extends AppCompatActivity {

    Button btLogin;
    Button btSignIn;
    Button btExit;
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
        // Exit Button
        btExit = (Button)findViewById(R.id.btExit);
        btExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                endApp();
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
        // Comprobamos el login
        LogInRealData myLogin = new LogInRealData();
        // Leemos lo escrito por el usuario
        String userName = etName.getText().toString();
        String userPassword = etPassword.getText().toString();
        // Comprobamos
        String mensaje;
        if (myLogin.login(userName,userPassword)){
            Intent mainMenu = new Intent(this, MainMenu.class);
            startActivity(mainMenu);
        } else {
            Toast toast = Toast.makeText(getApplicationContext(),"Datos incorrectos.", Toast.LENGTH_SHORT);
            toast.show();
            etPassword.setText("");
        }
    }

    /**
     * SignIn action
     */
    public void signIn(){
        Intent signInForm = new Intent(this, SignInForm.class);
        clearForm();
        startActivity(signInForm);
    }

    /**
     * Exit action
     */
    public void endApp(){
        this.finish();
    }
}
