package ga.shane.utilities.gui.media;

import java.awt.Graphics;

/** 
 * TODO optional additional values (map?)
 * 
 * @author http://www.shane.ga
 */
public abstract class Media<T> {
	private T value;
	private int x, y, width, height;
	
	public Media(T value, int x, int y) {
		this(value, x, y, 0, 0);
	}
	
	public Media(T value, int x, int y, int width, int height) {
		setValue(value).setX(x).setY(y).setWidth(width).setHeight(height);
	}
	
	public abstract void draw(Graphics g);

	public T getValue() {
		return value;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public Media setValue(T value) {
		this.value = value;
		return this;
	}

	public Media setX(int x) {
		this.x = x;
		return this;
	}

	public Media setY(int y) {
		this.y = y;
		return this;
	}

	public Media setWidth(int width) {
		this.width = width;
		return this;
	}

	public Media setHeight(int height) {
		this.height = height;
		return this;
	}
}
