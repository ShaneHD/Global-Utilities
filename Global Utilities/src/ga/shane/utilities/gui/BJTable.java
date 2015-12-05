package ga.shane.utilities.gui;

import java.awt.Component;
import java.awt.FontMetrics;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/** 
 * Stands for BetterJTable<br>
 * Adds support for easily making it not-editable ({@link #isEditable()})<br><br>
 * Also adds a method ({@link #getDefaultTableModel()}) to get the model and cast it to {@link DefaultTableModel} easily
 * 
 * @see {@link JTable}
 * @author https://www.github.com/ShaneHD 
*/
public class BJTable extends JTable {
	private int[] max;
	
	public BJTable(DefaultTableModel model) {
		super(model);
		
		setDefaultRenderer(Object.class, new Renderer(this));
		getTableHeader().setReorderingAllowed(false);
		setAutoResizeMode(AUTO_RESIZE_OFF);
	}
	
	/**
	 * Remove all rows
	 */
	public void clear() {
		getDefaultTableModel().setRowCount(0);
	}
	
	/**
	 * Has auto resize logic
	 */
	public void add(Object[] data) {
		FontMetrics fm = getFontMetrics(getFont());
		final int offs = 10;
		
		if(max == null) {
			max = new int[getDefaultTableModel().getColumnCount()];
			
			for(int i = 0; i < max.length; i++) {
				String _data = data[i].toString();
				
				if(_data.contains("<html"))
					continue;
				
				max[i] = fm.stringWidth(_data);
				getColumn(getDefaultTableModel().getColumnName(i)).setPreferredWidth(max[i] + offs);
			}
		} else {
			int[] curMax = new int[max.length];
			
			for(int i = 0; i < curMax.length; i++) {
				String _data = data[i].toString();
				
				if(_data.contains("<html"))
					continue;
				
				curMax[i] = fm.stringWidth(_data);
			}
			
			for(int i = 0; i < curMax.length; i++) {
				if(max[i] < curMax[i]) {
					max[i] = curMax[i];
					getColumn(getDefaultTableModel().getColumnName(i)).setPreferredWidth(max[i] + offs);
				}
			}
		}
		
		getDefaultTableModel().addRow(data);
	}
	
	public void remove(Object o) {
		for(int i = 0; i < getDefaultTableModel().getRowCount(); i++) {
			if(getDefaultTableModel().getValueAt(i, 0).equals(o))
				getDefaultTableModel().removeRow(i);
		}
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
	
	protected int textAlignment() {
		return SwingConstants.CENTER;
	}
	
	private final static class Renderer extends DefaultTableCellRenderer {
		public Renderer(BJTable table) {
			setHorizontalAlignment(table.textAlignment());	
		}
		
		@Override
		public Component getTableCellRendererComponent(final JTable table, final Object value, final boolean isSelected, final boolean hasFocus, final int row, final int column) {
			super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
			setBorder(noFocusBorder);
			return this;
		}
	}
}
