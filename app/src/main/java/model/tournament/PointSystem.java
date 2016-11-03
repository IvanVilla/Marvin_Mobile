/*
 * MAGRATHEA - DAM
 */
package model.tournament;

/**
 * Almacena el sistema de puntos
 * @author Klaussius
 */
class PointSystem {
    private int goldPoints;
    private int silverPoints;
    private int bronzePoints;
    private int ironPoints;
    private int umpirePoints;

    /**
     * Constructor con parámetros
     * @param goldPoints puntos para el primer clasificado
     * @param silverPoints puntos para el segundo clasificado
     * @param bronzePoints puntos para el tercer clasificado
     * @param ironPoints puntos para los participantes
     * @param umpirePoints putnos para los árbitros
     */
    public PointSystem(int goldPoints, int silverPoints, int bronzePoints, int ironPoints, int umpirePoints) {
        this.goldPoints = goldPoints;
        this.silverPoints = silverPoints;
        this.bronzePoints = bronzePoints;
        this.ironPoints = ironPoints;
        this.umpirePoints = umpirePoints;
    }

    /**
     * Constructor sin parámetros
     */
    public PointSystem() {
    }

    // GETTERS Y SETTERS
    /**
     * Devuelve los puntos del ganador
     * @return puntos para el ganador
     */
    public int getGoldPoints() {
        return goldPoints;
    }

    /**
     * Guarda los puntos del ganador
     * @param goldPoints puntos del ganador
     */
    public void setGoldPoints(int goldPoints) {
        this.goldPoints = goldPoints;
    }

    /**
     * Devuelve los puntos del segundo puesto
     * @return puntos del segundo puesto
     */
    public int getSilverPoints() {
        return silverPoints;
    }

    /**
     * Guarda los puntos del segundo puesto
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
     * Guarda los puntos del tercer puesto
     * @param bronzePoints puntos del tercer puesto
     */
    public void setBronzePoints(int bronzePoints) {
        this.bronzePoints = bronzePoints;
    }

    /**
     * Devuelve los puntos de los participantes
     * @return puntos de los participantes
     */
    public int getIronPoints() {
        return ironPoints;
    }

    /**
     * Guarda los puntos de los participantes
     * @param ironPoints puntos de los participantes
     */
    public void setIronPoints(int ironPoints) {
        this.ironPoints = ironPoints;
    }

    /**
     * Devuelve los puntos de los árbitros
     * @return puntos de los árbitros
     */
    public int getUmpirePoints() {
        return umpirePoints;
    }

    /**
     * Guarda los puntos de los árbitros
     * @param umpirePoints 
     */
    public void setUmpirePoints(int umpirePoints) {
        this.umpirePoints = umpirePoints;
    }    
    
}
