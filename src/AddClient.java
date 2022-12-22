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
import java.text.SimpleDateFormat;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import com.toedter.calendar.JDateChooser;

@SuppressWarnings("serial")
public class AddClient extends JFrame {
	private JPanel contentPane;
	private JTextField clientID;
	JFormattedTextField clientContact, clientName, clientEmail;
	JDateChooser bdayChoose;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddClient frame = new AddClient();
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
	public void clearContents() {
		clientEmail.setText("");
		clientName.setText("");
		clientContact.setText("");
		bdayChoose.setDate(null);
	}

	String client = "CLIENT";
	String id, date;
	SimpleDateFormat sdf;
	String gender;
	char vchar;
	Connection con;
	String query;
	PreparedStatement pst;

	public AddClient() {
		setBounds(100, 300, 706, 286);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(240, 255, 255));
		panel.setBounds(0, 0, 863, 36);
		contentPane.add(panel);
		JLabel lblAddANew = new JLabel("Add a new Client\r\n");
		lblAddANew.setForeground(new Color(0, 124, 124));
		lblAddANew.setFont(new Font("Bahnschrift", Font.PLAIN, 24));
		lblAddANew.setBounds(0, 0, 692, 26);
		panel.add(lblAddANew);
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(0, 31, 692, 218);
		contentPane.add(panel_1);
		JLabel label_2 = new JLabel("");
		label_2.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		label_2.setBounds(0, 0, 0, 0);
		panel_1.add(label_2);
		clientID = new JTextField();
		clientID.setForeground(Color.BLACK);
		clientID.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		clientID.setEditable(false);
		clientID.setColumns(10);
		clientID.setBackground(Color.WHITE);
		clientID.setBounds(152, 22, 283, 23);
		panel_1.add(clientID);
		JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setForeground(Color.WHITE);
		rdbtnMale.setBackground(Color.DARK_GRAY);
		rdbtnMale.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		rdbtnMale.setBounds(152, 154, 51, 21);
		panel_1.add(rdbtnMale);
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setForeground(Color.WHITE);
		rdbtnFemale.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		rdbtnFemale.setBackground(Color.DARK_GRAY);
		rdbtnFemale.setBounds(205, 154, 80, 21);
		panel_1.add(rdbtnFemale);
		JLabel lblClientId = new JLabel("Client ID:");
		lblClientId.setForeground(Color.WHITE);
		lblClientId.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		lblClientId.setBounds(10, 23, 132, 23);
		panel_1.add(lblClientId);
		JLabel lblMobileNumber = new JLabel("Mobile Number:");
		lblMobileNumber.setForeground(Color.WHITE);
		lblMobileNumber.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		lblMobileNumber.setBounds(10, 85, 132, 23);
		panel_1.add(lblMobileNumber);
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setBounds(445, 87, 176, 23);
		panel_1.add(lblNewLabel_3);
		clientContact = new JFormattedTextField();
		clientContact.addKeyListener(new KeyAdapter() {
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
		clientContact.setBounds(152, 87, 283, 23);
		panel_1.add(clientContact);
		clientName = new JFormattedTextField();
		clientName.setBounds(152, 56, 283, 23);
		panel_1.add(clientName);
		clientEmail = new JFormattedTextField();
		clientEmail.setBounds(152, 120, 522, 23);
		panel_1.add(clientEmail);
		id = client + (System.currentTimeMillis() / 1000);
		clientID.setText(id);
		bdayChoose = new JDateChooser();
		bdayChoose.setBounds(371, 151, 250, 23);
		bdayChoose.setDateFormatString("yyyy/MM/dd");
		panel_1.add(bdayChoose);
		JButton btnAddClient = new JButton("Add Client");
		btnAddClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnMale.isSelected() == true) {
					gender = "M";
				} else if (rdbtnFemale.isSelected() == true) {
					gender = "F";
				}
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/csiatables", "root",
							"mySQLpassword");
					query = "INSERT INTO `csiatables`.`clientlist` (`ClientID`, `Name`, `MobileNumber`, `Email`, `Gender`, `Birthday`)"
							+ " VALUES (?, ?, ?, ?, ?, ?)";
					pst = con.prepareStatement(query);
					pst.setString(1, id);
					if (clientName.getText().isEmpty() == false && clientContact.getText().isEmpty() == false) {
						sdf = new SimpleDateFormat("yyyy/MM/dd");
						date = sdf.format(bdayChoose.getDate());
						pst.setString(2, clientName.getText());
						pst.setString(3, clientContact.getText());
						pst.setString(4, clientEmail.getText().toLowerCase());
						pst.setString(5, gender);
						pst.setString(6, date);
					}
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Added Client Successfully");
					id = client + (System.currentTimeMillis() / 1000);
					clientID.setText(id);
					clearContents();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnAddClient.setForeground(Color.BLACK);
		btnAddClient.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		btnAddClient.setBackground(Color.WHITE);
		btnAddClient.setBounds(152, 181, 167, 23);
		panel_1.add(btnAddClient);
		JButton button_1 = new JButton("Clear Contents");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearContents();
			}
		});
		button_1.setForeground(Color.BLACK);
		button_1.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		button_1.setBackground(Color.WHITE);
		button_1.setBounds(329, 181, 167, 23);
		panel_1.add(button_1);
		JButton button_2 = new JButton("Back");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_2.setForeground(Color.BLACK);
		button_2.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		button_2.setBackground(Color.WHITE);
		button_2.setBounds(506, 181, 167, 23);
		panel_1.add(button_2);
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		lblEmail.setBounds(10, 116, 132, 23);
		panel_1.add(lblEmail);
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setForeground(Color.WHITE);
		lblGender.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		lblGender.setBounds(10, 147, 132, 23);
		panel_1.add(lblGender);
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnMale);
		bg.add(rdbtnFemale);
		JLabel lblBirthdate = new JLabel("Birthdate:");
		lblBirthdate.setForeground(Color.WHITE);
		lblBirthdate.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		lblBirthdate.setBounds(291, 153, 85, 23);
		panel_1.add(lblBirthdate);
		JLabel lblName = new JLabel("Name");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		lblName.setBounds(10, 54, 132, 23);
		panel_1.add(lblName);
	}
}