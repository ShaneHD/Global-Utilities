package ga.shane.utilities;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * All computer utilities<br>
 * Independent of Operating System
 * 
 * @author http://www.shane.ga
 */
public class PCUtils {
	/**
	 * Get the screen's width and height in {@link Dimension} form
	 */
	public static Dimension getScreenDimension() {
		return Toolkit.getDefaultToolkit().getScreenSize();
	}
	
	/**
	 * Get the screen's width
	 */
	public static int getScreenWidth() {
		return (int) getScreenDimension().getWidth();
	}
	
	/**
	 * Get the screen's height
	 */
	public static int getScreenHeight() {
		return (int) getScreenDimension().getHeight();
	}
	
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
}
