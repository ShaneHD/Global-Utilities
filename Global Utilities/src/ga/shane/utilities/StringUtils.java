package ga.shane.utilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/** @author http://www.shane.ga */
public class StringUtils {
	/** The alphabet in {@link String} form */
	public final static String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	/**
	 * Split a {@link String} by its {@link String#length()}
	 */
	public static ArrayList<String> splitByLength(String string, int maxLength) {
		ArrayList<String> split = new ArrayList<String>();
		
		if(string.length() <= maxLength)
			split.add(string);
		else {
			for(int i = 0; i <= string.length(); i+= maxLength) 
				split.add(string.substring(i, Math.min(i + maxLength, string.length())));
		}
		
		return split;
	}
	
	/**
	 * Surround a {@link String} with quotation marks
	 * @param obj The thing to be surrounded
	 * @return "{@link obj}"
	 */
	public static String quote(Object obj) {
		return "\"" + obj + "\"";
	}
	
	/**
	 * Replace the last occurrence of something in a {@link String}<br>
	 * (java y u no have this already)
	 * 
	 * @return
	 */
	public static String replaceLast(String string, String from, String to) {
		StringBuilder builder = new StringBuilder(string);
		int lastIndex = string.lastIndexOf(from);
		builder.replace(lastIndex, lastIndex + 1, to);
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
	
	public static String format_FirstLetterUpper(String string) {
		char first = string.charAt(0);
		string = Character.toUpperCase(first) + string.substring(1);
		return string;
	}
}
