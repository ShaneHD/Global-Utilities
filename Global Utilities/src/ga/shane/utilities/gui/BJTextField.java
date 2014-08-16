package ga.shane.utilities.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.text.Document;

/** 
 * Stands for BetterJTextField<br>
 * Adds support for a placeholder (text that draws when nothing is entered)<br><br>
 * See {@link #setPlaceholder(String)} and {@link #getPlaceholder()}<br>
 * See {@link #setPlaceholderColor(Color)} and {@link #getPlaceholderColor()} for the placeholder's draw color
 * 
 * @see {@link JTextField}
 * @author http://www.shane.ga 
*/
public class BJTextField extends JTextField {
	private String placeholder;
	private Color placeholderColor = Color.gray;
	
	public BJTextField() {
		super();
	}
	
	public BJTextField(int columns) {
		super(columns);
	}
	
	public BJTextField(String text) {
		super(text);
	}
	
	public BJTextField(String text, int columns) {
		super(text, columns);
	}
	
	public BJTextField(Document doc, String text, int columns) {
		super(doc, text, columns);
	}
	
	/**
	 * Get the placeholder
	 * @see {@link #setPlaceholder(String)}
	 */
	public String getPlaceholder() {
		return placeholder;
	}
	
	/**
	 * Set the placeholder
	 * @see {@link #getPlaceholder()}
	 */
	public void setPlaceholder(String placeholder) {
		this.placeholder = placeholder;
	}
	
	/**
	 * Get the placeholder's draw color
	 * @see {@link #setPlaceholderColor(Color)}
	 */
	public Color getPlaceholderColor() {
		return placeholderColor;
	}
	
	/**
	 * Set the placeholder's draw color
	 * @see {@link #getPlaceholderColor()}
	 */
	public void setPlaceholderColor(Color color) {
		placeholderColor = color;
	}
	
	/**
	 * @author Peter Tseng
	 */
	private void paintPlaceholder(Graphics g) {
		if(getPlaceholder() == null || getPlaceholder().length() == 0 || getText().length() > 0)
			return;
		
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setColor(getPlaceholderColor());
		g.drawString(getPlaceholder(), getInsets().left, g2d.getFontMetrics().getMaxAscent() + getInsets().top);	
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		paintPlaceholder(g);
	}
}
