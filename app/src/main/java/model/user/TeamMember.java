/*
 * MAGRATHEA - DAM
 */
package model.user;

/**
 * Almacena los miembros de un equipo con su rol
 * @author Klaussius
 */
public class TeamMember {
    private User user;
    private String role;

    /**
     * Constructor con parámetros
     * @param user miembro
     * @param role rol del miembro
     */
    public TeamMember(User user, String role) {
        this.user = user;
        this.role = role;
    }

    /**
     * Constructor sin parámetros
     */
    public TeamMember() {
    }

    // GETTERS y SETTERS

    /**
     *
     * @return
     */
    public User getUser() {
        return user;
    }

    /**
     *
     * @param user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     *
     * @return
     */
    public String getRole() {
        return role;
    }

    /**
     *
     * @param role
     */
    public void setRole(String role) {
        this.role = role;
    }
    
    
}
