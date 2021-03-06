package com.github.shanehd.utilities.gui.swing;

import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;

/**
 *  A {@link BJTextPane} with HTML formatting set up
 *
 *  @author https://www.github.com/ShaneHD 
*/
public class HtmlPane extends BJTextPane {
	private HTMLDocument doc;
	private HTMLEditorKit kit;
	
	public HtmlPane() {
		super();
		init();
	}
	
	/**
	 * Set the text for this text pane
	 */
	public HtmlPane(String content) {
		this();
		append(content);
	}
	
	/**
	 * Called in all constructors
	 */
	protected void init() {
		setContentType("text/html");
		
		setEditorKit(kit = new HTMLEditorKit());
		setDocument(doc = new HTMLDocument());
	}

	@Override
	public void append(String s) {
		try {			
			kit.insertHTML(doc, doc.getLength(), s, 0, 0, null);
			setCaretPosition(doc.getLength());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
