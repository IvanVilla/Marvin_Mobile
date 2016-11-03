/*
 * MAGRATHEA - DAM
 */
package model.tournament;

import java.util.ArrayList;

/**
 * Almacena las rondas de un torneo
 * @author Klaussius
 */
public class Round {
    private int roundNumber;
    private ArrayList <Match> matches;
    private String roundType;

    /**
     * Constructor con parámetros
     * @param roundNumber número de ronda
     * @param matches partidas de cada ronda
     * @param roundType tipo de ronda
     */
    public Round(int roundNumber, ArrayList<Match> matches, String roundType) {
        this.roundNumber = roundNumber;
        this.matches = matches;
        this.roundType = roundType;
    }

    /**
     * Constructor sin parámetros
     */
    public Round() {
    }
    
    // GETTERS y SETTERS
    
    /**
     * Devuelve el número de ronda
     * @return número de ronda
     */
    public int getRoundNumber() {
        return roundNumber;
    }

    /**
     * Guarda el número de ronda
     * @param roundNumber
     */
    public void setRoundNumber(int roundNumber) {
        this.roundNumber = roundNumber;
    }

    /**
     * Devuelve las partidas de una ronda
     * @return partidas de una ronda
     */
    public ArrayList<Match> getMatches() {
        return matches;
    }

    /**
     * Guarda las partidas de una ronda
     * @param matches partidas de una ronda
     */
    public void setMatches(ArrayList<Match> matches) {
        this.matches = matches;
    }

    /**
     * Devuelve el tipo de ronda
     * @return tipo de ronda
     */
    public String getRoundType() {
        return roundType;
    }

    /**
     * Guarda el tipo de ronda
     * @param roundType tipo de ronda
     */
    public void setRoundType(String roundType) {
        this.roundType = roundType;
    }    
    
}
