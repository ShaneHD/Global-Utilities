package ga.shane.utilities.gui;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/** 
 * Stands for BetterJTable<br>
 * Adds support for easily making it not-editable ({@link #isEditable()})<br><br>
 * Also adds a method ({@link #getDefaultTableModel()}) to get the model and cast it to {@link DefaultTableModel} easily
 * 
 * @see {@link JTable}
 * @author http://www.shane.ga 
*/
public class BJTable extends JTable {
	public BJTable(DefaultTableModel model) {
		super(model);
	}
	
	/**
	 * Set whether this table is editable or not<br><br>
	 * -1 = user editing is not enabled<br>
	 * 1 = user editing is enabled<br>
	 * 0 = use {@link JTable#isCellEditable(int, int)}
	 */
	protected int isEditable() {
		return 0;
	}
	
	@Override
	public boolean isCellEditable(int row, int column) {
		switch(isEditable()) {
		case -1:
			return false;
		case 1:
			return true;
		}
		
		return super.isCellEditable(row, column);
	}
	
	/**
	 * Cast {@link #getModel()} to {@link DefaultTableModel}
	 */
	public final DefaultTableModel getDefaultTableModel() {
		return (DefaultTableModel) getModel();
	}
}
