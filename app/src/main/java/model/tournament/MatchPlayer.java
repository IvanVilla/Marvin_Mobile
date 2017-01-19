/*
 * MAGRATHEA - DAM
 */
package model.tournament;

/**
 * Store the player of one tournament
 * @author Iván Villa
 */
public class MatchPlayer {
    private TournamentPlayer player;
    private int points;

    /**
     * Constructor with parameters
     * @param player name
     * @param points points
     */
    public MatchPlayer(TournamentPlayer player, int points) {
        this.player = player;
        this.points = points;
    }

    /**
     * Constructor simple
     */
    public MatchPlayer() {
    }
    
    // GETTERS AND SETTERS

    /**
     * Get player
     * @return player
     */
    public TournamentPlayer getPlayer() {
        return player;
    }

    /**
     * Set player
     * @param player player
     */
    public void setPlayer(TournamentPlayer player) {
        this.player = player;
    }

    /**
     * Get points
     * @return points
     */
    public int getPoints() {
        return points;
    }

    /**
     * Set points
     * @param points points
     */
    public void setPoints(int points) {
        this.points = points;
    }

    /**
     * To String
     * @return
     */
    public String toString(){
        return null;
    }
}
