package ga.shane.utilities.gui;

import javax.swing.JPanel;

/** 
 * Stands for BetterJPanel.<br>
 * Adds {@link #clear()}
 * 
 * @author http://www.shane.ga
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
