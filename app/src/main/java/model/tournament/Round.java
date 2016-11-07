/*
 * MAGRATHEA - DAM
 */
package model.tournament;

import java.util.ArrayList;

/**
 * Store the rounds
 * @author Klaussius
 */
public class Round {
    private int roundNumber;
    private ArrayList <Match> matches;
    private String roundType;

    /**
     * Constructor with parameters
     * @param roundNumber round number
     * @param matches matches
     * @param roundType type
     */
    public Round(int roundNumber, ArrayList<Match> matches, String roundType) {
        this.roundNumber = roundNumber;
        this.matches = matches;
        this.roundType = roundType;
    }

    /**
     * Constructor simple
     */
    public Round() {
    }
    
    // GETTERS AND SETTERS
    
    /**
     * Get round number
     * @return round number
     */
    public int getRoundNumber() {
        return roundNumber;
    }

    /**
     * Set round number
     * @param roundNumber round number
     */
    public void setRoundNumber(int roundNumber) {
        this.roundNumber = roundNumber;
    }

    /**
     * Get round matches
     * @return round matches
     */
    public ArrayList<Match> getMatches() {
        return matches;
    }

    /**
     * Set round matches
     * @param matches round matches
     */
    public void setMatches(ArrayList<Match> matches) {
        this.matches = matches;
    }

    /**
     * Get round type
     * @return round type
     */
    public String getRoundType() {
        return roundType;
    }

    /**
     * Set round type
     * @param roundType round type
     */
    public void setRoundType(String roundType) {
        this.roundType = roundType;
    }    
    
}
