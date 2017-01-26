package com.example.klaussius.marvin_mobile;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import data.QueryUserPrizes;
import data.QueryUserProfile;
import model.user.User;

/**
 * The profile of the user
 * @author Iván Villa
 */
public class Profile extends AppCompatActivity {

    Button btEdit,btExit, btMainMenu, btDeleteMyUser;
    TextView tvName, tvPublicName, tvEmail, tvPhone, tvPrizeNumber, tvUnclaimedPrizes;
    ImageView ivPrizeBox;
    LinearLayout LiPrizes;

    //My User
    User user;
    //Prizes number
    int prizesNumber;

    /**
     * OnCreate initializes our parameters
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        //Get data from server
        user =new QueryUserProfile(loadUserName()).getQueryResult();
        //TextView user prizes
        tvPrizeNumber = (TextView)findViewById(R.id.tvPrizeNumber);
        tvUnclaimedPrizes = (TextView)findViewById(R.id.tvUnclaimedPrizes);

        //LinearLayout Prizes
        LiPrizes = (LinearLayout)findViewById(R.id.LiPrizes);

        //ImageView prizeBox
        //Retrieving our prizes
        QueryUserPrizes queryUserPrizes = new QueryUserPrizes(loadUserName());
        queryUserPrizes.executeQuery();
        prizesNumber = queryUserPrizes.getQueryResult().size();
        // Filling our fields
        ivPrizeBox = (ImageView)findViewById(R.id.ivPrizeBox);
        if(prizesNumber>0){
            LiPrizes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    prizes();
                }
            });
            ivPrizeBox.setImageResource(R.drawable.userhasprizes);
            tvPrizeNumber.setText(prizesNumber+"");
            if (prizesNumber==1){
                tvUnclaimedPrizes.setText(R.string.unclaimedPrizesSingular);
            }
        }

        //TextViews for name and email
        tvName = (TextView)findViewById(R.id.tvName);
        tvPublicName = (TextView)findViewById(R.id.tvPublicName);
        tvEmail = (TextView)findViewById(R.id.tvEMail);
        tvPhone = (TextView)findViewById(R.id.tvPhone);
        //Fill the fields
        tvName.setText(user.getName());
        tvPublicName.setText(user.getPublicName());
        tvEmail.setText(user.geteMail());
        tvPhone.setText(user.getPhone());
        //Button to edit
        btEdit = (Button)findViewById(R.id.btEdit);
        btEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit();
            }
        });
        //Button to exit
        btExit = (Button)findViewById(R.id.btExit);
        btExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exit();
            }
        });
        //Button for main menú
        btMainMenu = (Button)findViewById(R.id.btMainMenu);
        btMainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainMenu();
            }
        });
        //Button for user delection
        btDeleteMyUser = (Button)findViewById(R.id.btDeleteMyUser);
        btDeleteMyUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteMyUser();
            }
        });
    }


    /**
     * Load the username from SharedPreferences
     */
    public String loadUserName(){
        SharedPreferences prefs = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        Log.i("Shared name",prefs.getString("marvinName",""));
        return prefs.getString("marvinName","");
    }

    /**
     * Begins the edit activity
     */
    private void edit(){
        startActivity(new Intent(this,ProfileEdit.class));
        this.finish();
    }

    /**
     * Open the main menú
     */
    private void mainMenu(){
        startActivity(new Intent(this,MainMenu.class));
        this.finish();
    }

    /**
     * Open the delete user menu
     */
    private void deleteMyUser(){
        startActivity(new Intent(this,ProfileDeleteConfirmation.class));
        this.finish();
    }

    private void prizes(){
        startActivity(new Intent(this,PrizesList.class));
    }

    /**
     * Finish current activity
     */
    private void exit(){
        Log.i("SharedPreferences","Cleaning Username");
        SharedPreferences prefs = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("marvinName","null");
        editor.commit();
        this.finish();
    }
}
