package com.github.shanehd.utilities.gui;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Interface for placeholder textfields to inherit<br>
 * (Used in {@link BJTextField} & {@link BJPasswordField})
 * 
 * @author https://www.github.com/ShaneHD
 */
interface IBJTextField {
	/**
	 * Get the placeholder
	 * @see {@link #setPlaceholder(String)}
	 */
	String getPlaceholder();
	
	
	/**
	 * Set the placeholder
	 * @see {@link #getPlaceholder()}
	 */
	void setPlaceholder(String placeholder);
	
	/**
	 * Get the placeholder's draw color
	 * @see {@link #setPlaceholderColor(Color)}
	 */
	Color getPlaceholderColor();
	
	/**
	 * Set the placeholder's draw color
	 * @see {@link #getPlaceholderColor()}
	 */
	void setPlaceholderColor(Color color);
	
	/**
	 * @author Peter Tseng
	 */
	void paintPlaceholder(Graphics g);
}
