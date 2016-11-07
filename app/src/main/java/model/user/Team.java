/*
 * MAGRATHEA - DAM
 */
package model.user;

import java.util.ArrayList;

/**
 * Store a team
 * @author Klaussius
 */
public class Team {
    private int id;
    private ArrayList<TeamMember> memberList;
    private String description;
    private int maxUsers;

    /**
     * Constructor with parameters
     * @param id id
     * @param memberList member list
     * @param description description
     * @param maxUsers max number of users
     */
    public Team(int id, ArrayList<TeamMember> memberList, String description, int maxUsers) {
        this.id = id;
        this.memberList = memberList;
        this.description = description;
        this.maxUsers = maxUsers;
    }

    /**
     * Constructor simple
     */
    public Team() {
    }       

    //GETTERS AND SETTERS

    /**
     * Get id
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * Set id
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get team members
     * @return team members
     */
    public ArrayList<TeamMember> getMemberList() {
        return memberList;
    }

    /**
     * Set team members
     * @param memberList team members
     */
    public void setMemberList(ArrayList<TeamMember> memberList) {
        this.memberList = memberList;
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
     * Get max number of users
     * @return max number of users
     */
    public int getMaxUsers() {
        return maxUsers;
    }

    /**
     * Set max number of users
     * @param maxUsers max number of users
     */
    public void setMaxUsers(int maxUsers) {
        this.maxUsers = maxUsers;
    }
    
    
}
