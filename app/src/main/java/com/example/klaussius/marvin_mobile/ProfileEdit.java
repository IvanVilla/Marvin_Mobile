package com.example.klaussius.marvin_mobile;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import data.QueryExistsUser;
import data.QueryModifyProfile;
import data.QueryUserProfile;
import model.user.User;

/**
 * Edit of the profile
 */
public class ProfileEdit extends AppCompatActivity {

    TextView tvPublicNameInfo, tvNameInfo, tvPasswordInfo, tvRepeatPasswordInfo, tvPhoneInfo, tvEmailInfo;
    EditText etName, etPassword, etRepeatPassword, etPhone, etEmail;
    Button btAccept, btClear, btCancel;

    User user; // Profile user

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_edit);
        // TextViews
        tvPublicNameInfo = (TextView)findViewById(R.id.tvPublicNameInfo);
        tvNameInfo = (TextView)findViewById(R.id.tvNameInfo);
        tvPasswordInfo = (TextView)findViewById(R.id.tvPasswordInfo);
        tvRepeatPasswordInfo = (TextView)findViewById(R.id.tvRepeatPasswordInfo);
        tvPhoneInfo = (TextView)findViewById(R.id.tvPhoneInfo);
        tvEmailInfo = (TextView)findViewById(R.id.tvEmailInfo);
        // EditText
        etName = (EditText)findViewById(R.id.etName);
        etPassword = (EditText)findViewById(R.id.etPassword);
        etRepeatPassword = (EditText)findViewById(R.id.etPasswordAgain);
        etPhone = (EditText)findViewById(R.id.etPhone);
        etEmail = (EditText)findViewById(R.id.etEmail);
        // We load the profile of our user and we show it on the screen
        loadProfile();
        tvPublicNameInfo.setText(user.getPublicName());
        etName.setText(user.getName());
        etPassword.setText(user.getPassword());
        etRepeatPassword.setText(user.getPassword());
        etPhone.setText(user.getPhone());
        etEmail.setText(user.geteMail());
        // Adding some control
        if(etName.getText().toString().length()==0){
            etName.setError(getString(R.string.nameRequired));
        }
        if(etEmail.getText().toString().length()==0){
            etEmail.setError(getString(R.string.eMailRequired));
        }
        if(etPhone.getText().toString().length()==0){
            etPhone.setError(getString(R.string.phoneNumberRequired));
        }
        // Buttons
        btAccept=(Button)findViewById(R.id.btAccept);
        btAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateProfile();
            }
        });
        btCancel=(Button)findViewById(R.id.btCancel);
        btCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancel();
            }
        });
        btClear=(Button)findViewById(R.id.btClear);
        btClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clear();
            }
        });
        // Focus to the first element
        etName.requestFocus();
    }

    /**
     * If you clear, the fields will be blank
     */
    private void clear(){
        etName.setText("");
        etPassword.setText("");
        etRepeatPassword.setText("");
        etEmail.setText("");
        etPhone.setText("");
    }

    /**
     * If you cancel, the activity finish
     */
    private void cancel(){
        startActivity(new Intent(this,Profile.class));
        this.finish();
    }

    /**
     * Validate and update the profile
     */
    private void updateProfile(){
        QueryExistsUser queryExistsUser = new QueryExistsUser(etName.getText().toString());
        queryExistsUser.executeQuery();
        // Conditions review before of doing the the insert
        if (!etPassword.getText().toString().equals(etRepeatPassword.getText().toString())) {
            toastMessage(getString(R.string.passwordNotMatch));
        }else if (etName.getText().toString().length()==0) {
            toastMessage(getString(R.string.nameRequired));
        }else if (etEmail.getText().toString().length()==0) {
            getString(R.string.eMailRequired);
        }else if (etPhone.getText().toString().length()==0) {
            getString(R.string.phoneNumberRequired);
        } else {
            if (etPassword.getText().toString().equals("")) {
                toastMessage(getString(R.string.passwordWillBeSame));
            }
            // We do the insert
            Log.i("Update","All is fine, we do the update!");
            user.setName(etName.getText().toString());
            user.setPassword(etPassword.getText().toString());
            user.seteMail(etEmail.getText().toString());
            user.setPhone(etPhone.getText().toString());
            QueryModifyProfile queryModifyProfile = new QueryModifyProfile(user);
            queryModifyProfile.executeQuery();
            // We close the activity
            startActivity(new Intent(this,Profile.class));
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
     * Load the profile of the current user
     */
    private void loadProfile(){
        user = new QueryUserProfile(loadUserName()).getQueryResult();
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
