import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class ViewProductInfo extends JFrame {
	private JPanel contentPane;
	JLabel pname, company, description, serialno, size, rate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewProductInfo frame = new ViewProductInfo();
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
	public ViewProductInfo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 397, 315);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 383, 361);
		contentPane.add(panel);
		panel.setLayout(null);
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(240, 255, 255));
		panel_1.setBounds(0, 0, 383, 36);
		panel.add(panel_1);
		JLabel lblProductInfo = new JLabel("Product Info");
		lblProductInfo.setForeground(new Color(0, 124, 124));
		lblProductInfo.setFont(new Font("Bahnschrift", Font.PLAIN, 24));
		lblProductInfo.setBounds(0, 0, 383, 26);
		panel_1.add(lblProductInfo);
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.DARK_GRAY);
		panel_2.setBounds(0, 36, 383, 244);
		panel.add(panel_2);
		JLabel lblSerialNumber = new JLabel("Serial Number: ");
		lblSerialNumber.setForeground(Color.WHITE);
		lblSerialNumber.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		lblSerialNumber.setBounds(10, 10, 83, 45);
		panel_2.add(lblSerialNumber);
		JLabel lblProductName = new JLabel("Product Name:");
		lblProductName.setForeground(Color.WHITE);
		lblProductName.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		lblProductName.setBounds(10, 78, 78, 45);
		panel_2.add(lblProductName);
		JButton button = new JButton("Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button.setForeground(Color.BLACK);
		button.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		button.setBackground(Color.WHITE);
		button.setBounds(110, 210, 167, 23);
		panel_2.add(button);
		JLabel lblProductDescription = new JLabel("<HTML>Product Description:<HTML>");
		lblProductDescription.setForeground(Color.WHITE);
		lblProductDescription.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		lblProductDescription.setBounds(10, 116, 75, 51);
		panel_2.add(lblProductDescription);
		JLabel lblSize = new JLabel("Size:");
		lblSize.setForeground(Color.WHITE);
		lblSize.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		lblSize.setBounds(10, 177, 25, 15);
		panel_2.add(lblSize);
		JLabel lblRate = new JLabel("Rate: ");
		lblRate.setForeground(Color.WHITE);
		lblRate.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		lblRate.setBounds(208, 177, 30, 15);
		panel_2.add(lblRate);
		JLabel lblCompany = new JLabel("Company:");
		lblCompany.setForeground(Color.WHITE);
		lblCompany.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		lblCompany.setBounds(10, 40, 51, 45);
		panel_2.add(lblCompany);
		serialno = new JLabel("");
		serialno.setForeground(Color.GREEN);
		serialno.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		serialno.setBounds(103, 10, 214, 45);
		panel_2.add(serialno);
		company = new JLabel("");
		company.setForeground(Color.GREEN);
		company.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		company.setBounds(74, 40, 299, 45);
		panel_2.add(company);
		pname = new JLabel("<HTML>" + "<HTML>");
		pname.setForeground(Color.GREEN);
		pname.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		pname.setBounds(98, 78, 275, 45);
		panel_2.add(pname);
		description = new JLabel("<HTML>" + "<HTML>");
		description.setForeground(Color.GREEN);
		description.setFont(new Font("Bahnschrift", Font.PLAIN, 10));
		description.setBounds(85, 116, 288, 51);
		panel_2.add(description);
		size = new JLabel("");
		size.setForeground(Color.GREEN);
		size.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		size.setBounds(41, 169, 83, 31);
		panel_2.add(size);
		rate = new JLabel("");
		rate.setForeground(Color.GREEN);
		rate.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		rate.setBounds(248, 169, 125, 31);
		panel_2.add(rate);
	}
}