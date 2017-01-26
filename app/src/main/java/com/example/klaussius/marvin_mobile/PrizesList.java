package com.example.klaussius.marvin_mobile;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import data.QueryUserPrizes;
import model.benefit.Prize;

/**
 * Show our prizes list
 */
public class PrizesList extends AppCompatActivity {

    Button btTakeMeBack;
    ListView lvPrizes;
    ArrayList<Prize>prizes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prizes_list);

        //Retrieving our prizes
        QueryUserPrizes queryUserPrizes = new QueryUserPrizes(loadUserName());
        queryUserPrizes.executeQuery();
        prizes = queryUserPrizes.getQueryResult();
        String myPrizes[] = new String[queryUserPrizes.getQueryResult().size()];
        for (int i=0;i<myPrizes.length;i++){
            myPrizes[i]=prizes.get(i).getName()+"-"+prizes.get(i).getDescription();
        }
        // Create an arrayadapter
        lvPrizes = (ListView)findViewById(R.id.lvPrizes);
        ArrayAdapter<String> itemsAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,myPrizes);
        lvPrizes.setAdapter(itemsAdapter);

        //Button
        btTakeMeBack = (Button)findViewById(R.id.btTakeMeBack);
        btTakeMeBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                endActivity();
            }
        });
    }

    /**
     * Ends the activity
     */
    private void endActivity(){
        this.finish();
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
