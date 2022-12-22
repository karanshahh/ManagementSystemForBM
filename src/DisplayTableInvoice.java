import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
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
import net.proteanit.sql.DbUtils;

@SuppressWarnings("serial")
public class DisplayTableInvoice extends JFrame {
	private JPanel contentPane;
	private JTable table;
	Connection con;
	String query;
	PreparedStatement pst;
	ResultSet rs;
	File file;
	String path;
	Process pro;
	int row;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DisplayTableInvoice frame = new DisplayTableInvoice();
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
	public DisplayTableInvoice() {
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
		JButton button = new JButton("View List");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/csiatables", "root",
							"mySQLpassword");
					query = "select SerialNo, Path, ClientName, Date from invoicelist order by Date DESC";
					pst = con.prepareStatement(query);
					rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
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
		JButton btnOpenInvoice = new JButton("Open Invoice");
		btnOpenInvoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				row = table.getSelectedRow();
				try {
					path = (String) table.getModel().getValueAt(row, 1);
					file = new File(path);
					if (file.exists()) {
						pro = Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler " + path);
						pro.waitFor();
					} else {
						JOptionPane.showMessageDialog(null, "Invoice does not exist");
					}
				} catch (Exception e1) {
				}
			}
		});
		btnOpenInvoice.setForeground(Color.BLACK);
		btnOpenInvoice.setVisible(false);
		btnOpenInvoice.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		btnOpenInvoice.setBackground(Color.WHITE);
		btnOpenInvoice.setBounds(148, 5, 128, 25);
		panel.add(btnOpenInvoice);
		JLabel lblListOfInvoices = new JLabel("List of Invoices");
		lblListOfInvoices.setHorizontalAlignment(SwingConstants.CENTER);
		lblListOfInvoices.setForeground(Color.WHITE);
		lblListOfInvoices.setFont(new Font("Bahnschrift", Font.PLAIN, 26));
		lblListOfInvoices.setBounds(373, 0, 609, 30);
		panel.add(lblListOfInvoices);
		JButton button_1 = new JButton("Back");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Invoices ii = new Invoices();
				ii.setVisible(true);
			}
		});
		button_1.setForeground(Color.BLACK);
		button_1.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		button_1.setBackground(Color.WHITE);
		button_1.setBounds(1222, 5, 91, 25);
		panel.add(button_1);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 34, 1303, 322);
		panel.add(scrollPane);
		table = new JTable();
		table.setDefaultEditor(Object.class, null);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnOpenInvoice.setVisible(true);
			}
		});
		scrollPane.setViewportView(table);
		table.setRowHeight(30);
	}
}