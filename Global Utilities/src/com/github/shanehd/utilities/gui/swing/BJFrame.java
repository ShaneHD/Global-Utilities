package com.github.shanehd.utilities.gui.swing;

import java.awt.Dimension;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 * Stands for BetterJFrame<br>
 * {@link WindowListener} is added, just override methods to use
 * 
 * @see JFrame
 * @see WindowListener
 * @author https://www.github.com/ShaneHD
 */
public abstract class BJFrame extends JFrame implements WindowListener {
	public BJFrame(String title) {
		this();
		setTitle(title);
	}
	
	public BJFrame() {
		setMinimumSize(new Dimension(50, 50));
		addWindowListener(this);
	}

	/**
	 * Clear this {@link JFrame}<br>
	 * Remove all components & refresh
	 */
	public void clear() {
		removeAll();
		revalidate();
		repaint();
	}
	
	/**
	 * Refreshes the window<br>
	 * Sets the size -2,-2 then +2,+2
	 * <!-- TODO look for cleaner way of doing this -->
	 */
	public void refresh() {
		setSize(getWidth() - 2, getHeight() - 2);
		setSize(getWidth() + 2, getHeight() + 2);
	}
	
	/**
	 * Set the icon with an image inside the program<br>
	 * 
	 * @see {@link #setIconImage(java.awt.Image)}
	 * @see {@link Class#getResource(String)}
	 */
	public void setIcon(String name) {
		URL url = getClass().getResource(name.startsWith("/") ? name : "/" + name);
		ImageIcon icon = new ImageIcon(url);
		setIconImage(icon.getImage());
	}
	
	
	@Override
	public void windowActivated(WindowEvent e) {
	}

	@Override
	public void windowClosed(WindowEvent e) {
	}

	@Override
	public void windowClosing(WindowEvent e) {
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
	}

	@Override
	public void windowIconified(WindowEvent e) {
	}

	@Override
	public void windowOpened(WindowEvent e) {
	}
}
