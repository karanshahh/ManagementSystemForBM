import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class Products extends JFrame {
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Products frame = new Products();
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
	public Products() {
		setResizable(false);
		setBounds(100, 100, 940, 173);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(240, 255, 255));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(240, 255, 255));
		panel.setBounds(0, 0, 1228, 79);
		contentPane.add(panel);
		JLabel lblBeautymanntraProducts = new JLabel("Beautymanntra Products");
		lblBeautymanntraProducts.setHorizontalAlignment(SwingConstants.CENTER);
		lblBeautymanntraProducts.setForeground(new Color(0, 124, 124));
		lblBeautymanntraProducts.setFont(new Font("Bahnschrift", Font.PLAIN, 60));
		lblBeautymanntraProducts.setBounds(0, 0, 937, 80);
		panel.add(lblBeautymanntraProducts);
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(0, 78, 936, 67);
		contentPane.add(panel_1);
		JButton btnAddANew = new JButton("Add a new Product");
		btnAddANew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddProduct a = new AddProduct();
				a.setVisible(true);
			}
		});
		btnAddANew.setForeground(Color.BLACK);
		btnAddANew.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		btnAddANew.setBackground(Color.WHITE);
		btnAddANew.setBounds(10, 10, 164, 35);
		panel_1.add(btnAddANew);
		JButton btnViewListOf = new JButton("View List of avalaible Products");
		btnViewListOf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DisplayTableProduct p = new DisplayTableProduct();
				p.setVisible(true);
			}
		});
		btnViewListOf.setForeground(Color.BLACK);
		btnViewListOf.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		btnViewListOf.setBackground(Color.WHITE);
		btnViewListOf.setBounds(184, 10, 240, 35);
		panel_1.add(btnViewListOf);
		JButton btnEditAnExisting = new JButton("Edit an existing Product");
		btnEditAnExisting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditProduct ep = new EditProduct();
				ep.setVisible(true);
			}
		});
		btnEditAnExisting.setForeground(Color.BLACK);
		btnEditAnExisting.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		btnEditAnExisting.setBackground(Color.WHITE);
		btnEditAnExisting.setBounds(434, 10, 197, 35);
		panel_1.add(btnEditAnExisting);
		JButton btnDeleteACompany = new JButton("Delete a Product");
		btnDeleteACompany.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteProduct dp = new DeleteProduct();
				dp.setVisible(true);
			}
		});
		btnDeleteACompany.setForeground(Color.BLACK);
		btnDeleteACompany.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		btnDeleteACompany.setBackground(Color.WHITE);
		btnDeleteACompany.setBounds(641, 10, 167, 35);
		panel_1.add(btnDeleteACompany);
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenu mm = new MainMenu();
				mm.setVisible(true);
				dispose();
			}
		});
		btnBack.setForeground(Color.BLACK);
		btnBack.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		btnBack.setBackground(Color.WHITE);
		btnBack.setBounds(818, 10, 92, 35);
		panel_1.add(btnBack);
	}
}
