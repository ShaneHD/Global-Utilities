package ga.shane.utilities.gui.remotefileexplorer;

import java.awt.event.ActionEvent;

/** 
 * @author http://www.shane.ga
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
