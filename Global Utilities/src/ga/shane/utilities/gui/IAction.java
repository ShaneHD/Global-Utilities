package ga.shane.utilities.gui;

import java.awt.Component;

/**
 * An interface that some of my utilities use<br>
 * Has one method ({@link #on(Component)})<br><br>
 * 
 * EX: In {@link ButtonCreator}, when a button is added, any {@link IAction}s
 * will run the {@link #on(Component)} method
 * 
 * @author https://www.github.com/ShaneHD
 */
public interface IAction {
	void on(Component c);
}
