package com.github.shanehd.utilities.gui.swing;

import javax.swing.JTextPane;
import javax.swing.text.StyledDocument;

/**
 * Stands for BetterJTextPane<br>
 * Contains a method for appending: {@link #append(String)}
 *
 * @author https://www.github.com/ShaneHD
 */
public class BJTextPane extends JTextPane {
	/**
	 * Set the text for this text pane
	 */
	public BJTextPane(String content) {
		append(content);
	}
	
	public BJTextPane() {
		super();
	}
	
	public BJTextPane(StyledDocument doc) {
		super(doc);
	}
	
	/** 
	 * Append to this text pane
	 */
	public void append(String s) {
		try {
			StyledDocument doc = getStyledDocument();
			doc.insertString(doc.getLength(), s, null);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
