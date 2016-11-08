/*
 * MAGRATHEA - DAM
 */
package model.user;

/**
 * Almacena los miembros de un equipo con su rol
 * @author Iván Villa
 */
public class TeamMember {
    private User user;
    private String role;

    /**
     * Constructor with parameters
     * @param user member
     * @param role role of the member
     */
    public TeamMember(User user, String role) {
        this.user = user;
        this.role = role;
    }

    /**
     * Constructor simple
     */
    public TeamMember() {
    }

    // GETTERS AND SETTERS

    /**
     * Get User
     * @return user
     */
    public User getUser() {
        return user;
    }

    /**
     * Set user
     * @param user user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Get role
     * @return role
     */
    public String getRole() {
        return role;
    }

    /**
     * Set role
     * @param role role
     */
    public void setRole(String role) {
        this.role = role;
    }

}
