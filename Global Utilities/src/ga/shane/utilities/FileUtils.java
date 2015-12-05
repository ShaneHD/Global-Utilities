package ga.shane.utilities;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Scanner;

import javax.annotation.Resource;


/**
 * {@link File} utilities
 * 
 * @author http://www.shane.ga
 */
public class FileUtils {
	/** Used with files to separate keys and values */
	public static String separator = ":";
	public static File workingDirectory = null;
	
	/**
	 * Check if a {@link File} is an image or not
	 */
	public static boolean isImage(File file) {
		String name = file.getName();
		
		for(String format : ImageUtils.FORMATS) {
			if(name.endsWith(format))
				return true;
		}
		
		return false;
	}
	
	public static void iterateLines(File file, NewLineIterator iterator) {
		iterateLines(getFileContents(file), iterator);
	}
	
	public static void iterateLines(String contents, NewLineIterator iterator) {
		for(String line : contents.split("\n"))
			iterator.onLine(line);
	}
	
	public static byte[] fileToByteArray(File file) throws Exception {
		byte[] result = new byte[(int) file.length()];
		FileInputStream fin = new FileInputStream(file);
		fin.read(result);
		fin.close();
		return result;
	}
	
	public static void saveByteArrayFileToDisk(String path, byte[] bytes) throws Exception {
		FileOutputStream fout = new FileOutputStream(path);
		fout.write(bytes);
		fout.close();
	}
	
	/**
	 * Gets the file's parent directory
	 */
	public static File getParentDirectory(File file) {	
		String s = file.getAbsolutePath();
		
		try {
			int index = s.lastIndexOf("\\");
			String parent = s.substring(0, index);
			
			if(!parent.endsWith("\\"))
				parent+= "\\";
			
			return new File(parent);
		} catch(Exception e) {
			int index = s.lastIndexOf("/");
			String parent = s.substring(0, index);
			
			if(!parent.endsWith("\\"))
				parent+= "\\";
			
			return new File(parent);
		}
	}
	
	/**
	 * Create a new {@link BFile}
	 * @param name Name of the file (including extension)
	 * @param createNewIfNotExistsFlag If this optional argument is set, {@link File#createNewFile()} will be called
	 */
	public static BFile newFile(String name, Object... createNewIfNotExistsFlag) {
		BFile file = workingDirectory == null ? new BFile(name) : new BFile(workingDirectory, name);
		
		if(createNewIfNotExistsFlag.length == 0)
			return file;
		
		try {
			if(!file.exists())
				file.createNewFile();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		return file;
	}
	
	//FIXME Doesn't work in jars, getResourceAsStream
	public static BFile newFileInsideClasspath(String name) {
		try {			
			URL url = FileUtils.class.getResource("/" + name);
			BFile file = new BFile(url.toURI());
			return file;
		} catch(Exception e) {
			//e.printStackTrace();
			throw new RuntimeException("Error loading internal file: " + StringUtils.quote(name));
		}
	}
	
	/**
	 * Get a value from a file using {@link #separator} to separate the key and value
	 */
	public static String getValue(String key, File file) {
		try {
			Scanner scanner = new Scanner(file);
			String value = null;
			
			while(scanner.hasNextLine()) {
				String s = scanner.nextLine();
				
				if(s.contains(key)) {
					value = s.split(separator)[1];
					break;
				}
			}
			
			scanner.close();
			
			if(value == null)
				throw new NullPointerException();
			
			return value;
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		throw new RuntimeException("Couldn't find value of key " + StringUtils.quote(key) + " from file " + StringUtils.quote(file.getName()));
	}
	
	/**
	 * Load a configuration file into a {@link HashMap}
	 */
	public static LinkedHashMap<String, String> loadFileIntoHashMap(File file) {
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		
		for(String line : getFileLines(file)) {
			String[] split = line.split(separator);
			map.put(split[0], split[1]);
		}
		
		return map;
	}
	
	/**
	 * Bundle all of a file's lines into a {@link HashSet}
	 */
	public static ArrayList<String> getFileLines(File file) {
		ArrayList<String> lines = new ArrayList<String>();
		
		try {
			Scanner scanner = new Scanner(file);
			
			while(scanner.hasNextLine())
				lines.add(scanner.nextLine());
			
			scanner.close();
			return lines;
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
		throw new RuntimeException("Couldn't find contents of file " + StringUtils.quote(file.getName()));
	}
	
	/**
	 * <s>Bundle all of a file's lines into a {@link ArrayList}</s>
	 * @deprecated {@link #getFileLines(File)}
	 */
	/*public static ArrayList<String> getLinesFromFile(File file) {
		ArrayList<String> lines = new ArrayList<String>();
		
		try {
			Scanner scanner = new Scanner(file);
			
			while(scanner.hasNextLine())
				lines.add(scanner.nextLine());
			
			scanner.close();
			return lines;
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
		throw new RuntimeException("Couldn't find contents of file " + StringUtils.quote(file.getName()));
	}*/
	
	/**
	 * Get the contents of a file into a single {@link String}<br>
	 * uses '\n' char for new lines
	 */
	public static String getFileContents(File file) {
		try {
			Scanner scanner = new Scanner(file);
			String contents = "";
			
			while(scanner.hasNextLine())
				contents+= scanner.nextLine() + "\n";
			
			scanner.close();
			return contents;
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
		throw new RuntimeException("Couldn't find contents of file " + StringUtils.quote(file.getName()));
	}
	
	/**
	 * Uses UTF-16 encoding
	 * @see {@link #getFileContents(File)}
	 * @author Someone from stackoverflow. Don't have their name.
	 */
	public static String getFileContentsUTF16(File file) {
		BufferedReader br;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-16"));
			String in, lines = "";
			
			while((in = br.readLine()) != null)
				lines+= in + "\n";
			
			br.close();
			return lines;
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		throw new RuntimeException("Couldn't find contents of file " + StringUtils.quote(file.getName()));
	}
	
	/**
	 * Write something to a file
	 * @return Whether the write was successful or not
	 */
	public static boolean write(Object toWrite, File file, boolean... append) {
		String write = "";

		if(toWrite instanceof String)
			write = (String) toWrite;
		else if(toWrite instanceof Iterable<?>) {
			for(Object obj : (Iterable<?>) toWrite)
				write+= obj + "\n";
		} else if(toWrite instanceof Object[]) {
			for(Object obj : (Object[]) toWrite)
				write+= obj + "\n";
		} else if(toWrite instanceof HashMap<?, ?>)
			write = StringUtils.group((HashMap<?, ?>) toWrite);
		else
			throw new IllegalArgumentException("toWrite is of an invalid type!");
		
		try {
			FileWriter writer = new FileWriter(file, append.length > 0 ? append[0] : false);
			writer.write(write);
			writer.close();
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	/**
	 * Downloads a file and saves it to a location on the computer
	 */
	@SuppressWarnings("resource")
	public static void download(URL url, String save) throws IOException {
		ReadableByteChannel channel = Channels.newChannel(url.openStream());
		new FileOutputStream(save).getChannel().transferFrom(channel, 0, Long.MAX_VALUE);
	}
}



