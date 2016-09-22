package com.github.shanehd.utilities.gui.swing;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JToggleButton;

/** @author https://www.github.com/ShaneHD */
public abstract class BJToggleButton extends JToggleButton implements ItemListener {	
	private final String enabledText, disabledText;
	
	public BJToggleButton(String enabledText, String disabledText) {
		this.enabledText = enabledText;
		this.disabledText = disabledText;
		
		addItemListener(this);
		setFocusable(false);
		rename(isSelected());
	}
	
	protected abstract void onToggle(boolean state);
	
	@Override
	public final void itemStateChanged(ItemEvent e) {
		boolean state = e.getStateChange() == e.SELECTED;
		
		onToggle(state);
		rename(state);
	}
	
	private final void rename(boolean state) {
		if(state)
			setText(String.format(enabledFormat(), enabledText));
		else
			setText(String.format(disabledFormat(), disabledText));
	}
	
	protected String enabledFormat() {
		return "<html><font color='green'>%s</font></html>";
	}
	
	protected String disabledFormat() {
		return "<html><font color='red'>%s</font></html>";
	}
}
