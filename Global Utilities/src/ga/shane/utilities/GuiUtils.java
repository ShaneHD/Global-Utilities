package ga.shane.utilities;

import javax.swing.UIManager;

/** @author http://www.shane.ga */
public class GuiUtils {
	public static void setDefaultLookandfeel() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
