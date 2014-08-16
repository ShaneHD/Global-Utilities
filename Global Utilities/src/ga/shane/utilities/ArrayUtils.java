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
	
	//TODO sort through the below methods and check documentation
	
	/**
	 * Convert Integer[] to int[]
	 */
	public static void setArray(final Integer[] from, final int[] to) {
		for(int i = 0; i < from.length; i++)
			to[i] = from[i];
	}
	
	/**
	 * Convert int[] to Integer[] 
	 */
	public static void setArray(final int[] from, final Integer[] to) {
		for(int i = 0; i < from.length; i++)
			to[i] = from[i];	
	}
	
	/**
	 * Convert Integer[] to int[]
	 */
	public static int[] objArrayToPrim(final Integer[] array) {
		final int[] clone = new int[array.length];
		
		for(int i = 0; i < array.length; i++)
			clone[i] = array[i];
		
		return clone;
	}
	
	/**
	 * Convert int[] to Integer[]
	 */
	public static Integer[] primArrayToObj(final int[] array) {
		final Integer[] clone = new Integer[array.length];
		
		for(int i = 0; i < array.length; i++)
			clone[i] = array[i];
		
		return clone;
	}
	
	/**
	 * Convert Float[] to float[]
	 */
	public static void setArray(final Float[] from, final float[] to) {
		for(int i = 0; i < from.length; i++)
			to[i] = from[i];
	}
	
	/**
	 * Convert float[] to Float[]
	 */
	public static void setArray(final float[] from, final Float[] to) {
		for(int i = 0; i < from.length; i++)
			to[i] = from[i];	
	}
	
	/**
	 * Convert Float[] to float[]
	 */
	public static float[] objArrayToPrim(final Float[] array) {
		final float[] clone = new float[array.length];
		
		for(int i = 0; i < array.length; i++)
			clone[i] = array[i];
		
		return clone;
	}
	
	/**
	 * Convert float[] to Float[]
	 */
	public static Float[] primArrayToObj(final float[] array) {
		final Float[] clone = new Float[array.length];
		
		for(int i = 0; i < array.length; i++)
			clone[i] = array[i];
		
		return clone;
	}
	
	/**
	 * Convert Boolean[] to boolean[]
	 */
	public static void setArray(final Boolean[] from, final boolean[] to) {
		for(int i = 0; i < from.length; i++)
			to[i] = from[i];
	}
	
	/**
	 * Convert boolean[] to Boolean[]
	 */
	public static void setArray(final boolean[] from, final Boolean[] to) {
		for(int i = 0; i < from.length; i++)
			to[i] = from[i];	
	}
	
	/**
	 * Convert Boolean[] to boolean[]
	 */
	public static boolean[] objArrayToPrim(final Boolean[] array) {
		final boolean[] clone = new boolean[array.length];
		
		for(int i = 0; i < array.length; i++)
			clone[i] = array[i];
		
		return clone;
	}
	
	/**
	 * Convert boolean[] to Boolean[]
	 */
	public static Boolean[] primArrayToObj(final boolean[] array) {
		final Boolean[] clone = new Boolean[array.length];
		
		for(int i = 0; i < array.length; i++)
			clone[i] = array[i];
		
		return clone;
	}
	
	/**
	 * Convert Double[] to double[]
	 */
	public static void setArray(final Double[] from, final double[] to) {
		for(int i = 0; i < from.length; i++)
			to[i] = from[i];
	}
	
	/**
	 * Convert double[] to Double[]
	 */
	public static void setArray(final double[] from, final Double[] to) {
		for(int i = 0; i < from.length; i++)
			to[i] = from[i];	
	}
	
	/**
	 * Convert Double[] to double[]
	 */
	public static double[] objArrayToPrim(final Double[] array) {
		final double[] clone = new double[array.length];
		
		for(int i = 0; i < array.length; i++)
			clone[i] = array[i];
		
		return clone;
	}
	
	/**
	 * Convert double[] to Double[]
	 */
	public static Double[] primArrayToObj(final double[] array) {
		final Double[] clone = new Double[array.length];
		
		for(int i = 0; i < array.length; i++)
			clone[i] = array[i];
		
		return clone;
	}
	
	/**
	 * Convert Character[] to char[]
	 */
	public static void setArray(final Character[] from, final char[] to) {
		for(int i = 0; i < from.length; i++)
			to[i] = from[i];
	}
	
	/**
	 * Convert char[] to Character[]
	 */
	public static void setArray(final char[] from, final Character[] to) {
		for(int i = 0; i < from.length; i++)
			to[i] = from[i];	
	}
	
	/**
	 * Convert Character[] to char[]
	 */
	public static char[] objArrayToPrim(final Character[] array) {
		final char[] clone = new char[array.length];
		
		for(int i = 0; i < array.length; i++)
			clone[i] = array[i];
		
		return clone;
	}
	
	/**
	 * Convert char[] to Character
	 */
	public static Character[] primArrayToObj(final char[] array) {
		final Character[] clone = new Character[array.length];
		
		for(int i = 0; i < array.length; i++)
			clone[i] = array[i];
		
		return clone;
	}
	
	/**
	 * Convert Byte[] to byte[]
	 */
	public static void setArray(final Byte[] from, final byte[] to) {
		for(int i = 0; i < from.length; i++)
			to[i] = from[i];
	}
	
	/**
	 * Convert byte[] to Byte[]
	 */
	public static void setArray(final byte[] from, final Byte[] to) {
		for(int i = 0; i < from.length; i++)
			to[i] = from[i];	
	}
	
	/**
	 * Convert Byte[] to byte[]
	 */
	public static byte[] objArrayToPrim(final Byte[] array) {
		final byte[] clone = new byte[array.length];
		
		for(int i = 0; i < array.length; i++)
			clone[i] = array[i];
		
		return clone;
	}
	
	/**
	 * Convert byte[] to Byte[]
	 */
	public static Byte[] primArrayToObj(final byte[] array) {
		final Byte[] clone = new Byte[array.length];
		
		for(int i = 0; i < array.length; i++)
			clone[i] = array[i];
		
		return clone;
	}
}
