package com.github.shanehd.utilities.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.github.shanehd.utilities.gui.BJButton;
import com.github.shanehd.utilities.gui.TitledJPanel;

/**
 * TODO maybe implement {@link ButtonCreator}?
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
