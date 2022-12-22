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
public class Invoices extends JFrame {
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Invoices frame = new Invoices();
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
	public Invoices() {
		setBounds(100, 100, 504, 181);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(new Color(240, 255, 255));
		panel.setBounds(0, 0, 977, 144);
		contentPane.add(panel);
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel_1.setBackground(new Color(240, 255, 255));
		panel_1.setBounds(0, 10, 491, 134);
		panel.add(panel_1);
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(240, 255, 255));
		panel_2.setBounds(0, -14, 490, 85);
		panel_1.add(panel_2);
		JLabel lblInvoice = new JLabel("Invoice");
		lblInvoice.setHorizontalAlignment(SwingConstants.CENTER);
		lblInvoice.setForeground(new Color(0, 124, 124));
		lblInvoice.setFont(new Font("Bahnschrift", Font.PLAIN, 60));
		lblInvoice.setBounds(0, 0, 489, 80);
		panel_2.add(lblInvoice);
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(Color.DARK_GRAY);
		panel_3.setBounds(0, 69, 490, 68);
		panel_1.add(panel_3);
		JButton btnPrepareAnInvoice = new JButton("Prepare an Invoice");
		btnPrepareAnInvoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrepareInvoice pi = new PrepareInvoice();
				pi.setVisible(true);
				dispose();
			}
		});
		btnPrepareAnInvoice.setForeground(Color.BLACK);
		btnPrepareAnInvoice.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		btnPrepareAnInvoice.setBackground(Color.WHITE);
		btnPrepareAnInvoice.setBounds(10, 10, 191, 35);
		panel_3.add(btnPrepareAnInvoice);
		JButton btnViewInvoices = new JButton("View Invoices");
		btnViewInvoices.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DisplayTableInvoice d = new DisplayTableInvoice();
				d.setVisible(true);
				dispose();
			}
		});
		btnViewInvoices.setForeground(Color.BLACK);
		btnViewInvoices.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		btnViewInvoices.setBackground(Color.WHITE);
		btnViewInvoices.setBounds(211, 10, 158, 35);
		panel_3.add(btnViewInvoices);
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
		button_2.setBounds(384, 10, 97, 35);
		panel_3.add(button_2);
	}
}