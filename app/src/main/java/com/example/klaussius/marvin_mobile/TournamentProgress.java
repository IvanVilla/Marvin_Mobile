package com.example.klaussius.marvin_mobile;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

import data.FakeTournamentData;
import model.tournament.Match;
import model.tournament.Tournament;

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
        tournament = new FakeTournamentData().getTournament();
        ArrayList<Match> matches = tournament.getRounds().get(roundNumber).getMatches();
        MatchAdapter matchAdapter = new MatchAdapter(this, matches);
        lvMatches.setAdapter(matchAdapter);
    }
}
