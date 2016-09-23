package com.github.shanehd.utilities;

import javax.swing.*;
import java.net.URL;

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

	/**
	 * Set a {@link JFrame} icon image using
	 * @param frame The frame
	 * @param location Location of the icon (within the classpath)
     */
	public static void setJframeIcon(JFrame frame, String location) {
		URL url = frame.getClass().getResource("/" + location);
		ImageIcon icon = new ImageIcon(url);
		frame.setIconImage(icon.getImage());
	}
}
