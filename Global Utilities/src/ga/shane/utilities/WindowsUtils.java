package ga.shane.utilities;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/** @author http://www.shane.ga */
public class WindowsUtils {
	/**
	 * Show a MessageBox normally
	 */
	public static void messagebox(String body, String title, int icon, Component... parent) {
		JOptionPane.showMessageDialog(parent.length > 0 ? parent[0] : null, body, title, icon);
	}

	/**
	 * Make a yes/no option box for the user
	 * @return Was ok pressed?
	 */
	public static boolean agreeBox(String body) {
		JFrame fullscreen = new JFrame();
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		fullscreen.setSize(size);
		fullscreen.setAlwaysOnTop(true);
		
		int i = JOptionPane.showConfirmDialog(fullscreen, body, "Authorisation required", JOptionPane.YES_NO_CANCEL_OPTION);
		fullscreen.dispose();
		fullscreen = null;
		
		return i == 0;
	}
	
	/**
	 * NoArg version
	 * @see {@link #agreeBox(String)}
	 */
	public static boolean agreeBox() {
		return agreeBox("Sure that you want to continue?");
	}
	
	/**
	 * Makes sure that the message is visible no matter what (on any window)
	 * @see {@link #messagebox(String, String, int, Component...)}
	 */
	public static void globalMessagebox(String body, String title, int icon) {
		JFrame fullscreen = new JFrame();
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		fullscreen.setSize(size);
		fullscreen.setAlwaysOnTop(true);
		
		JOptionPane.showMessageDialog(fullscreen, body, title, icon);
		fullscreen.dispose();
		fullscreen = null;
	}
	
	/**
	 * @see {@link #messagebox(String, String, int, Component...)}
	 */
	public static void messageBox(String body, String title, int icon, Component... parent) {
		messagebox(body, title, icon, parent);
	}
	
	/**
	 * @see {@link #globalMessagebox(String, String, int)}
	 */
	public static void globalMessageBox(String body, String title, int icon) {
		globalMessagebox(body, title, icon);
	}
	
	/**
	 * Run Visual Basic Script
	 * @param script The script code
	 * @param args Any arguments
	 */
	public static void runVBScript(final String script, final String... args) {
		new Thread() {
			public void run() {
				String arguments = StringUtils.groupAndQuote(args);
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
