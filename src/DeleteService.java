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
public class DeleteService extends JFrame {
	private JPanel contentPane;
	JFormattedTextField srlno;
	JLabel cat, subcat, rate;
	String query, cat1, subcat1, rate1;
	ResultSet rs;
	Connection con;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteService frame = new DeleteService();
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
		srlno.setEditable(true);
		srlno.setText("");
		cat.setText("");
		subcat.setText("");
		rate.setText("");
	}

	PreparedStatement pst;

	public DeleteService() {
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
		JLabel lblDeleteAnExisting = new JLabel("Delete an existing Service");
		lblDeleteAnExisting.setForeground(new Color(0, 124, 124));
		lblDeleteAnExisting.setFont(new Font("Bahnschrift", Font.PLAIN, 24));
		lblDeleteAnExisting.setBounds(0, 0, 537, 28);
		panel.add(lblDeleteAnExisting);
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
		JButton button = new JButton("Delete Service");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				query = "DELETE FROM `csiatables`.`servicelist` WHERE (`SerialNo` = ? )";
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/csiatables", "root",
							"mySQLpassword");
					pst = con.prepareStatement(query);
					pst.setInt(1, Integer.parseInt(srlno.getText()));
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Service removed successfully!");
					clearContents();
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
		JLabel label_5 = new JLabel("Serial Number:");
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		label_5.setBounds(10, 10, 110, 23);
		panel_1.add(label_5);
		srlno = new JFormattedTextField();
		srlno.setBounds(121, 7, 153, 23);
		panel_1.add(srlno);
		JButton button_3 = new JButton("Search");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Function f = new Function();
				rs = null;
				cat1 = "Category";
				subcat1 = "Subcategory";
				rate1 = "Rate";
				if (srlno.getText().isEmpty() == true) {
					JOptionPane.showMessageDialog(null, "Field Blank! Please enter the Service Serial No.!");
				} else {
					rs = f.find1(Integer.parseInt(srlno.getText()));
					try {
						if (rs.next()) {
							cat.setText(rs.getString(cat1));
							subcat.setText(rs.getString(subcat1));
							rate.setText(Integer.toString(rs.getInt(rate1)));
							srlno.setEditable(false);
						} else {
							JOptionPane.showMessageDialog(null, "No service registered with that serial number");
						}
					} catch (Exception e1) {
					}
				}
			}
		});
		button_3.setForeground(Color.BLACK);
		button_3.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		button_3.setBackground(Color.WHITE);
		button_3.setBounds(282, 7, 153, 23);
		panel_1.add(button_3);
		cat = new JLabel("");
		cat.setForeground(Color.GREEN);
		cat.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		cat.setBounds(121, 38, 379, 23);
		panel_1.add(cat);
		subcat = new JLabel("");
		subcat.setForeground(Color.GREEN);
		subcat.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		subcat.setBounds(121, 69, 379, 23);
		panel_1.add(subcat);
		rate = new JLabel("");
		rate.setForeground(Color.GREEN);
		rate.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		rate.setBounds(121, 102, 379, 23);
		panel_1.add(rate);
	}
}