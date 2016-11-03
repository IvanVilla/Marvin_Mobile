/*
 * MAGRATHEA - DAM
 */
package model.utils;

/**
 * Almacena un lugar
 * @author Klaussius
 */
public class GPS {
    private float latitude;
    private float longitude;

    /**
     * Constructor con parámetros
     * @param latitude
     * @param longitude 
     */
    public GPS(float latitude, float longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }
    
    /**
     * Constructor sin parámetros
     */
    public GPS(){        
    }

    // GETTERS y SETTERS

    /**
     * Devuelve la latitud geográfica
     * @return latitud geográfica
     */
    public float getLatitude() {
        return latitude;
    }

    /**
     * Guarda la latitud geográfica
     * @param latitude latitud geográfica
     */
    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    /**
     * Devuelve la longitud geográfica
     * @return longitud geográfica
     */
    public float getLongitude() {
        return longitude;
    }

    /**
     * Guarda la longitud geográfica
     * @param longitude longitud geográfica
     */
    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }    
    
}
