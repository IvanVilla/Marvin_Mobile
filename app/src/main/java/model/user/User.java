/*
 * MAGRATHEA - DAM
 */
package model.user;

import java.util.ArrayList;
import model.utils.MyDate;

/**
 * Almacena los datos de un usuario
 * @author Klaussius
 */
public class User {
    private int id;
    private String publicName;
    private String name;
    private String phone;
    private String eMail;
    private String privateDescription;
    private String publicDescription;
    private MyDate memberSince;
    private String role;
    private String language;
    private MyDate dataPassword;
    private boolean markedForDeletion;
    private MyDate clearRequestData;
    private boolean ads;
    private ArrayList<Sanction> sanctions;
    private ArrayList <AchievementUser> achievements;

    /**
     * Constructor con parámetros
     * @param id id del usuario
     * @param publicName nombre público (nick)
     * @param name nombre real
     * @param phone teléfono
     * @param eMail correo electrónico
     * @param privateDescription descripción privada
     * @param publicDescription descripción pública
     * @param memberSince miembro desde...
     * @param role rol del usuario
     * @param language lenguaje del usuario
     * @param dataPassword contraseña del usuario
     * @param markedForDeletion marcado para ser borrado
     * @param clearRequestData fecha de la solicitud de borrado
     * @param ads indica si el usuario admite anuncios
     * @param sanctions sanciones de los usuarios
     * @param achievements logros de los usuarios
     */
    public User(int id, String publicName, String name, String phone, String eMail, String privateDescription, String publicDescription, MyDate memberSince, String role, String language, MyDate dataPassword, boolean markedForDeletion, MyDate clearRequestData, boolean ads, ArrayList<Sanction> sanctions, ArrayList<AchievementUser> achievements) {
        this.id = id;
        this.publicName = publicName;
        this.name = name;
        this.phone = phone;
        this.eMail = eMail;
        this.privateDescription = privateDescription;
        this.publicDescription = publicDescription;
        this.memberSince = memberSince;
        this.role = role;
        this.language = language;
        this.dataPassword = dataPassword;
        this.markedForDeletion = markedForDeletion;
        this.clearRequestData = clearRequestData;
        this.ads = ads;
        this.sanctions = sanctions;
        this.achievements = achievements;
    }
    
    /**
     * Constructor sin parámetros
     */
    public User() {
    }

    // GETTERS y SETTERS

    /**
     * Devuelve el id del usuario
     * @return id del usuario
     */
    public int getId() {
        return id;
    }

    /**
     * Guarda la id del usuario
     * @param id id del usuario
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Devuelve el nickname del usuario
     * @return nickname del usuario
     */
    public String getPublicName() {
        return publicName;
    }

    /**
     * Guarda el nickname del usuario
     * @param publicName devuelve el nickname del usuario
     */
    public void setPublicName(String publicName) {
        this.publicName = publicName;
    }

    /**
     * Devuelve el nombre del usuario
     * @return nombre del usuario
     */
    public String getName() {
        return name;
    }

    /**
     * Guarda el nombre del usuario
     * @param name nombre del usuario
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Devuelve el teléfono del usuario
     * @return teléfono del usuario
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Guarda el teléfono del usuario
     * @param phone teléfono del usuario
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Devuelve el correo del usuario
     * @return correo del usuario
     */
    public String geteMail() {
        return eMail;
    }

    /**
     * Guarda el e-Mail del usuario
     * @param eMail e-Mail del usuario
     */
    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    /**
     * Devuelve la descripción privada del usuario
     * @return descripción privada del usuario
     */
    public String getPrivateDescription() {
        return privateDescription;
    }

    /**
     * Devuelve la descripción privada del usuario
     * @param privateDescription descripción privada del usuario
     */
    public void setPrivateDescription(String privateDescription) {
        this.privateDescription = privateDescription;
    }

    /**
     * Devuelve la descripción pública del usuario
     * @return descripción pública del usuario
     */
    public String getPublicDescription() {
        return publicDescription;
    }

    /**
     * Guarda la descripción pública del usuario
     * @param publicDescription descripción pública del usuario
     */
    public void setPublicDescription(String publicDescription) {
        this.publicDescription = publicDescription;
    }

    /**
     * Devuelve la fecha de alta del usuario
     * @return fecha de alta del usuario
     */
    public MyDate getMemberSince() {
        return memberSince;
    }

    /**
     * Guarda la fecha de alta del usuario
     * @param memberSince fecha de alta del usuario
     */
    public void setMemberSince(MyDate memberSince) {
        this.memberSince = memberSince;
    }

    /**
     * Devuelve el rol del usuario
     * @return rol del usuario
     */
    public String getRole() {
        return role;
    }

    /**
     * Guarda el rol del usuario
     * @param role rol del usuario
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * Devuelve el idioma del usuario
     * @return idioma del usuario
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Guarda el idioma del usuario
     * @param language idioma del usuario
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * Devuelve la fecha del password del usuario
     * @return password del usuario
     */
    public MyDate getDataPassword() {
        return dataPassword;
    }

    /**
     * Guarda la fecha del password del usuario
     * @param dataPassword password
     */
    public void setDataPassword(MyDate dataPassword) {
        this.dataPassword = dataPassword;
    }

    /**
     * Devuelve si el usuario está marcado para ser borrado
     * @return true si está marcado para borrar, false si no
     */
    public boolean isMarkedForDeletion() {
        return markedForDeletion;
    }

    /**
     * Guarda si el usuario está marcado para ser borrado
     * @param markedForDeletion true para marcarlo para borrar, false si no
     */
    public void setMarkedForDeletion(boolean markedForDeletion) {
        this.markedForDeletion = markedForDeletion;
    }

    /**
     * Deuvelve la fecha de petición de baja
     * @return fecha de petición de baja
     */
    public MyDate getClearRequestData() {
        return clearRequestData;
    }

    /**
     * Guarda la fecha de petición de baja
     * @param clearRequestData fecha de petición de baja
     */
    public void setClearRequestData(MyDate clearRequestData) {
        this.clearRequestData = clearRequestData;
    }

    /**
     * Devuelve si el usuario admite anuncios
     * @return si el usuario admite anuncios, true, en caso contrario false
     */
    public boolean isAds() {
        return ads;
    }

    /**
     * Guarda si el usuario admite anuncios
     * @param ads true si los admite, false si no
     */
    public void setAds(boolean ads) {
        this.ads = ads;
    }

    /**
     * Devuelve las sanciones del usuario
     * @return sanciones del usuario
     */
    public ArrayList<Sanction> getSanctions() {
        return sanctions;
    }

    /**
     * Guarda las sanciones del usuario
     * @param sanctions sanciones del usuario
     */
    public void setSanctions(ArrayList<Sanction> sanctions) {
        this.sanctions = sanctions;
    }

    /**
     * Devuelve los logros de un usuario
     * @return logros de un usuario
     */
    public ArrayList<AchievementUser> getAchievements() {
        return achievements;
    }

    /**
     * Guarda los logros de un usuario
     * @param achievements logros de un usuario
     */
    public void setAchievements(ArrayList<AchievementUser> achievements) {
        this.achievements = achievements;
    }   
    
}
