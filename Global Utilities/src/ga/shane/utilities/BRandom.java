package ga.shane.utilities;

import java.awt.Color;
import java.util.Random;

/**
 * Stands for BetterRandom<br>
 * Adds more functionality to {@link Random}
 * 
 * @see {@link #nextColor()}
 * @see {@link #chance(int)}
 * @author https://www.github.com/ShaneHD
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
	
	/**
	 * Uses {@link #nextInt(int)} to generate a random number, and returns whether it's equal to max or not<br>
	 * Useful for random events with a set chance of happening
	 */
	public boolean chance(int max) {
		return nextInt(max + 1) == max;
	}
}
