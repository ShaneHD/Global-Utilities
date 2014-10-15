package ga.shane.utilities.gui;


/**
 * A {@link BJButton} designed to be used with a {@link UrlTextField}<br>
 * Automatically enables/disables based on whether the URL input is valid
 * 
 * @author http://www.shane.ga
 */
public class UrlTextFieldButton extends BJButton {	
	public UrlTextFieldButton(UrlTextField url, String text) {
		super(text);
		url.addKeyListener(new UrlTextFieldKeyListener(this));
		setEnabled(false);
	}
}
