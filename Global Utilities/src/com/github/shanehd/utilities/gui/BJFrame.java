package com.github.shanehd.utilities.gui;

import java.awt.Dimension;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 * Stands for BetterJFrame<br>
 * <!--<s>Adds two methods: {@link #init()} & {@link #constructFrame()}<br><br>
 *
 * <b style='color:red;'>
	 * =========================================================<br>
	 * Both methods are called AUTOMATICALLY in the constructors<br>
	 * =========================================================
 * </b></s>--><br>
 * Also implements {@link WindowListener}
 * 
 * @see {@link JFrame}
 * @see {@link WindowListener}
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
//		init();
//		constructFrame();	
	}
	
	/**
	 * Anything that you'd normally have in<br>
	 * the constructor (excluding {@link JFrame} stuff)<br><br>
	 * This is called BEFORE {@link #constructFrame()}
	 * 
	 * @deprecated
	 * @see {@link #constructFrame()}
	 */
//	protected abstract void init();
	
	/**
	 * Place anything {@link JFrame} related in here<br>
	 * This is called AFTER {@link #init()}<br><br>
	 * E.G. stuff like {@link #setDefaultCloseOperation(int)}, {@link #setResizable(boolean)}<br>
	 * etc go here.
	 * @deprecated
	 */
//	protected abstract void constructFrame();

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
	 * <b style='color:red;'>DON'T start with a /</b>
	 * 
	 * @see {@link #setIconImage(java.awt.Image)}
	 * @see {@link Class#getResource(String)}
	 */
	public void setIcon(String name) {
		URL url = getClass().getResource("/" + name);
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