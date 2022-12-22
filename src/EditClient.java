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
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class EditClient extends JFrame {
	private JPanel contentPane;
	private JTextField clientID;
	JDateChooser bdayChoose;
	JLabel label_1, label_2, label_3, label_4, label_5, label_6, label_7, label_8, lblNewLabel_3;
	JButton button_1, button_2, btnEditClient;
	JFormattedTextField clientContact, clientName, clientEmail;
	Connection con, con1;
	char vchar, gender1;
	String id1, name1, email1, number1, date;
	Date date1;
	Function f;
	ResultSet rs;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditClient frame = new EditClient();
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
	String id, name, number, email, bday;
	String gender;
	PreparedStatement pst, pst1;

	public void clearContents() {
		clientID.setText("");
		clientContact.setText("");
		clientName.setText("");
		clientEmail.setText("");
		bdayChoose.setDate(null);
	}

	public void textFieldEditable(boolean n) {
		clientName.setEditable(n);
		clientContact.setEditable(n);
		clientEmail.setEditable(n);
		bdayChoose.setEnabled(n);
	}

	public EditClient() {
		setBounds(100, 300, 706, 286);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(240, 255, 255));
		panel.setBounds(0, 0, 863, 36);
		contentPane.add(panel);
		JLabel lblEditAnExisting = new JLabel("Edit an existing Client");
		lblEditAnExisting.setForeground(new Color(0, 124, 124));
		lblEditAnExisting.setFont(new Font("Bahnschrift", Font.PLAIN, 24));
		lblEditAnExisting.setBounds(0, 0, 692, 26);
		panel.add(lblEditAnExisting);
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(0, 31, 692, 218);
		contentPane.add(panel_1);
		label_1 = new JLabel("");
		label_1.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		label_1.setBounds(0, 0, 0, 0);
		panel_1.add(label_1);
		clientID = new JTextField();
		clientID.setForeground(Color.BLACK);
		clientID.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		clientID.setColumns(10);
		clientID.setBackground(Color.WHITE);
		clientID.setBounds(152, 22, 283, 23);
		panel_1.add(clientID);
		JRadioButton radioButton = new JRadioButton("Male");
		radioButton.setForeground(Color.WHITE);
		radioButton.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		radioButton.setBackground(Color.DARK_GRAY);
		radioButton.setBounds(152, 154, 51, 21);
		panel_1.add(radioButton);
		JRadioButton radioButton_1 = new JRadioButton("Female");
		radioButton_1.setForeground(Color.WHITE);
		radioButton_1.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		radioButton_1.setBackground(Color.DARK_GRAY);
		radioButton_1.setBounds(205, 154, 80, 21);
		panel_1.add(radioButton_1);
		ButtonGroup bg = new ButtonGroup();
		bg.add(radioButton);
		bg.add(radioButton_1);
		label_2 = new JLabel("Client ID:");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		label_2.setBounds(10, 23, 132, 23);
		panel_1.add(label_2);
		label_3 = new JLabel("Mobile Number:");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		label_3.setBounds(10, 85, 132, 23);
		panel_1.add(label_3);
		label_4 = new JLabel("");
		label_4.setForeground(Color.RED);
		label_4.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		label_4.setBounds(445, 87, 176, 23);
		panel_1.add(label_4);
		lblNewLabel_3 = new JLabel("");
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
		bdayChoose = new JDateChooser();
		bdayChoose.setBounds(371, 151, 250, 23);
		panel_1.add(bdayChoose);
		textFieldEditable(false);
		btnEditClient = new JButton("Edit Client");
		btnEditClient.setVisible(false);
		btnEditClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				id1 = clientID.getText();
				name1 = clientName.getText();
				number1 = clientContact.getText();
				email1 = clientEmail.getText().toLowerCase();
				gender1 = 'M';
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
				bday = sdf.format(bdayChoose.getDate());
				if (radioButton.isSelected()) {
					gender1 = 'M';
				} else if (radioButton_1.isSelected()) {
					gender1 = 'F';
				}
				String query = "update clientlist set Name = '" + name1 + "', MobileNumber = '" + number1 + "',"
						+ " Email = '" + email1 + "', Gender = '" + gender1 + "', Birthday = '" + bday + "' "
						+ "where ClientID = '" + id1 + "'";
				try {
					con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/csiatables", "root",
							"mySQLpassword");
					PreparedStatement pst1 = con1.prepareStatement(query);
					if (name1.isEmpty() == false && number1.isEmpty() == false && email1.isEmpty() == false
							&& bday.isEmpty() == false
							&& (radioButton.isSelected() == true || radioButton_1.isSelected() == true)) {
						pst1.execute();
						JOptionPane.showMessageDialog(null, "Client Edited Successfully!");
						textFieldEditable(false);
						clientID.setEditable(true);
						clearContents();
					} else {
						JOptionPane.showMessageDialog(null,
								"One or more fields are empty, please fill all the fields!");
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnEditClient.setForeground(Color.BLACK);
		btnEditClient.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		btnEditClient.setBackground(Color.WHITE);
		btnEditClient.setBounds(152, 181, 167, 23);
		panel_1.add(btnEditClient);
		button_1 = new JButton("Clear Contents");
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
		button_2 = new JButton("Back");
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
		label_5 = new JLabel("Email:");
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		label_5.setBounds(10, 116, 132, 23);
		panel_1.add(label_5);
		label_6 = new JLabel("Gender:");
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		label_6.setBounds(10, 147, 132, 23);
		panel_1.add(label_6);
		label_7 = new JLabel("Birthdate:");
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		label_7.setBounds(291, 153, 85, 23);
		panel_1.add(label_7);
		label_8 = new JLabel("Name");
		label_8.setForeground(Color.WHITE);
		label_8.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		label_8.setBounds(10, 54, 132, 23);
		panel_1.add(label_8);
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f = new Function();
				rs = null;
				name = "Name";
				number = "MobileNumber";
				email = "Email";
				gender = "Gender";
				date = "Birthday";
				if (clientID.getText().isEmpty() == true) {
					JOptionPane.showMessageDialog(null, "Field Blank! Please enter a Client ID!");
				} else {
					rs = f.find(clientID.getText());
					try {
						if (rs.next()) {
							textFieldEditable(true);
							clientName.setText(rs.getString(name));
							clientContact.setText(rs.getString(number));
							clientEmail.setText(rs.getString(email));
							if (rs.getString(gender).equals("M")) {
								radioButton.setSelected(true);
							} else if (rs.getString(gender).equals("F")) {
								radioButton_1.setSelected(true);
							}
							bday = rs.getString(date);
							date1 = new SimpleDateFormat("yyyy/MM/dd").parse(bday);
							bdayChoose.setDate(date1);
							btnEditClient.setVisible(true);
							clientID.setEditable(false);
						}
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, e1);
					}
				}
			}
		});
		btnSearch.setForeground(Color.BLACK);
		btnSearch.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		btnSearch.setBackground(Color.WHITE);
		btnSearch.setBounds(445, 22, 167, 23);
		panel_1.add(btnSearch);
	}
}
