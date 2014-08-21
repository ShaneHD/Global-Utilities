package ga.shane.utilities;

import java.util.ArrayList;
import java.util.List;

/** @author http://www.shane.ga */
public class ArrayUtils {
	/** 
	 * Array equivalent of {@link List#contains(Object)}
	 */
	public static <T> boolean contains(T[] array, T find) {
		for(T t : array) {
			if(t == find)
				return true;
		}
		
		return false;
	}
	
	/**
	 * Checks whether an array contains a value more than once or not
	 */
	public static boolean isExclusivelyPopulated(Object[] array) {
		ArrayList<Object> contents = new ArrayList<Object>();
		
		for(Object obj : array) {
			if(contents.contains(obj))
				return false;
			
			contents.add(obj);
		}
		
		return true;
	}
	
	/**
	 * Checks if an array is fully populated by one value ({@link value})
	 */
	public static boolean populated(Object[] array, Object value) {
		for(Object obj : array) {
			if(obj != value)
				return false;
		}
		
		return true;
	}
	
	/**
	 * Populate all spaces in an array with one value
	 */
	public static void populate(Object[] array, Object value) {
		for(int i = 0; i < array.length; i++)
			array[i] = value;
	}
	
	/**
	 * Converts a int array to its object equivalent ({@link Integer})[]
	 */
	public static Integer[] primToObj(int[] array) {
		Integer[] clone = new Integer[array.length];

		for(int i = 0; i < array.length; i++)
			clone[i] = array[i];

		return clone;
	}

	/**
	 * Converts a float array to its object equivalent ({@link Float})[]
	 */
	public static Float[] primToObj(float[] array) {
		Float[] clone = new Float[array.length];

		for(int i = 0; i < array.length; i++)
			clone[i] = array[i];

		return clone;
	}

	/**
	 * Converts a boolean array to its object equivalent ({@link Boolean})[]
	 */
	public static Boolean[] primToObj(boolean[] array) {
		Boolean[] clone = new Boolean[array.length];

		for(int i = 0; i < array.length; i++)
			clone[i] = array[i];

		return clone;
	}

	/**
	 * Converts a double array to its object equivalent ({@link Double})[]
	 */
	public static Double[] primToObj(double[] array) {
		Double[] clone = new Double[array.length];

		for(int i = 0; i < array.length; i++)
			clone[i] = array[i];

		return clone;
	}

	/**
	 * Converts a char array to its object equivalent ({@link Character})[]
	 */
	public static Character[] primToObj(char[] array) {
		Character[] clone = new Character[array.length];

		for(int i = 0; i < array.length; i++)
			clone[i] = array[i];

		return clone;
	}

	/**
	 * Converts a byte array to its object equivalent ({@link Byte})[]
	 */
	public static Byte[] primToObj(byte[] array) {
		Byte[] clone = new Byte[array.length];

		for(int i = 0; i < array.length; i++)
			clone[i] = array[i];

		return clone;
	}

	/**
	 * Converts a {@link Integer} array to its primitive equivalent (int[])
	 */
	public static int[] objToPrim(Integer[] array) {
		int[] clone = new int[array.length];

		for(int i = 0; i < array.length; i++)
			clone[i] = array[i];

		return clone;
	}

	/**
	 * Converts a {@link Float} array to its primitive equivalent (float[])
	 */
	public static float[] objToPrim(Float[] array) {
		float[] clone = new float[array.length];

		for(int i = 0; i < array.length; i++)
			clone[i] = array[i];

		return clone;
	}

	/**
	 * Converts a {@link Boolean} array to its primitive equivalent (boolean[])
	 */
	public static boolean[] objToPrim(Boolean[] array) {
		boolean[] clone = new boolean[array.length];

		for(int i = 0; i < array.length; i++)
			clone[i] = array[i];

		return clone;
	}

	/**
	 * Converts a {@link Double} array to its primitive equivalent (double[])
	 */
	public static double[] objToPrim(Double[] array) {
		double[] clone = new double[array.length];

		for(int i = 0; i < array.length; i++)
			clone[i] = array[i];

		return clone;
	}

	/**
	 * Converts a {@link Character} array to its primitive equivalent (char[])
	 */
	public static char[] objToPrim(Character[] array) {
		char[] clone = new char[array.length];

		for(int i = 0; i < array.length; i++)
			clone[i] = array[i];

		return clone;
	}

	/**
	 * Converts a {@link Byte} array to its primitive equivalent (byte[])
	 */
	public static byte[] objToPrim(Byte[] array) {
		byte[] clone = new byte[array.length];

		for(int i = 0; i < array.length; i++)
			clone[i] = array[i];

		return clone;
	}


}
