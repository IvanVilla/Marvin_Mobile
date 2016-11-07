/*
 * MAGRATHEA - DAM
 */
package model.utils;

/**
 * Store a place
 * @author Klaussius
 */
public class GPS {
    private float latitude;
    private float longitude;

    /**
     * Constructor with parameters
     * @param latitude latitude
     * @param longitude longitude
     */
    public GPS(float latitude, float longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }
    
    /**
     * Constructor simple
     */
    public GPS(){        
    }

    // GETTERS AND SETTERS

    /**
     * Get latitude
     * @return latitude
     */
    public float getLatitude() {
        return latitude;
    }

    /**
     * Set latitude
     * @param latitude latitude
     */
    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    /**
     * Devuelve la longitude
     * @return longitude
     */
    public float getLongitude() {
        return longitude;
    }

    /**
     * Get longitude
     * @param longitude longitude
     */
    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }    
    
}
