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
public class Branches extends JFrame {
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Branches frame = new Branches();
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
	public Branches() {
		super("Beautymanntra || Branches");
		setResizable(false);
		setBounds(100, 100, 1138, 203);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(240, 255, 255));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(240, 255, 255));
		panel_1.setBounds(0, 0, 1134, 79);
		contentPane.add(panel_1);
		JLabel lblBeautymanntraBranches = new JLabel("Beautymanntra Branches");
		lblBeautymanntraBranches.setHorizontalAlignment(SwingConstants.CENTER);
		lblBeautymanntraBranches.setForeground(new Color(0, 124, 124));
		lblBeautymanntraBranches.setFont(new Font("Bahnschrift", Font.PLAIN, 60));
		lblBeautymanntraBranches.setBounds(0, 0, 1133, 80);
		panel_1.add(lblBeautymanntraBranches);
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 78, 1134, 97);
		contentPane.add(panel);
		panel.setLayout(null);
		JButton btnAddANew = new JButton("Add a new Branch");
		btnAddANew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddBranch a = new AddBranch();
				a.setVisible(true);
			}
		});
		btnAddANew.setForeground(Color.BLACK);
		btnAddANew.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		btnAddANew.setBackground(Color.WHITE);
		btnAddANew.setBounds(10, 10, 211, 35);
		panel.add(btnAddANew);
		JButton btnViewListOf = new JButton("View List of Branches");
		btnViewListOf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DisplayTableBranch d = new DisplayTableBranch();
				d.setVisible(true);
			}
		});
		btnViewListOf.setForeground(Color.BLACK);
		btnViewListOf.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		btnViewListOf.setBackground(Color.WHITE);
		btnViewListOf.setBounds(231, 10, 211, 35);
		panel.add(btnViewListOf);
		JButton button = new JButton("Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MainMenu mm = new MainMenu();
				mm.setVisible(true);
			}
		});
		button.setForeground(Color.BLACK);
		button.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		button.setBackground(Color.WHITE);
		button.setBounds(894, 10, 211, 35);
		panel.add(button);
		JButton btnEditAnExisting = new JButton("Edit an existing Branch");
		btnEditAnExisting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditBranch eb = new EditBranch();
				eb.setVisible(true);
			}
		});
		btnEditAnExisting.setForeground(Color.BLACK);
		btnEditAnExisting.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		btnEditAnExisting.setBackground(Color.WHITE);
		btnEditAnExisting.setBounds(452, 10, 211, 35);
		panel.add(btnEditAnExisting);
		JButton btnDeleteABranch = new JButton("Delete a Branch");
		btnDeleteABranch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteBranch db = new DeleteBranch();
				db.setVisible(true);
			}
		});
		btnDeleteABranch.setForeground(Color.BLACK);
		btnDeleteABranch.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		btnDeleteABranch.setBackground(Color.WHITE);
		btnDeleteABranch.setBounds(673, 10, 211, 35);
		panel.add(btnDeleteABranch);
	}
}