package ga.shane.utilities;

/**
 * Enum containing all days of the week<br>
 * in short form(E.G. MON), and their<br>
 * long form(E.G. Monday)
 * @see {@link #full_name}
 * 
 * @author http://www.shane.ga
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
	
	Day(String full) {
		full_name = full;
	}
}
