package com.github.shanehd.utilities;

import com.github.shanehd.utilities.i.NewLineIterator;

import java.lang.reflect.Field;
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
	 * List a classes fields and values
	 * class_name[field=value,other=value]
	 * @param includeSuperClass Should super classes fields be used as well?
	 * @param fieldWhitelist Optional list of fields to only use, others will be skipped if set
	 */
	public static String format(Object instance, boolean includeSuperClass, String... fieldWhitelist) {
		String data = "";
		Class c = instance.getClass();

		try {
			Field[] fields = !includeSuperClass ? c.getDeclaredFields() : ArrayUtils.join(c.getSuperclass().getDeclaredFields(), c.getDeclaredFields());
			boolean whitelist = fieldWhitelist.length > 0;

			for(Field field : fields) {
				try {
					if(whitelist && !ArrayUtils.contains(fieldWhitelist, field.getName()))
						continue;

					boolean accessible = field.isAccessible();

					if(!accessible)
						field.setAccessible(true);

					data+= field.getName() + "=" + field.get(instance) + ",";

					if(!accessible)
						field.setAccessible(false);
				} catch(IllegalAccessException e) {
					return format(e);
				}
			}
		} catch(ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		}

		try {
			return c.getSimpleName() + "[" + data.substring(0, data.lastIndexOf(",")) + "]";
		} catch(StringIndexOutOfBoundsException e) {
			return c.getSimpleName();
		}
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
	 * Cast a string to other formats<br>
	 * @throws RuntimeException If using non implemented type
	 */
	public static Object cast(String arg, Class type) {
		if(arg == null || type == null)
			return null;

		try {
			if(type.isEnum())
				return Enum.valueOf(type, arg);
		} catch(IllegalArgumentException e) {
			e.printStackTrace();
			return null;
		}

		String s = type.getSimpleName().toLowerCase();

		if (s.equals("string"))
			return arg;
		else if (s.equals("integer") || s.equals("int"))
			return Integer.parseInt(arg);
		else if(s.equals("float"))
			return Float.parseFloat(arg);
		else if(s.equals("boolean"))
			return Boolean.parseBoolean(arg);
		else if(s.equals("double"))
			return Double.parseDouble(arg);
		else if(s.equals("character") || s.equals("char"))
			return arg.charAt(0);
		else if(s.equals("byte"))
			return Byte.parseByte(arg);
		else if(s.equals("short"))
			return Short.parseShort(arg);
		else if(s.equals("long"))
			return Long.parseLong(arg);

		try {
			return type.getConstructor(String.class).newInstance(arg);
		} catch(Exception e) {
			e.printStackTrace();
		}

		throw new RuntimeException("Invalid type: " + type);
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
