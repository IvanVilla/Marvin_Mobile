/*
 * MAGRATHEA - DAM
 */
package model.tournament;

import java.util.ArrayList;

/**
 * Store one match data
 * @author Klaussius
 */
public class Match {
    private ArrayList <MatchPlayer> matchPlayer;

    /**
     * Constructor with parameters
     * @param matchPlayer list of players
     */
    public Match(ArrayList<MatchPlayer> matchPlayer) {
        this.matchPlayer = matchPlayer;
    }

    /**
     * Constructor simple
     */
    public Match() {
    }

    // GETTERS AND SETTERS

    /**
     * Return player
     * @return player
     */
    public ArrayList<MatchPlayer> getMatchPlayer() {
        return matchPlayer;
    }

    /**
     * Set player
     * @param matchPlayer player
     */
    public void setMatchPlayer(ArrayList<MatchPlayer> matchPlayer) {
        this.matchPlayer = matchPlayer;
    }
    
}
