/*
 * MAGRATHEA - DAM
 */
package model.benefit;

import model.utils.MyDate;

/**
 * Almacena los premios
 * @author Klaussius
 */
public class Prize {
    private int id;
    private int name;
    private String description;
    private String image;
    private MyDate expirationDate;

    /**
     * Constructor con parámetros
     * @param id id del premio
     * @param name nombre del premio
     * @param description descripción del premio
     * @param image imagen del premio
     * @param expirationDate fecha de caducidad del premio
     */
    public Prize(int id, int name, String description, String image, MyDate expirationDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
        this.expirationDate = expirationDate;
    }

    /**
     * Constructor sin parámetros
     */
    public Prize() {
    }
    
    // GETTERS Y SETTERS

    /**
     * Devuelve la id
     * @return id
     */

    public int getId() {
        return id;
    }

    /**
     * Guarda la id
     * @param id id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Devuelve el nombre
     * @return nombre
     */
    public int getName() {
        return name;
    }

    /**
     * Guarda el nombre
     * @param name nombre
     */
    public void setName(int name) {
        this.name = name;
    }

    /**
     * Devuelve la descripción
     * @return descripción
     */
    public String getDescription() {
        return description;
    }

    /**
     * Guarda la descripción
     * @param description descripción
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Devuelve la imagen
     * @return imagen
     */
    public String getImage() {
        return image;
    }

    /**
     * Guarda la imagen
     * @param image imagen
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * Devuelve la fecha de caducidad
     * @return fecha de caducidad
     */
    public MyDate getExpirationDate() {
        return expirationDate;
    }

    /**
     * Guarda la fecha de caducidad
     * @param expirationDate fecha de caducidad
     */
    public void setExpirationDate(MyDate expirationDate) {
        this.expirationDate = expirationDate;
    }    
    
}
