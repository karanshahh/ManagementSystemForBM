import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class EditService extends JFrame {
	private JPanel contentPane;
	JFormattedTextField serviceCat, serviceSubCat, serviceRate, serviceSrlNo;
	int srlno, rate;
	String cat, subcat, query;
	Connection con1;
	PreparedStatement pst1;
	Function f;
	ResultSet rs;
	String rate1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditService frame = new EditService();
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
	public void textFieldEditable(boolean n) {
		serviceCat.setEditable(n);
		serviceSubCat.setEditable(n);
		serviceRate.setEditable(n);
	}

	public void clearContents() {
		textFieldEditable(false);
		serviceSrlNo.setEditable(true);
		serviceCat.setText("");
		serviceSubCat.setText("");
		serviceRate.setText("");
		serviceSrlNo.setText("");
	}

	public EditService() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 553, 237);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(240, 255, 255));
		panel.setBounds(0, 0, 612, 28);
		contentPane.add(panel);
		JLabel label = new JLabel("Edit an existing Service");
		label.setForeground(new Color(0, 124, 124));
		label.setFont(new Font("Bahnschrift", Font.PLAIN, 24));
		label.setBounds(0, 0, 537, 28);
		panel.add(label);
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(0, 30, 539, 186);
		contentPane.add(panel_1);
		JLabel label_1 = new JLabel("Category:");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		label_1.setBounds(10, 38, 86, 23);
		panel_1.add(label_1);
		JButton button = new JButton("Edit Service");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				srlno = Integer.parseInt(serviceSrlNo.getText());
				cat = serviceCat.getText();
				subcat = serviceSubCat.getText();
				rate = Integer.parseInt(serviceRate.getText());
				query = "UPDATE servicelist SET Category = '" + cat + "', Subcategory = '" + subcat + "', Rate = '"
						+ rate + "' WHERE (SerialNo = '" + srlno + "')";
				try {
					con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/csiatables", "root",
							"mySQLpassword");
					pst1 = con1.prepareStatement(query);
					if (serviceCat.getText().isEmpty() == false && serviceSubCat.getText().isEmpty() == false
							&& serviceCat.getText().isEmpty() == false) {
						pst1.execute();
						JOptionPane.showMessageDialog(null, "Service edited successfully!");
						clearContents();
						textFieldEditable(false);
						serviceSrlNo.setEditable(true);
					} else {
						JOptionPane.showMessageDialog(null,
								"One or more fields are empty, please fill all the fields!");
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		button.setForeground(Color.BLACK);
		button.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		button.setBackground(Color.WHITE);
		button.setBounds(121, 135, 153, 23);
		panel_1.add(button);
		JButton button_1 = new JButton("Clear Contents");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearContents();
			}
		});
		button_1.setForeground(Color.BLACK);
		button_1.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		button_1.setBackground(Color.WHITE);
		button_1.setBounds(284, 135, 132, 23);
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
		button_2.setBounds(426, 135, 74, 23);
		panel_1.add(button_2);
		JLabel label_2 = new JLabel("Rate (in \u20B9):");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		label_2.setBounds(10, 102, 93, 23);
		panel_1.add(label_2);
		JLabel label_3 = new JLabel("Sub-category:");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		label_3.setBounds(10, 69, 132, 23);
		panel_1.add(label_3);
		serviceCat = new JFormattedTextField();
		serviceCat.setBounds(121, 40, 379, 23);
		panel_1.add(serviceCat);
		serviceSubCat = new JFormattedTextField();
		serviceSubCat.setBounds(121, 71, 379, 23);
		panel_1.add(serviceSubCat);
		JLabel label_4 = new JLabel("");
		label_4.setForeground(Color.RED);
		label_4.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		label_4.setBounds(217, 102, 104, 23);
		panel_1.add(label_4);
		serviceRate = new JFormattedTextField();
		serviceRate.setBounds(121, 102, 86, 23);
		panel_1.add(serviceRate);
		textFieldEditable(false);
		JLabel lblEnterSerialNumber = new JLabel("Serial Number:");
		lblEnterSerialNumber.setForeground(Color.WHITE);
		lblEnterSerialNumber.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		lblEnterSerialNumber.setBounds(10, 10, 110, 23);
		panel_1.add(lblEnterSerialNumber);
		serviceSrlNo = new JFormattedTextField();
		serviceSrlNo.setBounds(121, 7, 153, 23);
		panel_1.add(serviceSrlNo);
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f = new Function();
				rs = null;
				cat = "Category";
				subcat = "Subcategory";
				rate1 = "Rate";
				if (serviceSrlNo.getText().isEmpty() == true) {
					JOptionPane.showMessageDialog(null, "Field Blank! Please enter the Service Serial No.!");
				} else {
					rs = f.find1(Integer.parseInt(serviceSrlNo.getText()));
					try {
						if (rs.next()) {
							textFieldEditable(true);
							serviceCat.setText(rs.getString(cat));
							serviceSubCat.setText(rs.getString(subcat));
							serviceRate.setText(Integer.toString(rs.getInt(rate1)));
							serviceSrlNo.setEditable(false);
						} else {
							JOptionPane.showMessageDialog(null, "No service registered with that serial number");
						}
					} catch (Exception e1) {
					}
				}
			}
		});
		btnSearch.setForeground(Color.BLACK);
		btnSearch.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		btnSearch.setBackground(Color.WHITE);
		btnSearch.setBounds(282, 7, 153, 23);
		panel_1.add(btnSearch);
	}
}
