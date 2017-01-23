package com.example.klaussius.marvin_mobile;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import data.QueryExistsUser;

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
        QueryExistsUser queryExistsUser = new QueryExistsUser(etPublicName.getText().toString());
        queryExistsUser.executeQuery();
        // Conditions review before of doing the the insert
        if (queryExistsUser.getExists()){
            toastMessage(getString(R.string.nameExists));
            etPublicName.setText("");
        } else if (!etPassword.getText().toString().equals(etPasswordAgain.getText().toString())) {
            toastMessage(getString(R.string.passwordNotMatch));
        }else if (etPublicName.getText().toString().length()==0) {
            toastMessage(getString(R.string.publicNameRequired));
        }else if (etPublicName.getText().toString().toLowerCase()=="null"){
            toastMessage(getString(R.string.publicNameNotNull));
        }else if (etName.getText().toString().length()==0) {
            toastMessage(getString(R.string.nameRequired));
        }else if (etPassword.getText().toString().length()==0) {
            toastMessage(getString(R.string.passwordRequired));
        }else if (etPasswordAgain.getText().toString().length()==0) {
            toastMessage(getString(R.string.passwordRequired));
        }else if (etEmail.getText().toString().length()==0) {
            getString(R.string.eMailRequired);
        }else if (etPhone.getText().toString().length()==0) {
            getString(R.string.phoneNumberRequired);
        } else {
            // We do the insert
            Log.i("Insert","All is fine, we go for the EULA form to do the insert!");
            // We open the EULA activity
            Intent eulaIntent = new Intent(this, EulaForm.class);
            eulaIntent.putExtra("name",etName.getText().toString());
            eulaIntent.putExtra("publicName",etPublicName.getText().toString());
            eulaIntent.putExtra("password",etPassword.getText().toString());
            eulaIntent.putExtra("eMail",etEmail.getText().toString());
            eulaIntent.putExtra("phone",etPhone.getText().toString());
            // We close the activity
            startActivity(eulaIntent);
            this.finish();
        }
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
     * Cancel the form
     */
    public void cancel() {
        startActivity(new Intent(this,LoginForm.class));
        this.finish();
    }

}