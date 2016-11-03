/*
 * MAGRATHEA - DAM
 */
package model.tournament;

/**
 * Almacena un jugador de un torneo
 * @author Klaussius
 */
public class TournamentPlayer {
    private int rank;

    /**
     * Constructor con parámetros
     * @param rank lugar en el ranking del jugador en el torneo
     */
    public TournamentPlayer(int rank) {
        this.rank = rank;
    }
    
    /**
     * Constructor sin parámetros
     */
    public TournamentPlayer() {
    }

    // GETTERS Y SETTERS

    /**
     * Devuelve el rnaking de un jugador en el torneo
     * @return el ranking del jugador en el torneo
     */
    public int getRank() {
        return rank;
    }

    /**
     * Guarda el ranking de un jugador en el torneo
     * @param rank ranking del jugador en el torneo
     */
    public void setRank(int rank) {
        this.rank = rank;
    }
    
    
}
