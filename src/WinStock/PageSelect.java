package WinStock;

import javax.swing.JPanel;
import java.awt.Panel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.Button;
import javax.swing.JInternalFrame;
import java.awt.BorderLayout;

public class PageSelect extends JPanel {
	 String[] ColumnNames = {"Stock", "EPS" , "PER"};
	 DefaultTableModel tableModel = new DefaultTableModel(ColumnNames, 0);
	 String[] aa = {"111","222","3"};
	 JPanel test = new JPanel();
	 private JTable table;
	/**
	 * Create the panel.
	 */
	public PageSelect() {
		setLayout(null);
		tableModel.addRow(aa);
        JScrollPane tableContainer = new JScrollPane();
        test.add(tableContainer);
		JInternalFrame internalFrame = new JInternalFrame("New JInternalFrame");
		internalFrame.setBounds(10, 10, 395, 292);
		internalFrame.getContentPane().add(test);
		table = new JTable(tableModel);
		internalFrame.getContentPane().add(table, BorderLayout.NORTH);
		table.setBounds(60, 87, 261, 146);
		add(table);
		add(internalFrame);
		internalFrame.setVisible(true);

	}
	public static void main(String[] args){
		PageSelect a = new PageSelect();
//		a.getStockNumber();
//		a.SelectStock();
	}
}
