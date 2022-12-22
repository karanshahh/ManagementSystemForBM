import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class Services extends JFrame {
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Services frame = new Services();
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
	public Services() {
		setResizable(false);
		setBounds(100, 100, 991, 181);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(240, 255, 255));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(new Color(240, 255, 255));
		panel.setBounds(0, 0, 1315, 507);
		contentPane.add(panel);
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel_1.setBackground(new Color(240, 255, 255));
		panel_1.setBounds(0, 10, 1314, 507);
		panel.add(panel_1);
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(240, 255, 255));
		panel_2.setBounds(0, -14, 1313, 85);
		panel_1.add(panel_2);
		JLabel lblServices = new JLabel("Services");
		lblServices.setBounds(0, 0, 984, 80);
		panel_2.add(lblServices);
		lblServices.setHorizontalAlignment(SwingConstants.CENTER);
		lblServices.setForeground(new Color(0, 124, 124));
		lblServices.setFont(new Font("Bahnschrift", Font.PLAIN, 60));
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(Color.DARK_GRAY);
		panel_3.setBounds(0, 69, 1313, 428);
		panel_1.add(panel_3);
		JButton btnAddANew = new JButton("Add a new Service");
		btnAddANew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddService a = new AddService();
				a.setVisible(true);
			}
		});
		btnAddANew.setForeground(Color.BLACK);
		btnAddANew.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		btnAddANew.setBackground(Color.WHITE);
		btnAddANew.setBounds(10, 10, 191, 35);
		panel_3.add(btnAddANew);
		JButton btnViewAvailableServices = new JButton("View available Services");
		btnViewAvailableServices.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DisplayTableService dt = new DisplayTableService();
				dt.setVisible(true);
			}
		});
		btnViewAvailableServices.setForeground(Color.BLACK);
		btnViewAvailableServices.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		btnViewAvailableServices.setBackground(Color.WHITE);
		btnViewAvailableServices.setBounds(211, 10, 211, 35);
		panel_3.add(btnViewAvailableServices);
		JButton button_2 = new JButton("Back");
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				MainMenu mm = new MainMenu();
				mm.setVisible(true);
			}
		});
		button_2.setForeground(Color.BLACK);
		button_2.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		button_2.setBackground(Color.WHITE);
		button_2.setBounds(881, 10, 87, 35);
		panel_3.add(button_2);
		JButton btnEditPriceOf = new JButton("Edit an Existing Service");
		btnEditPriceOf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditService es = new EditService();
				es.setVisible(true);
			}
		});
		btnEditPriceOf.setForeground(Color.BLACK);
		btnEditPriceOf.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		btnEditPriceOf.setBackground(Color.WHITE);
		btnEditPriceOf.setBounds(432, 10, 264, 35);
		panel_3.add(btnEditPriceOf);
		JButton btnRemoveAService = new JButton("Remove a Service");
		btnRemoveAService.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteService ds = new DeleteService();
				ds.setVisible(true);
			}
		});
		btnRemoveAService.setForeground(Color.BLACK);
		btnRemoveAService.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		btnRemoveAService.setBackground(Color.WHITE);
		btnRemoveAService.setBounds(706, 10, 165, 35);
		panel_3.add(btnRemoveAService);
	}
}