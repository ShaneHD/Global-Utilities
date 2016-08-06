package com.github.shanehd.utilities;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.net.Inet4Address;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * All computer utilities<br>
 * Independent of Operating System
 * 
 * @author https://www.github.com/ShaneHD
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
	
	public static void errorbox(String body, Component... parent) {
		messagebox(body, "Error!", JOptionPane.ERROR_MESSAGE, parent);
	}
	
	public static void warningbox(String body, Component... parent) {
		messagebox(body, "Warning!", JOptionPane.WARNING_MESSAGE, parent);
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
	 * @see #agreeBox(String)
	 */
	public static boolean agreeBox() {
		return agreeBox("Sure that you want to continue?");
	}
	
	/**
	 * Makes sure that the message is visible no matter what (on any window)
	 * @see #messagebox(String, String, int, Component...)
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
	
	public static void exceptionbox(Exception e) {
		messagebox(e.getMessage(), "Exception thrown", JOptionPane.ERROR_MESSAGE);
	}
	
	/**
	 * @see #messagebox(String, String, int, Component...)
	 */
	public static void messageBox(String body, String title, int icon, Component... parent) {
		messagebox(body, title, icon, parent);
	}
	
	/**
	 * @see #globalMessagebox(String, String, int)
	 */
	public static void globalMessageBox(String body, String title, int icon) {
		globalMessagebox(body, title, icon);
	}
	
	/**
	 * Returns the current user's computer name (E.G. Person-PC)
	 */
	public static String getHostname() {
		try {
			return Inet4Address.getLocalHost().getHostName();
		} catch(Exception e) {
			return "error finding comp name";
		}
	}

	
	/**
	 * Returns all system properties in HTML format
	 */
	public static String systemPropertiesToHtml() {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(out);
		System.getProperties().list(ps);
		String[] psplit = out.toString().split("\n");
		String _final = "";
		
		for(final String s : psplit) {			
			try {
				String[] split = s.split("=");
				_final+= "<html><font color='red'>" + split[0] + " <font color='blue'>" + split[1];
			} catch(Exception e) {
				_final+= "<html><font color='red'>" + s;
			}
			
			_final+= "<br>";
		}
		
		return _final;
	}
}
