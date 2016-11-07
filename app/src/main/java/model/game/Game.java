/**
 * MAGRATHEA - DAM
 */
package model.game;

/**
 * Game data
 * @author Klaussius
 */
public class Game {
    private int id;
    private String name;
    private String description;
    private String image;

    /**
     * Constructor con parámetros
     * @param id id
     * @param name name
     * @param description description
     * @param image image
     */
    public Game(int id, String name, String description, String image) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
    }

    /**
     * Constructor simple
     */
    public Game() {
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
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get description
     * @return description
     */
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
    
}
