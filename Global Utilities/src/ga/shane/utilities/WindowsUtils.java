package ga.shane.utilities;

import java.io.File;
import java.io.IOException;
import java.util.Random;

/** @author http://www.shane.ga */
public class WindowsUtils extends PCUtils {
	
	/**
	 * Run Visual Basic Script
	 * @param script The script code
	 * @param args Any arguments
	 */
	public static void runVBScript(final String script, final String... args) {
		new Thread() {
			public void run() {
				String arguments = StringUtils.groupAndQuote((Object[]) args);
				File file = new File(FileUtils.workingDirectory, new Random().nextLong() + ".vbs");
				
				try {
					file.createNewFile();
				} catch(IOException e) {
					e.printStackTrace();
				}
				
				FileUtils.write(script, file);
				
				try {
					Runtime.getRuntime().exec("cscript " + StringUtils.quote(file.getAbsolutePath()) + " " + arguments).waitFor();
				} catch(Exception e) {
					e.printStackTrace();
				}
				
				file.delete();
			}
		}.start();
	}
	
	/**
	 * @return An absolute path to <code>user</code>'s home directory<br>
	 * <i>C:/Users/%name%/</i>
	 */
	public static String getCUserDrive(String user) {
		return "C:/Users/" + user + "/";
	}
	
	/**
	 * Current user
	 * @see {@link #getCUserDrive(String)}
	 */
	public static String getCUserDrive() {
		return getCUserDrive(System.getProperty("user.name"));
	}
}
