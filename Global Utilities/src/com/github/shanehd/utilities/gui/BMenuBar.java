package com.github.shanehd.utilities.gui;

import java.awt.Menu;
import java.awt.MenuBar;
import java.util.ArrayList;
import java.util.Map;
import com.github.shanehd.utilities.ListMap;

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
					if(row[0] instanceof String)
						parent = new Menu((String) row[0]);
					else
						parent = (Menu) row[0];
				} catch(Exception e) {
					parent = lastParent;
				}
				
				if(parent == null)
					continue;

				for(int i = 1; i < row.length; i++) {
					BMenuItem item = (BMenuItem) row[i];

					if(item == null)
						continue;

					lastParent = parent;
					list.add(parent, item);
				}
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
