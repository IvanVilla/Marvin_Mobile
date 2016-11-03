/*
 * MAGRATHEA - DAM
 */
package model.tournament;

/**
 * Almacena el jugador de un encuentro, pueden ser equipos o individuos
 * @author Klaussius
 */
public class MatchPlayer {
    private TournamentPlayer player;
    private int points;

    /**
     * Constructor con parámetros
     * @param player nombre del jugador
     * @param points puntos del jugador
     */
    public MatchPlayer(TournamentPlayer player, int points) {
        this.player = player;
        this.points = points;
    }

    /**
     * Constructor sin parámetros
     */
    public MatchPlayer() {
    }
    
    // GETTERS Y SETTERS

    /**
     * Devuelve el jugador de un encuentro
     * @return jugador
     */
    public TournamentPlayer getPlayer() {
        return player;
    }

    /**
     * Guarda el jugador de un encuentro
     * @param player jugador
     */
    public void setPlayer(TournamentPlayer player) {
        this.player = player;
    }

    /**
     * Devuelve los puntos del juegador de un encuentro
     * @return puntos del encuentro
     */
    public int getPoints() {
        return points;
    }

    /**
     * Guarda los puntos del jugador en el encuentro
     * @param points puntos del encuentro
     */
    public void setPoints(int points) {
        this.points = points;
    }    
    
}
