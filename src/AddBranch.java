import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
public class AddBranch extends JFrame {
	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	private final JPanel panel_1 = new JPanel();
	JLabel lblAddress = new JLabel("Address:");
	JLabel lblContactNumber = new JLabel("Contact Number:");
	private JTextField branchID;
	JFormattedTextField branchAddress;
	JFormattedTextField branchContact;
	char vchar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddBranch frame = new AddBranch();
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
	String branch = "BRANCH";
	PreparedStatement pst;
	Random r = new Random();
	ResultSet rs;
	String squery;
	String query;
	String id;
	Connection con;

	public AddBranch() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 300, 877, 226);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel.setBackground(new Color(240, 255, 255));
		panel.setBounds(0, 0, 863, 36);
		contentPane.add(panel);
		panel.setLayout(null);
		JLabel lblNewLabel = new JLabel("Add a Branch\r\n");
		lblNewLabel.setForeground(new Color(0, 124, 124));
		lblNewLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 24));
		lblNewLabel.setBounds(0, 0, 1108, 36);
		panel.add(lblNewLabel);
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(0, 31, 863, 158);
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setBounds(445, 87, 176, 23);
		panel_1.add(lblNewLabel_3);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		panel_1.add(lblNewLabel_2);
		branchID = new JTextField();
		branchID.setBounds(152, 23, 469, 23);
		branchID.setEditable(false);
		branchID.setBackground(Color.white);
		branchID.setForeground(Color.black);
		branchID.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		panel_1.add(branchID);
		branchID.setColumns(10);
		JLabel lblNewLabel_1 = new JLabel("Branch ID:");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(10, 21, 132, 23);
		panel_1.add(lblNewLabel_1);
		lblAddress.setForeground(Color.WHITE);
		lblAddress.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		lblAddress.setBounds(10, 54, 132, 23);
		panel_1.add(lblAddress);
		lblContactNumber.setForeground(Color.WHITE);
		lblContactNumber.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		lblContactNumber.setBounds(10, 87, 132, 23);
		panel_1.add(lblContactNumber);
		branchAddress = new JFormattedTextField();
		branchAddress.setBounds(152, 56, 698, 23);
		panel_1.add(branchAddress);
		branchContact = new JFormattedTextField();
		branchContact.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				vchar = e.getKeyChar();
				if ((!(Character.isDigit(vchar)) || (vchar == KeyEvent.VK_BACK_SPACE)
						|| (vchar == KeyEvent.VK_DELETE))) {
					lblNewLabel_3.setText("Invalid Entry!");
					e.consume();
				} else {
					lblNewLabel_3.setText("");
				}
			}
		});
		branchContact.setBounds(152, 87, 283, 23);
		panel_1.add(branchContact);
		id = branch + (System.currentTimeMillis());
		branchID.setText(id);
		JButton button = new JButton("Add a new Branch");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/csiatables", "root",
							"mySQLpassword");
					query = "INSERT INTO `csiatables`.`branchlist` (`BranchID`, `Address`, `ContactNumber`) VALUES (?, ?, ?)";
					pst = con.prepareStatement(query);
					pst.setString(1, id);
					if (branchAddress.getText().isEmpty() == false && branchContact.getText().isEmpty() == false) {
						if (branchContact.getText().length() == 10) {
							pst.setString(2, branchAddress.getText());
							pst.setString(3, branchContact.getText());
						} else {
							JOptionPane.showMessageDialog(null, "Contact Number should be 10 digits long");
						}
					}
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Added branch successfully");
					id = branch + (System.currentTimeMillis());
					branchID.setText(id);
					branchAddress.setText("");
					branchContact.setText("");
				} catch (Exception e1) {
					if (branchAddress.getText().toString().length() == 0
							|| branchContact.getText().toString().length() == 0) {
						JOptionPane.showMessageDialog(null, "One or more fields have been left blank");
					}
				}
			}
		});
		button.setForeground(Color.BLACK);
		button.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		button.setBackground(Color.WHITE);
		button.setBounds(152, 120, 167, 23);
		panel_1.add(button);
		JButton btnClearContents = new JButton("Clear Contents");
		btnClearContents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel_3.setText("");
				branchAddress.setText("");
				branchContact.setText("");
			}
		});
		btnClearContents.setForeground(Color.BLACK);
		btnClearContents.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		btnClearContents.setBackground(Color.WHITE);
		btnClearContents.setBounds(329, 120, 167, 23);
		panel_1.add(btnClearContents);
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnBack.setForeground(Color.BLACK);
		btnBack.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		btnBack.setBackground(Color.WHITE);
		btnBack.setBounds(506, 120, 167, 23);
		panel_1.add(btnBack);
	}
}
