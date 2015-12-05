package ga.shane.utilities.gui;

import ga.shane.utilities.ListMap;

import java.awt.Menu;
import java.awt.MenuBar;
import java.util.ArrayList;
import java.util.Map;

/**
 * 
 *
 * @author https://www.github.com/ShaneHD
 */
public class BMenuBar extends MenuBar {
	public BMenuBar(Object[][] contents) {
		ListMap<Menu, BMenuItem> list = new ListMap<Menu, BMenuItem>();
		Menu lastParent = null;
		
		for(Object[] row : contents) {
			try {
				Menu parent;
				
				try {
					parent = (Menu) row[0];
				} catch(Exception e) {
					parent = lastParent;
				}
				
				if(parent == null)
					continue;
				
				BMenuItem item = (BMenuItem) row[1];
				
				if(item == null) 
					continue;
				
				lastParent = parent;
				list.put(parent, item);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		for(Map.Entry<Menu, ArrayList<BMenuItem>> e : list.entrySet()) {
			Menu parent = e.getKey();
			
			for(BMenuItem item : e.getValue())
				parent.add(item);
			
			add(parent);
		}
	}
}
