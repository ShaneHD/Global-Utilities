package ga.shane.utilities.gui;

import javax.swing.JFrame;

/**
 * Stands for BetterJFrame<br>
 * Adds two methods: {@link #init()} & {@link #constructFrame()}<br><br>
 *
 * <b style='color:red;'>
	 * =========================================================<br>
	 * Both methods are called AUTOMATICALLY in the constructors<br>
	 * =========================================================
 * </b>
 * 
 * @see {@link JFrame}
 * @author http://www.shane.ga
 */
public abstract class BJFrame extends JFrame {
	public BJFrame(String title) {
		this();
		setTitle(title);
	}
	
	public BJFrame() {
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
}
