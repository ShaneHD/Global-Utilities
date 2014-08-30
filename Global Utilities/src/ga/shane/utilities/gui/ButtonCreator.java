package ga.shane.utilities.gui;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import javax.swing.JButton;
import javax.swing.JPanel;

/** @author http://www.shane.ga */
public class ButtonCreator {
	public final JPanel panel;
	private final HashSet<IAction> actions;
	public final ArrayList<JButton> buttons = new ArrayList<JButton>();
	
	public ButtonCreator(JPanel panel, IAction... actions) {
		this.panel = panel;
		this.actions = new HashSet<IAction>(Arrays.asList(actions));
	}
		
	public ButtonCreator add(Object... buttons) {
		JButton last = null;
		
		for(Object o : buttons) {
			JButton button = null;
			
			if(o instanceof String)
				button = new BJButton((String) o);
			else if(o instanceof JButton)
				button = (JButton) o;
			else if(o instanceof ActionListener) {
				if(last != null)
					last.addActionListener((ActionListener) o);
				else
					throw new RuntimeException("Button needs to go before listener");
			} else
				throw new RuntimeException("Invalid param");
			
			if(button != null) {
				last = button;
				this.buttons.add(button);
				panel.add(button);
				
				for(IAction action : actions)
					action.on(button);
			}
		}
		
		return this;
	}

	public ButtonCreator remove(JButton button) {
		buttons.remove(button);
		panel.remove(button);
		panel.revalidate();
		panel.repaint();
		
		return this;
	}
	
	public ButtonCreator addAction(IAction action) {
		actions.add(action);
		return this;
	}
	
	public ButtonCreator removeAction(IAction action) {
		actions.remove(action);
		return this;
	}
}
