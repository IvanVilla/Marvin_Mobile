package com.example.klaussius.marvin_mobile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import tools.Match2p;

/**
 * For Tournament in Progress, we create a custom adapter to use it.
 * Using this guide: https://guides.codepath.com/android/Using-an-ArrayAdapter-with-ListView
 * Created by Klaussius on 21/01/2017.
 */
public class MatchAdapter extends ArrayAdapter<Match2p> {

    public MatchAdapter(Context context, ArrayList<Match2p> match2ps) {
        super(context, 0, match2ps);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        final Match2p match2p = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_2p_match, parent, false);
        }
        // Lookup view for data population
        final TextView tvNamePlayer1 = (TextView)convertView.findViewById(R.id.tvNamePlayer1);
        final TextView tvNamePlayer2 = (TextView)convertView.findViewById(R.id.tvNamePlayer2);
        final TextView tvPointsPlayer1 = (TextView)convertView.findViewById(R.id.tvPointsPlayer1);
        final TextView tvPointsPlayer2 = (TextView)convertView.findViewById(R.id.tvPointsPlayer2);
        Button btSum1 = (Button)convertView.findViewById(R.id.btSum1);
        Button btSub1 = (Button)convertView.findViewById(R.id.btSub1);
        Button btSum2 = (Button)convertView.findViewById(R.id.btSum2);
        Button btSub2 = (Button)convertView.findViewById(R.id.btSub2);

        // Populate the data into the template view using the data object
        tvNamePlayer1.setText(match2p.getP1());
        tvNamePlayer2.setText(match2p.getP2());
        tvPointsPlayer1.setText(match2p.getP1points()+"");
        tvPointsPlayer2.setText(match2p.getP2points()+"");

        // Button actions
        btSum1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                match2p.sumP1();
                tvPointsPlayer1.setText(match2p.getP1points()+"");
            }
        });
        btSum2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                match2p.sump2();
                tvPointsPlayer2.setText(match2p.getP2points()+"");
            }
        });
        btSub1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                match2p.subP1();
                tvPointsPlayer1.setText(match2p.getP1points()+"");
            }
        });
        btSub2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                match2p.subP2();
                tvPointsPlayer2.setText(match2p.getP2points()+"");
            }
        });
        // Return the completed view to render on screen
        return convertView;
    }
}
