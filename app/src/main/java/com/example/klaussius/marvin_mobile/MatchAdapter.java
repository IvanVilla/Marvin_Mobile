package com.example.klaussius.marvin_mobile;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import model.tournament.Match;
import model.tournament.PlayerIndividual;

/**
 * For Tournament in Progress, we create a custom adapter to use it.
 * Using this guide: https://guides.codepath.com/android/Using-an-ArrayAdapter-with-ListView
 * Created by Klaussius on 21/01/2017.
 */
public class MatchAdapter extends ArrayAdapter<Match> {

    /**
     * Constructor
     * @param context
     * @param matches
     */
    public MatchAdapter(Context context, ArrayList<Match> matches) {
        super(context,0, matches);

        for (Match match : matches){
            PlayerIndividual p1 = (PlayerIndividual) match.getMatchPlayer().get(0).getPlayer();
            PlayerIndividual p2 = (PlayerIndividual) match.getMatchPlayer().get(0).getPlayer();
            Log.i("Users",p1.getUser().getName()+" vs "+p2.getUser().getName());
        }
    }

    /**
     * For each item
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        final Match match = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_2p_match, parent, false);
        }
        // Lookup view for data population
        //... For player 1
        TextView tvNamePlayer1 = (TextView)convertView.findViewById(R.id.tvNamePlayer1);
        TextView tvPointsPlayer1 = (TextView)convertView.findViewById(R.id.tvPointsPlayer1);
        //...... Buttons
        Button btSum1 = (Button)convertView.findViewById(R.id.btSum1);
        Button btSub1 = (Button)convertView.findViewById(R.id.btSub1);
        //... For player 2
        TextView tvNamePlayer2 = (TextView)convertView.findViewById(R.id.tvNamePlayer2);
        TextView tvPointsPlayer2 = (TextView)convertView.findViewById(R.id.tvPointsPlayer2);
        //...... Buttons
        Button btSum2 = (Button)convertView.findViewById(R.id.btSum2);
        Button btSub2 = (Button)convertView.findViewById(R.id.btSub2);

        // We add button actions
        btSum1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                match.getMatchPlayer().get(0).sumPoint();
            }
        });
        btSub1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                match.getMatchPlayer().get(0).subPoint();
            }
        });
        btSum2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                match.getMatchPlayer().get(1).sumPoint();
            }
        });
        btSub2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                match.getMatchPlayer().get(1).subPoint();
            }
        });

        // Populate the data into the template view using the data object
        // Player 1
        PlayerIndividual p1 = (PlayerIndividual) match.getMatchPlayer().get(0).getPlayer();
        tvNamePlayer1.setText(p1.getUser().getName());
        tvPointsPlayer1.setText(match.getMatchPlayer().get(0).getPoints()+"");
        // Player 2
        PlayerIndividual p2 = (PlayerIndividual) match.getMatchPlayer().get(1).getPlayer();
        tvNamePlayer2.setText(p2.getUser().getName());
        tvPointsPlayer2.setText(match.getMatchPlayer().get(1).getPoints()+"");

        // Return the completed view to render on screen
        return convertView;
    }
}
