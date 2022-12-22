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
import javax.swing.table.TableColumnModel;
import net.proteanit.sql.DbUtils;

public class DisplayTableClient extends JFrame {
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DisplayTableClient frame = new DisplayTableClient();
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
	PreparedStatement pst;
	ResultSet rs;
	Connection conn;
	String query;
	private JTable table;
	TableColumnModel tcm;
	int row;

	public DisplayTableClient() {
		setBounds(100, 300, 1339, 403);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1325, 366);
		contentPane.add(panel);
		panel.setBackground(Color.CYAN.darker().darker().darker());
		panel.setLayout(null);
		JButton btnViewClientInformation = new JButton("View Client Information");
		btnViewClientInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewClientInfo v = new ViewClientInfo();
				v.setVisible(true);
				row = table.getSelectedRow();
				v.clientLabel.setText(table.getModel().getValueAt(row, 0) + "");
				v.nameLabel.setText(table.getModel().getValueAt(row, 1) + "");
				v.numberLabel.setText(table.getModel().getValueAt(row, 2) + "");
				v.emailLabel.setText(table.getModel().getValueAt(row, 3) + "");
				v.genderLabel.setText(table.getModel().getValueAt(row, 4) + "");
				v.bdayLabel.setText(table.getModel().getValueAt(row, 5) + "");
			}
		});
		btnViewClientInformation.setForeground(Color.BLACK);
		btnViewClientInformation.setVisible(false);
		btnViewClientInformation.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		btnViewClientInformation.setBackground(Color.WHITE);
		btnViewClientInformation.setBounds(148, 5, 208, 25);
		panel.add(btnViewClientInformation);
		JButton btnViewList = new JButton("View List");
		btnViewList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/csiatables", "root",
							"mySQLpassword");
					query = "select * from clientlist order by Name ASC";
					pst = conn.prepareStatement(query);
					rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					tcm = table.getColumnModel();
					tcm.removeColumn(tcm.getColumn(5));
					tcm.removeColumn(tcm.getColumn(4));
					tcm.removeColumn(tcm.getColumn(3));
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnViewList.setBounds(10, 5, 128, 25);
		btnViewList.setForeground(Color.BLACK);
		btnViewList.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		btnViewList.setBackground(Color.WHITE);
		panel.add(btnViewList);
		JButton button_1 = new JButton("Back");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_1.setForeground(Color.BLACK);
		button_1.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		button_1.setBackground(Color.WHITE);
		button_1.setBounds(1222, 5, 91, 25);
		panel.add(button_1);
		JLabel lblListOfClients = new JLabel("List of Clients");
		lblListOfClients.setBounds(373, 0, 609, 30);
		lblListOfClients.setHorizontalAlignment(SwingConstants.CENTER);
		lblListOfClients.setForeground(Color.WHITE);
		lblListOfClients.setFont(new Font("Bahnschrift", Font.PLAIN, 26));
		panel.add(lblListOfClients);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 34, 1303, 322);
		panel.add(scrollPane);
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnViewClientInformation.setVisible(true);
			}
		});
		table.setDefaultEditor(Object.class, null);
		scrollPane.setViewportView(table);
		table.setRowHeight(30);
	}
}