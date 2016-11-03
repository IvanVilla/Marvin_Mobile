/**
 * MAGRATHEA - DAM
 */
package model.game;

/**
 * Almacena los datos de un juego
 * @author Klaussius
 */
public class Game {
    private int id;
    private String name;
    private String description;
    private String image;

    /**
     * Constructor con parámetros
     * @param id id del juego
     * @param name nombre del juego
     * @param description descripción del juego
     * @param image imagen del juego
     */
    public Game(int id, String name, String description, String image) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
    }

    /**
     * Constructor sin parámetros
     */
    public Game() {
    }

    // GETTERS Y SETTERS

    /**
     * Devuelve la id de un juego
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Guarda la id de un juego
     * @param id id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Devuelve el nombre de un juego
     * @return nombre
     */
    public String getName() {
        return name;
    }

    /**
     * Guarda el nombre de un juego
     * @param name nombre
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Devuelve la descripción de un juego
     * @return descripción
     */
    public String getDescription() {
        return description;
    }

    /**
     * Guarda la descripción de un juego
     * @param description descripción
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Devuelve la imagen de un juego
     * @return imagen del juego
     */
    public String getImage() {
        return image;
    }

    /**
     * Guarda la imagen de un juego
     * @param image imagen del juego
     */
    public void setImage(String image) {
        this.image = image;
    }    
    
}
