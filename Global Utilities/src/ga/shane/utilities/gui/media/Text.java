package ga.shane.utilities.gui.media;

import java.awt.Graphics;

/** 
 * @author http://www.shane.ga
 */
public class Text extends Media<String> {
	public Text(String value, int x, int y) {
		super(value, x, y);
	}

	public Text(String value, int x, int y, int width, int height) {
		super(value, x, y, width, height);
	}

	@Override
	public void draw(Graphics g) {
		g.drawString(getValue(), getX(), getY());
	}
}
