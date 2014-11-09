package ga.shane.utilities;

import java.util.HashMap;
import java.util.Map;

/** @author http://www.shane.ga */
public class StringUtils {
	/** The alphabet in {@link String} form */
	public final static String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	/**
	 * Surround a {@link String} with quotation marks
	 * @param obj The thing to be surrounded
	 * @return "{@link obj}"
	 */
	public static String quote(Object obj) {
		return "\"" + obj + "\"";
	}
	
	/**
	 * Replace the last occurance of something in a {@link String}<br>
	 * (java y u no have this already)
	 * 
	 * @return
	 */
	public static String replaceLast(String string, String toReplace, String newValue) {
		StringBuilder builder = new StringBuilder(string);
		int lastIndex = string.lastIndexOf(toReplace);
		builder.replace(lastIndex, lastIndex + 1, newValue);
		return builder.toString();
	}
	
	/**
	 * Group multiple things into a single {@link String}<br>
	 * Useful for writing quick debug messages
	 * Example usage:<pre>
	 * int x = 3;
	 * String s = "This is my";
	 * String otherString = "amazing message, and this is the value of x:";
	 * String complete = group(s, otherString, x);</pre>
	 */
	public static String group(Object... objs) {
		String grouped = "";
		
		for(int i = 0; i < objs.length; i++) {
			grouped+= objs[i];
			
			if(i != objs.length - 1)
				grouped+= " ";
		}
		
		return grouped;
	}
	
	/**
	 * Uses {@link #quote(Object)} on everything grouped
	 * @see {@link #group(Object...)}
	 */
	public static String groupAndQuote(Object... objs) {
		String grouped = "";
		
		for(int i = 0; i < objs.length; i++) {
			grouped+= quote(objs[i]);
			
			if(i != objs.length - 1)
				grouped+= " ";
		}
		
		return grouped;
	}
	
	/**
	 * Clean HTML tags from a {@link String}<br>
	 * Only replaces < and > for now<br>
	 * TODO improve
	 */
	public static String cleanHTML(String s) {
		return s.replaceAll("<", "[").replaceAll(">", "]");
	}
	
	/**
	 * For {@link HashMap}s<br>
	 * Uses {@link FileUtils#separator} to seperate keys and values
	 * @see {@link #group(Object...)}
	 */
	public static String group(HashMap<?, ?> hashmap) {
		String grouped = "";
		
		for(Map.Entry<?, ?> entry : hashmap.entrySet())
			grouped+= entry.getKey() + FileUtils.separator + entry.getValue() + '\n';
		
		grouped = replaceLast(grouped, "\n", "");
		return grouped;
	}
}
