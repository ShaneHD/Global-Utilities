package ga.shane.utilities.gui;

import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.event.ActionListener;

/**
 * Stands for BetterMenuItem<br>
 * Adds an {@link ActionListener} in the constructors
 * 
 * @see {@link MenuItem}
 * @author https://www.github.com/ShaneHD
 */
public abstract class BMenuItem extends MenuItem implements ActionListener {
	public BMenuItem() {
		super();
		addActionListener(this);
	}
	
	public BMenuItem(String label) {
		super(label);
		addActionListener(this);
	}
	
	public BMenuItem(String label, MenuShortcut s) {
		super(label, s);
		addActionListener(this);
	}
}
