package ga.shane.utilities.android;

import android.app.Activity;
import android.widget.Toast;

/** @author http://www.shane.ga */
public class AndroidUtils {
	private static Activity main;
	
	/**
	 * Set the main activity for this app<br>
	 * This <b>MUST</b> be set
	 */
	public static void setMainActivity(Activity activity) {
		main = activity;
	}
	
	public static Activity getMainActivity() {
		return main;
	}
	
	/**
	 * Send a <a href='http://goo.gl/WoTk'>Toast</a> to the user
	 * @param message The message to be sent
	 * @param duration The duration for it to be readable for (Toast.LENGTH_*)
	 */
	public static void toast(String message, int duration) {		
		Toast.makeText(main.getApplicationContext(), message, duration).show();
	}
	
	/**
	 * Uses {@link Toast#LENGTH_LONG}
	 * @see {@link #toast(String, int)}
	 */
	public static void toast(String message) {
		toast(message, Toast.LENGTH_LONG);
	}
}
