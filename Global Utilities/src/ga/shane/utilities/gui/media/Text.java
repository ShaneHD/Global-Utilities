package ga.shane.utilities.gui.media;

import java.awt.Graphics;

/** 
 * @author http://www.shane.ga
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
