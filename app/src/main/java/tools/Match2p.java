package tools;

import model.tournament.Match;
import model.tournament.PlayerIndividual;

/**
 * Class made to make easier access to our data
 * Created by Klaussius on 21/01/2017.
 */

public class Match2p {
    private String p1,p2;
    private int p1points, p2points;

    public Match2p(Match match){
        PlayerIndividual p1 = (PlayerIndividual) match.getMatchPlayer().get(0).getPlayer();
        this.p1 = p1.getUser().getName();
        PlayerIndividual p2 = (PlayerIndividual) match.getMatchPlayer().get(1).getPlayer();
        this.p2 = p2.getUser().getName();
        this.p1points=0;
        this.p2points=0;
    }

    /**
     * Add point to p1
     */
    public void sumP1(){
        this.p1points++;
    }

    /**
     * Substract point to p1 if it's over 0
     */
    public void subP1(){
        if (this.p1points>0){
            this.p1points--;
        }
    }

    /**
     * Add point to p2
     */
    public void sump2(){
        this.p2points++;
    }

    /**
     * Substract point to p2 if it's over 0
     */
    public void subP2(){
        if(this.p2points>0){
            this.p2points--;
        }
    }

    // Getters and Setters

    /**
     * Get player 1 name
     * @return player 1 name
     */
    public String getP1() {
        return this.p1;
    }

    /**
     * Set player 1 name
     * @param p1 player 1 name
     */
    public void setP1(String p1) {
        this.p1 = p1;
    }

    /**
     * Get player 2 name
     * @return player 2 name
     */
    public String getP2() {
        return this.p2;
    }

    /**
     * Set player 2 name
     * @param p2 player 2 name
     */
    public void setP2(String p2) {
        this.p2 = p2;
    }

    /**
     * Returns player 1 points
     * @return player 1 points
     */
    public int getP1points() {
        return this.p1points;
    }

    /**
     * Rwturns player 2 points
     * @return player 2 points
     */
    public int getP2points() {
        return this.p2points;
    }
}
