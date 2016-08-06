package com.github.shanehd.utilities.gui;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;

/**
 * Designed to be added to a {@link UrlTextField}<br>
 * Automatically enables/disables a {@link JButton} based on whether the URL input is valid
 *
 * @author https://www.github.com/ShaneHD
 */
public class UrlTextFieldKeyListener implements KeyListener {
	private final JButton button;
	
	public UrlTextFieldKeyListener(JButton button) {
		this.button = button;
	}
	
	protected void update(Component c) {
		button.setEnabled(((UrlTextField) c).valid());
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		update(e.getComponent());
	}

	@Override
	public void keyReleased(KeyEvent e) {
		update(e.getComponent());
	}

	@Override
	public void keyTyped(KeyEvent e) {
		update(e.getComponent());
	}
}
