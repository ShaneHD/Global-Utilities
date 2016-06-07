package com.github.shanehd.utilities;

import java.util.Calendar;

/**
 * Enum containing all days of the week<br>
 * in short form(E.G. MON), and their<br>
 * long form(E.G. Monday)
 * @see {@link #full_name}
 * 
 * @author https://www.github.com/ShaneHD
 */
public enum Day {
	MON("Monday"),
	TUE("Tuesday"),
	WED("Wednesday"),
	THU("Thursday"),
	FRI("Friday"),
	SAT("Saturday"),
	SUN("Sunday");
	
	/**
	 * The day of the week in full form<br>
	 * E.G. {@link MON} becomes Monday
	 */
	public final String full_name;
	public final int calendar_id;
	
	Day(String full) {
		full_name = full;
		int id = 0;
		
		try {
			id = Calendar.class.getField(full.toUpperCase()).getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		calendar_id = id;
	}
		
	/**
	 * @return Is this the current day of the week
	 */
	public boolean is() {
		return Calendar.getInstance().get(Calendar.DAY_OF_WEEK) == calendar_id;
	}
}
