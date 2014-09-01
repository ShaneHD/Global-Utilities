package ga.shane.utilities.gui;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Action;
import javax.swing.Icon;

/**
 * A {@link BJButton} designed to be used with a {@link UrlTextField}<br>
 * Automatically enables/disables based on whether the URL input is valid
 * 
 * @author http://www.shane.ga
 */
public class UrlTextFieldButton extends BJButton implements KeyListener {	
	public UrlTextFieldButton(UrlTextField url, String text) {
		super(text);
		url.addKeyListener(this);
	}
	
	public void update(Component c) {
		setEnabled(((UrlTextField) c).valid());
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
