package com.example.klaussius.marvin_mobile;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

import data.FakeTournamentData;
import model.tournament.Match;
import model.tournament.Tournament;
import tools.Match2p;

public class TournamentProgress extends AppCompatActivity {
    Tournament tournament;
    int roundNumber;
    ListView lvMatches;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tournament_progress);
        // My listview
        lvMatches = (ListView)findViewById(R.id.lvMatches);
        roundNumber = Integer.parseInt(getIntent().getStringExtra("round"));
        // I retrieve the fake data
        tournament = new FakeTournamentData().getTournament();
        ArrayList<Match> matches = tournament.getRounds().get(roundNumber).getMatches();
        // I make the arraylist for the adapter
        ArrayList<Match2p> match2ps = new ArrayList<>();
        MatchAdapter matchAdapter =  new MatchAdapter(this,match2ps);
        lvMatches.setAdapter(matchAdapter);
        for (Match match:matches){
            matchAdapter.add(new Match2p(match));
        }
    }
}
