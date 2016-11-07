package com.example.klaussius.marvin_mobile;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Activity for not avaiable options
 */
public class Working extends AppCompatActivity {

    Button btTakeMeBack;

    /**
     * Create the activity
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_working);
        btTakeMeBack = (Button)findViewById(R.id.btTakeMeBack);
        btTakeMeBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeThis();
            }
        });
    }

    /**
     * Close this activity
     */
    public void closeThis(){
        this.finish();
    }
}
