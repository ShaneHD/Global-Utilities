package com.github.shanehd.utilities.gui.swing;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.text.Document;

/**
 * A {@link BJTextField} designed for URL input
 * @see #valid()
 * 
 * @author https://www.github.com/ShaneHD
 */
public class UrlTextField extends BJTextField {
	public UrlTextField() {
		super();
	}
	
	public UrlTextField(int columns) {
		super(columns);
	}
	
	public UrlTextField(String text) {
		super(text);
	}
	
	public UrlTextField(String text, int columns) {
		super(text, columns);
	}
	
	public UrlTextField(Document doc, String text, int columns) {
		super(doc, text, columns);
	}
	
	/**
	 * Checks if valid or not<br>
	 * Also calls <code>KeyListener#keyPressed</code> to update
	 * 
	 * @return {@link #valid()}
	 */
	@SuppressWarnings("deprecation")
	public boolean update() {
		if(!valid()) {
			for(KeyListener listener : getKeyListeners())
				listener.keyPressed(new KeyEvent(this, 0, 0, 0, 0));
			
			return false;
		}
		
		return true;
	}
	
	/**
	 * TODO
	 * Is the text a valid URL?<br>
	 * (only checks for http[s]:// for now)
	 */
	public boolean valid() {
		String text = getText();
		boolean valid = text.startsWith("http") && text.contains("://");
		
		setForeground(valid ? Color.green : Color.red);
		return valid;
	}
}
