
	/*
	 ################################################################
	################ Auto generated code #############################
	 ################################################################
	*/

package ga.shane.utilities;

import java.util.ArrayList;
import java.lang.reflect.Array;

/** @author http://www.shane.ga */
public class ArrayUtils {
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
	 * Converts a short array to its object equivalent ({@link Short})[]
	 */
	public static Short[] primToObj(short[] array) {
		Short[] clone = new Short[array.length];
	
		for(int i = 0; i < array.length; i++)
			clone[i] = array[i];
	
		return clone;
	}
	/**
	 * Converts a long array to its object equivalent ({@link Long})[]
	 */
	public static Long[] primToObj(long[] array) {
		Long[] clone = new Long[array.length];
	
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
	/**
	 * Converts a {@link Short} array to its primitive equivalent (short[])
	 */
	public static short[] objToPrim(Short[] array) {
		short[] clone = new short[array.length];
	
		for(int i = 0; i < array.length; i++)
			clone[i] = array[i];
	
		return clone;
	}
	/**
	 * Converts a {@link Long} array to its primitive equivalent (long[])
	 */
	public static long[] objToPrim(Long[] array) {
		long[] clone = new long[array.length];
	
		for(int i = 0; i < array.length; i++)
			clone[i] = array[i];
	
		return clone;
	}
	/**
	 * Array equivalent of {@link List#contains(Object)}
	 */
	public static boolean contains(Integer[] array, Integer find) {
		for(Integer cur : array) {
			if(cur.equals(find))
				return true;
		}
	
		return false;
	}
	/**
	 * Array equivalent of {@link List#contains(Object)}
	 */
	public static boolean contains(Float[] array, Float find) {
		for(Float cur : array) {
			if(cur.equals(find))
				return true;
		}
	
		return false;
	}
	/**
	 * Array equivalent of {@link List#contains(Object)}
	 */
	public static boolean contains(Boolean[] array, Boolean find) {
		for(Boolean cur : array) {
			if(cur.equals(find))
				return true;
		}
	
		return false;
	}
	/**
	 * Array equivalent of {@link List#contains(Object)}
	 */
	public static boolean contains(Double[] array, Double find) {
		for(Double cur : array) {
			if(cur.equals(find))
				return true;
		}
	
		return false;
	}
	/**
	 * Array equivalent of {@link List#contains(Object)}
	 */
	public static boolean contains(Character[] array, Character find) {
		for(Character cur : array) {
			if(cur.equals(find))
				return true;
		}
	
		return false;
	}
	/**
	 * Array equivalent of {@link List#contains(Object)}
	 */
	public static boolean contains(Byte[] array, Byte find) {
		for(Byte cur : array) {
			if(cur.equals(find))
				return true;
		}
	
		return false;
	}
	/**
	 * Array equivalent of {@link List#contains(Object)}
	 */
	public static boolean contains(Short[] array, Short find) {
		for(Short cur : array) {
			if(cur.equals(find))
				return true;
		}
	
		return false;
	}
	/**
	 * Array equivalent of {@link List#contains(Object)}
	 */
	public static boolean contains(Long[] array, Long find) {
		for(Long cur : array) {
			if(cur.equals(find))
				return true;
		}
	
		return false;
	}
	/**
	 * Array equivalent of {@link List#contains(Object)}
	 */
	public static boolean contains(Object[] array, Object find) {
		for(Object cur : array) {
			if(cur.equals(find))
				return true;
		}
	
		return false;
	}
	/**
	 * Array equivalent of {@link List#contains(Object)}
	 */
	public static boolean contains(int[] array, int find) {
		for(int cur : array) {
			if(cur == find)
				return true;
		}
	
		return false;
	}
	/**
	 * Array equivalent of {@link List#contains(Object)}
	 */
	public static boolean contains(float[] array, float find) {
		for(float cur : array) {
			if(cur == find)
				return true;
		}
	
		return false;
	}
	/**
	 * Array equivalent of {@link List#contains(Object)}
	 */
	public static boolean contains(boolean[] array, boolean find) {
		for(boolean cur : array) {
			if(cur == find)
				return true;
		}
	
		return false;
	}
	/**
	 * Array equivalent of {@link List#contains(Object)}
	 */
	public static boolean contains(double[] array, double find) {
		for(double cur : array) {
			if(cur == find)
				return true;
		}
	
		return false;
	}
	/**
	 * Array equivalent of {@link List#contains(Object)}
	 */
	public static boolean contains(char[] array, char find) {
		for(char cur : array) {
			if(cur == find)
				return true;
		}
	
		return false;
	}
	/**
	 * Array equivalent of {@link List#contains(Object)}
	 */
	public static boolean contains(byte[] array, byte find) {
		for(byte cur : array) {
			if(cur == find)
				return true;
		}
	
		return false;
	}
	/**
	 * Array equivalent of {@link List#contains(Object)}
	 */
	public static boolean contains(short[] array, short find) {
		for(short cur : array) {
			if(cur == find)
				return true;
		}
	
		return false;
	}
	/**
	 * Array equivalent of {@link List#contains(Object)}
	 */
	public static boolean contains(long[] array, long find) {
		for(long cur : array) {
			if(cur == find)
				return true;
		}
	
		return false;
	}
	/**
	 * Set the contents of an array to that of another array
	 */
	public static void set(Integer[] from, Integer[] to) {
		if(from.length != to.length)
			throw new RuntimeException("Can't set array -> to, because sizes aren't the same");
	
		for(int i = 0; i < from.length; i++)
			from[i] = to[i];
	}
	/**
	 * Set the contents of an array to that of another array
	 */
	public static void set(Float[] from, Float[] to) {
		if(from.length != to.length)
			throw new RuntimeException("Can't set array -> to, because sizes aren't the same");
	
		for(int i = 0; i < from.length; i++)
			from[i] = to[i];
	}
	/**
	 * Set the contents of an array to that of another array
	 */
	public static void set(Boolean[] from, Boolean[] to) {
		if(from.length != to.length)
			throw new RuntimeException("Can't set array -> to, because sizes aren't the same");
	
		for(int i = 0; i < from.length; i++)
			from[i] = to[i];
	}
	/**
	 * Set the contents of an array to that of another array
	 */
	public static void set(Double[] from, Double[] to) {
		if(from.length != to.length)
			throw new RuntimeException("Can't set array -> to, because sizes aren't the same");
	
		for(int i = 0; i < from.length; i++)
			from[i] = to[i];
	}
	/**
	 * Set the contents of an array to that of another array
	 */
	public static void set(Character[] from, Character[] to) {
		if(from.length != to.length)
			throw new RuntimeException("Can't set array -> to, because sizes aren't the same");
	
		for(int i = 0; i < from.length; i++)
			from[i] = to[i];
	}
	/**
	 * Set the contents of an array to that of another array
	 */
	public static void set(Byte[] from, Byte[] to) {
		if(from.length != to.length)
			throw new RuntimeException("Can't set array -> to, because sizes aren't the same");
	
		for(int i = 0; i < from.length; i++)
			from[i] = to[i];
	}
	/**
	 * Set the contents of an array to that of another array
	 */
	public static void set(Short[] from, Short[] to) {
		if(from.length != to.length)
			throw new RuntimeException("Can't set array -> to, because sizes aren't the same");
	
		for(int i = 0; i < from.length; i++)
			from[i] = to[i];
	}
	/**
	 * Set the contents of an array to that of another array
	 */
	public static void set(Long[] from, Long[] to) {
		if(from.length != to.length)
			throw new RuntimeException("Can't set array -> to, because sizes aren't the same");
	
		for(int i = 0; i < from.length; i++)
			from[i] = to[i];
	}
	/**
	 * Set the contents of an array to that of another array
	 */
	public static void set(Object[] from, Object[] to) {
		if(from.length != to.length)
			throw new RuntimeException("Can't set array -> to, because sizes aren't the same");
	
		for(int i = 0; i < from.length; i++)
			from[i] = to[i];
	}
	/**
	 * Set the contents of an array to that of another array
	 */
	public static void set(int[] from, int[] to) {
		if(from.length != to.length)
			throw new RuntimeException("Can't set array -> to, because sizes aren't the same");
	
		for(int i = 0; i < from.length; i++)
			from[i] = to[i];
	}
	/**
	 * Set the contents of an array to that of another array
	 */
	public static void set(float[] from, float[] to) {
		if(from.length != to.length)
			throw new RuntimeException("Can't set array -> to, because sizes aren't the same");
	
		for(int i = 0; i < from.length; i++)
			from[i] = to[i];
	}
	/**
	 * Set the contents of an array to that of another array
	 */
	public static void set(boolean[] from, boolean[] to) {
		if(from.length != to.length)
			throw new RuntimeException("Can't set array -> to, because sizes aren't the same");
	
		for(int i = 0; i < from.length; i++)
			from[i] = to[i];
	}
	/**
	 * Set the contents of an array to that of another array
	 */
	public static void set(double[] from, double[] to) {
		if(from.length != to.length)
			throw new RuntimeException("Can't set array -> to, because sizes aren't the same");
	
		for(int i = 0; i < from.length; i++)
			from[i] = to[i];
	}
	/**
	 * Set the contents of an array to that of another array
	 */
	public static void set(char[] from, char[] to) {
		if(from.length != to.length)
			throw new RuntimeException("Can't set array -> to, because sizes aren't the same");
	
		for(int i = 0; i < from.length; i++)
			from[i] = to[i];
	}
	/**
	 * Set the contents of an array to that of another array
	 */
	public static void set(byte[] from, byte[] to) {
		if(from.length != to.length)
			throw new RuntimeException("Can't set array -> to, because sizes aren't the same");
	
		for(int i = 0; i < from.length; i++)
			from[i] = to[i];
	}
	/**
	 * Set the contents of an array to that of another array
	 */
	public static void set(short[] from, short[] to) {
		if(from.length != to.length)
			throw new RuntimeException("Can't set array -> to, because sizes aren't the same");
	
		for(int i = 0; i < from.length; i++)
			from[i] = to[i];
	}
	/**
	 * Set the contents of an array to that of another array
	 */
	public static void set(long[] from, long[] to) {
		if(from.length != to.length)
			throw new RuntimeException("Can't set array -> to, because sizes aren't the same");
	
		for(int i = 0; i < from.length; i++)
			from[i] = to[i];
	}
	/**
	 * Populate all spaces in an array with one value
	 */
	public static void populate(Integer[] array, Integer value) {
		for(int i = 0; i < array.length; i++)
			array[i] = value;
	}
	/**
	 * Populate all spaces in an array with one value
	 */
	public static void populate(Float[] array, Float value) {
		for(int i = 0; i < array.length; i++)
			array[i] = value;
	}
	/**
	 * Populate all spaces in an array with one value
	 */
	public static void populate(Boolean[] array, Boolean value) {
		for(int i = 0; i < array.length; i++)
			array[i] = value;
	}
	/**
	 * Populate all spaces in an array with one value
	 */
	public static void populate(Double[] array, Double value) {
		for(int i = 0; i < array.length; i++)
			array[i] = value;
	}
	/**
	 * Populate all spaces in an array with one value
	 */
	public static void populate(Character[] array, Character value) {
		for(int i = 0; i < array.length; i++)
			array[i] = value;
	}
	/**
	 * Populate all spaces in an array with one value
	 */
	public static void populate(Byte[] array, Byte value) {
		for(int i = 0; i < array.length; i++)
			array[i] = value;
	}
	/**
	 * Populate all spaces in an array with one value
	 */
	public static void populate(Short[] array, Short value) {
		for(int i = 0; i < array.length; i++)
			array[i] = value;
	}
	/**
	 * Populate all spaces in an array with one value
	 */
	public static void populate(Long[] array, Long value) {
		for(int i = 0; i < array.length; i++)
			array[i] = value;
	}
	/**
	 * Populate all spaces in an array with one value
	 */
	public static void populate(Object[] array, Object value) {
		for(int i = 0; i < array.length; i++)
			array[i] = value;
	}
	/**
	 * Populate all spaces in an array with one value
	 */
	public static void populate(int[] array, int value) {
		for(int i = 0; i < array.length; i++)
			array[i] = value;
	}
	/**
	 * Populate all spaces in an array with one value
	 */
	public static void populate(float[] array, float value) {
		for(int i = 0; i < array.length; i++)
			array[i] = value;
	}
	/**
	 * Populate all spaces in an array with one value
	 */
	public static void populate(boolean[] array, boolean value) {
		for(int i = 0; i < array.length; i++)
			array[i] = value;
	}
	/**
	 * Populate all spaces in an array with one value
	 */
	public static void populate(double[] array, double value) {
		for(int i = 0; i < array.length; i++)
			array[i] = value;
	}
	/**
	 * Populate all spaces in an array with one value
	 */
	public static void populate(char[] array, char value) {
		for(int i = 0; i < array.length; i++)
			array[i] = value;
	}
	/**
	 * Populate all spaces in an array with one value
	 */
	public static void populate(byte[] array, byte value) {
		for(int i = 0; i < array.length; i++)
			array[i] = value;
	}
	/**
	 * Populate all spaces in an array with one value
	 */
	public static void populate(short[] array, short value) {
		for(int i = 0; i < array.length; i++)
			array[i] = value;
	}
	/**
	 * Populate all spaces in an array with one value
	 */
	public static void populate(long[] array, long value) {
		for(int i = 0; i < array.length; i++)
			array[i] = value;
	}
	/**
	 * Checks if an array is fully populated by one value
	 */
	public static boolean populated(Integer[] array, Integer value) {
		for(Integer cur : array) {
			if(!cur.equals(value))
				return false;
		}
	
		return true;
	}
	/**
	 * Checks if an array is fully populated by one value
	 */
	public static boolean populated(Float[] array, Float value) {
		for(Float cur : array) {
			if(!cur.equals(value))
				return false;
		}
	
		return true;
	}
	/**
	 * Checks if an array is fully populated by one value
	 */
	public static boolean populated(Boolean[] array, Boolean value) {
		for(Boolean cur : array) {
			if(!cur.equals(value))
				return false;
		}
	
		return true;
	}
	/**
	 * Checks if an array is fully populated by one value
	 */
	public static boolean populated(Double[] array, Double value) {
		for(Double cur : array) {
			if(!cur.equals(value))
				return false;
		}
	
		return true;
	}
	/**
	 * Checks if an array is fully populated by one value
	 */
	public static boolean populated(Character[] array, Character value) {
		for(Character cur : array) {
			if(!cur.equals(value))
				return false;
		}
	
		return true;
	}
	/**
	 * Checks if an array is fully populated by one value
	 */
	public static boolean populated(Byte[] array, Byte value) {
		for(Byte cur : array) {
			if(!cur.equals(value))
				return false;
		}
	
		return true;
	}
	/**
	 * Checks if an array is fully populated by one value
	 */
	public static boolean populated(Short[] array, Short value) {
		for(Short cur : array) {
			if(!cur.equals(value))
				return false;
		}
	
		return true;
	}
	/**
	 * Checks if an array is fully populated by one value
	 */
	public static boolean populated(Long[] array, Long value) {
		for(Long cur : array) {
			if(!cur.equals(value))
				return false;
		}
	
		return true;
	}
	/**
	 * Checks if an array is fully populated by one value
	 */
	public static boolean populated(Object[] array, Object value) {
		for(Object cur : array) {
			if(!cur.equals(value))
				return false;
		}
	
		return true;
	}
	/**
	 * Checks if an array is fully populated by one value
	 */
	public static boolean populated(int[] array, int value) {
		for(int cur : array) {
			if(cur != value)
				return false;
		}
	
		return true;
	}
	/**
	 * Checks if an array is fully populated by one value
	 */
	public static boolean populated(float[] array, float value) {
		for(float cur : array) {
			if(cur != value)
				return false;
		}
	
		return true;
	}
	/**
	 * Checks if an array is fully populated by one value
	 */
	public static boolean populated(boolean[] array, boolean value) {
		for(boolean cur : array) {
			if(cur != value)
				return false;
		}
	
		return true;
	}
	/**
	 * Checks if an array is fully populated by one value
	 */
	public static boolean populated(double[] array, double value) {
		for(double cur : array) {
			if(cur != value)
				return false;
		}
	
		return true;
	}
	/**
	 * Checks if an array is fully populated by one value
	 */
	public static boolean populated(char[] array, char value) {
		for(char cur : array) {
			if(cur != value)
				return false;
		}
	
		return true;
	}
	/**
	 * Checks if an array is fully populated by one value
	 */
	public static boolean populated(byte[] array, byte value) {
		for(byte cur : array) {
			if(cur != value)
				return false;
		}
	
		return true;
	}
	/**
	 * Checks if an array is fully populated by one value
	 */
	public static boolean populated(short[] array, short value) {
		for(short cur : array) {
			if(cur != value)
				return false;
		}
	
		return true;
	}
	/**
	 * Checks if an array is fully populated by one value
	 */
	public static boolean populated(long[] array, long value) {
		for(long cur : array) {
			if(cur != value)
				return false;
		}
	
		return true;
	}
	/**
	 * Checks whether an array contains a value more than once or not
	 */
	public static boolean isExclusivelyPopulated(Integer[] array) {
		ArrayList<Integer> contents = new ArrayList<Integer>();
	
		for(Integer cur : array) {
			if(contents.contains(cur))
				return false;
	
			contents.add(cur);
		}
	
		return true;
	}
	/**
	 * Checks whether an array contains a value more than once or not
	 */
	public static boolean isExclusivelyPopulated(Float[] array) {
		ArrayList<Float> contents = new ArrayList<Float>();
	
		for(Float cur : array) {
			if(contents.contains(cur))
				return false;
	
			contents.add(cur);
		}
	
		return true;
	}
	/**
	 * Checks whether an array contains a value more than once or not
	 */
	public static boolean isExclusivelyPopulated(Boolean[] array) {
		ArrayList<Boolean> contents = new ArrayList<Boolean>();
	
		for(Boolean cur : array) {
			if(contents.contains(cur))
				return false;
	
			contents.add(cur);
		}
	
		return true;
	}
	/**
	 * Checks whether an array contains a value more than once or not
	 */
	public static boolean isExclusivelyPopulated(Double[] array) {
		ArrayList<Double> contents = new ArrayList<Double>();
	
		for(Double cur : array) {
			if(contents.contains(cur))
				return false;
	
			contents.add(cur);
		}
	
		return true;
	}
	/**
	 * Checks whether an array contains a value more than once or not
	 */
	public static boolean isExclusivelyPopulated(Character[] array) {
		ArrayList<Character> contents = new ArrayList<Character>();
	
		for(Character cur : array) {
			if(contents.contains(cur))
				return false;
	
			contents.add(cur);
		}
	
		return true;
	}
	/**
	 * Checks whether an array contains a value more than once or not
	 */
	public static boolean isExclusivelyPopulated(Byte[] array) {
		ArrayList<Byte> contents = new ArrayList<Byte>();
	
		for(Byte cur : array) {
			if(contents.contains(cur))
				return false;
	
			contents.add(cur);
		}
	
		return true;
	}
	/**
	 * Checks whether an array contains a value more than once or not
	 */
	public static boolean isExclusivelyPopulated(Short[] array) {
		ArrayList<Short> contents = new ArrayList<Short>();
	
		for(Short cur : array) {
			if(contents.contains(cur))
				return false;
	
			contents.add(cur);
		}
	
		return true;
	}
	/**
	 * Checks whether an array contains a value more than once or not
	 */
	public static boolean isExclusivelyPopulated(Long[] array) {
		ArrayList<Long> contents = new ArrayList<Long>();
	
		for(Long cur : array) {
			if(contents.contains(cur))
				return false;
	
			contents.add(cur);
		}
	
		return true;
	}
	/**
	 * Checks whether an array contains a value more than once or not
	 */
	public static boolean isExclusivelyPopulated(Object[] array) {
		ArrayList<Object> contents = new ArrayList<Object>();
	
		for(Object cur : array) {
			if(contents.contains(cur))
				return false;
	
			contents.add(cur);
		}
	
		return true;
	}
	/**
	 * Checks whether an array contains a value more than once or not
	 */
	public static boolean isExclusivelyPopulated(int[] array) {
		ArrayList<Integer> contents = new ArrayList<Integer>();
	
		for(int cur : array) {
			if(contents.contains(Integer.valueOf(cur)))
				return false;
	
			contents.add(cur);
		}
	
		return true;
	}
	/**
	 * Checks whether an array contains a value more than once or not
	 */
	public static boolean isExclusivelyPopulated(float[] array) {
		ArrayList<Float> contents = new ArrayList<Float>();
	
		for(float cur : array) {
			if(contents.contains(Float.valueOf(cur)))
				return false;
	
			contents.add(cur);
		}
	
		return true;
	}
	/**
	 * Checks whether an array contains a value more than once or not
	 */
	public static boolean isExclusivelyPopulated(boolean[] array) {
		ArrayList<Boolean> contents = new ArrayList<Boolean>();
	
		for(boolean cur : array) {
			if(contents.contains(Boolean.valueOf(cur)))
				return false;
	
			contents.add(cur);
		}
	
		return true;
	}
	/**
	 * Checks whether an array contains a value more than once or not
	 */
	public static boolean isExclusivelyPopulated(double[] array) {
		ArrayList<Double> contents = new ArrayList<Double>();
	
		for(double cur : array) {
			if(contents.contains(Double.valueOf(cur)))
				return false;
	
			contents.add(cur);
		}
	
		return true;
	}
	/**
	 * Checks whether an array contains a value more than once or not
	 */
	public static boolean isExclusivelyPopulated(char[] array) {
		ArrayList<Character> contents = new ArrayList<Character>();
	
		for(char cur : array) {
			if(contents.contains(Character.valueOf(cur)))
				return false;
	
			contents.add(cur);
		}
	
		return true;
	}
	/**
	 * Checks whether an array contains a value more than once or not
	 */
	public static boolean isExclusivelyPopulated(byte[] array) {
		ArrayList<Byte> contents = new ArrayList<Byte>();
	
		for(byte cur : array) {
			if(contents.contains(Byte.valueOf(cur)))
				return false;
	
			contents.add(cur);
		}
	
		return true;
	}
	/**
	 * Checks whether an array contains a value more than once or not
	 */
	public static boolean isExclusivelyPopulated(short[] array) {
		ArrayList<Short> contents = new ArrayList<Short>();
	
		for(short cur : array) {
			if(contents.contains(Short.valueOf(cur)))
				return false;
	
			contents.add(cur);
		}
	
		return true;
	}
	/**
	 * Checks whether an array contains a value more than once or not
	 */
	public static boolean isExclusivelyPopulated(long[] array) {
		ArrayList<Long> contents = new ArrayList<Long>();
	
		for(long cur : array) {
			if(contents.contains(Long.valueOf(cur)))
				return false;
	
			contents.add(cur);
		}
	
		return true;
	}
	/**
	 * Checks if array1 is the same as array2
	 */
	public static boolean equals(Integer[] array1, Integer[] array2) {
		if(array1.length != array2.length)
			return false;
	
		for(int i = 0; i < array1.length; i++) {
			if(array1[i] == null || array2[i] == null) {
				if(array1[i] != array2[i])
					return false;
			} else if(!array1[i].equals(array2[i]))
				return false;
		}
	
		return true;
	}
	/**
	 * Checks if array1 is the same as array2
	 */
	public static boolean equals(Float[] array1, Float[] array2) {
		if(array1.length != array2.length)
			return false;
	
		for(int i = 0; i < array1.length; i++) {
			if(array1[i] == null || array2[i] == null) {
				if(array1[i] != array2[i])
					return false;
			} else if(!array1[i].equals(array2[i]))
				return false;
		}
	
		return true;
	}
	/**
	 * Checks if array1 is the same as array2
	 */
	public static boolean equals(Boolean[] array1, Boolean[] array2) {
		if(array1.length != array2.length)
			return false;
	
		for(int i = 0; i < array1.length; i++) {
			if(array1[i] == null || array2[i] == null) {
				if(array1[i] != array2[i])
					return false;
			} else if(!array1[i].equals(array2[i]))
				return false;
		}
	
		return true;
	}
	/**
	 * Checks if array1 is the same as array2
	 */
	public static boolean equals(Double[] array1, Double[] array2) {
		if(array1.length != array2.length)
			return false;
	
		for(int i = 0; i < array1.length; i++) {
			if(array1[i] == null || array2[i] == null) {
				if(array1[i] != array2[i])
					return false;
			} else if(!array1[i].equals(array2[i]))
				return false;
		}
	
		return true;
	}
	/**
	 * Checks if array1 is the same as array2
	 */
	public static boolean equals(Character[] array1, Character[] array2) {
		if(array1.length != array2.length)
			return false;
	
		for(int i = 0; i < array1.length; i++) {
			if(array1[i] == null || array2[i] == null) {
				if(array1[i] != array2[i])
					return false;
			} else if(!array1[i].equals(array2[i]))
				return false;
		}
	
		return true;
	}
	/**
	 * Checks if array1 is the same as array2
	 */
	public static boolean equals(Byte[] array1, Byte[] array2) {
		if(array1.length != array2.length)
			return false;
	
		for(int i = 0; i < array1.length; i++) {
			if(array1[i] == null || array2[i] == null) {
				if(array1[i] != array2[i])
					return false;
			} else if(!array1[i].equals(array2[i]))
				return false;
		}
	
		return true;
	}
	/**
	 * Checks if array1 is the same as array2
	 */
	public static boolean equals(Short[] array1, Short[] array2) {
		if(array1.length != array2.length)
			return false;
	
		for(int i = 0; i < array1.length; i++) {
			if(array1[i] == null || array2[i] == null) {
				if(array1[i] != array2[i])
					return false;
			} else if(!array1[i].equals(array2[i]))
				return false;
		}
	
		return true;
	}
	/**
	 * Checks if array1 is the same as array2
	 */
	public static boolean equals(Long[] array1, Long[] array2) {
		if(array1.length != array2.length)
			return false;
	
		for(int i = 0; i < array1.length; i++) {
			if(array1[i] == null || array2[i] == null) {
				if(array1[i] != array2[i])
					return false;
			} else if(!array1[i].equals(array2[i]))
				return false;
		}
	
		return true;
	}
	/**
	 * Checks if array1 is the same as array2
	 */
	public static boolean equals(Object[] array1, Object[] array2) {
		if(array1.length != array2.length)
			return false;
	
		for(int i = 0; i < array1.length; i++) {
			if(array1[i] == null || array2[i] == null) {
				if(array1[i] != array2[i])
					return false;
			} else if(!array1[i].equals(array2[i]))
				return false;
		}
	
		return true;
	}
	/**
	 * Checks if array1 is the same as array2
	 */
	public static boolean equals(int[] array1, int[] array2) {
		if(array1.length != array2.length)
			return false;
	
		for(int i = 0; i < array1.length; i++) {
			if(array1[i] != array2[i])
				return false;
		}
	
		return true;
	}
	/**
	 * Checks if array1 is the same as array2
	 */
	public static boolean equals(float[] array1, float[] array2) {
		if(array1.length != array2.length)
			return false;
	
		for(int i = 0; i < array1.length; i++) {
			if(array1[i] != array2[i])
				return false;
		}
	
		return true;
	}
	/**
	 * Checks if array1 is the same as array2
	 */
	public static boolean equals(boolean[] array1, boolean[] array2) {
		if(array1.length != array2.length)
			return false;
	
		for(int i = 0; i < array1.length; i++) {
			if(array1[i] != array2[i])
				return false;
		}
	
		return true;
	}
	/**
	 * Checks if array1 is the same as array2
	 */
	public static boolean equals(double[] array1, double[] array2) {
		if(array1.length != array2.length)
			return false;
	
		for(int i = 0; i < array1.length; i++) {
			if(array1[i] != array2[i])
				return false;
		}
	
		return true;
	}
	/**
	 * Checks if array1 is the same as array2
	 */
	public static boolean equals(char[] array1, char[] array2) {
		if(array1.length != array2.length)
			return false;
	
		for(int i = 0; i < array1.length; i++) {
			if(array1[i] != array2[i])
				return false;
		}
	
		return true;
	}
	/**
	 * Checks if array1 is the same as array2
	 */
	public static boolean equals(byte[] array1, byte[] array2) {
		if(array1.length != array2.length)
			return false;
	
		for(int i = 0; i < array1.length; i++) {
			if(array1[i] != array2[i])
				return false;
		}
	
		return true;
	}
	/**
	 * Checks if array1 is the same as array2
	 */
	public static boolean equals(short[] array1, short[] array2) {
		if(array1.length != array2.length)
			return false;
	
		for(int i = 0; i < array1.length; i++) {
			if(array1[i] != array2[i])
				return false;
		}
	
		return true;
	}
	/**
	 * Checks if array1 is the same as array2
	 */
	public static boolean equals(long[] array1, long[] array2) {
		if(array1.length != array2.length)
			return false;
	
		for(int i = 0; i < array1.length; i++) {
			if(array1[i] != array2[i])
				return false;
		}
	
		return true;
	}
	/**
	 * Join two arrays into one array
	 */
	public static Integer[] join(Integer[] array1, Integer[] array2) {
		Integer[] joined = new Integer[array1.length + array2.length];
	
		int last = 0;
	
		for(int i = 0; i < array1.length; i++) {
			joined[i] = array1[i];
			last = i;
		}
	
		for(int i = 0; i < array2.length; i++)
			joined[++last] = array2[i];
	
		return joined;
	}
	/**
	 * Join two arrays into one array
	 */
	public static Float[] join(Float[] array1, Float[] array2) {
		Float[] joined = new Float[array1.length + array2.length];
	
		int last = 0;
	
		for(int i = 0; i < array1.length; i++) {
			joined[i] = array1[i];
			last = i;
		}
	
		for(int i = 0; i < array2.length; i++)
			joined[++last] = array2[i];
	
		return joined;
	}
	/**
	 * Join two arrays into one array
	 */
	public static Boolean[] join(Boolean[] array1, Boolean[] array2) {
		Boolean[] joined = new Boolean[array1.length + array2.length];
	
		int last = 0;
	
		for(int i = 0; i < array1.length; i++) {
			joined[i] = array1[i];
			last = i;
		}
	
		for(int i = 0; i < array2.length; i++)
			joined[++last] = array2[i];
	
		return joined;
	}
	/**
	 * Join two arrays into one array
	 */
	public static Double[] join(Double[] array1, Double[] array2) {
		Double[] joined = new Double[array1.length + array2.length];
	
		int last = 0;
	
		for(int i = 0; i < array1.length; i++) {
			joined[i] = array1[i];
			last = i;
		}
	
		for(int i = 0; i < array2.length; i++)
			joined[++last] = array2[i];
	
		return joined;
	}
	/**
	 * Join two arrays into one array
	 */
	public static Character[] join(Character[] array1, Character[] array2) {
		Character[] joined = new Character[array1.length + array2.length];
	
		int last = 0;
	
		for(int i = 0; i < array1.length; i++) {
			joined[i] = array1[i];
			last = i;
		}
	
		for(int i = 0; i < array2.length; i++)
			joined[++last] = array2[i];
	
		return joined;
	}
	/**
	 * Join two arrays into one array
	 */
	public static Byte[] join(Byte[] array1, Byte[] array2) {
		Byte[] joined = new Byte[array1.length + array2.length];
	
		int last = 0;
	
		for(int i = 0; i < array1.length; i++) {
			joined[i] = array1[i];
			last = i;
		}
	
		for(int i = 0; i < array2.length; i++)
			joined[++last] = array2[i];
	
		return joined;
	}
	/**
	 * Join two arrays into one array
	 */
	public static Short[] join(Short[] array1, Short[] array2) {
		Short[] joined = new Short[array1.length + array2.length];
	
		int last = 0;
	
		for(int i = 0; i < array1.length; i++) {
			joined[i] = array1[i];
			last = i;
		}
	
		for(int i = 0; i < array2.length; i++)
			joined[++last] = array2[i];
	
		return joined;
	}
	/**
	 * Join two arrays into one array
	 */
	public static Long[] join(Long[] array1, Long[] array2) {
		Long[] joined = new Long[array1.length + array2.length];
	
		int last = 0;
	
		for(int i = 0; i < array1.length; i++) {
			joined[i] = array1[i];
			last = i;
		}
	
		for(int i = 0; i < array2.length; i++)
			joined[++last] = array2[i];
	
		return joined;
	}
	/**
	 * Join two arrays into one array
	 */
	public static <T> T[] join(T[] array1, T[] array2) {
		T[] joined = (T[]) Array.newInstance(array1.getClass().getComponentType(), array1.length + array2.length);
	
		int last = 0;
	
		for(int i = 0; i < array1.length; i++) {
			joined[i] = array1[i];
			last = i;
		}
	
		for(int i = 0; i < array2.length; i++)
			joined[++last] = array2[i];
	
		return joined;
	}
	/**
	 * Join two arrays into one array
	 */
	public static int[] join(int[] array1, int[] array2) {
		int[] joined = new int[array1.length + array2.length];
	
		int last = 0;
	
		for(int i = 0; i < array1.length; i++) {
			joined[i] = array1[i];
			last = i;
		}
	
		for(int i = 0; i < array2.length; i++)
			joined[++last] = array2[i];
	
		return joined;
	}
	/**
	 * Join two arrays into one array
	 */
	public static float[] join(float[] array1, float[] array2) {
		float[] joined = new float[array1.length + array2.length];
	
		int last = 0;
	
		for(int i = 0; i < array1.length; i++) {
			joined[i] = array1[i];
			last = i;
		}
	
		for(int i = 0; i < array2.length; i++)
			joined[++last] = array2[i];
	
		return joined;
	}
	/**
	 * Join two arrays into one array
	 */
	public static boolean[] join(boolean[] array1, boolean[] array2) {
		boolean[] joined = new boolean[array1.length + array2.length];
	
		int last = 0;
	
		for(int i = 0; i < array1.length; i++) {
			joined[i] = array1[i];
			last = i;
		}
	
		for(int i = 0; i < array2.length; i++)
			joined[++last] = array2[i];
	
		return joined;
	}
	/**
	 * Join two arrays into one array
	 */
	public static double[] join(double[] array1, double[] array2) {
		double[] joined = new double[array1.length + array2.length];
	
		int last = 0;
	
		for(int i = 0; i < array1.length; i++) {
			joined[i] = array1[i];
			last = i;
		}
	
		for(int i = 0; i < array2.length; i++)
			joined[++last] = array2[i];
	
		return joined;
	}
	/**
	 * Join two arrays into one array
	 */
	public static char[] join(char[] array1, char[] array2) {
		char[] joined = new char[array1.length + array2.length];
	
		int last = 0;
	
		for(int i = 0; i < array1.length; i++) {
			joined[i] = array1[i];
			last = i;
		}
	
		for(int i = 0; i < array2.length; i++)
			joined[++last] = array2[i];
	
		return joined;
	}
	/**
	 * Join two arrays into one array
	 */
	public static byte[] join(byte[] array1, byte[] array2) {
		byte[] joined = new byte[array1.length + array2.length];
	
		int last = 0;
	
		for(int i = 0; i < array1.length; i++) {
			joined[i] = array1[i];
			last = i;
		}
	
		for(int i = 0; i < array2.length; i++)
			joined[++last] = array2[i];
	
		return joined;
	}
	/**
	 * Join two arrays into one array
	 */
	public static short[] join(short[] array1, short[] array2) {
		short[] joined = new short[array1.length + array2.length];
	
		int last = 0;
	
		for(int i = 0; i < array1.length; i++) {
			joined[i] = array1[i];
			last = i;
		}
	
		for(int i = 0; i < array2.length; i++)
			joined[++last] = array2[i];
	
		return joined;
	}
	/**
	 * Join two arrays into one array
	 */
	public static long[] join(long[] array1, long[] array2) {
		long[] joined = new long[array1.length + array2.length];
	
		int last = 0;
	
		for(int i = 0; i < array1.length; i++) {
			joined[i] = array1[i];
			last = i;
		}
	
		for(int i = 0; i < array2.length; i++)
			joined[++last] = array2[i];
	
		return joined;
	}

}
	/*
	 ################################################################
	################ Auto generated code #############################
	 ################################################################
	*/
