package com.github.shanehd.utilities;

import java.util.Calendar;

/**
 * @author https://www.github.com/ShaneHD
 *         Created by Shane on 07/06/2016.
 */
public enum Month {
    JAN("January"),
    FEB("February"),
    MAR("March"),
    APR("April"),
    MAY("May"),
    JUN("June"),
    JUL("July"),
    AUG("August"),
    SEP("September"),
    OCT("October"),
    NOV("November"),
    DEC("December");

    /**
     * The month name in full form<br>
     * E.G. {@link JAN} becomes January
     */
    public final String full_name;
    public final int calendar_id;


    Month(String full) {
        full_name = full;
        int id = 0;

        try {
            id = Calendar.class.getField(full.toUpperCase()).getInt(1);
        } catch(Exception e) {
            e.printStackTrace();
        }

        calendar_id = id;
    }

    /**
     * @return Is this the current month?
     */
    public boolean is() {
        return Calendar.getInstance().get(Calendar.MONTH) == calendar_id;
    }
}
