/*
 * MAGRATHEA - DAM
 */
package model.tournament;

import java.util.ArrayList;

/**
 * Store one match data
 * @author Iván Villa
 */
public class Match {
    private ArrayList <MatchPlayer> matchPlayers;
    private int matchId;

    /**
     * Constructor with parameters
     * @param matchPlayers list of players
     */
    public Match(ArrayList<MatchPlayer> matchPlayers, int matchId) {
        this.matchPlayers = matchPlayers;
        this.matchId = matchId;
    }

    /**
     * Constructor simple
     */
    public Match() {
        matchPlayers = new ArrayList<>();
    }

    // GETTERS AND SETTERS

    /**
     * Return player
     * @return player
     */
    public ArrayList<MatchPlayer> getMatchPlayer() {
        return matchPlayers;
    }

    /**
     * Set player
     * @param matchPlayer player
     */
    public void setMatchPlayer(ArrayList<MatchPlayer> matchPlayer) {
        this.matchPlayers = matchPlayer;
    }

    /**
     * REturn id
     * @return id
     */
    public int getMatchId() {
        return matchId;
    }

    /**
     * Set id
     * @param matchId id
     */
    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }
}
