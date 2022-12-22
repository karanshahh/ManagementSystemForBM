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

@SuppressWarnings("serial")
public class DisplayTableProduct extends JFrame {
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DisplayTableProduct frame = new DisplayTableProduct();
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
	Connection conn;
	String query;
	int row;
	PreparedStatement pst;
	ResultSet rs;
	TableColumnModel tcm;
	private JTable table;

	public DisplayTableProduct() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 300, 1339, 403);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBounds(0, 0, 1325, 366);
		contentPane.add(panel);
		panel.setBackground(Color.CYAN.darker().darker().darker());
		panel.setLayout(null);
		JLabel lblListOfClients = new JLabel("List of Products");
		lblListOfClients.setBounds(365, 0, 599, 30);
		lblListOfClients.setHorizontalAlignment(SwingConstants.CENTER);
		lblListOfClients.setForeground(Color.WHITE);
		lblListOfClients.setFont(new Font("Bahnschrift", Font.PLAIN, 26));
		panel.add(lblListOfClients);
		JButton btnViewProductInformation = new JButton("View Product Information\r\n");
		btnViewProductInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewProductInfo v = new ViewProductInfo();
				v.setVisible(true);
				row = table.getSelectedRow();
				v.serialno.setText(table.getModel().getValueAt(row, 0) + "");
				v.company.setText(table.getModel().getValueAt(row, 1) + "");
				v.pname.setText("<HTML>" + table.getModel().getValueAt(row, 2) + "<HTML>");
				v.description.setText("<HTML>" + table.getModel().getValueAt(row, 3) + "<HTML>");
				v.size.setText(table.getModel().getValueAt(row, 4) + "");
				v.rate.setText(table.getModel().getValueAt(row, 5) + "");
			}
		});
		btnViewProductInformation.setVisible(false);
		btnViewProductInformation.setForeground(Color.BLACK);
		btnViewProductInformation.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		btnViewProductInformation.setBackground(Color.WHITE);
		btnViewProductInformation.setBounds(151, 5, 204, 25);
		panel.add(btnViewProductInformation);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 34, 1303, 322);
		panel.add(scrollPane);
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnViewProductInformation.setVisible(true);
			}
		});
		table.setDefaultEditor(Object.class, null);
		scrollPane.setViewportView(table);
		table.setRowHeight(30);
		JButton button = new JButton("View List");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/csiatables", "root",
							"mySQLpassword");
					query = "select * from productlist";
					pst = conn.prepareStatement(query);
					rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					tcm = table.getColumnModel();
					tcm.removeColumn(tcm.getColumn(5));
					tcm.removeColumn(tcm.getColumn(4));
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		button.setForeground(Color.BLACK);
		button.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		button.setBackground(Color.WHITE);
		button.setBounds(10, 5, 128, 25);
		panel.add(button);
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnBack.setForeground(Color.BLACK);
		btnBack.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		btnBack.setBackground(Color.WHITE);
		btnBack.setBounds(1185, 5, 128, 25);
		panel.add(btnBack);
	}
}