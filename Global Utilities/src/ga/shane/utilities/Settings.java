package ga.shane.utilities;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * A {@link HashMap}<{@link String}, {@link Object}><br>
 * Contains methods for saving and loading settings<br>
 * @see {@link #save()} 
 * @see {@link #load()}
 * @see {@link #setFile(File)}
 * 
 * @author http://www.shane.ga
 */
public class Settings extends HashMap<String, Object> {
	private File file;
	
	public Settings() {}
	
	public Settings(File file) {
		setFile(file);
	}
	
	/**
	 * Load settings from a file
	 * @see {@link #save()}
	 * @return Was the load successful?
	 */
	public boolean load() {
		final File file = getFile();
		
		if(!file.exists())
			return false;
		
		ArrayList<String> lines = FileUtils.getLinesFromFile(file);
		
		for(String line : lines) {
			try {
				String[] split = line.split(FileUtils.separator);
				
				String key = split[0];
				Object value = loadValue(split[1], split[2]);
				
				if(value != null)
					add(key, value);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return true;
	}
	
	/**
	 * Parses a value in a settings file
	 * @param s The value in {@link String} format
	 * @param type The type (e.g. java.lang.Double)
	 * @return The parsed value
	 */
	protected Object loadValue(String s, String type) {
		if(type.contains("String"))
			return s;
		
		if(type.contains("Integer"))
			return Integer.parseInt(s);
		
		if(type.contains("Float"))
			return Float.parseFloat(s);
		
		if(type.contains("Boolean"))
			return Boolean.parseBoolean(s);
		
		if(type.contains("Double"))
			return Double.parseDouble(s);
		
		if(type.contains("Character"))
			return s.charAt(0);
		
		if(type.contains("Byte"))
			return Byte.parseByte(s);
		
		if(type.contains("Short"))
			return Short.parseShort(s);
		
		if(type.contains("Long"))
			return Long.parseLong(s);
		
		return null;
	}
	
	/**
	 * Save the settings to the {@link #getFile()}
	 */
	public void save() throws IOException {
		final File file = getFile();
		
		if(!file.exists()) 
			file.createNewFile();
		
		String settings = "";
		
		for(Map.Entry<String, Object> e : entrySet())
			settings+= e.getKey() + FileUtils.separator + e.getValue() + FileUtils.separator + e.getValue().getClass().getName() + "\n";
		
		FileUtils.write(settings, file, false);
	}
	
	/**
	 * Set the {@link File} that these settings are saved to
	 * @see {@link #getFile()}
	 */
	public void setFile(File file) {
		this.file = file;
	}
	
	/**
	 * Get the {@link File} that these settings are saved to
	 * @see {@link #setFile(File)}
	 */
	public File getFile() {
		return file;
	}
	
	/**
	 * Add keys and values<br>
	 * EX: <code>add("key", "value", "anotherKey", 42);</code>
	 */
	public void add(Object... things) {
		if(things.length % 2 != 0)
			throw new RuntimeException("Can't add an odd number of things. (needs [key, value])");
		
		String key = null;
		Object value = null;
		
		for(int i = 0; i < things.length; i++) {
			if(i % 2 == 0) {
				key = (String) things[i];
			} else {
				value = things[i];
				super.put(key, value);
				
				value = key = null;
			}
		}
	}
	
	/**
	 * @see {@link #add(Object...)}
	 * @deprecated
	 */
	public Object put(String arg0, Object arg1) {
		throw new RuntimeException("Don't use this.");
	}
}
