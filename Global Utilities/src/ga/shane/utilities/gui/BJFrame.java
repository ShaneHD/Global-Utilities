package ga.shane.utilities.gui;

import javax.swing.JFrame;

/** @author http://www.shane.ga */
public abstract class BJFrame extends JFrame {
	public BJFrame(String title) {
		this();
		setTitle(title);
	}
	
	public BJFrame() {
		init();
		constructFrame();		
	}
	
	protected abstract void constructFrame();
	protected abstract void init();
}
