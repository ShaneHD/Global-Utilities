package com.github.shanehd.utilities.gui.swing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JTextField;
import javax.swing.text.Document;

/** 
 * Stands for BetterJTextField<br>
 * Adds support for a placeholder (text that draws when nothing is entered)
 *
 * @see #setPlaceholder(String)
 * @see #getPlaceholder()
 * @see #setPlaceholderColor(Color)
 * @see #getPlaceholderColor()
 *
 * @author https://www.github.com/ShaneHD
*/
public class BJTextField extends JTextField implements IBJTextField {
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
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		paintPlaceholder(g);
	}

	@Override
	public String getPlaceholder() {
		return placeholder;
	}

	@Override
	public void setPlaceholder(String placeholder) {
		this.placeholder = placeholder;
	}

	@Override
	public Color getPlaceholderColor() {
		return placeholderColor;
	}

	@Override
	public void setPlaceholderColor(Color color) {
		placeholderColor = color;
	}

	@Override
	public void paintPlaceholder(Graphics g) {
		if(getPlaceholder() == null || getPlaceholder().length() == 0 || getText().length() > 0)
			return;
		
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setColor(getPlaceholderColor());
		g.drawString(getPlaceholder(), getInsets().left, g2d.getFontMetrics().getMaxAscent() + getInsets().top);
	}
	
	/**
	 * Clear all text<br>
	 * Calls <code>{@link #setText(String)}</code> with <code>""</code>
	 */
	public void clear() {
		setText("");
	}
}
