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
public class ViewClientInfo extends JFrame {
	private JPanel contentPane;
	protected JLabel clientLabel, nameLabel, bdayLabel, emailLabel, genderLabel, numberLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewClientInfo frame = new ViewClientInfo();
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
	public ViewClientInfo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 50, 323, 280);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 706, 263);
		contentPane.add(panel);
		panel.setLayout(null);
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(240, 255, 255));
		panel_1.setBounds(0, 0, 692, 36);
		panel.add(panel_1);
		JLabel lblClientInfo = new JLabel("Client Info");
		lblClientInfo.setForeground(new Color(0, 124, 124));
		lblClientInfo.setFont(new Font("Bahnschrift", Font.PLAIN, 24));
		lblClientInfo.setBounds(0, 0, 505, 26);
		panel_1.add(lblClientInfo);
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.DARK_GRAY);
		panel_2.setBounds(0, 31, 692, 218);
		panel.add(panel_2);
		JLabel label_1 = new JLabel("");
		label_1.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		label_1.setBounds(0, 0, 0, 0);
		panel_2.add(label_1);
		JLabel label_2 = new JLabel("Client ID:");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		label_2.setBounds(10, 23, 64, 23);
		panel_2.add(label_2);
		JLabel label_3 = new JLabel("Mobile Number:");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		label_3.setBounds(10, 85, 96, 23);
		panel_2.add(label_3);
		JButton button_2 = new JButton("Back");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_2.setForeground(Color.BLACK);
		button_2.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		button_2.setBackground(Color.WHITE);
		button_2.setBounds(109, 181, 167, 23);
		panel_2.add(button_2);
		JLabel label_5 = new JLabel("Email:");
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		label_5.setBounds(10, 116, 44, 23);
		panel_2.add(label_5);
		JLabel label_6 = new JLabel("Gender:");
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		label_6.setBounds(10, 147, 44, 23);
		panel_2.add(label_6);
		JLabel label_7 = new JLabel("Birthdate:");
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		label_7.setBounds(111, 147, 64, 24);
		panel_2.add(label_7);
		JLabel lblName = new JLabel("Name:");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		lblName.setBounds(10, 54, 49, 23);
		panel_2.add(lblName);
		clientLabel = new JLabel("");
		clientLabel.setForeground(Color.GREEN);
		clientLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		clientLabel.setBounds(62, 23, 214, 23);
		panel_2.add(clientLabel);
		nameLabel = new JLabel("");
		nameLabel.setForeground(Color.GREEN);
		nameLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		nameLabel.setBounds(52, 54, 224, 23);
		panel_2.add(nameLabel);
		numberLabel = new JLabel("");
		numberLabel.setForeground(Color.GREEN);
		numberLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		numberLabel.setBounds(100, 85, 177, 23);
		panel_2.add(numberLabel);
		emailLabel = new JLabel("");
		emailLabel.setForeground(Color.GREEN);
		emailLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		emailLabel.setBounds(52, 116, 231, 23);
		panel_2.add(emailLabel);
		genderLabel = new JLabel("");
		genderLabel.setForeground(Color.GREEN);
		genderLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		genderLabel.setBounds(52, 147, 59, 23);
		panel_2.add(genderLabel);
		bdayLabel = new JLabel("");
		bdayLabel.setForeground(Color.GREEN);
		bdayLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		bdayLabel.setBounds(166, 147, 110, 23);
		panel_2.add(bdayLabel);
	}
}
