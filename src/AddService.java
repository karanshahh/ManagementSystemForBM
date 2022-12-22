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
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class AddService extends JFrame {
	private JPanel contentPane;
	JFormattedTextField category, subCategory, serviceRate;
	String query, cat, subcat;
	float rate;
	Connection con;
	char vchar;
	PreparedStatement pst;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddService frame = new AddService();
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
		category.setText("");
		subCategory.setText("");
		serviceRate.setText("");
	}

	public AddService() {
		setBounds(100, 100, 553, 210);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(240, 255, 255));
		panel.setBounds(0, 0, 539, 28);
		contentPane.add(panel);
		JLabel label = new JLabel("Add a new Service");
		label.setForeground(new Color(0, 124, 124));
		label.setFont(new Font("Bahnschrift", Font.PLAIN, 24));
		label.setBounds(0, 0, 692, 26);
		panel.add(label);
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(0, 30, 539, 143);
		contentPane.add(panel_1);
		JLabel lblCategory = new JLabel("Category:");
		lblCategory.setForeground(Color.WHITE);
		lblCategory.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		lblCategory.setBounds(10, 8, 86, 23);
		panel_1.add(lblCategory);
		JButton btnAddService = new JButton("Add Service");
		btnAddService.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				query = "INSERT INTO `csiatables`.`servicelist`  (`Category`, `Subcategory`, `Rate`) VALUES (?, ?, ?)";
				cat = category.getText();
				subcat = subCategory.getText();
				rate = Integer.parseInt(serviceRate.getText());
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/csiatables", "root",
							"mySQLpassword");
					pst = con.prepareStatement(query);
					if (category.getText().isEmpty() == false && subCategory.getText().isEmpty() == false
							&& serviceRate.getText().isEmpty() == false) {
						pst.setString(1, cat);
						pst.setString(2, subcat);
						pst.setFloat(3, rate);
						pst.executeUpdate();
						JOptionPane.showMessageDialog(null, "Service added successfully");
						clearContents();
					} else {
						JOptionPane.showMessageDialog(null,
								"One or more fields are empty, please fill all the fields!");
					}
				} catch (Exception e1) {
				}
			}
		});
		btnAddService.setForeground(Color.BLACK);
		btnAddService.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		btnAddService.setBackground(Color.WHITE);
		btnAddService.setBounds(121, 105, 153, 23);
		panel_1.add(btnAddService);
		JButton button_1 = new JButton("Clear Contents");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearContents();
			}
		});
		button_1.setForeground(Color.BLACK);
		button_1.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		button_1.setBackground(Color.WHITE);
		button_1.setBounds(284, 105, 132, 23);
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
		button_2.setBounds(426, 105, 74, 23);
		panel_1.add(button_2);
		JLabel label_4 = new JLabel("Rate (in \u20B9):");
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		label_4.setBounds(10, 72, 93, 23);
		panel_1.add(label_4);
		JLabel lblSubcategory = new JLabel("Sub-category:");
		lblSubcategory.setForeground(Color.WHITE);
		lblSubcategory.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		lblSubcategory.setBounds(10, 39, 132, 23);
		panel_1.add(lblSubcategory);
		category = new JFormattedTextField();
		category.setBounds(121, 10, 379, 23);
		panel_1.add(category);
		subCategory = new JFormattedTextField();
		subCategory.setBounds(121, 41, 379, 23);
		panel_1.add(subCategory);
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setBounds(217, 72, 104, 23);
		panel_1.add(lblNewLabel_3);
		serviceRate = new JFormattedTextField();
		serviceRate.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				vchar = e.getKeyChar();
				if (vchar == '.' || (vchar == KeyEvent.VK_BACK_SPACE) || (vchar == KeyEvent.VK_DELETE)) {
					lblNewLabel_3.setText("");
				} else {
					if ((!(Character.isDigit(vchar)) || (vchar == KeyEvent.VK_BACK_SPACE)
							|| (vchar == KeyEvent.VK_DELETE))) {
						lblNewLabel_3.setText("Invalid Entry!");
						e.consume();
					} else {
						lblNewLabel_3.setText("");
					}
				}
			}
		});
		serviceRate.setBounds(121, 72, 86, 23);
		panel_1.add(serviceRate);
	}
}