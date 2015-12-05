package com.github.shanehd.utilities.gui.media;

import java.awt.Graphics;

/** 
 * @author https://www.github.com/ShaneHD
 */
public class Text extends Media<String> {
	public Text(String value, int x, int y) {
		super(value, x, y);
	}

	@Override
	public void draw(Graphics g) {
		g.drawString(getValue(), getX(), getY());
	}
}
