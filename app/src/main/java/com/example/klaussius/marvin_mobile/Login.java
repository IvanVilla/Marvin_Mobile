package com.example.klaussius.marvin_mobile;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import fakeThings.LoginInfo;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class Login extends AppCompatActivity {

    Button btLogin;
    EditText etName;
    EditText etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_menu, menu);
        // Campos de texto
        etName = (EditText)findViewById(R.id.etName);
        etPassword = (EditText)findViewById(R.id.etPassword);
        // Login button y listener
        btLogin = (Button)findViewById(R.id.btLogin);
        btLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                login();
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
     * Acción de pulsar el botón de Login
     */
    public void login(){
        // Objeto LoginInfo
        LoginInfo myLogin = new LoginInfo();
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
            etName.setText("");
            etPassword.setText("");
            toast.show();
        }
    }
}
