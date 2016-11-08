/*
 * MAGRATHEA - DAM
 */
package model.tournament;

/**
 * Store point system
 * @author Iván Villa
 */
class PointSystem {
    private int goldPoints;
    private int silverPoints;
    private int bronzePoints;
    private int ironPoints;
    private int umpirePoints;

    /**
     * Constructor with parameters
     * @param goldPoints 1st place points
     * @param silverPoints 2nd place points
     * @param bronzePoints 3rd place points
     * @param ironPoints contestant points
     * @param umpirePoints umpire points
     */
    public PointSystem(int goldPoints, int silverPoints, int bronzePoints, int ironPoints, int umpirePoints) {
        this.goldPoints = goldPoints;
        this.silverPoints = silverPoints;
        this.bronzePoints = bronzePoints;
        this.ironPoints = ironPoints;
        this.umpirePoints = umpirePoints;
    }

    /**
     * Constructor simple
     */
    public PointSystem() {
    }

    // GETTERS AND SETTERS
    /**
     * Get 1st place points
     * @return 1st place points
     */
    public int getGoldPoints() {
        return goldPoints;
    }

    /**
     * Set 1st place points
     * @param goldPoints 1st place points
     */
    public void setGoldPoints(int goldPoints) {
        this.goldPoints = goldPoints;
    }

    /**
     * Get 2nd place points
     * @return puntos del segundo puesto
     */
    public int getSilverPoints() {
        return silverPoints;
    }

    /**
     * Set 2nd place points
     * @param silverPoints puntos del segundo puesto
     */
    public void setSilverPoints(int silverPoints) {
        this.silverPoints = silverPoints;
    }

    /**
     * Devuelve los puntos del tercer puesto
     * @return puntos del tercer puesto
     */
    public int getBronzePoints() {
        return bronzePoints;
    }

    /**
     * Set 3rd place points
     * @param bronzePoints 3rd place points
     */
    public void setBronzePoints(int bronzePoints) {
        this.bronzePoints = bronzePoints;
    }

    /**
     * Get contestant points
     * @return contestant points
     */
    public int getIronPoints() {
        return ironPoints;
    }

    /**
     * Set contestant points
     * @param ironPoints contestant points
     */
    public void setIronPoints(int ironPoints) {
        this.ironPoints = ironPoints;
    }

    /**
     * Get umpire points
     * @return umpire points
     */
    public int getUmpirePoints() {
        return umpirePoints;
    }

    /**
     * Set umpire points
     * @param umpirePoints 
     */
    public void setUmpirePoints(int umpirePoints) {
        this.umpirePoints = umpirePoints;
    }    
    
}
