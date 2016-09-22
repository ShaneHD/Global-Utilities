package com.github.shanehd.utilities.gui.swing;

import javax.swing.tree.DefaultMutableTreeNode;

/**
 * A {@link DefaultMutableTreeNode} with an icon field ({@link #getIcon()})<br>
 * <b>NOTE</b> {@link #getIcon()} doesn't do anything by itself.<br>
 * This is simply something for you to use in whatever way you wish.<br><br>
 * I made this so that when adding nodes to a {@link javax.swing.JTree}, I could give them an icon image
 * 
 * @author https://www.github.com/ShaneHD 
 */
public class IconTreeNode extends DefaultMutableTreeNode {
	private String icon;
	
	public IconTreeNode(String title, String icon) {
		super(title);
		setIcon(icon);
	}
	
	/**
	 * Set the icon
	 * @see {@link #getIcon()}
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}
	
	/**
	 * @return The icon in {@link String} form
	 * @see {@link #setIcon(String)}
	 */ 
	public String getIcon() {
		return icon;
	}
}
