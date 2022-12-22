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
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class AddProduct extends JFrame {
	private JPanel contentPane;
	JFormattedTextField company, prodname, size, rate;
	JTextArea description;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddProduct frame = new AddProduct();
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
	String query, comp, pname, desc;
	double size1, rate1;
	Connection con;

	public void clearContents() {
		company.setText("");
		prodname.setText("");
		size.setText("");
		rate.setText("");
		description.setText("");
	}

	public AddProduct() {
		setBounds(100, 300, 626, 264);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(240, 255, 255));
		panel.setBounds(0, 0, 612, 28);
		contentPane.add(panel);
		JLabel lblAddANew = new JLabel("Add a new Product");
		lblAddANew.setForeground(new Color(0, 124, 124));
		lblAddANew.setFont(new Font("Bahnschrift", Font.PLAIN, 24));
		lblAddANew.setBounds(0, 0, 692, 26);
		panel.add(lblAddANew);
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(0, 30, 612, 229);
		contentPane.add(panel_1);
		JLabel lblCompany = new JLabel("Company:");
		lblCompany.setForeground(Color.WHITE);
		lblCompany.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		lblCompany.setBounds(10, 8, 86, 23);
		panel_1.add(lblCompany);
		JLabel lblSizeinMl = new JLabel("Size (in ML):");
		lblSizeinMl.setForeground(Color.WHITE);
		lblSizeinMl.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		lblSizeinMl.setBounds(10, 72, 94, 23);
		panel_1.add(lblSizeinMl);
		JButton btnAddProduct = new JButton("Add Product");
		btnAddProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				query = "INSERT INTO `csiatables`.`productlist` (`Company`, `ProductName`, `ProductDescription`, `Size`, `Rate`) VALUES (?, ?, ?, ?, ?)";
				comp = company.getText();
				pname = prodname.getText();
				size1 = Double.parseDouble((size.getText()));
				rate1 = Double.parseDouble(rate.getText());
				desc = description.getText();
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/csiatables", "root",
							"mySQLpassword");
					pst = con.prepareStatement(query);
					if (comp.isEmpty() == false && pname.isEmpty() == false && size.getText().isEmpty() == false
							&& rate.getText().isEmpty() == false) {
						pst.setString(1, comp);
						pst.setString(2, pname);
						pst.setString(3, desc);
						pst.setDouble(4, size1);
						pst.setDouble(5, rate1);
						pst.executeUpdate();
						JOptionPane.showMessageDialog(null, "Product added successfully!");
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
		btnAddProduct.setForeground(Color.BLACK);
		btnAddProduct.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		btnAddProduct.setBackground(Color.WHITE);
		btnAddProduct.setBounds(121, 166, 167, 23);
		panel_1.add(btnAddProduct);
		JButton button_1 = new JButton("Clear Contents");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearContents();
			}
		});
		button_1.setForeground(Color.BLACK);
		button_1.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		button_1.setBackground(Color.WHITE);
		button_1.setBounds(298, 166, 167, 23);
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
		button_2.setBounds(475, 166, 122, 23);
		panel_1.add(button_2);
		JLabel lblQuantity = new JLabel("Rate (in \u20B9):");
		lblQuantity.setForeground(Color.WHITE);
		lblQuantity.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		lblQuantity.setBounds(363, 72, 93, 23);
		panel_1.add(lblQuantity);
		JLabel lblProductName = new JLabel("Product Name:");
		lblProductName.setForeground(Color.WHITE);
		lblProductName.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		lblProductName.setBounds(10, 39, 132, 23);
		panel_1.add(lblProductName);
		JLabel lblProductDescription = new JLabel("<HTML>Product Description:<HTML>");
		lblProductDescription.setForeground(Color.WHITE);
		lblProductDescription.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		lblProductDescription.setBounds(10, 109, 86, 51);
		panel_1.add(lblProductDescription);
		company = new JFormattedTextField();
		company.setBounds(121, 10, 476, 23);
		panel_1.add(company);
		prodname = new JFormattedTextField();
		prodname.setBounds(121, 41, 476, 23);
		panel_1.add(prodname);
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setBounds(10, 90, 104, 23);
		panel_1.add(lblNewLabel_3);
		size = new JFormattedTextField();
		size.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char vchar = e.getKeyChar();
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
		size.setBounds(121, 72, 186, 23);
		panel_1.add(size);
		rate = new JFormattedTextField();
		rate.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char vchar = e.getKeyChar();
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
		rate.setBounds(444, 72, 153, 23);
		panel_1.add(rate);
		description = new JTextArea();
		description.setLineWrap(true);
		description.setBounds(121, 109, 476, 51);
		panel_1.add(description);
	}
}