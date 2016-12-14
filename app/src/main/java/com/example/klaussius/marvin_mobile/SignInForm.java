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
        // Inicializates the text fields
        etPublicName = (EditText)findViewById(R.id.etPublicName);
        etName = (EditText)findViewById(R.id.etName);
        etPassword = (EditText)findViewById(R.id.etPassword);
        etPasswordAgain = (EditText)findViewById(R.id.etPasswordAgain);
        etEmail = (EditText)findViewById(R.id.etEmail);
        etPhone = (EditText)findViewById(R.id.etPhone);
        // Adding some control
        if(etPublicName.getText().toString().length()==0){
            etPublicName.setError(getString(R.string.publicNameRequired));
        }
        if(etName.getText().toString().length()==0){
            etName.setError(getString(R.string.nameRequired));
        }
        if(etPassword.getText().toString().length()==0){
            etPassword.setError(getString(R.string.passwordRequired));
        }
        if(etPasswordAgain.getText().toString().length()==0){
            etPasswordAgain.setError(getString(R.string.passwordRequired));
        }
        if(etEmail.getText().toString().length()==0){
            etEmail.setError(getString(R.string.eMailRequired));
        }
        if(etPhone.getText().toString().length()==0){
            etPhone.setError(getString(R.string.phoneNumberRequired));
        }
        // Focus to the first element
        etPublicName.requestFocus();
        // Clear button
        btClear = (Button)findViewById(R.id.btClear);
        btClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clear();
            }
        });
        // Accept button
        btSignIn = (Button)findViewById(R.id.btSignIn);
        btSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });
        // Cancel button
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
     * Accepts the form
     */
    public void signIn(){
        QueryExistsUser queryExistsUser = new QueryExistsUser(etName.getText().toString());
        queryExistsUser.exitsUser();
        if (queryExistsUser.getExists()){
            // If the user name exits already, we dont do the insert
            Toast toast = Toast.makeText(getApplicationContext(),getString(R.string.nameExists), Toast.LENGTH_SHORT);
            toast.show();
            etPublicName.setText("");
        } else if (!etPassword.getText().toString().equals(etPasswordAgain.getText().toString())){
            Log.i("Passwords matchs",etPassword.getText().toString()+"="+etPasswordAgain.getText().toString());
            // If the password fields dont match between them, we dont do the insert
            Toast toast = Toast.makeText(getApplicationContext(),getString(R.string.passwordNotMatch), Toast.LENGTH_SHORT);
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