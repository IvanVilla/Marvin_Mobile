package com.example.klaussius.marvin_mobile;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import data.QueryCreateAccount;
import data.QueryExistsUser;
import model.user.User;

/**
 * Form to sign in as new user
 * @author Iván Villa
 */
public class SignInForm extends AppCompatActivity {
    Button btClear, btSignIn, btCancel;
    EditText etPublicName, etName, etPassword, etPasswordAgain, etEmail, etPhone;

    /**
     * Inicialices the parameters and controls
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        // Inicializo los campos de texto
        etPublicName = (EditText)findViewById(R.id.etPublicName);
        etName = (EditText)findViewById(R.id.etName);
        etPassword = (EditText)findViewById(R.id.etPassword);
        etPasswordAgain = (EditText)findViewById(R.id.etPasswordAgain);
        etEmail = (EditText)findViewById(R.id.etEmail);
        etPhone = (EditText)findViewById(R.id.etPhone);
        // Inicializo botón de limpieza y añado listener
        btClear = (Button)findViewById(R.id.btClear);
        btClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clear();
            }
        });
        // Inicializo botón de aceptar y añado listener
        btSignIn = (Button)findViewById(R.id.btSignIn);
        btSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });
        // Inicializo botón de cancelar y añado listener
        btCancel = (Button)findViewById(R.id.btCancel);
        btCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancel();
            }
        });
    }

    /**
     * Clean the form
     */
    public void clear(){
        etPublicName.setText("");
        etName.setText("");
        etPassword.setText("");
        etPasswordAgain.setText("");
        etEmail.setText("");
    }

    /**
     * Acceps the form
     */
    public void signIn(){
        QueryExistsUser queryExistsUser = new QueryExistsUser(etName.getText().toString());
        queryExistsUser.exitsUser();
        if (queryExistsUser.getExists()){
            // If the user name exits already, we dont do the insert
            Toast toast = Toast.makeText(getApplicationContext(),"Sorry, the user with that name exists.", Toast.LENGTH_SHORT);
            toast.show();
            etPublicName.setText("");
        } else if (!etPassword.getText().toString().equals(etPasswordAgain.getText().toString())){
            Log.i("Passwords matchs",etPassword.getText().toString()+"="+etPasswordAgain.getText().toString());
            // If the password fields dont match between them, we dont do the insert
            Toast toast = Toast.makeText(getApplicationContext(),"Sorry, the passwords dont match.", Toast.LENGTH_SHORT);
            toast.show();
        } else {
            // We do the insert
            Log.i("Insert","All is fine, we do the insert!");
            User user = new User();
            user.setName(etName.getText().toString());
            user.setPublicName(etPublicName.getText().toString());
            user.setPassword(etPassword.getText().toString());
            user.seteMail(etEmail.getText().toString());
            user.setPhone(etPhone.getText().toString());
            QueryCreateAccount queryCreateAccount = new QueryCreateAccount(user);
            queryCreateAccount.createAccount();
            // We close the activity
            this.finish();
        }
    }

    /**
     * Cancel the form
     */
    public void cancel() { this.finish(); }

}