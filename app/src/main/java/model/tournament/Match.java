/*
 * MAGRATHEA - DAM
 */
package model.tournament;

import java.util.ArrayList;

/**
 * Almacena un encuentro y su resultado
 * @author Klaussius
 */
public class Match {
    private ArrayList <MatchPlayer> matchPlayer;

    /**
     * Constructor con parámetros
     * @param matchPlayer lista de jugadores de una partida
     */
    public Match(ArrayList<MatchPlayer> matchPlayer) {
        this.matchPlayer = matchPlayer;
    }

    /**
     * Constructor sin parámetros
     */
    public Match() {
    }

    // GETTERS Y SETTERS

    /**
     * Devuelve el jugadro de un encuentro
     * @return jugador
     */
    public ArrayList<MatchPlayer> getMatchPlayer() {
        return matchPlayer;
    }

    /**
     * Fija el jugador de un encuentro
     * @param matchPlayer jugador
     */
    public void setMatchPlayer(ArrayList<MatchPlayer> matchPlayer) {
        this.matchPlayer = matchPlayer;
    }
    
}
