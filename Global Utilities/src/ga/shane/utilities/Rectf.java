package ga.shane.utilities;

/** 
 * @author http://www.shane.ga
 */
public class Rectf {
	public float x, y, width, height;
	
	public Rectf(float x, float y, float width, float height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	private boolean determine(float pos1, float pos2, float mod1, float mod2) {
		return (pos1 > pos2 && pos1 + mod1 < pos2 + mod2) || (pos2 > pos1 && pos2 + mod2 < pos1 + mod1);
	}
	
	public boolean intersects(float rx, float ry, float rwidth, float rheight) {
		return determine(x, rx, width, rwidth) && determine(y, ry, height, rheight);
	}
	
	public boolean intersects(Rectf rect) {
		return intersects(rect.x, rect.y, rect.width, rect.height);		
	}
	
	@Override
	public String toString() {
		return "[Rect: " + x + ", " + y + ", " + width + ", " + height + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Rectf) {
			Rectf rekt = (Rectf) obj;	
			return rekt == this || (rekt.x == x && rekt.y == y && rekt.width == width && rekt.height == height);
		}
		
		return super.equals(obj);
	}
}
