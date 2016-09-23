package com.github.shanehd.utilities;

import com.github.shanehd.utilities.i.NewLineIterator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/** @author https://www.github.com/ShaneHD */
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
	 * Formats a {@link Throwable} like so; <code>class_name - message</code>
     */
	public static String format(Throwable t) {
		return t.getClass().getName() + " - " + t.getMessage();
	}

	/**
	 * Surround a {@link String} with quotation marks
	 */
	public static String quote(Object obj) {
		return "\"" + obj + "\"";
	}
	
	/**
	 * Replace the last occurrence of something in a {@link String}
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
		return group(" ", objs);
	}

	public static String group(String separator, Object[] objs) {
		String grouped = "";

		for(int i = 0; i < objs.length; i++) {
			grouped+= objs[i];

			if(i != objs.length - 1)
				grouped+= separator;
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
	
	/**
	 * Iterate over all lines (\n)
	 */
	public static void iterateLines(String string, NewLineIterator iterator) {
		FileUtils.iterateLines(string, iterator);
	}
	
	public static String format_FirstLetterUpper(String string) {
		char first = string.charAt(0);
		string = Character.toUpperCase(first) + string.substring(1);
		return string;
	}
}
