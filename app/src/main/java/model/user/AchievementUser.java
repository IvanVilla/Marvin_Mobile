/*
 * MAGRATHEA - DAM
 */
package model.user;

import model.benefits.Achievement;
import model.utils.MyDate;

/**
 * Almacena los logros de un usuario
 * @author Klaussius
 */
public class AchievementUser {
    private MyDate date;
    private Achievement achievement;

    /**
     * Constructor con parámetros
     * @param date fecha del logro
     * @param achievement logro
     */
    public AchievementUser(MyDate date, Achievement achievement) {
        this.date = date;
        this.achievement = achievement;
    }

    /**
     * Constructor sin parámetros
     */
    public AchievementUser() {
    }

    // GETTERS y SETTERS

    /**
     * Devuelve la fecha del logro
     *  @return fecha del logro
     */
    public MyDate getDate() {
        return date;
    }

    /**
     * Guarda la fecha del logro
     * @param date fecha del logro
     */
    public void setDate(MyDate date) {
        this.date = date;
    }

    /**
     * Devuelve el logro
     * @return logro
     */
    public Achievement getAchievement() {
        return achievement;
    }

    /**
     * Guarda el logro
     * @param achievement logro
     */
    public void setAchievement(Achievement achievement) {
        this.achievement = achievement;
    }
    
}
