package com.github.shanehd.utilities.gui.remotefileexplorer;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.github.shanehd.utilities.FileUtils;
import com.github.shanehd.utilities.gui.BJTable;

/** 
 * A file tree explorer for remote systems
 * 
 * @author https://www.github.com/ShaneHD
 */
//TODO make cache work (don't re request shit that's already cached), and make downloading work.

public abstract class RemoteFileTree extends BJTable implements MouseListener {
	private String directory = "";
	
	public RemoteFileTree() {
		super(new DefaultTableModel(new Object[] {"Directory", "Absolute Path"}, 0));
		
		addMouseListener(this);
		setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}
	
	private void add(String directory, String path) {
		add(new Object[]{directory, path});
	}
	
	/**
	 * Set the current directory & files list
	 * @param files
	 */
	public void set(String directory, ArrayList<String> files) {
		clear();
		boolean done = directory.equals("/") || directory.isEmpty() ? true : false;
				
		if(!done) {
			done = true;
			System.out.println("The file is : " + directory);
			add("Parent", FileUtils.getParentDirectory(new File(directory)).getAbsolutePath());
		}
		
		for(String file : files) {			
			add(directory, file);
		}
		
		this.directory = directory;
	}
	
	@Override
	protected int isEditable() {
		return -1;
	}
	
	/**
	 * @return The current directory being displayed
	 */
	public String getDirectory() {
		return directory;
	}
	
	protected abstract void dispatchOpenDirectoryCommand(String selected);
	protected abstract void dispatchDeleteCommand(String selected);
	protected abstract void dispatchDownloadCommand(String selected);
	
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Test");
		
		RemoteFileTree tree = new RemoteFileTree(){

			@Override
			protected void dispatchOpenDirectoryCommand(String selected) {
				System.out.println("Request: " + selected);
			}

			@Override
			protected void dispatchDeleteCommand(String selected) {
				System.out.println("Delete: " + selected);
			}

			@Override
			protected void dispatchDownloadCommand(String selected) {
				System.out.println("Download: " + selected);
			}
		};
		ArrayList<String> a = new ArrayList<String>();
		a.add("C:/Users");
		a.add("C:/Windows");
		a.add("C:/Program Files");
		tree.set("C:/", a);
		frame.add(new JScrollPane(tree));
		
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setAlwaysOnTop(true);
		frame.setSize(650,  450);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
	
	@Override
	protected int textAlignment() {
		return SwingConstants.LEFT;
	}
	
	public String getPath() {
		return (String) getValueAt(getSelectedRow(), 1);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getClickCount() != 2)
			return;
		
		
		String path = (String) getValueAt(rowAtPoint(e.getPoint()), 1);
		
		if(new File(path).isDirectory())
			dispatchOpenDirectoryCommand(path);
		else
			System.out.println("no");
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(e.getButton() != 3)
			return;
		
		int row = rowAtPoint(e.getPoint());
		
		if(row >= 0 && row < getRowCount())
			setRowSelectionInterval(row, row);
		else
			clearSelection();
		
		int index = getSelectedRow();
		
		if(index < 0)
			return;
		
		if(e.isPopupTrigger()) {
			JPopupMenu menu = new PopupMenu(this);
			menu.show(e.getComponent(), e.getX(), e.getY());
		}
	}
}





