import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import net.proteanit.sql.DbUtils;

@SuppressWarnings("serial")
public class DisplayTableBranch extends JFrame {
	private JPanel contentPane;
	static JTable table;
	Connection con, conn;
	String query;
	int row;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DisplayTableBranch frame = new DisplayTableBranch();
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
	static void updateTable() {
		String query;
		Connection conn;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/csiatables", "root", "mySQLpassword");
			query = "select * from branchlist";
			pst = conn.prepareStatement(query);
			rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	static PreparedStatement pst;
	static ResultSet rs;

	public DisplayTableBranch() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 300, 1339, 403);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN.darker().darker().darker());
		panel.setBounds(0, 0, 1325, 366);
		contentPane.add(panel);
		panel.setLayout(null);
		JButton btnDeleteSelectedBranch1 = new JButton("Delete Selected Branch");
		btnDeleteSelectedBranch1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					row = table.getSelectedRow();
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/csiatables", "root",
							"mySQLpassword");
					query = "DELETE FROM branchlist where BranchID = '" + table.getModel().getValueAt(row, 0) + "'";
					pst = con.prepareStatement(query);
					pst.execute();
					JOptionPane.showMessageDialog(null, "Branch deleted successfully!");
					updateTable();
					btnDeleteSelectedBranch1.setVisible(false);
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Error");
				}
			}
		});
		btnDeleteSelectedBranch1.setForeground(Color.BLACK);
		btnDeleteSelectedBranch1.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		btnDeleteSelectedBranch1.setBackground(Color.WHITE);
		btnDeleteSelectedBranch1.setBounds(113, 5, 227, 25);
		btnDeleteSelectedBranch1.setVisible(false);
		panel.add(btnDeleteSelectedBranch1);
		JLabel l = new JLabel("Beautymanntra Branches");
		l.setBounds(104, 5, 1117, 25);
		l.setHorizontalAlignment(SwingConstants.CENTER);
		l.setFont(new Font("Bahnschrift", Font.PLAIN, 26));
		l.setForeground(Color.WHITE);
		panel.add(l);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 33, 1305, 323);
		panel.add(scrollPane);
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnDeleteSelectedBranch1.setVisible(true);
			}
		});
		table.setDefaultEditor(Object.class, null);
		table.setRowHeight(50);
		scrollPane.setViewportView(table);
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnBack.setForeground(Color.BLACK);
		btnBack.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		btnBack.setBackground(Color.WHITE);
		btnBack.setBounds(1222, 5, 93, 25);
		panel.add(btnBack);
		JButton btnView = new JButton("View");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/csiatables", "root",
							"mySQLpassword");
					query = "select * from branchlist order by BranchID desc";
					pst = conn.prepareStatement(query);
					rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Error");
				}
			}
		});
		btnView.setForeground(Color.BLACK);
		btnView.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		btnView.setBackground(Color.WHITE);
		btnView.setBounds(10, 5, 93, 25);
		panel.add(btnView);
	}
}