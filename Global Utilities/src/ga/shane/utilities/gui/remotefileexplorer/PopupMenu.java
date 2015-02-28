package ga.shane.utilities.gui.remotefileexplorer;

import javax.swing.JPopupMenu;

/** 
 * @author http://www.shane.ga
 */
class PopupMenu extends JPopupMenu {
	PopupMenu(RemoteFileTree tree) {
		add(new M_Delete(tree));
		setSize(120, 120);
		setVisible(true);
	}
}
