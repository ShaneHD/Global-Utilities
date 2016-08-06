package com.github.shanehd.utilities.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPasswordField;
import javax.swing.text.Document;

/** 
 * Stands for BetterJPasswordField<br>
 * Adds support for a placeholder (text that draws when nothing is entered)<br><br>
 * @see #setPlaceholder(String)
 * @see #getPlaceholder()
 * @see #setPlaceholderColor(Color)
 * @see #getPlaceholderColor()
 *
 * @author https://www.github.com/ShaneHD 
*/
public class BJPasswordField extends JPasswordField implements IBJTextField {
	private String placeholder;
	private Color placeholderColor = Color.gray;
	
	public BJPasswordField() {
		super();
	}
	
	public BJPasswordField(int columns) {
		super(columns);
	}
	
	public BJPasswordField(String text) {
		super(text);
	}
	
	public BJPasswordField(String text, int columns) {
		super(text, columns);
	}
	
	public BJPasswordField(Document doc, String text, int columns) {
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
	
	@SuppressWarnings("deprecation")
	@Override
	public void paintPlaceholder(Graphics g) {
		if(getPlaceholder() == null || getPlaceholder().length() == 0 || getText().length() > 0)
			return;
		
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setColor(getPlaceholderColor());
		g.drawString(getPlaceholder(), getInsets().left, g2d.getFontMetrics().getMaxAscent() + getInsets().top);
	}
}
