package ga.shane.utilities.gui.remotefileexplorer;

import java.awt.event.ActionEvent;

/** 
 * @author https://www.github.com/ShaneHD
 */
class M_Download extends M {
	public M_Download(RemoteFileTree tree) {
		super("Download", tree);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		tree.dispatchDownloadCommand(tree.getPath());;
	}
}
