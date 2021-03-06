package com.github.shanehd.utilities;

import com.github.shanehd.utilities.i.NewLineIterator;

import java.io.*;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.*;


/**
 * {@link File} utilities
 * 
 * @author https://www.github.com/ShaneHD
 */
public class FileUtils {
	/** Used with files to separate keys and values */
	public static String separator = ":";
	public static File workingDirectory = null;

	/** An array of common video formats */
	public static final String[] VIDEO_FORMATS = {
			"avi", "mp4", "mkv", "flv", "mov", "mpg", "m4v", "m2ts"
	};

	private final static boolean USE_APACHE_COMMONS_IO;

	static {
		boolean commonsIo = false;

		try {
			FileUtils.class.getClassLoader().loadClass("org.apache.commons.io.IOUtils");
			commonsIo = true;
		} catch(ClassNotFoundException e) {}

		USE_APACHE_COMMONS_IO = commonsIo;
	}

	/**
	 * @return A list of all the file extensions found inside a directory<br/>
	 * For example, a folder containing <code>song.mp3, pic.png and text.txt</code>
	 * 		will return an {@link ArrayList} containing <code>"mp3", "png", "txt"</code>
	 */
	public static ArrayList<String>	listExtsInDirs(File dir) {
		ArrayList<String> list = new ArrayList();

		for(File file : dir.listFiles()) {
			if(file.isDirectory()) {
				ArrayList<String> found = listExtsInDirs(file);

				for(String ext : found) {
					if(!list.contains(ext))
						list.add(ext);
				}

				continue;
			}

			String ext = ext(file);

			if(!list.contains(ext))
				list.add(ext);
		}

		return list;
	}

	/**
	 * @return The {@link File}'s name NOT containing its extension(.txt, .png, etc)
	 */
	public static String getNameWithoutExtension(File file) {
		return file.getName().split("." + ext(file))[0];
	}

	/**
	 * Check if a {@link File} is an image or not<br/>
	 * Uses {@link ImageUtils#FORMATS}
	 */
	public static boolean isImage(File file) {
		return is(file, ImageUtils.FORMATS);
	}

	/**
	 * Check if a {@link File} is a video or not<br/>
	 * Uses {@link #VIDEO_FORMATS}
	 */
	public static boolean isVideo(File file) {
		return is(file, VIDEO_FORMATS);
	}

	/**
	 * Check if the {@link File} has one of the extensions inside the <code>formats</code> param
	 * @param file The {@link File} to check
	 * @param formats A {@link String} array of extensions to check for
	 */
	private static boolean is(File file, String[] formats) {
		return ArrayUtils.contains(formats, ext(file));
	}

	/**
	 * Get a {@link File}'s extension
	 */
	public static String ext(File file) {
		String[] split = file.getName().split("\\.");
		return split[split.length - 1];
	}

	/**
	 * Iterate over all new lines (<code>\n</code>) of a {@link File}'s contents with {@link NewLineIterator}
	 */
	public static void iterateLines(File file, NewLineIterator iterator) {
		iterateLines(getFileContents(file), iterator);
	}

	/**
	 * Iterate over all new lines in a {@link String} (<code>\n</code>) with {@link NewLineIterator}
	 */
	public static void iterateLines(String contents, NewLineIterator iterator) {
		for(String line : contents.split("\n"))
			iterator.onLine(line);
	}

	/**
	 * Convert the {@link File} to a byte array
	 * @see #saveByteArrayFileToDisk(String, byte[])
	 */
	public static byte[] fileToByteArray(File file) throws IOException {
		byte[] result = new byte[(int) file.length()];
		FileInputStream fin = new FileInputStream(file);
		fin.read(result);
		fin.close();
		return result;
	}

	/**
	 * Save a file in byte array form to the hard drive
	 * @see #fileToByteArray(File)
	 */
	public static void saveByteArrayFileToDisk(String path, byte[] bytes) throws IOException {
		FileOutputStream fout = new FileOutputStream(path);
		fout.write(bytes);
		fout.close();
	}
	
	/**
	 * Gets the {@link File}'s parent directory
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
	 * Get a value from a {@link File} using {@link #separator} to separate the key and value
	 * @deprecated
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
	 * @deprecated
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
	 * Bundle all of a file's lines into a {@link List}
	 */
	public static List<String> getFileLines(File file) {
		if(USE_APACHE_COMMONS_IO) {
			try {
				return org.apache.commons.io.IOUtils.readLines(new FileReader(file));
			} catch(IOException e) {
				//TODO throw this
				e.printStackTrace();
			}
		}

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
	 * @see #getFileContents(File)
	 */
	public static String getFileContents(String fileDir) {
		return getFileContents(new File(fileDir));
	}

	/**
	 * Get the contents of a file into a single {@link String}
	 */
	public static String getFileContents(File file) {
		return getFileContents(file, "UTF-8");
	}

	private static String getFileContents(File file, String encoding) {
		if(USE_APACHE_COMMONS_IO) {
			try {
				return org.apache.commons.io.FileUtils.readFileToString(file, encoding);
			} catch(IOException e) {
				//TODO throw this
				e.printStackTrace();
			}
		}

		BufferedReader br;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(file), encoding));
			String in, lines = "";

			while((in = br.readLine()) != null)
				lines+= in + "\n";

			br.close();
			return lines;
		} catch(Exception e) {
			//TODO throw this
			e.printStackTrace();
		}

		throw new RuntimeException("Couldn't find contents of file " + StringUtils.quote(file.getName()));
	}

	/**
	 * Uses UTF-16 encoding
	 * @see #getFileContents(File)
	 */
	public static String getFileContentsUTF16(File file) throws FileNotFoundException {
		return getFileContents("UTF-16");
	}
	
	/**
	 * Write something to a {@link File}
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
		
		write = write.trim();
		
		try {
			if(USE_APACHE_COMMONS_IO) {
				org.apache.commons.io.FileUtils.writeStringToFile(file, write, append.length > 0 && append[0]);
			} else {
				FileWriter writer = new FileWriter(file, append.length > 0 && append[0]);
				writer.write(write);
				writer.close();
			}
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	/**
	 * Downloads a {@link File} and saves it to a location on the computer
	 */
	public static void download(URL url, String save) throws IOException {
		ReadableByteChannel channel = Channels.newChannel(url.openStream());
		new FileOutputStream(save).getChannel().transferFrom(channel, 0, Long.MAX_VALUE);
		channel.close();
	}

	/**
	 * @return %appdata%
	 */
	public static File getAppdataDir() {
		File appdata = new File(System.getProperty("user.home"), "AppData/Roaming");

		if(!appdata.exists())
			throw new NullPointerException("The current computer does not have an AppData directory (not windows?)");

		return appdata;
	}

	/**
	 * Get a folder inside AppData (creates if it doesn't exist)
	 * @see #getAppdataDir()
	 * @param name Name of the directory you want to get (which is inside AppData)
	 */
	public static File getAppdataDir(String name) {
		File appdata = getAppdataDir();
		File dir = new File(appdata, name);

		if(!dir.exists())
			dir.mkdir();

		return dir;
	}
}



