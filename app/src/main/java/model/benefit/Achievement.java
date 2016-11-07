/*
 * MAGRATHEA - DAM
 */
package model.benefit;

import model.utils.MyDate;

/**
 * Almacena los logros
 * @author Klaussius
 */
public class Achievement {
    private int id;
    private String name;
    private String content;
    private MyDate achievementDate;

    /**
     * Constructor with parameters
     * @param id id
     * @param name name
     * @param content text
     * @param achievementDate date
     */
    public Achievement(int id, String name, String content, MyDate achievementDate) {
        this.id = id;
        this.name = name;
        this.content = content;
    }

    /**
     * Constructor simple
     */
    public Achievement() {
    }
    
    // GETTERS AND SETTERS

    /**
     * Get the id
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Set the id
     * @param id id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Return the name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name
     * @param name nombre
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Return achievement's text
     * @return achievement's text
     */
    public String getContent() {
        return content;
    }

    /**
     * Set achievement's text
     * @param content achievement's text
     */
    public void setContent(String content) {
        this.content = content;
    }
    
}
