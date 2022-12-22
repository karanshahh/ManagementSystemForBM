import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class MainMenu extends JFrame {
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu();
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
	public MainMenu() {
		super("Beautymanntra || Main Menu");
		setResizable(false);
		setBounds(100, 100, 872, 290);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 126, 868, 173);
		contentPane.add(panel);
		panel.setLayout(null);
		JToggleButton tglbtnReports = new JToggleButton("Reports");
		tglbtnReports.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				Reports r = new Reports();
				r.setVisible(true);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				tglbtnReports.setBackground(Color.GREEN);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				tglbtnReports.setBackground(Color.WHITE);
			}
		});
		tglbtnReports.setForeground(Color.BLACK);
		tglbtnReports.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
		tglbtnReports.setBackground(Color.WHITE);
		tglbtnReports.setBounds(721, 0, 147, 35);
		panel.add(tglbtnReports);
		JToggleButton toggleButton_1 = new JToggleButton("Products");
		toggleButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				toggleButton_1.setBackground(Color.GREEN);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				toggleButton_1.setBackground(Color.WHITE);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				Products p = new Products();
				setVisible(false);
				p.setVisible(true);
			}
		});
		JToggleButton toggleButton_4 = new JToggleButton("Clients");
		toggleButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				toggleButton_4.setBackground(Color.GREEN);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				toggleButton_4.setBackground(Color.WHITE);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				Clients c = new Clients();
				setVisible(false);
				c.setVisible(true);
			}
		});
		toggleButton_4.setForeground(Color.BLACK);
		toggleButton_4.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
		toggleButton_4.setBackground(Color.WHITE);
		toggleButton_4.setBounds(0, 0, 147, 35);
		panel.add(toggleButton_4);
		toggleButton_1.setForeground(Color.BLACK);
		toggleButton_1.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
		toggleButton_1.setBackground(Color.WHITE);
		toggleButton_1.setBounds(145, 0, 147, 35);
		panel.add(toggleButton_1);
		JToggleButton toggleButton_2 = new JToggleButton("Services");
		toggleButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				toggleButton_2.setBackground(Color.GREEN);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				toggleButton_2.setBackground(Color.WHITE);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				Services s = new Services();
				setVisible(false);
				s.setVisible(true);
			}
		});
		toggleButton_2.setForeground(Color.BLACK);
		toggleButton_2.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
		toggleButton_2.setBackground(Color.WHITE);
		toggleButton_2.setBounds(290, 0, 147, 35);
		panel.add(toggleButton_2);
		JToggleButton tglbtnAppointments = new JToggleButton("Invoice");
		tglbtnAppointments.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				tglbtnAppointments.setBackground(Color.GREEN);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				tglbtnAppointments.setBackground(Color.WHITE);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				Invoices i = new Invoices();
				i.setVisible(true);
				dispose();
			}
		});
		tglbtnAppointments.setForeground(Color.BLACK);
		tglbtnAppointments.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
		tglbtnAppointments.setBackground(Color.WHITE);
		tglbtnAppointments.setBounds(435, 0, 147, 35);
		panel.add(tglbtnAppointments);
		JToggleButton toggleButton_5 = new JToggleButton("Branches");
		toggleButton_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Branches b = new Branches();
				setVisible(false);
				b.setVisible(true);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				toggleButton_5.setBackground(Color.GREEN);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				toggleButton_5.setBackground(Color.WHITE);
			}
		});
		toggleButton_5.setForeground(Color.BLACK);
		toggleButton_5.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
		toggleButton_5.setBackground(Color.WHITE);
		toggleButton_5.setBounds(580, 0, 147, 35);
		panel.add(toggleButton_5);
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(240, 255, 255));
		panel_1.setBounds(0, 0, 868, 127);
		contentPane.add(panel_1);
		JLabel label = new JLabel("BEAUTY\r\n");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.CYAN.darker().darker());
		label.setFont(new Font("Segoe UI Symbol", Font.BOLD, 70));
		label.setBounds(0, -11, 868, 66);
		panel_1.add(label);
		JLabel label_1 = new JLabel("MANNTRA\r\n");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.CYAN.darker().darker());
		label_1.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 55));
		label_1.setBounds(0, 40, 868, 60);
		panel_1.add(label_1);
		JLabel label_2 = new JLabel("SALON\r\n");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(Color.CYAN.darker());
		label_2.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 40));
		label_2.setBounds(0, 79, 868, 54);
		panel_1.add(label_2);
		ButtonGroup group = new ButtonGroup();
		group.add(toggleButton_5);
		group.add(tglbtnAppointments);
		group.add(toggleButton_2);
		group.add(toggleButton_1);
		group.add(tglbtnReports);
		JToggleButton toggleButton_3 = new JToggleButton("Branches");
		toggleButton_3.setForeground(Color.BLACK);
		toggleButton_3.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
		toggleButton_3.setBackground(Color.WHITE);
		toggleButton_3.setBounds(0, 0, 147, 35);
		panel.add(toggleButton_3);
		JPanel panel_2 = new RoundedPanel(200, Color.GREEN.darker());
		panel_2.setBackground(Color.DARK_GRAY);
		panel_2.setBounds(10, 45, 88, 79);
		panel.add(panel_2);
		panel_2.setLayout(null);
		JLabel lblNewLabel_1 = new JLabel("MON");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Bahnschrift", Font.BOLD, 30));
		lblNewLabel_1.setBounds(10, 0, 68, 59);
		panel_2.add(lblNewLabel_1);
		JLabel lblNewLabel_2 = new JLabel("10:00 to 20:30");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Bahnschrift", Font.BOLD, 10));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 42, 68, 27);
		panel_2.add(lblNewLabel_2);
		JPanel panel_3 = new RoundedPanel(200, Color.GREEN.darker());
		panel_3.setBackground(Color.DARK_GRAY);
		panel_3.setBounds(132, 45, 88, 79);
		panel.add(panel_3);
		panel_3.setLayout(null);
		JLabel lblTue = new JLabel("TUE");
		lblTue.setForeground(Color.WHITE);
		lblTue.setHorizontalAlignment(SwingConstants.CENTER);
		lblTue.setFont(new Font("Bahnschrift", Font.BOLD, 30));
		lblTue.setBounds(10, 0, 68, 59);
		panel_3.add(lblTue);
		JLabel label_3 = new JLabel("10:00 to 20:30");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Bahnschrift", Font.BOLD, 10));
		label_3.setBounds(10, 42, 68, 27);
		panel_3.add(label_3);
		JPanel panel_4 = new RoundedPanel(200, Color.GREEN.darker());
		panel_4.setBackground(Color.DARK_GRAY);
		panel_4.setBounds(251, 45, 88, 79);
		panel.add(panel_4);
		panel_4.setLayout(null);
		JLabel lblWed = new JLabel("WED");
		lblWed.setForeground(Color.WHITE);
		lblWed.setHorizontalAlignment(SwingConstants.CENTER);
		lblWed.setFont(new Font("Bahnschrift", Font.BOLD, 30));
		lblWed.setBounds(10, 0, 68, 59);
		panel_4.add(lblWed);
		JLabel label_4 = new JLabel("10:00 to 20:30");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Bahnschrift", Font.BOLD, 10));
		label_4.setBounds(10, 42, 68, 27);
		panel_4.add(label_4);
		JPanel panel_5 = new RoundedPanel(200, Color.GREEN.darker());
		panel_5.setBackground(Color.DARK_GRAY);
		panel_5.setBounds(381, 45, 88, 79);
		panel.add(panel_5);
		panel_5.setLayout(null);
		JLabel lblThur = new JLabel("THU");
		lblThur.setForeground(Color.WHITE);
		lblThur.setHorizontalAlignment(SwingConstants.CENTER);
		lblThur.setFont(new Font("Bahnschrift", Font.BOLD, 30));
		lblThur.setBounds(10, 0, 68, 59);
		panel_5.add(lblThur);
		JLabel label_5 = new JLabel("10:00 to 20:30");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Bahnschrift", Font.BOLD, 10));
		label_5.setBounds(10, 42, 68, 27);
		panel_5.add(label_5);
		JPanel panel_6 = new RoundedPanel(200, Color.GREEN.darker());
		panel_6.setBackground(Color.DARK_GRAY);
		panel_6.setBounds(494, 45, 88, 79);
		panel.add(panel_6);
		panel_6.setLayout(null);
		JLabel lblFri = new JLabel("FRI");
		lblFri.setForeground(Color.WHITE);
		lblFri.setHorizontalAlignment(SwingConstants.CENTER);
		lblFri.setFont(new Font("Bahnschrift", Font.BOLD, 30));
		lblFri.setBounds(10, 0, 68, 59);
		panel_6.add(lblFri);
		JLabel label_6 = new JLabel("10:00 to 20:30");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font("Bahnschrift", Font.BOLD, 10));
		label_6.setBounds(10, 42, 68, 27);
		panel_6.add(label_6);
		JPanel panel_7 = new RoundedPanel(200, Color.GREEN.darker());
		panel_7.setBackground(Color.DARK_GRAY);
		panel_7.setBounds(625, 45, 88, 79);
		panel.add(panel_7);
		panel_7.setLayout(null);
		JLabel lblSat = new JLabel("SAT");
		lblSat.setForeground(Color.WHITE);
		lblSat.setHorizontalAlignment(SwingConstants.CENTER);
		lblSat.setFont(new Font("Bahnschrift", Font.BOLD, 30));
		lblSat.setBounds(10, 0, 68, 59);
		panel_7.add(lblSat);
		JLabel label_7 = new JLabel("10:00 to 20:30");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("Bahnschrift", Font.BOLD, 10));
		label_7.setBounds(10, 42, 68, 27);
		panel_7.add(label_7);
		JPanel panel_8 = new RoundedPanel(200, Color.GREEN.darker());
		panel_8.setBackground(Color.DARK_GRAY);
		panel_8.setBounds(753, 45, 88, 79);
		panel.add(panel_8);
		panel_8.setLayout(null);
		JLabel lblSun = new JLabel("SUN");
		lblSun.setForeground(Color.WHITE);
		lblSun.setHorizontalAlignment(SwingConstants.CENTER);
		lblSun.setFont(new Font("Bahnschrift", Font.BOLD, 30));
		lblSun.setBounds(10, 0, 68, 59);
		panel_8.add(lblSun);
		JLabel label_8 = new JLabel("10:00 to 20:30");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setForeground(Color.WHITE);
		label_8.setFont(new Font("Bahnschrift", Font.BOLD, 10));
		label_8.setBounds(10, 42, 68, 27);
		panel_8.add(label_8);
	}
}
