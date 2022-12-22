import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Reports extends JFrame {
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reports frame = new Reports();
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
	public Reports() {
		setBounds(100, 100, 412, 181);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(240, 255, 255));
		panel.setBounds(0, 0, 482, 76);
		contentPane.add(panel);
		JLabel lblReports = new JLabel("Generate Report");
		lblReports.setHorizontalAlignment(SwingConstants.CENTER);
		lblReports.setForeground(new Color(0, 124, 124));
		lblReports.setFont(new Font("Bahnschrift", Font.PLAIN, 48));
		lblReports.setBounds(0, 0, 383, 66);
		panel.add(lblReports);
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(0, 76, 482, 68);
		contentPane.add(panel_1);
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
		button_2.setBounds(283, 10, 97, 35);
		panel_1.add(button_2);
		JButton btnProductInDemand = new JButton("Generate report");
		btnProductInDemand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login gn = new Login();
				gn.setVisible(true);
				dispose();
			}
		});
		btnProductInDemand.setForeground(Color.BLACK);
		btnProductInDemand.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		btnProductInDemand.setBackground(Color.WHITE);
		btnProductInDemand.setBounds(10, 10, 226, 35);
		panel_1.add(btnProductInDemand);
	}
}
