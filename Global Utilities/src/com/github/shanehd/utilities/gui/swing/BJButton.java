package com.github.shanehd.utilities.gui.swing;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;

/** 
 * Stands for BetterJButton<br>
 * Simply makes the button non-focusable
 * 
 * @author https://www.github.com/ShaneHD
*/
public class BJButton extends JButton {
	public BJButton() {
		init();
	}
	
	public BJButton(String arg0) {
		super(arg0);
		init();
	}
	
	public BJButton(Action arg0) {
		super(arg0);
		init();
	}
	
	public BJButton(Icon arg0) {
		super(arg0);
		init();
	}
	
	public BJButton(String arg0, Icon arg1) {
		super(arg0, arg1);
		init();
	}

	protected final void init() {
		setFocusable(false);
	}
}
