/*
 * MAGRATHEA - DAM
 */
package model.tournament;

import model.user.Team;

/**
 * Store a team as player. Inherits from TournamentPlayer
 * @author Iván Villa
 */
public class PlayerTeam extends TournamentPlayer{
    private Team player;
    
    /**
     * Constructor with parameters
     * @param player team
     * @param rank ranking
     */
    public PlayerTeam(Team player, int rank) {
        super(rank);
        this.player = player;
    }

    /**
     * Constructor simle
     */
    public PlayerTeam() {
    }

    // GETTERS AND SETTERS

    /**
     * Get team
     * @return team
     */
    public Team getPlayer() {
        return player;
    }

    /**
     * Set team
     * @param player team
     */
    public void setPlayer(Team player) {
        this.player = player;
    }
    
    @Override
    public String toString(){
        return player.getDescription();
    }
}
