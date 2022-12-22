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
public class Clients extends JFrame {
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Clients frame = new Clients();
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
	public Clients() {
		super("Beautymanntra || Clients");
		setResizable(false);
		setBounds(100, 100, 903, 203);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(240, 255, 255));
		panel.setBounds(0, 0, 1134, 79);
		contentPane.add(panel);
		JLabel lblClients = new JLabel("Clients");
		lblClients.setHorizontalAlignment(SwingConstants.CENTER);
		lblClients.setForeground(new Color(0, 124, 124));
		lblClients.setFont(new Font("Bahnschrift", Font.PLAIN, 60));
		lblClients.setBounds(0, 0, 900, 80);
		panel.add(lblClients);
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(0, 78, 1134, 97);
		contentPane.add(panel_1);
		JButton btnAddANew = new JButton("Add a new Client");
		btnAddANew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddClient ab = new AddClient();
				ab.setVisible(true);
			}
		});
		btnAddANew.setForeground(Color.BLACK);
		btnAddANew.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		btnAddANew.setBackground(Color.WHITE);
		btnAddANew.setBounds(10, 10, 211, 35);
		panel_1.add(btnAddANew);
		JButton btnViewListOf = new JButton("View List of Clients");
		btnViewListOf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DisplayTableClient d = new DisplayTableClient();
				d.setVisible(true);
			}
		});
		btnViewListOf.setForeground(Color.BLACK);
		btnViewListOf.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		btnViewListOf.setBackground(Color.WHITE);
		btnViewListOf.setBounds(231, 10, 211, 35);
		panel_1.add(btnViewListOf);
		JButton button_2 = new JButton("Back");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenu mm = new MainMenu();
				mm.setVisible(true);
				dispose();
			}
		});
		button_2.setForeground(Color.BLACK);
		button_2.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		button_2.setBackground(Color.WHITE);
		button_2.setBounds(673, 10, 211, 35);
		panel_1.add(button_2);
		JButton btnEditAnExisting = new JButton("Edit an existing Client");
		btnEditAnExisting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditClient e1 = new EditClient();
				e1.setVisible(true);
			}
		});
		btnEditAnExisting.setForeground(Color.BLACK);
		btnEditAnExisting.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		btnEditAnExisting.setBackground(Color.WHITE);
		btnEditAnExisting.setBounds(452, 10, 211, 35);
		panel_1.add(btnEditAnExisting);
	}
}
