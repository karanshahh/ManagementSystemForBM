import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class DeleteBranch extends JFrame {
	private JPanel contentPane;
	JFormattedTextField branchID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteBranch frame = new DeleteBranch();
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
	String query;
	Connection con;

	public DeleteBranch() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 551, 155);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBounds(0, 0, 863, 189);
		contentPane.add(panel);
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(240, 255, 255));
		panel_1.setBounds(0, 0, 1108, 36);
		panel.add(panel_1);
		JLabel lblDeleteABranch = new JLabel("Delete a Branch");
		lblDeleteABranch.setForeground(new Color(0, 124, 124));
		lblDeleteABranch.setFont(new Font("Bahnschrift", Font.PLAIN, 24));
		lblDeleteABranch.setBounds(10, 0, 1098, 36);
		panel_1.add(lblDeleteABranch);
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.DARK_GRAY);
		panel_2.setBounds(0, 31, 1108, 181);
		panel.add(panel_2);

		JLabel label_1 = new JLabel("Branch ID:");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		label_1.setBounds(10, 21, 132, 23);
		panel_2.add(label_1);
		branchID = new JFormattedTextField();
		branchID.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		branchID.setColumns(10);
		branchID.setBounds(152, 23, 372, 23);
		panel_2.add(branchID);
		JButton btnDeleteBranch = new JButton("Delete Branch");
		btnDeleteBranch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/csiatables", "root",
							"mySQLpassword");
					query = "DELETE FROM `csiatables`.`branchlist` WHERE (`BranchID` = ? )";
					pst = con.prepareStatement(query);
					pst.setString(1, branchID.getText());
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Branch deleted successfully!");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnDeleteBranch.setForeground(Color.BLACK);
		btnDeleteBranch.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		btnDeleteBranch.setBackground(Color.WHITE);
		btnDeleteBranch.setBounds(152, 56, 132, 23);
		panel_2.add(btnDeleteBranch);
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnBack.setForeground(Color.BLACK);
		btnBack.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		btnBack.setBackground(Color.WHITE);
		btnBack.setBounds(427, 56, 97, 23);
		panel_2.add(btnBack);
		JButton btnClearField = new JButton("Clear Field");
		btnClearField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				branchID.setText("");
			}
		});
		btnClearField.setForeground(Color.BLACK);
		btnClearField.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		btnClearField.setBackground(Color.WHITE);
		btnClearField.setBounds(294, 56, 123, 23);
		panel_2.add(btnClearField);
	}
}
