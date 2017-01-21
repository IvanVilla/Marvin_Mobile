package data;

import java.util.ArrayList;

import model.tournament.Match;
import model.tournament.MatchPlayer;
import model.tournament.PlayerIndividual;
import model.tournament.Round;
import model.tournament.Tournament;
import model.user.User;

/**
 * Created by Klaussius on 19/01/2017.
 */

public class FakeTournamentData {
    ArrayList<MatchPlayer> players;
    ArrayList<Round> rounds;
    Tournament tournament;

    /**
     * Default builder
     */
    public FakeTournamentData(){
        tournament = new Tournament();
        players = new ArrayList<>();
        rounds = new ArrayList<>();
        createData();
    }

    /**
     * Creates Users
     */
    private void createData(){
        for (int i=0; i<6; i++){
            players.add(createMatchPlayer("Id: "+(i+1)));
        }
        // Round 1
        Round round1 = new Round();
        round1.getMatches().add(createMatch(1,4));
        round1.getMatches().add(createMatch(2,5));
        round1.getMatches().add(createMatch(3,6));
        rounds.add(round1);
        // Round 2
        Round round2 = new Round();
        round2.getMatches().add(createMatch(1,6));
        round2.getMatches().add(createMatch(4,5));
        round2.getMatches().add(createMatch(2,3));
        rounds.add(round2);
        // Round 3
        Round round3 = new Round();
        round3.getMatches().add(createMatch(1,5));
        round3.getMatches().add(createMatch(6,3));
        round3.getMatches().add(createMatch(4,2));
        rounds.add(round3);
        // Round 4
        Round round4 = new Round();
        round4.getMatches().add(createMatch(1,3));
        round4.getMatches().add(createMatch(5,2));
        round4.getMatches().add(createMatch(6,4));
        rounds.add(round4);
        // Round 5
        Round round5 = new Round();
        round5.getMatches().add(createMatch(1,2));
        round5.getMatches().add(createMatch(3,4));
        round5.getMatches().add(createMatch(5,6));
        rounds.add(round5);
        // Adding the roudns to tournament
        tournament.setRounds(rounds);
    }

    /**
     * Create a MatchPlayer
     * @param name
     * @return
     */
    private MatchPlayer createMatchPlayer(String name){
        MatchPlayer matchPlayer = new MatchPlayer();
        User user = new User();
        user.setName(name);
        PlayerIndividual playerIndividual = new PlayerIndividual();
        playerIndividual.setPlayer(user);
        matchPlayer.setPlayer(playerIndividual);
        return matchPlayer;
    }

    /**
     * Create a match with two players
     * @param player1
     * @param player2
     * @return
     */
    private Match createMatch (int player1, int player2){
        Match match = new Match();
        match.getMatchPlayer().add(players.get(player1-1));
        match.getMatchPlayer().add(players.get(player2-1));
        return match;
    }

    /**
     * Return the tournament
     * @return tournament
     */
    public Tournament getTournament(){
        return tournament;
    }
}
