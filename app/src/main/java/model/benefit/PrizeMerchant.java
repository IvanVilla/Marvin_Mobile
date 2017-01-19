/*
 * MAGRATHEA - DAM
 */
package model.benefit;

import model.utils.MyDate;

/**
 * Store merchandising for prizes. Inherits from Prize.
 * @author Iván Villa
 */
public class PrizeMerchant extends Prize{
    private MyDate receptionDate;
    boolean claimed;

    /**
     * Constructor with parameters
     * @param receptionDate reception date
     * @param claimed if it was claimed
     * @param id id
     * @param name name
     * @param description description
     * @param image image
     * @param expirationDate expiration date
     */
    public PrizeMerchant(MyDate receptionDate, boolean claimed, int id, String name, String description, String image, MyDate expirationDate) {
        super(id, name, description, image, expirationDate);
        this.receptionDate = receptionDate;
        this.claimed = claimed;
    }

    /**
     * Constructor simple
     */
    public PrizeMerchant() {
    }

    // GETTERS AND SETTERS

    /**
     * Get reception date
     * @return reception date
     */
    public MyDate getReceptionDate() {
        return receptionDate;
    }

    /**
     * Set reception date
     * @param receptionDate reception date
     */
    public void setReceptionDate(MyDate receptionDate) {
        this.receptionDate = receptionDate;
    }

    /**
     * Get if a prize was claimed
     * @return true (claimed) false (not claimed)
     */
    public boolean isClaimed() {
        return claimed;
    }

    /**
     * Set if a prize was claimed
     * @param claimed true (yes) false (no)
     */
    public void setClaimed(boolean claimed) {
        this.claimed = claimed;
    } 
    
}
