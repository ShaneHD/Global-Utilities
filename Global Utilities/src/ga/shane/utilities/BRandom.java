package ga.shane.utilities;

import java.awt.Color;
import java.util.Random;

/**
 * Stands for BetterRandom<br>
 * Adds more functionality to {@link Random}
 * 
 *@see {@link #nextColor()}
 * @author http://www.shane.ga
 */
public class BRandom extends Random {
	public BRandom() {
		super();
	}
	
	public BRandom(long seed) {
		super(seed);
	}
	
	/**
	 * Calls {@link Color}({@link #nextFloat()}, {@link #nextFloat()}, {@link #nextFloat()}, {@link #nextFloat()})
	 * @return
	 */
	public Color nextColor() {
		return new Color(nextFloat(), nextFloat(), nextFloat(), nextFloat());
	}
	
	public float nextFloat(float min, float max) {
		return nextFloat() * (max - min) + min;
	}
	
	public int nextInt(int min, int max) {
		return nextInt(max - min) + min;
	}
}
