package com.github.shanehd.utilities.gui.swing.remotefileexplorer;

import java.awt.event.ActionEvent;

/** 
 * @author https://www.github.com/ShaneHD
 */
class M_Delete extends M {
	public M_Delete(RemoteFileTree tree) {
		super("Delete", tree);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		tree.dispatchDeleteCommand(tree.getPath());
	}
}
