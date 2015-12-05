package ga.shane.utilities;

/** 
 * @author http://www.shane.ga
 */
public class EMath {
	public static int toNextEven(int i) {
		return i % 2 == 0 ? i : ++i;
	}
	
	public static int toLastEven(int i) {
		return i % 2 == 0 ? i : --i;
	}
	
	public static int toNextOdd(int i) {
		return i % 2 == 0 ? ++i : i;
	}
	
	public static int toLastOdd(int i) {
		return i % 2 == 0 ? --i : i;
	}
	
	/**
	 * Finds center location (int)
	 */
	public static int center(int size, int maxsize) {
		return maxsize / 2 - (size/ 2);
	}
	
	/**
	 * Finds center location (float)
	 */
	public static float center(float size, float maxsize) {
		return maxsize / 2 - (size/ 2);
	}
}
