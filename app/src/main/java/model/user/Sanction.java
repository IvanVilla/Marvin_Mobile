/*
 * MAGRATHEA - DAM
 */
package model.user;

import model.utils.MyDate;

/**
 * Store sanctions of one user
 * @author Iván Villa
 */
public class Sanction {
    private int id;
    private String reason;
    private MyDate penaltyBegin;
    private MyDate penaltyEnd;

    /**
     * Constructor with parameters
     * @param id id
     * @param reason reason
     * @param penaltyBegin penalty begin date
     * @param penaltyEnd penalty end date
     */
    public Sanction(int id, String reason, MyDate penaltyBegin, MyDate penaltyEnd) {
        this.id = id;
        this.reason = reason;
        this.penaltyBegin = penaltyBegin;
        this.penaltyEnd = penaltyEnd;
    }

    /**
     * Constructor simple
     */
    public Sanction() {
    }

    //GETTERS AND SETTERS

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
     * Get Reason
     * @return reason
     */
    public String getReason() {
        return reason;
    }

    /**
     * Set reason
     * @param reason reason
     */
    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
     * Get penalty date of beginning
     * @return penalty date of beginning
     */
    public MyDate getPenaltyBegin() {
        return penaltyBegin;
    }

    /**
     * Set penalty date of beginning
     * @param penaltyBegin penalty date of beginning
     */
    public void setPenaltyBegin(MyDate penaltyBegin) {
        this.penaltyBegin = penaltyBegin;
    }

    /**
     * Get penalty date of ending
     * @return penalty date of ending
     */
    public MyDate getPenaltyEnd() {
        return penaltyEnd;
    }

    /**
     * Set penalty date of ending
     * @param penaltyEnd penalty date of ending
     */
    public void setPenaltyEnd(MyDate penaltyEnd) {
        this.penaltyEnd = penaltyEnd;
    }
    
    
}
