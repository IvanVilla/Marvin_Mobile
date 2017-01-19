package com.example.klaussius.marvin_mobile;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import data.QueryCreateAccount;
import model.user.User;

public class EulaForm extends AppCompatActivity {

    Button btContinue, btCancel;
    CheckBox cbAcceptPublicity, cbAcceptConditions;
    String publicName, name, eMail, phone, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eula_form);
        // We read the intent vars
        Intent myIntent = getIntent();
        name = myIntent.getStringExtra("name");
        publicName = myIntent.getStringExtra("publicName");
        password = myIntent.getStringExtra("password");
        eMail = myIntent.getStringExtra("eMail");
        phone = myIntent.getStringExtra("phone");
        // Buttons
        btContinue = (Button)findViewById(R.id.btContinue);
        btContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });
        btCancel = (Button)findViewById(R.id.btCancel);
        btCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                close();
            }
        });
        // Checkboxes
        cbAcceptConditions = (CheckBox)findViewById(R.id.cbAcceptConditions);
        cbAcceptConditions.setChecked(false);
        cbAcceptPublicity = (CheckBox)findViewById(R.id.cbAcceptPublicity);
        cbAcceptPublicity.setChecked(true);
    }

    /**
     * Close the activity
     */
    private void close (){
        this.finish();
    }

    /**
     * If the conditions are checked we query for the insertion...
     */
    private void signIn(){
        if (cbAcceptConditions.isChecked()){
            // We do the insert
            User user = new User();
            user.setName(name);
            user.setPublicName(publicName);
            user.setPassword(password);
            user.seteMail(eMail);
            user.setPhone(phone);
            user.setAds(cbAcceptPublicity.isChecked());
            QueryCreateAccount queryCreateAccount = new QueryCreateAccount(user);
            queryCreateAccount.executeQuery();
            Log.i("Insert",user.getName()+", "+user.getPublicName()+", "+user.getPassword()+", "+user.getPhone()+", "+user.getAds());
            // We close the activity
            startActivity(new Intent(this,LoginForm.class));
            QueryCreateAccount createAccount = new QueryCreateAccount(user);
            createAccount.executeQuery();
            this.finish();
        } else {
            toastMessage(getString(R.string.acceptEULA));
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
}
