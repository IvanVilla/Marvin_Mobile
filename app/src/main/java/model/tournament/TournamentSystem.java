/*
 * MAGRATHEA - DAM
 */
package model.tournament;

/**
 * Store tournament system
 * @author Iván Villa
 */
public class TournamentSystem {
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
     * Constructor with parameters
     * @param id id
     * @param name name
     * @param maxPlayers max players number
     * @param minPlayers min players number
     * @param nRounds number of rounds
     * @param nPlayoffs number of playoffs
     * @param matchPlayers players for matchs
     * @param maxTeamPlayer max players in one team
     * @param pointSystem point system
     */
    public TournamentSystem(int id, String name, int maxPlayers, int minPlayers, int nRounds, int nPlayoffs, int matchPlayers, int maxTeamPlayer, PointSystem pointSystem) {
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
     * Constructor simple
     */
    public TournamentSystem() {
    }

    // GETTERS AND SETTERS

    /**
     * Get id
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Set id
     * @param id id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Set name
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get max players
     * @return max players
     */
    public int getMaxPlayers() {
        return maxPlayers;
    }

    /**
     * Set max players
     * @param maxPlayers max players
     */
    public void setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    /**
     * Get min players
     * @return min players
     */
    public int getMinPlayers() {
        return minPlayers;
    }

    /**
     * Set min players
     * @param minPlayers min players
     */
    public void setMinPlayers(int minPlayers) {
        this.minPlayers = minPlayers;
    }

    /**
     * Get leage round numbers
     * @return leage rounds number
     */
    public int getnRounds() {
        return nRounds;
    }

    /**
     * Set leage round numbers
     * @param nRounds round numbers
     */
    public void setnRounds(int nRounds) {
        this.nRounds = nRounds;
    }

    /**
     * Get playoffs number
     * @return playoff number
     */
    public int getnPlayoffs() {
        return nPlayoffs;
    }

    /**
     * Set playoff number
     * @param nPlayoffs playoff number
     */
    public void setnPlayoffs(int nPlayoffs) {
        this.nPlayoffs = nPlayoffs;
    }

    /**
     * Get match player number
     * @return match player number
     */
    public int getMatchPlayers() {
        return matchPlayers;
    }

    /**
     * Set match player number
     * @param matchPlayers  match player number
     */
    public void setMatchPlayers(int matchPlayers) {
        this.matchPlayers = matchPlayers;
    }

    /**
     * Get max players in a team
     * @return max players in a team
     */
    public int getMaxTeamPlayer() {
        return maxTeamPlayer;
    }

    /**
     * Set max players in a team
     * @param maxTeamPlayer max players in a team
     */
    public void setMaxTeamPlayer(int maxTeamPlayer) {
        this.maxTeamPlayer = maxTeamPlayer;
    }

    /**
     * Get point system
     * @return point system
     */
    public PointSystem getPointSystem() {
        return pointSystem;
    }

    /**
     * Set point system
     * @param pointSystem point system
     */
    public void setPointSystem(PointSystem pointSystem) {
        this.pointSystem = pointSystem;
    }    
    
}
