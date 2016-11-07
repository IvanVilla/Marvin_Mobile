/*
 * MAGRATHEA - DAM
 */
package model.tournament;

/**
 * Store the player in a tournament
 * @author Klaussius
 */
public class TournamentPlayer {
    private int rank;

    /**
     * Constructor with parameters
     * @param rank rank of the player
     */
    public TournamentPlayer(int rank) {
        this.rank = rank;
    }
    
    /**
     * Constructor simple
     */
    public TournamentPlayer() {
    }

    // GETTERS AND SETTERS

    /**
     * Get the ranking of the player
     * @return the ranking of the player
     */
    public int getRank() {
        return rank;
    }

    /**
     * Set the ranking of the player
     * @param rank the ranking of the player
     */
    public void setRank(int rank) {
        this.rank = rank;
    }
    
    
}
