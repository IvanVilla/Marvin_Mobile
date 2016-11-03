/*
 * MAGRATHEA - DAM
 */
package model.tournament;

import model.users.Team;

/**
 * Almacena un jugador - equipo
 * @author Klaussius
 */
public class PlayerTeam extends TournamentPlayer{
    private Team player;
    
    /**
     * Constructor con parámetros
     * @param player equipo de jugadores
     * @param rank ranking final del equipo
     */
    public PlayerTeam(Team player, int rank) {
        super(rank);
        this.player = player;
    }

    /**
     * Constructor sin parámetros
     */
    public PlayerTeam() {
    }

    // GETTERS Y SETTERS

    /**
     * Devuelve el equipo jugador
     * @return equipo jugador
     */
    public Team getPlayer() {
        return player;
    }

    /**
     * Guarda el equipo jugador
     * @param player equipo jugador
     */
    public void setPlayer(Team player) {
        this.player = player;
    }
    
    
}
