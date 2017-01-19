/*
 * MAGRATHEA - DAM
 */
package model.benefit;

import model.utils.MyDate;

/**
 * Store prizes
 * @author Iván Villa
 */
public class Prize {
    private int id;
    private String name;
    private String description;
    private String image;
    private MyDate expirationDate;

    /**
     * Constructor con parámetros
     * @param id id
     * @param name name
     * @param description description
     * @param image image
     * @param expirationDate expiration date
     */
    public Prize(int id, String name, String description, String image, MyDate expirationDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
        this.expirationDate = expirationDate;
    }

    /**
     * Constructor simple
     */
    public Prize() {
    }
    
    // GETTERS AND SETTERS

    /**
     * Get id
     * @return id
     */

    public int getId() {
        return id;
    }

    /**
     * Set la id
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
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Return description
     description     */
    public String getDescription() {
        return description;
    }

    /**
     * Set description
     * @param description description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get image
     * @return image
     */
    public String getImage() {
        return image;
    }

    /**
     * Set image
     * @param image image
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * Get expiration date
     * @return expiration date
     */
    public MyDate getExpirationDate() {
        return expirationDate;
    }

    /**
     * Save expiration date
     * @param expirationDate expiration date
     */
    public void setExpirationDate(MyDate expirationDate) {
        this.expirationDate = expirationDate;
    }    
    
}
