/*
 * MAGRATHEA - DAM
 */
package model.benefit;

import model.utils.MyDate;

/**
 * Store discount. Inherits from Prize.
 * @author Iván Villa
 */
public class PrizeDiscount extends Prize{
    int discount;

    /**
     * Constructor with parameters
     * @param discount discount
     * @param id id
     * @param name name
     * @param description description
     * @param image image
     * @param expirationDate expiration date
     */
    public PrizeDiscount(int discount, int id, String name, String description, String image, MyDate expirationDate) {
        super(id, name, description, image, expirationDate);
        this.discount = discount;
    }

    /**
     * Constructor simple
     */
    public PrizeDiscount() {
    }

    // GETTERS AND SETTERS

    /**
     * Get discount
     * @return discount
     */
    public int getDiscount() {
        return discount;
    }

    /**
     * Set discount
     * @param discount discount
     */
    public void setDiscount(int discount) {
        this.discount = discount;
    }
    
}
