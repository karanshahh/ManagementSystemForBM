import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class EditBranch extends JFrame {
	private JPanel contentPane;
	private JTextField branchID;
	String address, con, id, query, check;
	Connection con1;
	String branch = "BRANCH";
	PreparedStatement pst, pst1;
	Random r = new Random();
	ResultSet rs;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditBranch frame = new EditBranch();
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
	public EditBranch() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 868, 220);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBounds(0, 0, 854, 183);
		contentPane.add(panel);
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(240, 255, 255));
		panel_1.setBounds(0, 0, 862, 36);
		panel.add(panel_1);
		JLabel label = new JLabel("Edit Branch");
		label.setForeground(new Color(0, 124, 124));
		label.setFont(new Font("Bahnschrift", Font.PLAIN, 24));
		label.setBounds(0, 0, 882, 36);
		panel_1.add(label);
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.DARK_GRAY);
		panel_2.setBounds(0, 31, 863, 158);
		panel.add(panel_2);
		JLabel label_1 = new JLabel("");
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		label_1.setBounds(445, 87, 176, 23);
		panel_2.add(label_1);
		JLabel label_2 = new JLabel("");
		label_2.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		label_2.setBounds(0, 0, 0, 0);
		panel_2.add(label_2);
		branchID = new JTextField();
		branchID.setForeground(Color.BLACK);
		branchID.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		branchID.setColumns(10);
		branchID.setBackground(Color.WHITE);
		branchID.setBounds(152, 23, 469, 23);
		panel_2.add(branchID);
		JLabel label_3 = new JLabel("Branch ID:");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		label_3.setBounds(10, 21, 132, 23);
		panel_2.add(label_3);
		JLabel label_4 = new JLabel("Address:");
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		label_4.setBounds(10, 54, 132, 23);
		panel_2.add(label_4);
		JLabel label_5 = new JLabel("Contact Number:");
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		label_5.setBounds(10, 87, 132, 23);
		panel_2.add(label_5);
		JFormattedTextField branchAddress = new JFormattedTextField();
		branchAddress.setBounds(152, 56, 698, 23);
		panel_2.add(branchAddress);
		JLabel label_6 = new JLabel("");
		label_6.setForeground(Color.RED);
		label_6.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		label_6.setBounds(445, 87, 176, 23);
		panel_2.add(label_6);
		JFormattedTextField branchContact = new JFormattedTextField();
		branchContact.setBounds(152, 87, 283, 23);
		panel_2.add(branchContact);
		JButton button = new JButton("Edit Branch");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				address = branchAddress.getText();
				con = branchContact.getText();
				id = branchID.getText();
				query = "update branchlist set Address='" + address + "', ContactNumber='" + con + "' where BranchID='"
						+ id + "'";
				check = "SELECT * FROM branchlist";
				try {
					con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/csiatables", "root",
							"mySQLpassword");
					pst = con1.prepareStatement(query);
					pst1 = con1.prepareStatement(check);
					rs = pst1.executeQuery(check);
					if (rs.next() == true) {
						pst.execute();
						JOptionPane.showMessageDialog(null, "Branch found and edited successfully");
						branchID.setText("");
						branchAddress.setText("");
						branchContact.setText("");
					} else if (branchID.getText().isEmpty() == true || branchAddress.getText().isEmpty() == true
							|| branchContact.getText().isEmpty() == true) {
						JOptionPane.showMessageDialog(null, "Some entries are empty, re-enter");
					} else {
						JOptionPane.showMessageDialog(null, "Branch not found");
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		button.setForeground(Color.BLACK);
		button.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		button.setBackground(Color.WHITE);
		button.setBounds(152, 120, 167, 23);
		panel_2.add(button);
		JButton button_1 = new JButton("Clear Contents");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				branchID.setText("");
				branchAddress.setText("");
				branchContact.setText("");
			}
		});
		button_1.setForeground(Color.BLACK);
		button_1.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		button_1.setBackground(Color.WHITE);
		button_1.setBounds(329, 120, 167, 23);
		panel_2.add(button_1);
		JButton button_2 = new JButton("Back");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_2.setForeground(Color.BLACK);
		button_2.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		button_2.setBackground(Color.WHITE);
		button_2.setBounds(506, 120, 167, 23);
		panel_2.add(button_2);
	}
}