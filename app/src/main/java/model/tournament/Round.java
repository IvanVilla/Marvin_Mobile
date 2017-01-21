/*
 * MAGRATHEA - DAM
 */
package model.tournament;

import java.util.ArrayList;

/**
 * Store the rounds
 * @author Iván Villa
 */
public class Round {
    private int roundNumber;
    private ArrayList <Match> matches;
    private String roundType;
    private boolean finished;

    /**
     * Constructor with parameters
     * @param roundNumber round number
     * @param matches matches
     * @param roundType type
     */
    public Round(int roundNumber, ArrayList<Match> matches, String roundType, boolean finished) {
        this.roundNumber = roundNumber;
        this.matches = matches;
        this.roundType = roundType;
        this.finished = finished;
    }

    /**
     * Constructor simple
     */
    public Round() {
        matches = new ArrayList<>();
        this.finished = false;
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

    /**
     * We know if it's finished
     * @return if it's finished
     */
    public boolean isFinished() {
        return finished;
    }

    /**
     * We set state for the round
     * @param finished (true: finished, false: not)
     */
    public void setFinished(boolean finished) {
        this.finished = finished;
    }
}
