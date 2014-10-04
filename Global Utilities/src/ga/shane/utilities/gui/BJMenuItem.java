package ga.shane.utilities.gui;

import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

/**
 * 
 *
 * @author http://www.shane.ga
 */
public abstract class BJMenuItem extends JMenuItem implements ActionListener {
	public BJMenuItem() {
		super();
		addActionListener(this);
	}
	
	public BJMenuItem(String label) {
		super(label);
		addActionListener(this);
	}
}
