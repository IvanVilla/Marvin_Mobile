/*
 * MAGRATHEA - DAM
 */
package model.benefit;

import model.utils.MyDate;

/**
 * Almacena los artículos de merchandising de premio. Hereda de Prize.
 * @author Klaussius
 */
public class PrizeMerchant extends Prize{
    private MyDate receptionDate;
    boolean claimed;

    /**
     * Constructor con parámetros
     * @param receptionDate fecha de recepción
     * @param claimed indica si ha sido reclamado
     * @param id id del premio
     * @param name nombre del premio
     * @param description descripción del premio
     * @param image imagen del premio
     * @param expirationDate fecha de caducidad del premio
     */
    public PrizeMerchant(MyDate receptionDate, boolean claimed, int id, int name, String description, String image, MyDate expirationDate) {
        super(id, name, description, image, expirationDate);
        this.receptionDate = receptionDate;
        this.claimed = claimed;
    }

    /**
     * Constructor sin parámetros
     */
    public PrizeMerchant() {
    }

    // GETTERS Y SETTERS

    /**
     * Devuelve la fecha de recepción del producto
     * @return
     */
    public MyDate getReceptionDate() {
        return receptionDate;
    }

    /**
     * Guarda la fecha de recepción del producto
     * @param receptionDate
     */
    public void setReceptionDate(MyDate receptionDate) {
        this.receptionDate = receptionDate;
    }

    /**
     * Indica si un premio se ha reclamado o no
     * @return true (se ha reclamado) false (no se ha reclamado)
     */
    public boolean isClaimed() {
        return claimed;
    }

    /**
     * Guarda si un premio se ha reclamado o no
     * @param claimed true (se ha reclamado) false (no se ha reclamado)
     */
    public void setClaimed(boolean claimed) {
        this.claimed = claimed;
    } 
    
}
