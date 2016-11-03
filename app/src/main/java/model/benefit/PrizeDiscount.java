/*
 * MAGRATHEA - DAM
 */
package model.benefit;

import model.utils.MyDate;

/**
 * Almacena los descuentos, hereda de Prize
 * @author Klaussius
 */
public class PrizeDiscount extends Prize{
    int discount;

    /**
     * Constructor con parámetros
     * @param discount descuento
     * @param id id del premio
     * @param name nombre del premio
     * @param description descripción del premio
     * @param image dirección de la imagen
     * @param expirationDate fecha de caducidad
     */
    public PrizeDiscount(int discount, int id, int name, String description, String image, MyDate expirationDate) {
        super(id, name, description, image, expirationDate);
        this.discount = discount;
    }

    /**
     * Constructor sin parámetros
     * @param discount 
     */
    public PrizeDiscount(int discount) {
        this.discount = discount;
    }

    /**
     * Constructor sin parámetros
     */
    public PrizeDiscount() {
    }

    // GETTERS Y SETTERS

    /**
     * Devuelve el descuento
     * @return descuento
     */
    public int getDiscount() {
        return discount;
    }

    /**
     * Guarda el descuento
     * @param discount descuento
     */
    public void setDiscount(int discount) {
        this.discount = discount;
    }
    
}
