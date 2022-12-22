import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
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
import javax.swing.JRadioButton;

@SuppressWarnings("serial")
public class PrepareInvoice extends JFrame {
	private JPanel contentPane;
	private JTextField clientNumber;
	JLabel cname, cnumber;
	private JTable table;
	@SuppressWarnings("rawtypes")
	JComboBox serviceComboBox, prodComboBox, comboBox_2;
	int selectedRowIndex;
	JButton prodButton, servButton;
	String path1;
	JFileChooser j;
	ArrayList<RowDataService> servlist;
	ArrayList<RowDataProduct> prodlist;
	JLabel lblTotalAmount;
	JButton btnDeleteRow, btnNewButton_1;
	String query, query1, i, ii;
	Connection con, con1, con11;
	ResultSet rs, rs1, prodrs, servrs;
	PreparedStatement pst, pst1;
	int noOfProds = 0, noOfServs = 0, time, g;
	String path;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrepareInvoice frame = new PrepareInvoice();
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
	public void setComboButtonEditable(boolean n) {
		serviceComboBox.setEnabled(n);
		prodComboBox.setEnabled(n);
		prodButton.setEnabled(n);
		servButton.setEnabled(n);
		comboBox_2.setEnabled(n);
		btnNewButton_1.setEnabled(n);
	}

	@SuppressWarnings({ "serial", "unchecked", "rawtypes" })
	public PrepareInvoice() {
		setResizable(false);
		setBounds(100, 100, 1018, 548);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN.darker().darker().darker());
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblPrepareAnInvoice = new JLabel("Prepare an Invoice");
		lblPrepareAnInvoice.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrepareAnInvoice.setForeground(Color.WHITE);
		lblPrepareAnInvoice.setFont(new Font("Bahnschrift", Font.PLAIN, 26));
		lblPrepareAnInvoice.setBounds(0, 0, 1004, 30);
		contentPane.add(lblPrepareAnInvoice);
		JLabel lblServiceTaken = new JLabel("Service Taken:");
		lblServiceTaken.setHorizontalAlignment(SwingConstants.RIGHT);
		lblServiceTaken.setForeground(Color.WHITE);
		lblServiceTaken.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblServiceTaken.setBounds(10, 136, 103, 21);
		contentPane.add(lblServiceTaken);
		serviceComboBox = new JComboBox();
		serviceComboBox.setBackground(Color.WHITE);
		serviceComboBox.setFont(new Font("Arial", Font.PLAIN, 12));
		serviceComboBox.addItem("Select a service");
		try {
			query = "SELECT Subcategory, SerialNo FROM servicelist";
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/csiatables", "root", "mySQLpassword");
			pst = con.prepareStatement(query);
			rs = pst.executeQuery();
			while (rs.next()) {
				serviceComboBox.addItem(rs.getString("Subcategory"));
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		serviceComboBox.setBounds(123, 138, 255, 21);
		contentPane.add(serviceComboBox);
		JLabel lblProductBought = new JLabel("Product bought:");
		lblProductBought.setHorizontalAlignment(SwingConstants.RIGHT);
		lblProductBought.setForeground(Color.WHITE);
		lblProductBought.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblProductBought.setBounds(10, 105, 103, 21);
		contentPane.add(lblProductBought);
		prodComboBox = new JComboBox();
		prodComboBox.setBackground(Color.WHITE);
		prodComboBox.setFont(new Font("Arial", Font.PLAIN, 12));
		prodComboBox.addItem("Select a Product");
		try {
			query = "SELECT Company, ProductName FROM productlist";
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/csiatables", "root", "mySQLpassword");
			pst = con.prepareStatement(query);
			rs = pst.executeQuery();
			while (rs.next()) {
				prodComboBox.addItem(rs.getString("ProductName"));
			}
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, e1);
		}
		prodComboBox.setBounds(123, 107, 255, 21);
		contentPane.add(prodComboBox);
		JLabel lblClientId = new JLabel("Client Mobile:");
		lblClientId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblClientId.setForeground(Color.WHITE);
		lblClientId.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblClientId.setBounds(10, 72, 103, 21);
		contentPane.add(lblClientId);
		clientNumber = new JTextField();
		clientNumber.setBounds(123, 74, 255, 21);
		contentPane.add(clientNumber);
		clientNumber.setColumns(10);
		JButton clientButton = new JButton("+");
		clientButton.setBackground(Color.WHITE);
		clientButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (clientNumber.getText().isEmpty() == false) {
					query1 = "SELECT Name, ClientID FROM csiatables.clientlist WHERE MobileNumber=?";
					try {
						con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/csiatables", "root",
								"mySQLpassword");
						pst1 = con1.prepareStatement(query1);
						pst1.setString(1, clientNumber.getText());
						rs1 = pst1.executeQuery();
						if (rs1.next()) {
							cname.setText(rs1.getString("Name"));
							cnumber.setText(rs1.getString("ClientID"));
							clientNumber.setEditable(false);
							setComboButtonEditable(true);
						} else {
							JOptionPane.showMessageDialog(null,
									"No client registered with that phone number! Add Client");
							AddClient client = new AddClient();
							client.setVisible(true);
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, "Enter Client Phone number");
				}
			}
		});
		clientButton.setMargin(new Insets(0, 0, 0, 0));
		clientButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		clientButton.setBounds(388, 74, 21, 21);
		contentPane.add(clientButton);
		JLabel lblClientName = new JLabel("Client Name:");
		lblClientName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblClientName.setForeground(Color.WHITE);
		lblClientName.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblClientName.setBounds(713, 105, 101, 21);
		contentPane.add(lblClientName);
		prodButton = new JButton("+");
		prodButton.setBackground(Color.WHITE);
		prodButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ii = prodComboBox.getSelectedItem().toString();
				if (ii != "Select a Product") {
					noOfProds++;
					con11 = null;
					try {
						prodlist = new ArrayList<RowDataProduct>();
						con11 = DriverManager.getConnection("jdbc:mysql://localhost:3306/csiatables", "root",
								"mySQLpassword");
						query1 = "select Company, ProductName, Size, Rate from productlist where ProductName = '" + ii
								+ "'";
						pst = con11.prepareStatement(query1);
						prodrs = pst.executeQuery();
						if (prodrs.next()) {
							int qty = Integer.parseInt(comboBox_2.getSelectedItem().toString());
							RowDataProduct product = new RowDataProduct("Product", ii, qty, prodrs.getDouble("Rate"),
									prodrs.getDouble("Rate") * qty);
							prodlist.add(product);
							addProductRowToTable(prodlist);
							getTotalAmount();
							updateLabel();
						}
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, e2);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Select products bought by customer");
				}
			}
		});
		prodButton.setMargin(new Insets(0, 0, 0, 0));
		prodButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		prodButton.setBounds(475, 107, 21, 21);
		contentPane.add(prodButton);
		servButton = new JButton("+");
		servButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				i = serviceComboBox.getSelectedItem().toString();
				if (i != "Select a service") {
					noOfServs++;
					con1 = null;
					try {
						servlist = new ArrayList<RowDataService>();
						con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/csiatables", "root",
								"mySQLpassword");
						query1 = "select Category, Rate from servicelist where Subcategory = '" + i + "'";
						pst = con1.prepareStatement(query1);
						servrs = pst.executeQuery();
						if (servrs.next()) {
							RowDataService service = new RowDataService("Service", i, 1, servrs.getDouble("Rate"),
									servrs.getDouble("Rate"));
							servlist.add(service);
							addServiceRowToTable(servlist);
							getTotalAmount();
							updateLabel();
						}
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, e2);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Select services");
				}
			}
		});
		servButton.setBackground(Color.WHITE);
		servButton.setMargin(new Insets(0, 0, 0, 0));
		servButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		servButton.setBounds(388, 138, 21, 21);
		contentPane.add(servButton);
		comboBox_2 = new JComboBox();
		for (int j = 1; j < 100; j++) {
			comboBox_2.addItem(j);
		}
		comboBox_2.setFont(new Font("Arial", Font.PLAIN, 12));
		comboBox_2.setBackground(Color.WHITE);
		comboBox_2.setBounds(431, 107, 34, 21);
		contentPane.add(comboBox_2);
		Date myDateObj = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		java.sql.Date formattedDate = new java.sql.Date(myDateObj.getTime());
		JLabel lblDate = new JLabel("Invoice Date: " + formatter.format(myDateObj));
		lblDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDate.setForeground(Color.WHITE);
		lblDate.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblDate.setBounds(733, 40, 248, 21);
		contentPane.add(lblDate);
		cname = new JLabel("");
		cname.setHorizontalAlignment(SwingConstants.LEFT);
		cname.setForeground(Color.WHITE);
		cname.setFont(new Font("Bahnschrift", Font.BOLD, 14));
		cname.setBounds(824, 105, 165, 21);
		contentPane.add(cname);
		JLabel lblClientPhoneNumber = new JLabel("Client ID:");
		lblClientPhoneNumber.setHorizontalAlignment(SwingConstants.RIGHT);
		lblClientPhoneNumber.setForeground(Color.WHITE);
		lblClientPhoneNumber.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblClientPhoneNumber.setBounds(713, 72, 101, 21);
		contentPane.add(lblClientPhoneNumber);
		cnumber = new JLabel("");
		cnumber.setHorizontalAlignment(SwingConstants.LEFT);
		cnumber.setForeground(Color.WHITE);
		cnumber.setFont(new Font("Bahnschrift", Font.BOLD, 14));
		cnumber.setBounds(824, 74, 170, 21);
		contentPane.add(cnumber);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 169, 984, 283);
		contentPane.add(scrollPane);
		table = new JTable();
		DefaultTableModel model = new DefaultTableModel();
		model.setRowCount(10);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnDeleteRow.setVisible(true);
			}
		});
		table.setDefaultEditor(Object.class, null);
		table.setShowGrid(false);
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Item Type", "Description", "Quantity", "Rate(in \u20B9)", "Amount(in \u20B9)" }) {
			Class[] columnTypes = new Class[] { String.class, String.class, Integer.class, Double.class, Double.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table);
		btnDeleteRow = new JButton("Delete row");
		btnDeleteRow.setVisible(false);
		btnDeleteRow.addActionListener(new ActionListener() {
			DefaultTableModel model = (DefaultTableModel) table.getModel();

			public void actionPerformed(ActionEvent e) {
				try {
					selectedRowIndex = table.getSelectedRow();
					if (table.getValueAt(selectedRowIndex, 0).equals("Product")) {
						noOfProds--;
					} else if (table.getValueAt(selectedRowIndex, 0).equals("Service")) {
						noOfServs--;
					}
					subtractValue(selectedRowIndex);
					model.removeRow(selectedRowIndex);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Error");
				}
			}
		});
		btnDeleteRow.setMargin(new Insets(0, 0, 0, 0));
		btnDeleteRow.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
		btnDeleteRow.setBackground(Color.WHITE);
		btnDeleteRow.setBounds(419, 138, 136, 21);
		contentPane.add(btnDeleteRow);
		JComboBox branchInfo = new JComboBox();
		try {
			query = "SELECT Address, ContactNumber FROM branchlist";
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/csiatables", "root", "mySQLpassword");
			pst = con.prepareStatement(query);
			rs = pst.executeQuery();
			while (rs.next()) {
				branchInfo.addItem(rs.getString("Address") + " - " + rs.getString("ContactNumber"));
			}
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, e1);
		}
		branchInfo.setFont(new Font("Arial", Font.PLAIN, 12));
		branchInfo.setBackground(Color.WHITE);
		branchInfo.setBounds(123, 43, 575, 21);
		contentPane.add(branchInfo);
		JButton brButton = new JButton("+");
		brButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Selected Branch Successfully");
			}
		});
		brButton.setMargin(new Insets(0, 0, 0, 0));
		brButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		brButton.setBackground(Color.WHITE);
		brButton.setBounds(708, 43, 21, 21);
		contentPane.add(brButton);
		btnNewButton_1 = new JButton("Generate an Invoice");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
// Generating pdf
				path1 = "";
				j = new JFileChooser();
				j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				g = j.showSaveDialog(null);
				if (g == JFileChooser.APPROVE_OPTION) {
					path1 = j.getSelectedFile().toString();
				}
				time = (int) (System.currentTimeMillis() / 1000);
				path1 = path1.replace("\\", "\\\\");
				path = path1 + "\\\\Invoice-" + cname.getText() + "- " + time + ".pdf";
//Insert invoice info to database
				Document doc = new Document();
				try {
					if (table.getRowCount() != 0) {
						String FONT1 = "resources/fonts/PlayfairDisplay-Regular.ttf";
						com.itextpdf.text.Font f3 = FontFactory.getFont(FONT1, BaseFont.IDENTITY_H, BaseFont.EMBEDDED,
								18);
						PdfWriter.getInstance(doc, new FileOutputStream(path));
						doc.open();
						Paragraph para = new Paragraph("BEAUTYMANNTRA INVOICE", FontFactory.getFont(
								FontFactory.HELVETICA_BOLD, 24, Font.BOLD, BaseColor.CYAN.darker().darker().darker()));
						para.setAlignment(Element.ALIGN_CENTER);
						Paragraph para1 = new Paragraph("----------------------------------------------------------"
								+ "------------------------------------------------------------------------");
						Paragraph para2 = new Paragraph("Date: " + formatter.format(myDateObj));
						para2.setAlignment(Element.ALIGN_RIGHT);
						Paragraph para3 = new Paragraph("----------------------------------------------------------"
								+ "------------------------------------------------------------------------");
						Paragraph para4 = new Paragraph("Client ID: " + cnumber.getText());
						Paragraph para5 = new Paragraph("Client Name: " + cname.getText());
						Paragraph para6 = new Paragraph("----------------------------------------------------------"
								+ "------------------------------------------------------------------------");
						doc.add(para);
						doc.add(para1);
						doc.add(para2);
						doc.add(para3);
						doc.add(para4);
						doc.add(para5);
						doc.add(para6);
						PdfPTable table1 = new PdfPTable(5);
						table1.setWidthPercentage(105);
						table1.setSpacingBefore(11f);
						table1.setSpacingAfter(11f);
						float[] colWidth = { 2f, 2f, 2f, 2f, 2f };
						table1.setWidths(colWidth);
						PdfPCell c1 = new PdfPCell(new Phrase("Item Type"));
						table1.addCell(c1);
						PdfPCell c2 = new PdfPCell(new Phrase("Description"));
						table1.addCell(c2);
						PdfPCell c3 = new PdfPCell(new Phrase("Quantity"));
						table1.addCell(c3);
						PdfPCell c4 = new PdfPCell(new Phrase("Rate"));
						table1.addCell(c4);
						PdfPCell c5 = new PdfPCell(new Phrase("Amount"));
						table1.addCell(c5);
						for (int m = 0; m < table.getRowCount(); m++) {
							String itype = table.getValueAt(m, 0).toString();
							String desc = table.getValueAt(m, 1).toString();
							String qty = table.getValueAt(m, 2).toString();
							String r = table.getValueAt(m, 3).toString();
							String amt = table.getValueAt(m, 4).toString();
							table1.addCell(itype);
							table1.addCell(desc);
							table1.addCell(qty);
							table1.addCell(r);
							table1.addCell(amt);
						}
						doc.add(table1);
						Paragraph para7 = new Paragraph("Total Amount: Rs. " + sum, f3);
						para7.setAlignment(Element.ALIGN_RIGHT);
						doc.add(para7);
						Paragraph space = new Paragraph("----------------------------------------------------------"
								+ "------------------------------------------------------------------------");
						Paragraph branchinfo = new Paragraph(branchInfo.getSelectedItem().toString(),
								FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD, BaseColor.BLACK));
						branchinfo.setAlignment(Element.ALIGN_CENTER);
						doc.add(space);
						doc.add(branchinfo);
						doc.close();
						JOptionPane.showMessageDialog(null, "PDF Generated for Invoice");
						try {
							String invoiceinfo = "INSERT INTO `csiatables`.`invoicelist` (`Path`, `ClientName`, `Date`, `Expense`) VALUES "
									+ "('" + path + "', '" + cname.getText() + "', '" + formattedDate + "', '" + sum
									+ "')";
							Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/csiatables",
									"root", "mySQLpassword");
							PreparedStatement invoicepst = con.prepareStatement(invoiceinfo);
							invoicepst.executeUpdate();
						} catch (Exception e11) {
							JOptionPane.showMessageDialog(null, e11);
						}
//Insert product and service data in database table
						try {
							String inv = "select SerialNo from invoicelist where Date = '" + formattedDate + "'";
							String prodInfo = "INSERT INTO `csiatables`.`invoiceproductlist` (`invoiceno`, `Date`, `Product Name`, `productID`, `price`) VALUES (?, ?, ?, ?, ?)";
							String servInfo = "INSERT INTO `csiatables`.`invoiceservicelist` (`invoiceno`, `Date`, `Service Name`, `serviceID`, `price`) VALUES (?, ?, ?, ?, ?)";
							Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/csiatables",
									"root", "mySQLpassword");
							for (int i = 0; i < table.getRowCount(); i++) {
								PreparedStatement prodpst = con1.prepareStatement(prodInfo);
								PreparedStatement invIdpst = con1.prepareStatement(inv);
								ResultSet rs1 = invIdpst.executeQuery();
								int id = 0;
								while (rs1.next()) {
									id = rs1.getInt("SerialNo");
								}
								if (table.getValueAt(i, 0).toString().equals("Product")) {
									String prod = "select SerialNo from productlist where ProductName = '"
											+ table.getValueAt(i, 1).toString() + "'";
									for (int Quantity = 0; Quantity < Integer
											.parseInt(table.getValueAt(i, 2).toString()); Quantity++) {
										PreparedStatement prodIdpst = con1.prepareStatement(prod);
										ResultSet rsprod = prodIdpst.executeQuery();
										int prodId = 0;
										while (rsprod.next()) {
											prodId = rsprod.getInt("SerialNo");
										}
										double price = Double.parseDouble(table.getValueAt(i, 3).toString());
										String prodName = table.getValueAt(i, 1).toString();
										prodpst.setInt(1, id);
										prodpst.setDate(2, formattedDate);
										prodpst.setString(3, prodName);
										prodpst.setInt(4, prodId);
										prodpst.setDouble(5, price);
										prodpst.executeUpdate();
									}
								} else if (table.getValueAt(i, 0).toString().equals("Service")) {
									String serv = "select SerialNo from servicelist where Subcategory = '"
											+ table.getValueAt(i, 1).toString() + "'";
									PreparedStatement servpst = con1.prepareStatement(servInfo);
									PreparedStatement servIdpst = con1.prepareStatement(serv);
									ResultSet rsserv = servIdpst.executeQuery();
									int servId = 0;
									while (rsserv.next()) {
										servId = rsserv.getInt("SerialNo");
									}
									double amount = Double.parseDouble(table.getValueAt(i, 4).toString());
									String servName = table.getValueAt(i, 1).toString();
									servpst.setInt(1, id);
									servpst.setDate(2, formattedDate);
									servpst.setString(3, servName);
									servpst.setInt(4, servId);
									servpst.setDouble(5, amount);
									servpst.executeUpdate();
								}
							}
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null, e1);
						}
					} else {
						JOptionPane.showMessageDialog(null, "Enter services taken or products bought");
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		btnNewButton_1.setBounds(10, 462, 243, 30);
		contentPane.add(btnNewButton_1);
		setComboButtonEditable(false);
		JLabel lblQty = new JLabel("Qty:");
		lblQty.setHorizontalAlignment(SwingConstants.RIGHT);
		lblQty.setForeground(Color.WHITE);
		lblQty.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblQty.setBounds(387, 105, 34, 21);
		contentPane.add(lblQty);
		lblTotalAmount = new JLabel("Total Amount to be paid: ");
		lblTotalAmount.setHorizontalAlignment(SwingConstants.LEFT);
		lblTotalAmount.setForeground(Color.WHITE);
		lblTotalAmount.setFont(new Font("Bahnschrift", Font.PLAIN, 26));
		lblTotalAmount.setBounds(475, 449, 529, 30);
		contentPane.add(lblTotalAmount);
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Reports rp = new Reports();
				rp.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		btnBack.setBackground(Color.WHITE);
		btnBack.setBounds(263, 462, 110, 30);
		contentPane.add(btnBack);
		JLabel lblBranchAddress = new JLabel("Branch Info: ");
		lblBranchAddress.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBranchAddress.setForeground(Color.WHITE);
		lblBranchAddress.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblBranchAddress.setBounds(0, 41, 126, 21);
		contentPane.add(lblBranchAddress);
	}

	public class RowDataService {
		String itemtype, description;
		double rate, amount;
		int quantity;

		public RowDataService(String ItemType, String Description, int Quantity, double Rate, double Amount) {
			this.itemtype = ItemType;
			this.description = Description;
			this.quantity = Quantity;
			this.rate = Rate;
			this.amount = Amount;
		}
	}

	public class RowDataProduct {
		String itemtype, description;
		double rate, amount;
		int quantity;

		public RowDataProduct(String ItemType, String Description, int Quantity, double Rate, double Amount) {
			this.itemtype = ItemType;
			this.description = Description;
			this.quantity = Quantity;
			this.rate = Rate;
			this.amount = Amount;
		}
	}

	public void addServiceRowToTable(ArrayList<RowDataService> list) {
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		ArrayList<RowDataService> sl = list;
		Object rowData[] = new Object[5];
		for (int i = 0; i < sl.size(); i++) {
			rowData[0] = sl.get(i).itemtype;
			rowData[1] = sl.get(i).description;
			rowData[2] = sl.get(i).quantity;
			rowData[3] = sl.get(i).rate;
			rowData[4] = sl.get(i).amount;
			dtm.addRow(rowData);
		}
	}

	public void addProductRowToTable(ArrayList<RowDataProduct> list) {
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		ArrayList<RowDataProduct> sl = list;
		Object rowData[] = new Object[5];
		for (int i = 0; i < sl.size(); i++) {
			rowData[0] = sl.get(i).itemtype;
			rowData[1] = sl.get(i).description;
			rowData[2] = sl.get(i).quantity;
			rowData[3] = sl.get(i).rate;
			rowData[4] = sl.get(i).amount;
			dtm.addRow(rowData);
		}
	}

	double sum = 0;

	public void subtractValue(int row) {
		int selectedRow = row;
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		sum = sum - Double.parseDouble(model.getValueAt(selectedRow, 4).toString());
		lblTotalAmount.setText("Total Amount to be paid: " + sum + "\u20B9");
	}

	public void getTotalAmount() {
		sum = 0;
		for (int v = 0; v < table.getRowCount(); v++) {
			sum = sum + Double.parseDouble(table.getValueAt(v, 4).toString());
		}
	}

	public void updateLabel() {
		lblTotalAmount.setText("Total Amount to be paid: " + sum + "\u20B9");
	}
}
