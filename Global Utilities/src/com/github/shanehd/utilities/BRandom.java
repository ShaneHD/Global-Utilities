package com.github.shanehd.utilities;

import java.awt.Color;
import java.util.Random;

/**
 * Stands for BetterRandom<br>
 * Adds more functionality to {@link Random}
 * 
 * @see #nextColor()
 * @see #chance(int)
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
	 * Generates a random color using {@link #nextFloat()}
	 */
	public Color nextColor() {
		return new Color(nextFloat(), nextFloat(), nextFloat(), nextFloat());
	}

	/**
	 * Generates a random float between <code>min</code> and <code>max</code> using {@link #nextFloat()}
	 * @param min The minimum value of the random float
	 * @param max The maximum value of the random float
	 */
	public float nextFloat(float min, float max) {
		return nextFloat() * (max - min) + min;
	}

	/**
	 * Generates a random int between <code>min</code> and <code>max</code> using {@link #nextFloat()}
	 * @param min The minimum value of the random int
	 * @param max The maximum value of the random int
	 */
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
