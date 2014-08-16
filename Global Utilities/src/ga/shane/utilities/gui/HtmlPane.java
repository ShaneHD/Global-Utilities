package ga.shane.utilities.gui;

import javax.swing.JTextPane;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;

/**
 *  A {@link JTextPane} with HTML formatting set up<br>
 *  Contains a method for appending: {@link #append(String)}
 *  
 *  @author http://www.shane.ga 
*/
public class HtmlPane extends JTextPane {
	private final HTMLDocument doc;
	private HTMLEditorKit kit;
	
	public HtmlPane() {
		setContentType("text/html");
		
		setEditorKit(kit = new HTMLEditorKit());
		setDocument(doc = new HTMLDocument());
	}
	
	/**
	 * Set the text for this text pane
	 */
	public HtmlPane(String content) {
		this();
		append(content);
	}
	
	/** 
	 * Append to this text pane
	 */
	public void append(String s) {
		try {
			kit.insertHTML(doc, doc.getLength(), s, 0, 0, null);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
