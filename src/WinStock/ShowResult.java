package WinStock;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.UIManager;

public class ShowResult extends JFrame {
	String[] ColumnNames = {"Stock","EPS","PRERatio","ClosePrice"};
	String[] newlines = new String[4];
	DefaultTableModel tableModel = new DefaultTableModel(null,ColumnNames);
	private JPanel contentPane;
	private JTable table;	/**
	 * Launch the application.
	 */	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowResult frame = new ShowResult();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ShowResult() {
		PageFunction a = new PageFunction();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(UIManager.getBorder("InternalFrame.border"));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		tableModel.addRow(ColumnNames);
		for(int x=0;x<a.number;x++){
			newlines[0] = a.DisPlayNameList.get(x);
			System.out.println(newlines[0]); 
			for(int y=0;y<a.innerResult.size();y++){
				newlines[y+1]= a.FinalResult.get(x).get(y).toString();
				System.out.println(newlines[y+1]); 
			}
			tableModel.addRow(newlines);
		}
		
		table = new JTable(tableModel);
		table.setBounds(28, 118, 161, -97);
		contentPane.add(table);
		setVisible(true);
	}

}
