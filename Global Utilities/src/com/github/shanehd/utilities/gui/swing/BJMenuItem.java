package com.github.shanehd.utilities.gui.swing;

import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

/**
 * 
 *
 * @author https://www.github.com/ShaneHD
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
