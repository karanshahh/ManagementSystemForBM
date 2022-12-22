import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import java.awt.Window;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.toedter.calendar.JDateChooser;
import net.proteanit.sql.DbUtils;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.JToggleButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;

@SuppressWarnings("serial")
public class GenRep extends JFrame {
	private JPanel contentPane;
	private JTable table;
	private JTable table_6;
	java.sql.Date date1, date2;
	JButton btnGenerateAPdf;
	String sum;
	int tot = 0;
	String impQuery, impQuery1, query, query1, query2, query11;
	Connection con;
	int val1, val2;
	PreparedStatement pst, pstDate, pst1, pst2;
	Date lastVisit;
	ResultSet rs, rsDate, rs1, rs2;
	int g;
	String path1, path;
	JFileChooser j;
	java.util.Date myDateObj;
	SimpleDateFormat formatter;
	java.sql.Date formattedDate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GenRep frame = new GenRep();
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
	public GenRep() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 635, 454);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 621, 425);
		panel.setBackground(Color.CYAN.darker().darker().darker());
		contentPane.add(panel);
		panel.setLayout(null);
		ButtonGroup bg = new ButtonGroup();
		ButtonGroup bg1 = new ButtonGroup();
		JLabel lblGenerateReports = new JLabel("GENERATE REPORT");
		lblGenerateReports.setFont(new Font("Bahnschrift", Font.PLAIN, 36));
		lblGenerateReports.setForeground(Color.WHITE);
		lblGenerateReports.setHorizontalAlignment(SwingConstants.CENTER);
		lblGenerateReports.setBounds(0, 0, 601, 66);
		panel.add(lblGenerateReports);
		JLabel lblNumberOfClients = new JLabel("Number of clients:");
		lblNumberOfClients.setForeground(Color.WHITE);
		lblNumberOfClients.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		lblNumberOfClients.setBounds(10, 103, 394, 19);
		panel.add(lblNumberOfClients);
		JLabel noOfClients = new JLabel("");
		noOfClients.setForeground(Color.GREEN);
		noOfClients.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		noOfClients.setBounds(414, 103, 101, 19);
		panel.add(noOfClients);
		JLabel lblAmountOfSales = new JLabel("Amount of sales:");
		lblAmountOfSales.setHorizontalAlignment(SwingConstants.LEFT);
		lblAmountOfSales.setForeground(Color.WHITE);
		lblAmountOfSales.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		lblAmountOfSales.setBounds(10, 132, 144, 19);
		panel.add(lblAmountOfSales);
		JLabel sales = new JLabel("");
		sales.setForeground(Color.GREEN);
		sales.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		sales.setBounds(163, 132, 186, 19);
		panel.add(sales);
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(96, 74, 172, 19);
		panel.add(dateChooser);
		JLabel lblFrom = new JLabel("From");
		lblFrom.setForeground(Color.WHITE);
		lblFrom.setFont(new Font("Bahnschrift", Font.PLAIN, 22));
		lblFrom.setBounds(32, 76, 54, 19);
		panel.add(lblFrom);
		JLabel lblTo = new JLabel("To");
		lblTo.setForeground(Color.WHITE);
		lblTo.setFont(new Font("Bahnschrift", Font.PLAIN, 22));
		lblTo.setBounds(278, 74, 29, 19);
		panel.add(lblTo);
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(308, 74, 172, 19);
		panel.add(dateChooser_1);
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 216, 296, 165);
		panel.add(scrollPane_1);
		table = new JTable();
		table.setAutoCreateRowSorter(true);
		scrollPane_1.setViewportView(table);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(317, 216, 296, 165);
		panel.add(scrollPane);
		table_6 = new JTable();
		table_6.setAutoCreateRowSorter(true);
		scrollPane.setViewportView(table_6);
		JButton btnGenerate = new JButton("Generate");
		btnGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					btnGenerateAPdf.setVisible(true);
					date1 = new java.sql.Date(dateChooser.getDate().getTime());
					date2 = new java.sql.Date(dateChooser_1.getDate().getTime());
					try {
						impQuery = "select `Product Name`, count(productID) AS `Products Bought` from invoiceproductlist where Date between '"
								+ date1 + "' and '" + date2 + "' GROUP BY productID ORDER BY `Products Bought` DESC";
						con = DriverManager.getConnection("jdbc:mysql://localhost:3306/csiatables", "root",
								"mySQLpassword");
						pst = con.prepareStatement(impQuery);
						rs = pst.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Error");
					}
					try {
						impQuery1 = "select `Service Name`, count(serviceID) AS `Services Taken` from invoiceservicelist where Date between '"
								+ date1 + "' and '" + date2 + "' GROUP BY serviceID order by `Services Taken` DESC";
						con = DriverManager.getConnection("jdbc:mysql://localhost:3306/csiatables", "root",
								"mySQLpassword");
						pst = con.prepareStatement(impQuery1);
						rs = pst.executeQuery();
						table_6.setModel(DbUtils.resultSetToTableModel(rs));
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Error");
					}
					query = "select sum(Expense) from invoicelist where Date between '" + date1 + "' and '" + date2
							+ "'";
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/csiatables", "root",
							"mySQLpassword");
					pst = con.prepareStatement(query);
					rs = pst.executeQuery();
					lblNumberOfClients.setText("Number of clients since " + dateChooser.getDate() + ":");
					val1 = 0;
					val2 = 0;
					query1 = "select SerialNo from invoicelist where Date = '" + date1 + "'";
					query2 = "select SerialNo from invoicelist where Date = '" + date2 + "'";
					query11 = "select Date from invoicelist";
					pstDate = con.prepareStatement(query11);
					rsDate = pstDate.executeQuery();
					lastVisit = null;
					while (rsDate.next()) {
						lastVisit = rsDate.getDate("Date");
					}
					if (date2.compareTo(lastVisit) < 0 || date2.compareTo(lastVisit) == 0
							|| date2.compareTo(lastVisit) > 0) {
						pst1 = con.prepareStatement(query1);
						rs1 = pst1.executeQuery();
						pst2 = con.prepareStatement(query2);
						rs2 = pst2.executeQuery();
						while (rs1.next()) {
							val1 = rs1.getInt("SerialNo");
						}
						while (rs2.next()) {
							val2 = rs2.getInt("SerialNo");
						}
						if (val1 > val2) {
							tot = val1 - val2 + 1;
						} else if (val2 > val1) {
							tot = val2 - val1 + 1;
						}
						noOfClients.setText(String.valueOf(tot));
						rs.next();
						sum = rs.getString(1);
						sales.setText(sum);
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Error");
				}
			}
		});
		btnGenerate.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		btnGenerate.setBounds(490, 74, 98, 19);
		panel.add(btnGenerate);
		btnGenerateAPdf = new JButton("Generate a PDF Report");
		btnGenerateAPdf.setVisible(false);
		btnGenerateAPdf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				path1 = "";
				j = new JFileChooser();
				j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				g = j.showSaveDialog(null);
				if (g == JFileChooser.APPROVE_OPTION) {
					path1 = j.getSelectedFile().toString();
				}
				int time = (int) (System.currentTimeMillis() / 1000);
				path1 = path1.replace("\\", "\\\\");
				path = path1 + "\\\\BM Report - " + time + ".pdf";
				myDateObj = new java.util.Date();
				formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
				formattedDate = new java.sql.Date(myDateObj.getTime());
				Document doc = new Document();
				date1 = new java.sql.Date(dateChooser.getDate().getTime());
				date2 = new java.sql.Date(dateChooser_1.getDate().getTime());
				try {
					String FONT1 = "resources/fonts/PlayfairDisplayRegular.ttf";
					com.itextpdf.text.Font f3 = FontFactory.getFont(FONT1, BaseFont.IDENTITY_H, BaseFont.EMBEDDED, 18);
					PdfWriter.getInstance(doc, new FileOutputStream(path));
					doc.open();
					Paragraph para = new Paragraph("BEAUTYMANNTRA INTERVAL REPORT", FontFactory.getFont(
							FontFactory.HELVETICA_BOLD, 24, Font.BOLD, BaseColor.CYAN.darker().darker().darker()));
					para.setAlignment(Element.ALIGN_CENTER);
					Paragraph para1 = new Paragraph("----------------------------------------------------------"
							+ "------------------------------------------------------------------------");
					Paragraph para2 = new Paragraph("Report Generated on: " + formatter.format(myDateObj),
							FontFactory.getFont(FontFactory.HELVETICA, 12, Font.PLAIN, BaseColor.DARK_GRAY));
					para2.setAlignment(Element.ALIGN_RIGHT);
					Paragraph paraSpace = new Paragraph("");
					Paragraph space = new Paragraph("----------------------------------------------------------"
							+ "------------------------------------------------------------------------");
					Paragraph para3 = new Paragraph(
							"Most to Least Demanded Products between " + date1 + " and " + date2,
							FontFactory.getFont(FontFactory.HELVETICA, 15, Font.PLAIN, BaseColor.BLACK));
					para3.setAlignment(Element.ALIGN_CENTER);
					doc.add(para);
					doc.add(paraSpace);
					doc.add(space);
					doc.add(paraSpace);
					doc.add(para1);
					doc.add(paraSpace);
					doc.add(para2);
					doc.add(paraSpace);
					doc.add(space);
					doc.add(paraSpace);
					doc.add(para3);
					PdfPTable table1 = new PdfPTable(3);
					table1.setWidthPercentage(105);
					table1.setSpacingBefore(11f);
					table1.setSpacingAfter(11f);
					float[] colWidth = { 2f, 2f, 2f };
					table1.setWidths(colWidth);
					PdfPCell c1 = new PdfPCell(new Phrase("Serial No"));
					table1.addCell(c1);
					PdfPCell c2 = new PdfPCell(new Phrase("Product Name"));
					table1.addCell(c2);
					PdfPCell c3 = new PdfPCell(new Phrase("Number of Products Bought"));
					table1.addCell(c3);
					for (int i = 0; i < table.getRowCount(); i++) {
						String serialNo = String.valueOf(i + 1);
						String prodName = table.getValueAt(i, 0).toString();
						String prodBought = table.getValueAt(i, 1).toString();
						table1.addCell(serialNo);
						table1.addCell(prodName);
						table1.addCell(prodBought);
					}
					doc.add(table1);
					doc.add(space);
					Paragraph paraServ = new Paragraph(
							"Most to Least Demanded Services between " + date1 + " and " + date2,
							FontFactory.getFont(FontFactory.HELVETICA, 15, Font.PLAIN, BaseColor.BLACK));
					para3.setAlignment(Element.ALIGN_CENTER);
					doc.add(paraServ);
					PdfPTable table2 = new PdfPTable(3);
					table2.setWidthPercentage(105);
					table2.setSpacingBefore(11f);
					table2.setSpacingAfter(11f);
					table2.setWidths(colWidth);
					PdfPCell c11 = new PdfPCell(new Phrase("Serial No"));
					table2.addCell(c11);
					PdfPCell c22 = new PdfPCell(new Phrase("Service Name"));
					table2.addCell(c22);
					PdfPCell c33 = new PdfPCell(new Phrase("Frequency of Services taken"));
					table2.addCell(c33);
					for (int i = 0; i < table_6.getRowCount(); i++) {
						String serialNo = String.valueOf(i + 1);
						String servName = table_6.getValueAt(i, 0).toString();
						String servBought = table_6.getValueAt(i, 1).toString();
						table2.addCell(serialNo);
						table2.addCell(servName);
						table2.addCell(servBought);
					}
					doc.add(table2);
					doc.add(space);
					Paragraph amountOfClients = new Paragraph(
							"Amount of Sales between " + date1 + " and " + date2 + " = " + sum,
							FontFactory.getFont(FontFactory.HELVETICA, 15, Font.PLAIN, BaseColor.BLACK));
					amountOfClients.setAlignment(Element.ALIGN_CENTER);
					doc.add(amountOfClients);
					doc.add(space);
					Paragraph amountOfSales = new Paragraph(
							"Number of Clients between " + date1 + " and " + date2 + " = " + tot,
							FontFactory.getFont(FontFactory.HELVETICA, 15, Font.PLAIN, BaseColor.BLACK));
					amountOfSales.setAlignment(Element.ALIGN_CENTER);
					doc.add(amountOfSales);
					doc.add(space);
					Paragraph para5 = new Paragraph("Thank you for using the program!");
					para5.setAlignment(Element.ALIGN_CENTER);
					doc.add(para5);
					doc.add(space);
					doc.close();
				} catch (Exception e1) {
				}
			}
		});
		btnGenerateAPdf.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		btnGenerateAPdf.setBounds(118, 391, 189, 19);
		panel.add(btnGenerateAPdf);
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Reports rp = new Reports();
				rp.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		btnBack.setBounds(10, 391, 98, 19);
		panel.add(btnBack);
		JLabel lblProductsAndServices = new JLabel("Products and Services in most demand");
		lblProductsAndServices.setHorizontalAlignment(SwingConstants.CENTER);
		lblProductsAndServices.setForeground(Color.WHITE);
		lblProductsAndServices.setFont(new Font("Bahnschrift", Font.PLAIN, 24));
		lblProductsAndServices.setBounds(0, 171, 621, 35);
		panel.add(lblProductsAndServices);
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(0, 161, 621, 10);
		panel.add(panel_1);
	}
}
