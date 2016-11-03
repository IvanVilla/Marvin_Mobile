/*
 * MAGRATHEA - DAM
 */
package model.tournament;

import model.user.User;

/**
 * Almacena un jugador individual
 * @author Klaussius
 */
public class PlayerIndividual extends TournamentPlayer{
    private User player;

    /**
     * Constructor con parámetros
     * @param player jugador individual
     * @param rank ranking final del jugador
     */
    public PlayerIndividual(User player, int rank) {
        super(rank);
        this.player = player;
    }

    /**
     * Constructor sin parámetros
     */
    public PlayerIndividual() {
    }

    // GETTERS Y SETTERS

    /**
     * Devuelve el jugador individual
     * @return jugador individual
     */
    public User getPlayer() {
        return player;
    }

    /**
     * Guarda el jugador individual
     * @param player jugador individual
     */
    public void setPlayer(User player) {
        this.player = player;
    }
    
}
