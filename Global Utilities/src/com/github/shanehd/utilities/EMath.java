package com.github.shanehd.utilities;

/**
 * Contains some math functions
 *
 * @author https://www.github.com/ShaneHD
 */
public class EMath {
	/**
	 * @return The closest even number <code>>= i</code>
	 */
	public static int toNextEven(int i) {
		return i % 2 == 0 ? i : ++i;
	}

	/**
	 * @return The closest even number <code><= i</code>
	 */
	public static int toLastEven(int i) {
		return i % 2 == 0 ? i : --i;
	}

	/**
	 * @return The closest odd number <code>>= i</code>
	 */
	public static int toNextOdd(int i) {
		return i % 2 == 0 ? ++i : i;
	}

	/**
	 * @return The closest odd number <code><= i</code>
	 */
	public static int toLastOdd(int i) {
		return i % 2 == 0 ? --i : i;
	}
	
	/**
	 * Helps to find the center location in <code>int</code> form
	 */
	public static int center(int size, int maxsize) {
		return maxsize / 2 - (size/ 2);
	}

	/**
	 * Helps to find the center location in <code>float</code> form
	 */
	public static float center(float size, float maxsize) {
		return maxsize / 2 - (size/ 2);
	}
}
