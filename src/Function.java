import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Function {
	Connection con = null;
	ResultSet rs = null;
	PreparedStatement pst = null;

	public ResultSet find(int s) {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/csiatables", "root", "mySQLpassword");
			pst = con.prepareStatement("SELECT * FROM productlist WHERE SerialNo = ?");
			pst.setInt(1, s);
			rs = pst.executeQuery();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return rs;
	}

	public ResultSet find1(int v) {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/csiatables", "root", "mySQLpassword");
			pst = con.prepareStatement("SELECT * FROM servicelist WHERE SerialNo = ?");
			pst.setInt(1, v);
			rs = pst.executeQuery();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return rs;
	}

	public ResultSet find(String s) {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/csiatables", "root", "mySQLpassword");
			pst = con.prepareStatement("SELECT * FROM clientlist WHERE ClientID = ?");
			pst.setString(1, s);
			rs = pst.executeQuery();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return rs;
	}
}
