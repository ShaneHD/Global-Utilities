package com.github.shanehd.utilities.gui.swing;

import java.awt.Desktop;

import javax.swing.JEditorPane;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

public class IHyperlinkListener implements HyperlinkListener {	
	public IHyperlinkListener() {
		
	}
	
	/**
	 * Calls addHyperlinkListener(this)
	 */
	public IHyperlinkListener(JEditorPane c) {
		c.addHyperlinkListener(this);
	}
	
	@Override
	public void hyperlinkUpdate(HyperlinkEvent e) {		
		if(e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
			try {
				Desktop.getDesktop().browse(e.getURL().toURI());
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}
