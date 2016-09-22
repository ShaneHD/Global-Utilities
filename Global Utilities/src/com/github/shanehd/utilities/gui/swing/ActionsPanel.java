package com.github.shanehd.utilities.gui.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 *
 * @author https://www.github.com/ShaneHD
 */
public class ActionsPanel extends TitledJPanel {
	public ActionsPanel(JPanel parent, ActionListener listener, Object... actions) {
		super("Actions");
		setLayout(new GridLayout(1, actions.length));
		
		for(Object action : actions) {
			JButton button;
			
			if(action instanceof String)
				button = new BJButton(action.toString());
			else if(action instanceof JButton)
				button = (JButton) action;
			else
				continue;
			
			button.addActionListener(listener);
			add(button);
		}
		
		parent.add(this, BorderLayout.SOUTH);
	}
}	
