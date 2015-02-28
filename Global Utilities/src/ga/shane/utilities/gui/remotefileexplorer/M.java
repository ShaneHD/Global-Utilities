package ga.shane.utilities.gui.remotefileexplorer;

import ga.shane.utilities.gui.BJMenuItem;

/** 
 * @author http://www.shane.ga
 */
abstract class M extends BJMenuItem {
	protected final RemoteFileTree tree;
	
	M(String label, RemoteFileTree tree) {
		super(label);
		this.tree = tree;
	}
}
