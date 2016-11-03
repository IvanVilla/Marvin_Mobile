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
     * Constructor con parámetros
     * @param id id del logro
     * @param name nombre del logro
     * @param content texto del logro
     * @param achievementDate
     */
    public Achievement(int id, String name, String content, MyDate achievementDate) {
        this.id = id;
        this.name = name;
        this.content = content;
    }

    /**
     * Constructor sin parámetros
     */
    public Achievement() {
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
    public String getName() {
        return name;
    }

    /**
     * Guarda el nombre
     * @param name nombre
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Devuelve el contenido del logro (descripción)
     * @return contenido
     */
    public String getContent() {
        return content;
    }

    /**
     * Guarda el contenido del logro (descripción)
     * @param content contenido
     */
    public void setContent(String content) {
        this.content = content;
    }
    
}
