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
public class DeleteProduct extends JFrame {
	private JPanel contentPane;
	JFormattedTextField serialNo;
	JLabel company, pname, description, rate, size;
	Connection con;
	String query, company1, pname1, description1, size1, rate1;
	ResultSet rs;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteProduct frame = new DeleteProduct();
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
		serialNo.setText("");
		company.setText("");
		description.setText("");
		size.setText("");
		rate.setText("");
		pname.setText("");
	}

	PreparedStatement pst;

	public DeleteProduct() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 397, 315);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 383, 278);
		contentPane.add(panel);
		panel.setLayout(null);
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(240, 255, 255));
		panel_1.setBounds(0, 0, 383, 36);
		panel.add(panel_1);
		JLabel lblDeleteAProduct = new JLabel("Delete a Product\r\n");
		lblDeleteAProduct.setForeground(new Color(0, 124, 124));
		lblDeleteAProduct.setFont(new Font("Bahnschrift", Font.PLAIN, 24));
		lblDeleteAProduct.setBounds(0, 0, 383, 26);
		panel_1.add(lblDeleteAProduct);
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.DARK_GRAY);
		panel_2.setBounds(0, 35, 383, 244);
		panel.add(panel_2);
		JLabel label_1 = new JLabel("Serial Number: ");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		label_1.setBounds(10, 10, 83, 45);
		panel_2.add(label_1);
		JLabel label_2 = new JLabel("Product Name:");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		label_2.setBounds(10, 78, 78, 45);
		panel_2.add(label_2);
		JButton button = new JButton("Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button.setForeground(Color.BLACK);
		button.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		button.setBackground(Color.WHITE);
		button.setBounds(236, 211, 102, 23);
		panel_2.add(button);
		JLabel label_3 = new JLabel("<HTML>Product Description:<HTML>");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		label_3.setBounds(10, 116, 75, 51);
		panel_2.add(label_3);
		JLabel label_4 = new JLabel("Size:");
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		label_4.setBounds(10, 177, 25, 15);
		panel_2.add(label_4);
		JLabel label_5 = new JLabel("Rate: ");
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		label_5.setBounds(168, 177, 30, 15);
		panel_2.add(label_5);
		JLabel label_6 = new JLabel("Company:");
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		label_6.setBounds(10, 40, 51, 45);
		panel_2.add(label_6);
		company = new JLabel("");
		company.setForeground(Color.GREEN);
		company.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		company.setBounds(74, 40, 299, 45);
		panel_2.add(company);
		pname = new JLabel("");
		pname.setForeground(Color.GREEN);
		pname.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		pname.setBounds(98, 78, 177, 45);
		panel_2.add(pname);
		description = new JLabel("<HTML><HTML>");
		description.setForeground(Color.GREEN);
		description.setFont(new Font("Bahnschrift", Font.PLAIN, 10));
		description.setBounds(85, 116, 288, 51);
		panel_2.add(description);
		size = new JLabel("");
		size.setForeground(Color.GREEN);
		size.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		size.setBounds(41, 169, 117, 31);
		panel_2.add(size);
		rate = new JLabel("");
		rate.setForeground(Color.GREEN);
		rate.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		rate.setBounds(220, 169, 134, 31);
		panel_2.add(rate);
		serialNo = new JFormattedTextField();
		serialNo.setBounds(117, 24, 146, 19);
		panel_2.add(serialNo);
		JButton btnDeleteProduct = new JButton("Delete Product");
		btnDeleteProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				query = "DELETE FROM `csiatables`.`productlist` WHERE (`SerialNo` = ? )";
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/csiatables", "root",
							"mySQLpassword");
					pst = con.prepareStatement(query);
					pst.setInt(1, Integer.parseInt(serialNo.getText()));
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Product deleted successfully!");
					clearContents();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnDeleteProduct.setForeground(Color.BLACK);
		btnDeleteProduct.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		btnDeleteProduct.setBackground(Color.WHITE);
		btnDeleteProduct.setBounds(90, 211, 136, 23);
		panel_2.add(btnDeleteProduct);
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Function f = new Function();
				rs = null;
				company1 = "Company";
				pname1 = "ProductName";
				description1 = "ProductDescription";
				size1 = "Size";
				rate1 = "Rate";
				if (serialNo.getText().isEmpty() == true) {
					JOptionPane.showMessageDialog(null, "Field Blank! Please enter a Client ID!");
				} else {
					rs = f.find(Integer.parseInt(serialNo.getText()));
					try {
						if (rs.next()) {
							company.setText(rs.getString(company1));
							pname.setText(rs.getString(pname1));
							description.setText(rs.getString(description1));
							size.setText(Integer.toString(rs.getInt(size1)));
							rate.setText(Integer.toString(rs.getInt(rate1)));
							serialNo.setEditable(false);
						} else {
							JOptionPane.showMessageDialog(null, "No product registered with that serial number");
							serialNo.setText("");
						}
					} catch (Exception e1) {
					}
				}
			}
		});
		btnSearch.setForeground(Color.BLACK);
		btnSearch.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		btnSearch.setBackground(Color.WHITE);
		btnSearch.setBounds(271, 23, 83, 23);
		panel_2.add(btnSearch);
	}
}