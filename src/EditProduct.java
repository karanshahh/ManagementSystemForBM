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
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class EditProduct extends JFrame {
	private JPanel contentPane;
	JFormattedTextField prodComp, prodName, prodSize, prodRate, productID;
	JTextArea prodDesc;
	int srlno;
	String company1;
	String pname1;
	String description1;
	int size1;
	int rate1;
	String query;
	Connection con1;
	Function f;
	ResultSet rs;
	String company;
	String pname;
	String description;
	String size;
	String rate;
	PreparedStatement pst1;
	char vchar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditProduct frame = new EditProduct();
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
		prodDesc.setText("");
		prodComp.setText("");
		prodName.setText("");
		prodSize.setText("");
		prodRate.setText("");
		productID.setText("");
	}

	public void textFieldEditable(boolean n) {
		prodDesc.setEditable(n);
		prodComp.setEditable(n);
		prodName.setEditable(n);
		prodSize.setEditable(n);
		prodRate.setEditable(n);
	}

	public EditProduct() {
		setBounds(100, 300, 626, 303);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(240, 255, 255));
		panel.setBounds(0, 0, 612, 28);
		contentPane.add(panel);
		JLabel lblEditAProduct = new JLabel("Edit a product");
		lblEditAProduct.setForeground(new Color(0, 124, 124));
		lblEditAProduct.setFont(new Font("Bahnschrift", Font.PLAIN, 24));
		lblEditAProduct.setBounds(0, 0, 692, 26);
		panel.add(lblEditAProduct);
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(0, 27, 612, 269);
		contentPane.add(panel_1);
		JLabel label_2 = new JLabel("Company:");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		label_2.setBounds(10, 38, 86, 23);
		panel_1.add(label_2);
		JLabel label_3 = new JLabel("Size (in ML):");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		label_3.setBounds(10, 102, 94, 23);
		panel_1.add(label_3);
		JButton btnEditProduct = new JButton("Edit Product");
		btnEditProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				srlno = Integer.parseInt(productID.getText());
				company1 = prodComp.getText();
				pname1 = prodName.getText();
				description1 = prodDesc.getText();
				size1 = Integer.parseInt(prodSize.getText());
				rate1 = Integer.parseInt(prodRate.getText());
				query = "UPDATE productlist SET Company = '" + company1 + "', ProductName = '" + pname1
						+ "', ProductDescription = '" + description1 + "', Size = '" + size1 + "', Rate = '" + rate1
						+ "' WHERE (SerialNo = '" + srlno + "')";
				try {
					con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/csiatables", "root",
							"mySQLpassword");
					pst1 = con1.prepareStatement(query);
					if (company1.isEmpty() == false && pname1.isEmpty() == false
							&& prodSize.getText().isEmpty() == false && prodRate.getText().isEmpty() == false) {
						pst1.execute();
						JOptionPane.showMessageDialog(null, "Product edited successfully!");
						clearContents();
						textFieldEditable(false);
						productID.setEditable(true);
					} else {
						JOptionPane.showMessageDialog(null,
								"One or more fields are empty, please fill all the fields!");
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnEditProduct.setForeground(Color.BLACK);
		btnEditProduct.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		btnEditProduct.setBackground(Color.WHITE);
		btnEditProduct.setBounds(121, 196, 167, 23);
		panel_1.add(btnEditProduct);
		JButton button_1 = new JButton("Clear Contents");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearContents();
			}
		});
		button_1.setForeground(Color.BLACK);
		button_1.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		button_1.setBackground(Color.WHITE);
		button_1.setBounds(298, 196, 167, 23);
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
		button_2.setBounds(475, 196, 122, 23);
		panel_1.add(button_2);
		JLabel label_5 = new JLabel("Rate (in \u20B9):");
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		label_5.setBounds(336, 102, 93, 23);
		panel_1.add(label_5);
		JLabel lblProductName = new JLabel("Product Name:");
		lblProductName.setForeground(Color.WHITE);
		lblProductName.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		lblProductName.setBounds(10, 69, 109, 23);
		panel_1.add(lblProductName);
		JLabel label_8 = new JLabel("<HTML>Product Description:<HTML>");
		label_8.setForeground(Color.WHITE);
		label_8.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		label_8.setBounds(10, 139, 86, 51);
		panel_1.add(label_8);
		prodComp = new JFormattedTextField();
		prodComp.setBounds(121, 40, 476, 23);
		panel_1.add(prodComp);
		prodName = new JFormattedTextField();
		prodName.setBounds(121, 71, 476, 23);
		panel_1.add(prodName);
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(10, 120, 104, 23);
		panel_1.add(lblNewLabel_3);
		prodSize = new JFormattedTextField();
		prodSize.addKeyListener(new KeyAdapter() {
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
		prodSize.setBounds(121, 102, 172, 23);
		panel_1.add(prodSize);
		prodRate = new JFormattedTextField();
		prodRate.addKeyListener(new KeyAdapter() {
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
		prodRate.setBounds(425, 102, 172, 23);
		panel_1.add(prodRate);
		prodDesc = new JTextArea();
		prodDesc.setLineWrap(true);
		prodDesc.setBounds(121, 139, 476, 51);
		panel_1.add(prodDesc);
		JLabel lblSerialNumber = new JLabel("Serial Number:");
		lblSerialNumber.setForeground(Color.WHITE);
		lblSerialNumber.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		lblSerialNumber.setBounds(10, 5, 122, 23);
		panel_1.add(lblSerialNumber);
		textFieldEditable(false);
		productID = new JFormattedTextField();
		productID.setBounds(138, 5, 150, 23);
		panel_1.add(productID);
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f = new Function();
				rs = null;
				company = "Company";
				pname = "ProductName";
				description = "ProductDescription";
				size = "Size";
				rate = "Rate";
				if (productID.getText().isEmpty() == true) {
					JOptionPane.showMessageDialog(null, "Field Blank! Please enter a Product Serial No.!");
				} else {
					rs = f.find(Integer.parseInt(productID.getText()));
					try {
						if (rs.next()) {
							textFieldEditable(true);
							prodComp.setText(rs.getString(company));
							prodName.setText(rs.getString(pname));
							prodDesc.setText(rs.getString(description));
							prodSize.setText(Integer.toString(rs.getInt(size)));
							prodRate.setText(Integer.toString(rs.getInt(rate)));
							productID.setEditable(false);
						} else {
							JOptionPane.showMessageDialog(null, "No product registered with that serial number");
						}
					} catch (Exception e1) {
					}
				}
			}
		});
		btnSearch.setForeground(Color.BLACK);
		btnSearch.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		btnSearch.setBackground(Color.WHITE);
		btnSearch.setBounds(298, 5, 109, 23);
		panel_1.add(btnSearch);
	}
}