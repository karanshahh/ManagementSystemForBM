import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Login extends JFrame {
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	String user, pass;
	String info[][] = { { "owner", "ownerpassword" }, { "manager", "managerpassword" } };

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 401, 192);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 387, 43);
		panel.setBackground(new Color(240, 255, 255));
		contentPane.add(panel);
		panel.setLayout(null);
		JLabel lblLogin = new JLabel("Login Page");
		lblLogin.setFont(new Font("Bahnschrift", Font.PLAIN, 30));
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setBounds(0, 0, 387, 43);
		panel.add(lblLogin);
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(0, 42, 387, 115);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setBounds(10, 10, 85, 25);
		panel_1.add(lblUsername);
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		lblPassword.setBounds(10, 46, 85, 25);
		panel_1.add(lblPassword);
		textField = new JTextField();
		textField.setBounds(105, 12, 272, 25);
		panel_1.add(textField);
		textField.setColumns(10);
		passwordField = new JPasswordField();
		passwordField.setBounds(105, 48, 272, 25);
		panel_1.add(passwordField);
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				user = textField.getText();
				pass = passwordField.getText();
				for (int i = 0; i < 2; i++) {
					if (user.equals(info[i][0]) && pass.equals(info[i][1])) {
						if (info[i][0] == "owner") {
							dispose();
							GenRep mm = new GenRep();
							mm.setVisible(true);
						} else if (info[i][0] == "manager") {
							JOptionPane.showMessageDialog(null, "Reports can't be accessed by managers");
							textField.setText("");
							passwordField.setText("");
						}
					} else {
						JOptionPane.showMessageDialog(null, "Invalid username or password!");
					}
				}
			}
		});
		btnLogin.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		btnLogin.setBounds(144, 83, 138, 21);
		panel_1.add(btnLogin);
	}
}
