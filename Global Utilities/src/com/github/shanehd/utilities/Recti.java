package com.github.shanehd.utilities;

/** 
 * @author https://www.github.com/ShaneHD
 */
public class Recti {
	public int x, y, width, height;
	
	public Recti(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	private boolean determine(int pos1, int pos2, int mod1, int mod2) {
		return (pos1 > pos2 && pos1 + mod1 < pos2 + mod2) || (pos2 > pos1 && pos2 + mod2 < pos1 + mod1);
	}
	
	public boolean intersects(int rx, int ry, int rwidth, int rheight) {
		return determine(x, rx, width, rwidth) && determine(y, ry, height, rheight);
	}
	
	public boolean intersects(Recti rect) {
		return intersects(rect.x, rect.y, rect.width, rect.height);		
	}
	
	public boolean intersects(Rectf rect) {
		return intersects((int)rect.x, (int)rect.y, (int)rect.width, (int)rect.height);
	}
	
	@Override
	public String toString() {
		return "[Rect: " + x + ", " + y + ", " + width + ", " + height + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Recti) {
			Recti rekt = (Recti) obj;	
			return rekt == this || (rekt.x == x && rekt.y == y && rekt.width == width && rekt.height == height);
		}
		
		return super.equals(obj);
	}
}
