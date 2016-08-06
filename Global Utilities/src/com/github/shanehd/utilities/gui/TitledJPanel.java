package com.github.shanehd.utilities.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 * 
 *
 * @author https://www.github.com/ShaneHD
 */
public class TitledJPanel extends JPanel {
	private Color color;
	private String title;
	
	public TitledJPanel(String title) {
		setTitle(title);
		setLayout(new BorderLayout());
	}
	
	public TitledJPanel(String title, Component... components) {
		this(title);
		
		for(Component component : components) 
			add(component);
	}

	/**
	 * Set the border color<br>
	 * <b style="color='red'">MAKE SURE TO CALL {@link #setTitle(String)} AFTER</b>
	 * @see #getBorderColor()
	 * @return <code>this</code>
	 */
	public TitledJPanel setBorderColor(Color color) {
		this.color = color;
		return this;
	}
	
	/**
	 * @return The border color
	 * @see #setBorderColor(Color)
	 */
	public Color getBorderColor() {
		return color;
	}
	
	/** 
	 * @return The title
	 * @see #setTitle(String)
	 */
	public String getTitle() {
		return title;
	}
	
	/** 
	 * Set the title for this panel
	 * @see #getTitle()
	 */
	public void setTitle(String title) {
		Border border = BorderFactory.createLineBorder(Color.darkGray);
		setBorder(BorderFactory.createTitledBorder(border, this.title = title));
	}
}
