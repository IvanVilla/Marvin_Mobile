/*
 * MAGRATHEA - DAM
 */
package model.host;

import model.utils.GPS;

/**
 * Store the host for the tournaments
 * @author Klaussius
 */
public class TournamentHost {
    private int id;
    private String name;
    private String phone;
    private String adress;
    private String eMail;
    private GPS gps;
    private boolean defaultHost;

    /**
     * Constructor con parámetros
     * @param id id
     * @param name name
     * @param phone phone
     * @param adress adress
     * @param eMail e-mail
     * @param gps GPS (latitude and longitude)
     * @param defaultHost if its the default place
     */
    public TournamentHost(int id, String name, String phone, String adress, String eMail, GPS gps, boolean defaultHost) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.adress = adress;
        this.eMail = eMail;
        this.gps = gps;
        this.defaultHost = defaultHost;
    }

    /**
     * Constructor simple
     */
    public TournamentHost() {
    }

    // GETTERS Y SETTERS

    /**
     * Return id
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
     * @param name nombre
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get phone
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Set phone
     * @param phone phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Get adress
     * @return adress
     */
    public String getAdress() {
        return adress;
    }

    /**
     * Set adress
     * @param adress adress
     */
    public void setAdress(String adress) {
        this.adress = adress;
    }

    /**
     * Get eMail
     * @return eMail
     */
    public String geteMail() {
        return eMail;
    }

    /**
     * Set eMail
     * @param eMail eMail
     */
    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    /**
     * Get GPS
     * @return gps
     */
    public GPS getGps() {
        return gps;
    }

    /**
     * Set gps
     * @param gps gps
     */
    public void setGps(GPS gps) {
        this.gps = gps;
    }

    /**
     * Get if its the default place for tournaments
     * @return true (yes) false (no)
     */
    public boolean isDefaultHost() {
        return defaultHost;
    }

    /**
     * Set if its the default place for tournaments
     * @param defaultHost true (yes) false (no)
     */
    public void setDefaultHost(boolean defaultHost) {
        this.defaultHost = defaultHost;
    }    
    
}
