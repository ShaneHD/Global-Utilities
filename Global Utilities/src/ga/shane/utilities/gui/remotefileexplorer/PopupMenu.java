package ga.shane.utilities.gui.remotefileexplorer;

import javax.swing.JPopupMenu;

/** 
 * @author http://www.shane.ga
 */
class PopupMenu extends JPopupMenu {
	PopupMenu(RemoteFileTree tree) {
		M[] _m = {
			new M_Delete(tree),
			new M_Download(tree)
		};
		
		for(M m : _m) 
			add(m);
		
		
		setSize(120, 120);
		setVisible(true);
	}
}
