package ga.shane.utilities.gui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

/**
 * Stands for BetterJFrame<br>
 * Adds two methods: {@link #init()} & {@link #constructFrame()}<br><br>
 *
 * <b style='color:red;'>
	 * =========================================================<br>
	 * Both methods are called AUTOMATICALLY in the constructors<br>
	 * =========================================================
 * </b><br>
 * Also implements {@link WindowListener}
 * 
 * @see {@link JFrame}
 * @see {@link WindowListener}
 * @author http://www.shane.ga
 */
public abstract class BJFrame extends JFrame implements WindowListener {
	public BJFrame(String title) {
		this();
		setTitle(title);
	}
	
	public BJFrame() {
		setMinimumSize(new Dimension(50, 50));
		addWindowListener(this);
		init();
		constructFrame();	
	}
	
	/**
	 * Anything that you'd normally have in<br>
	 * the constructor (excluding {@link JFrame} stuff)<br><br>
	 * This is called BEFORE {@link #constructFrame()}
	 * 
	 * @see {@link #constructFrame()}
	 */
	protected abstract void init();
	
	/**
	 * Place anything {@link JFrame} related in here<br>
	 * This is called AFTER {@link #init()}<br><br>
	 * E.G. stuff like {@link #setDefaultCloseOperation(int)}, {@link #setResizable(boolean)}<br>
	 * etc go here.
	 */
	protected abstract void constructFrame();

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
	 */
	public void refresh() {
		setSize(getWidth() - 2, getHeight() + 2);
		setSize(getWidth() + 2, getHeight() + 2);
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
