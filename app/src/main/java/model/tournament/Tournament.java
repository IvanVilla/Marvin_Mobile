package model.tournament;

import java.util.List;

import model.benefit.Prize;
import model.game.Game;
import model.host.TournamentHost;
import model.user.User;
import model.utils.MyDate;

/**
 * @author Iván Villa
 */

public class Tournament {
    private int id;
    private String name;
    private String publicDes;
    private String privateDes;
    private String image;
    private MyDate date;
    private String status;
    private Game game;
    private TournamentHost host;
    private List<Prize> prizes;
    private List<User> umpires;
    private List<TournamentPlayer> players;
    private List<Round> rounds;
    private TournamentSystem tournamentSystem;

    /**
     * Constructor with parameters
     * @param id id of the tournament
     * @param name name of the tournament
     * @param publicDes public description of the tournament
     * @param privateDes private description of the tournament
     * @param image image of the tournament
     * @param date date of the tournament
     * @param status status of the tournament
     * @param game game of the tournament
     * @param host hostplace of the tournament
     * @param prizes prizes' list
     * @param umpires umpires' list
     * @param players players' list
     * @param rounds rounds' list
     * @param tournamentSystem tournament tournamentSystem
     */
    public Tournament(int id, String name, String publicDes, String privateDes, String image, MyDate date, String status, Game game, TournamentHost host, List<Prize> prizes, List<User> umpires, List<TournamentPlayer> players, List<Round> rounds, TournamentSystem tournamentSystem) {
        this.id = id;
        this.name = name;
        this.publicDes = publicDes;
        this.privateDes = privateDes;
        this.image = image;
        this.date = date;
        this.status = status;
        this.game = game;
        this.host = host;
        this.prizes = prizes;
        this.umpires = umpires;
        this.players = players;
        this.rounds = rounds;
        this.tournamentSystem = tournamentSystem;
    }

    /**
     * Constructor without parameters
     */
    public Tournament() {
    }

    /**
     * Get the id
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Set the id
     * @param id id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get the name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the public description
     * @return public description
     */
    public String getPublicDes() {
        return publicDes;
    }

    /**
     * Set the public description
     * @param publicDes
     */
    public void setPublicDes(String publicDes) {
        this.publicDes = publicDes;
    }

    /**
     * Get the private description
     * @return private description
     */
    public String getPrivateDes() {
        return privateDes;
    }

    /**
     * Set the private description
     * @param privateDes private description
     */
    public void setPrivateDes(String privateDes) {
        this.privateDes = privateDes;
    }

    /**
     * Get the image
     * @return the image
     */
    public String getImage() {
        return image;
    }

    /**
     * Set the image
     * @param image the image
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * get the date
     * @return the date
     */
    public MyDate getDate() {
        return date;
    }

    /**
     * Set the date
     * @param date the date
     */
    public void setDate(MyDate date) {
        this.date = date;
    }

    /**
     * Get the status
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Set the status
     * @param status the status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Get the game
     * @return the game
     */
    public Game getGame() {
        return game;
    }

    /**
     * Set the game
     * @param game the game
     */
    public void setGame(Game game) {
        this.game = game;
    }

    /**
     * Get the host
     * @return the host
     */
    public TournamentHost getHost() {
        return host;
    }

    /**
     * Set the host
     * @param host the host
     */
    public void setHost(TournamentHost host) {
        this.host = host;
    }

    /**
     * Get the prizes
     * @return the prizes
     */
    public List<Prize> getPrizes() {
        return prizes;
    }

    /**
     * Set the prizes
     * @param prizes the prizes
     */
    public void setPrizes(List<Prize> prizes) {
        this.prizes = prizes;
    }

    /**
     * Get the umpires
     * @return the umpires
     */
    public List<User> getUmpires() {
        return umpires;
    }

    /**
     * Set the umpires
     * @param umpires
     */
    public void setUmpires(List<User> umpires) {
        this.umpires = umpires;
    }

    /**
     * Get the players
     * @return the players' list
     */
    public List<TournamentPlayer> getPlayers() {
        return players;
    }

    /**
     * Set the players
     * @param players the players' list
     */
    public void setPlayers(List<TournamentPlayer> players) {
        this.players = players;
    }

    /**
     * Get the umpires
     * @return the umpires's list
     */
    public List<Round> getRounds() {
        return rounds;
    }

    /**
     * Set the rounds
     * @param rounds the rounds' list
     */
    public void setRounds(List<Round> rounds) {
        this.rounds = rounds;
    }

    /**
     * Get the tournamentSystem
     * @return the systems' list
     */
    public TournamentSystem getTournamentSystem() {
        return tournamentSystem;
    }

    /**
     * Set the tournamentSystem
     * @param tournamentSystem the systems' list
     */
    public void setTournamentSystem(TournamentSystem tournamentSystem) {
        this.tournamentSystem = tournamentSystem;
    }
}
