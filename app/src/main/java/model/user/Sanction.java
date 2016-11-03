/*
 * MAGRATHEA - DAM
 */
package model.user;

import model.utils.MyDate;

/**
 * Almacena las sanciones que tenga un usuario
 * @author Klaussius
 */
public class Sanction {
    private int id;
    private String reason;
    private MyDate penaltyBegin;
    private MyDate penaltyEnd;

    /**
     * Constructor con parámetros
     * @param id id de la sanción
     * @param reason razón de la sanción
     * @param penaltyBegin comienzo del castigo
     * @param penaltyEnd fin del castigo
     */
    public Sanction(int id, String reason, MyDate penaltyBegin, MyDate penaltyEnd) {
        this.id = id;
        this.reason = reason;
        this.penaltyBegin = penaltyBegin;
        this.penaltyEnd = penaltyEnd;
    }

    /**
     * Constructor sin parámetros
     */
    public Sanction() {
    }

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
    public String getReason() {
        return reason;
    }

    /**
     *
     * @param reason
     */
    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
     *
     * @return
     */
    public MyDate getPenaltyBegin() {
        return penaltyBegin;
    }

    /**
     *
     * @param penaltyBegin
     */
    public void setPenaltyBegin(MyDate penaltyBegin) {
        this.penaltyBegin = penaltyBegin;
    }

    /**
     *
     * @return
     */
    public MyDate getPenaltyEnd() {
        return penaltyEnd;
    }

    /**
     *
     * @param penaltyEnd
     */
    public void setPenaltyEnd(MyDate penaltyEnd) {
        this.penaltyEnd = penaltyEnd;
    }
    
    
}
