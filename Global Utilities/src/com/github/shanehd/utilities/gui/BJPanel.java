package com.github.shanehd.utilities.gui;

import javax.swing.JPanel;

/** 
 * Stands for BetterJPanel.<br>
 * Adds {@link #clear()}
 * 
 * @author https://www.github.com/ShaneHD
 */
public class BJPanel extends JPanel {

	/**
	 * Clear this {@link JPanel}<br>
	 * Remove all components & refresh
	 */
	public void clear() {
		removeAll();
		revalidate();
		repaint();
	}
}
