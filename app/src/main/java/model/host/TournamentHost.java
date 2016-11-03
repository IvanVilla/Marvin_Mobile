/*
 * MAGRATHEA - DAM
 */
package model.host;

import model.utils.GPS;

/**
 * Almacena un lugar de celebración de un torneo
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
     * @param id id del lugar
     * @param name nombre del lugar
     * @param phone teléfono del lugar
     * @param adress dirección del lugar
     * @param eMail correo electrónico del lugar
     * @param gps coordenadas GPS del lugar
     * @param defaultHost indica si es el lugar de celebración por defecto
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
     * Constructor sin parámetros
     */
    public TournamentHost() {
    }

    // GETTERS Y SETTERS

    /**
     * Devuelve la id de la sede
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Guarda la id de la sede
     * @param id id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Devuelve el nombre de la sede
     * @return nombre
     */
    public String getName() {
        return name;
    }

    /**
     * Guarda el nombre de la sede
     * @param name nombre
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Devuelve el teléfono de la sede
     * @return teléfono
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Guarda el teléfono de la sede
     * @param phone teléfono
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Devuelve la dirección de la sede
     * @return dirección
     */
    public String getAdress() {
        return adress;
    }

    /**
     * Guarda la dirección de las ede
     * @param adress dirección
     */
    public void setAdress(String adress) {
        this.adress = adress;
    }

    /**
     * Devuelve el e-mail de la sede
     * @return e-mail
     */
    public String geteMail() {
        return eMail;
    }

    /**
     * Guarda el e-mail de la sede
     * @param eMail e-mail
     */
    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    /**
     * Devuelve el GPS de la sede
     * @return gps
     */
    public GPS getGps() {
        return gps;
    }

    /**
     * Guarda el GPS de las ede
     * @param gps gps
     */
    public void setGps(GPS gps) {
        this.gps = gps;
    }

    /**
     * Indica si es el lugar por defecto de cerebración de torneos
     * @return true (lugar por defecto) false (no lo es)
     */
    public boolean isDefaultHost() {
        return defaultHost;
    }

    /**
     * Fija si es lugar por defecto para cerebrar los torenos
     * @param defaultHost true (es el lugar por defecto) false (no lo es)
     */
    public void setDefaultHost(boolean defaultHost) {
        this.defaultHost = defaultHost;
    }    
    
}
