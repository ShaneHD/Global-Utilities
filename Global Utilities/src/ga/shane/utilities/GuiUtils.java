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
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
