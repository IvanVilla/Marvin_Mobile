/*
 * MAGRATHEA - DAM
 */
package model.utils;

/**
 * Almacena un día, mes, año
 * @author Klaussius
 */
public class MyDate {
    private int Day;
    private int Month;
    private int Year;

    /**
     * Constructor con parámetros
     * @param Day día
     * @param Month mes
     * @param Year año
     */
    public MyDate(int Day, int Month, int Year) {
        this.Day = Day;
        this.Month = Month;
        this.Year = Year;
    }

    /**
     * Constructor sin parámetros
     */
    public MyDate() {
    }
    
    //GETTERS y SETTERS

    /**
     *
     * @return
     */
    public int getDay() {
        return Day;
    }

    /**
     *
     * @param Day
     */
    public void setDay(int Day) {
        this.Day = Day;
    }

    /**
     *
     * @return
     */
    public int getMonth() {
        return Month;
    }

    /**
     *
     * @param Month
     */
    public void setMonth(int Month) {
        this.Month = Month;
    }

    /**
     *
     * @return
     */
    public int getYear() {
        return Year;
    }

    /**
     *
     * @param Year
     */
    public void setYear(int Year) {
        this.Year = Year;
    }
    
}
