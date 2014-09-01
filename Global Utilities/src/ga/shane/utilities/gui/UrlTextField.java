package ga.shane.utilities.gui;

import java.awt.Color;

import javax.swing.text.Document;

/**
 * A {@link BJTextField} designed for URL input
 * @see {@link #valid()}
 * 
 * @author http://www.shane.ga
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
