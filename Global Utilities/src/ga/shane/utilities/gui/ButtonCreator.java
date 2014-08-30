package ga.shane.utilities.gui;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * A {@link JButton} creator<br>
 * Creates and adds {@link JButton}s to a {@link JPanel}<br>
 * 
 * @author http://www.shane.ga
 */
public class ButtonCreator extends ArrayList<JButton> {
	/** The panel that the buttons have been added to */
	public final JPanel panel;
	private final HashSet<IAction> actions;
	/** A {@link HashMap} containing all the buttons [buttonText, {@link JButton}] */
	public final HashMap<String, JButton> map = new HashMap<String, JButton>();
	 
	public ButtonCreator(JPanel panel, IAction... actions) {
		this.panel = panel;
		this.actions = new HashSet<IAction>(Arrays.asList(actions));
	}
	
	/**
	 * Add a {@link JButton}<br>
	 * You can add as many buttons as you want.<br>
	 * arg can be a {@link String}, {@link JButton}, or a {@link ActionListener}<br>
	 * A {@link String} will use <code>new {@link BJButton(String)}</code><br>
	 * and an {@link ActionListener} will add that listener to the previously added button<br><br>
	 * 
	 * An arg can also be an {@link IAction}. It call the action on the previously added button
	 * 
	 * @return this
	 */
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
			} else if(o instanceof IAction) {
				if(last != null)
					((IAction) o).on(last);
				else
					throw new RuntimeException("Button needs to go before IAction");
			} else
				throw new RuntimeException("Invalid param");
			
			if(button != null) {
				last = button;
				add(button);
				map.put(button.getText(), button);
				panel.add(button);
				
				for(IAction action : actions)
					action.on(button);
			}
		}
		
		return this;
	}

	/**
	 * Attempt to get the {@link JButton} by its text<br>
	 * NOTE: any changes to the button's text ({@link JButton#setText(String)}) will NOT BE DETECTED.<br>
	 * This means that you MUST use the same text as when the button was added to this creator
	 * 
	 * @see {@link #remove(JButton)}
	 * @return this
	 */
	public ButtonCreator remove(String button) {
		remove(map.get(button));
		return this;
	}
	
	/**
	 * Remove a {@link JButton}
	 * @return this
	 */
	public ButtonCreator remove(JButton button) {
		remove(button);
		panel.remove(button);
		panel.revalidate();
		panel.repaint();
		
		return this;
	}
	
	/**
	 * Add an {@link IAction}
	 * @return this
	 */
	public ButtonCreator addAction(IAction action) {
		actions.add(action);
		return this;
	}
	
	/**
	 * Remove an {@link IAction}
	 * @return this
	 */
	public ButtonCreator removeAction(IAction action) {
		actions.remove(action);
		return this;
	}
}
