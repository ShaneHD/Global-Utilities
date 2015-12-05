package com.github.shanehd.utilities.gui.remotefileexplorer;

import com.github.shanehd.utilities.gui.BJMenuItem;

/** 
 * @author https://www.github.com/ShaneHD
 */
abstract class M extends BJMenuItem {
	protected final RemoteFileTree tree;
	
	M(String label, RemoteFileTree tree) {
		super(label);
		this.tree = tree;
	}
}
