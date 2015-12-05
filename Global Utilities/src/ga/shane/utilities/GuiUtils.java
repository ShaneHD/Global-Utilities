package ga.shane.utilities;

import javax.swing.UIManager;

/**
 * Miscellaneous GUI utilities
 * 
 * @author http://www.shane.ga
 */
public class GuiUtils {
	/**
	 * Calls {@link UIManager#setLookAndFeel(javax.swing.LookAndFeel)} with {@link UIManager#getSystemLookAndFeelClassName()}
	 */
	public static void setDefaultLookandfeel() {
		try {
			setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Set the swing look and feel
	 */
	public static void setLookAndFeel(String laf) {
		try {
			UIManager.setLookAndFeel(laf);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
