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
	String[] ColumnNames = {"Stock", "EPS" , "PER"};
	DefaultTableModel tableModel = new DefaultTableModel(ColumnNames, 12);
	private JPanel contentPane;
	private JTable table;
	private PageFunction test= new PageFunction();
	/**
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(UIManager.getBorder("InternalFrame.border"));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		table = new JTable(tableModel);
		table.setBounds(28, 118, 161, -97);
		contentPane.add(table);
		setVisible(true);
	}

}
