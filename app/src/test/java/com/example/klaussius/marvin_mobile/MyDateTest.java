package com.example.klaussius.marvin_mobile;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import model.utils.MyDate;

/**
 * Testing queryTournamentsByStatus class isFuture function
 * Created by klaus on 25/01/2017
 */

public class MyDateTest {

    //Future
    @Test
    public void dataValidator_day_isFuture(){
        MyDate future = new MyDate(new MyDate().getDay()+1,new MyDate().getMonth(),new MyDate().getYear());
        assertThat(future.isFuture(), is(true));
    }

    @Test
    public void dataValidator_month_isFuture(){
        MyDate future = new MyDate(new MyDate().getDay(),new MyDate().getMonth()+1,new MyDate().getYear());
        assertThat(future.isFuture(), is(true));
    }

    @Test
    public void dataValidator_year_isFuture(){
        MyDate future = new MyDate(new MyDate().getDay(),new MyDate().getMonth(),new MyDate().getYear()+1);
        assertThat(future.isFuture(), is(true));
    }

    //Past
    @Test
    public void dataValidator_day_isPast(){
        MyDate past = new MyDate(new MyDate().getDay()-1,new MyDate().getMonth(),new MyDate().getYear());
        assertThat(past.isFuture(), is(false));
    }

    @Test
    public void dataValidator_month_isPast(){
        MyDate past = new MyDate(new MyDate().getDay(),new MyDate().getMonth()-1,new MyDate().getYear());
        assertThat(past.isFuture(), is(false));
    }

    @Test
    public void dataValidator_year_isPast(){
        MyDate past = new MyDate(new MyDate().getDay(),new MyDate().getMonth(),new MyDate().getYear()-1);
        assertThat(past.isFuture(), is(false));
    }
}
