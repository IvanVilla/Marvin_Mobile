/*
 * MAGRATHEA - DAM
 */
package model.tournament;

/**
 * Almacena el sistema usado en un torneo
 * @author Klaussius
 */
public class System {
    private int id;
    private String name;
    private int maxPlayers;
    private int minPlayers;
    private int nRounds;
    private int nPlayoffs;
    private int matchPlayers;
    private int maxTeamPlayer;
    private PointSystem pointSystem;

    /**
     * Constructor con parámetros
     * @param id id del sistema
     * @param name nombre del sistema
     * @param maxPlayers máximo número de jugadores
     * @param minPlayers mínimo número de jugadores 
     * @param nRounds número de rondas de tipo liga
     * @param nPlayoffs número de playoffs
     * @param matchPlayers jugadores por cada partida
     * @param maxTeamPlayer máximo número de jugadores en cada equipo
     * @param pointSystem sistema de puntos utilizado
     */
    public System(int id, String name, int maxPlayers, int minPlayers, int nRounds, int nPlayoffs, int matchPlayers, int maxTeamPlayer, PointSystem pointSystem) {
        this.id = id;
        this.name = name;
        this.maxPlayers = maxPlayers;
        this.minPlayers = minPlayers;
        this.nRounds = nRounds;
        this.nPlayoffs = nPlayoffs;
        this.matchPlayers = matchPlayers;
        this.maxTeamPlayer = maxTeamPlayer;
        this.pointSystem = pointSystem;
    }

    /**
     * Constructor sin parámetros
     */
    public System() {
    }

    // GETTERS Y SETTERS

    /**
     * Devuelve la id del sistema de juego usado
     * @return id del sistema de juego usado
     */
    public int getId() {
        return id;
    }

    /**
     * Devuelve la id del sistema de juego usado
     * @param id id del sistema de juego usado
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Devuelve el nombre del sistema de juego usado
     * @return nombre
     */
    public String getName() {
        return name;
    }

    /**
     * Guarda el nombre del sistema de juego usado
     * @param name nombre del sistema de juego usado
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Devuelve el número de jugadores o equipos máximo permitido por el sistema
     * @return número de jugadores o equipos máximo
     */
    public int getMaxPlayers() {
        return maxPlayers;
    }

    /**
     * Guarda el número de jugadores o equipos máximo permitido por el sistema
     * @param maxPlayers número de jugadores o equipos máximo
     */
    public void setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    /**
     * Devuelve el mínimo número de jugadores necesario para el torneo
     * @return número de jugadores mínimo necesario
     */
    public int getMinPlayers() {
        return minPlayers;
    }

    /**
     * Guarda el mínimo número de jugadores necesario para el torneo
     * @param minPlayers mínimo número de jugadores
     */
    public void setMinPlayers(int minPlayers) {
        this.minPlayers = minPlayers;
    }

    /**
     * Devuelve el número de rondas de tipo liga que se jugarán
     * @return número de rondas de tipo liga
     */
    public int getnRounds() {
        return nRounds;
    }

    /**
     * Guarda el número de rondas de tipo liga que se jugarán
     * @param nRounds número de rondas de tipo liga
     */
    public void setnRounds(int nRounds) {
        this.nRounds = nRounds;
    }

    /**
     * Devuelve el número de rondas de tipo playoffs que se jugarán
     * @return número de rondas de playoff
     */
    public int getnPlayoffs() {
        return nPlayoffs;
    }

    /**
     * Guarda el número de rondas de tipo playoffs que se jugarán
     * @param nPlayoffs
     */
    public void setnPlayoffs(int nPlayoffs) {
        this.nPlayoffs = nPlayoffs;
    }

    /**
     * Devuelve el número de jugadores por partida
     * @return número de jugadores por partida
     */
    public int getMatchPlayers() {
        return matchPlayers;
    }

    /**
     * Guarda el número de jugadores por partida
     * @param matchPlayers número de jugadores por partida
     */
    public void setMatchPlayers(int matchPlayers) {
        this.matchPlayers = matchPlayers;
    }

    /**
     * Devuelve el número de jugadores máximo que tiene un equipo en el torneo
     * @return número de jugadores máximo que puede tener un equipo en del torneo
     */
    public int getMaxTeamPlayer() {
        return maxTeamPlayer;
    }

    /**
     * Guarda el número de jugadores máximos que tiene un equipo en el torneo
     * @param maxTeamPlayer número de jugadores máximo que puede tener un equipo en el torneo
     */
    public void setMaxTeamPlayer(int maxTeamPlayer) {
        this.maxTeamPlayer = maxTeamPlayer;
    }

    /**
     * Devuelve el sistema de puntuaciones del torneo
     * @return sistema de puntuaciones del torneo
     */
    public PointSystem getPointSystem() {
        return pointSystem;
    }

    /**
     * Guarda el sistema de puntuaciones del torneo
     * @param pointSystem sistema de puntuaciones del torneo
     */
    public void setPointSystem(PointSystem pointSystem) {
        this.pointSystem = pointSystem;
    }    
    
}
