package com.example.klaussius.marvin_mobile;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import data.FakeTournamentData;
import model.tournament.Match;
import model.tournament.PlayerIndividual;
import model.tournament.Tournament;

public class TournamentProgress extends AppCompatActivity {
    Tournament tournament;
    int roundNumber;
    ListView matchList;
    TextView tvMatches;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tournament_progress);
        tvMatches = (TextView)findViewById(R.id.tvMatches);
        roundNumber = Integer.parseInt(getIntent().getStringExtra("round"));
        tournament = new FakeTournamentData().getTournament();
        tvMatches.setText(listMatches());
    }

    public String listMatches(){
        String result="";
        for (int i = 0; i<tournament.getRounds().size(); i++){
            result+="\nRONDA"+(i+1)+"\n";
            for (Match match : tournament.getRounds().get(roundNumber).getMatches()){
                PlayerIndividual player1 = (PlayerIndividual) match.getMatchPlayer().get(0).getPlayer();
                PlayerIndividual player2 = (PlayerIndividual) match.getMatchPlayer().get(1).getPlayer();
                result += player1.getPlayer().getName() + " vs " + player2.getPlayer().getName()+"\n";
            }
        }
        return result;
    }
}
