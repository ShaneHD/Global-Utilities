package ga.shane.utilities.gui;

import javax.swing.JTextPane;
import javax.swing.text.StyledDocument;

/**
 * Stands for BetterJTextPane<br>
 * Contains a method for appending: {@link #append(String)}
 * @see {@link JTextPane}
 * 
 * @author http://www.shane.ga
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
