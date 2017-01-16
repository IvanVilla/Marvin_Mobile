package com.example.klaussius.marvin_mobile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class EulaForm extends AppCompatActivity {

    Button btContinue, btCancel;
    CheckBox cbAcceptPublicity, cbAcceptConditions;
    String publicName, name, eMail, phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eula_form);

        btContinue = (Button)findViewById(R.id.btContinue);
        btContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btCancel = (Button)findViewById(R.id.btCancel);
        btCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                close();
            }
        });

        cbAcceptConditions = (CheckBox)findViewById(R.id.cbAcceptConditions);
        cbAcceptPublicity = (CheckBox)findViewById(R.id.cbAcceptPublicity);
    }

    /**
     * Close the activity
     */
    private void close (){
        this.finish();
    }

    /**
     * If the conditions are checked we query for the insercion...
     */
    private void signIn(){

    }
}
