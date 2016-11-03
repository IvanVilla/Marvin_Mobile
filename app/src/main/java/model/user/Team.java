/*
 * MAGRATHEA - DAM
 */
package model.user;

import java.util.ArrayList;

/**
 * Almacena un equipo
 * @author Klaussius
 */
public class Team {
    private int id;
    private ArrayList<TeamMember> memberList;
    private String description;
    private int maxUsers;

    /**
     * Constructor con parámetros
     * @param id id del equipo
     * @param memberList lista de miembros del equipo
     * @param description descripción del equipo
     * @param maxUsers máximo número de usuarios
     */
    public Team(int id, ArrayList<TeamMember> memberList, String description, int maxUsers) {
        this.id = id;
        this.memberList = memberList;
        this.description = description;
        this.maxUsers = maxUsers;
    }

    /**
     * Constructor sin parámetros
     */
    public Team() {
    }       

    //GETTERS y SETTERS

    /**
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public ArrayList<TeamMember> getMemberList() {
        return memberList;
    }

    /**
     *
     * @param memberList
     */
    public void setMemberList(ArrayList<TeamMember> memberList) {
        this.memberList = memberList;
    }

    /**
     *
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return
     */
    public int getMaxUsers() {
        return maxUsers;
    }

    /**
     *
     * @param maxUsers
     */
    public void setMaxUsers(int maxUsers) {
        this.maxUsers = maxUsers;
    }
    
    
}
