/*
 * MAGRATHEA - DAM
 */
package model.user;

import model.benefit.Achievement;
import model.utils.MyDate;

/**
 * Store user achievements
 * @author Klaussius
 */
public class AchievementUser {
    private MyDate date;
    private Achievement achievement;

    /**
     * Constructor with parameters
     * @param date date
     * @param achievement achievement
     */
    public AchievementUser(MyDate date, Achievement achievement) {
        this.date = date;
        this.achievement = achievement;
    }

    /**
     * Constructor simple
     */
    public AchievementUser() {
    }

    // GETTERS AND SETTERS

    /**
     * Get achievement date
     * @return achievement date
     */
    public MyDate getDate() {
        return date;
    }

    /**
     * Set achievement date
     * @param date achievement date
     */
    public void setDate(MyDate date) {
        this.date = date;
    }

    /**
     * Get achievement
     * @return achievement
     */
    public Achievement getAchievement() {
        return achievement;
    }

    /**
     * Set achievement
     * @param achievement achievement
     */
    public void setAchievement(Achievement achievement) {
        this.achievement = achievement;
    }
    
}
