package com.github.shanehd.utilities;

import javax.swing.UIManager;

/**
 * Miscellaneous GUI utilities
 * 
 * @author https://www.github.com/ShaneHD
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
