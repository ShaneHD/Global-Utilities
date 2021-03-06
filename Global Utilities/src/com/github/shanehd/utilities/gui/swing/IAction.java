package com.github.shanehd.utilities.gui.swing;

import java.awt.Component;

//TODO wtf
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
