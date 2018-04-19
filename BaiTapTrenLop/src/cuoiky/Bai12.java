package cuoiky;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.mysql.jdbc.Connection;

public class Bai12 {
	private FileReader fr;
	private BufferedReader br;
	private BufferedWriter bw;
	private FileWriter fw;

	public static void main(String[] args) {
		Bai12 obj = new Bai12();
		try {
			// Connect database
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/java?useUnicode=true&characterEncoding=utf-8";
			Connection conn = (Connection) DriverManager.getConnection(url, "root", "");

			Statement stm = conn.createStatement();
			PreparedStatement preStmt;
			String query = "SELECT * FROM nhanvien";
			ResultSet rs = stm.executeQuery(query);
			System.out.println("Dữ liệu từ database: ");
			while (rs.next()) {
				System.out.print(rs.getString("MaNhanVien") + "\t");
				System.out.print(rs.getString("TenNhanVien") + "\t");
				System.out.print(rs.getString("NgaySinh") + "\t");
				System.out.print(rs.getString("DiaChiEmail") + "\t");
				System.out.println(rs.getString("ThuNhap"));
			}

			BufferedReader data1 = obj.loadFile("data1.txt");
			BufferedReader data2 = obj.loadFile("data2.txt");

			String line, maNhanVien, tenNhanVien, ngaySinh, diaChiEmail;
			int thuNhap;
			String[] parseData1 = new String[5];
			String[] parseData2 = new String[2];

			System.out.println("Dữ liệu từ file: data1.txt");
			while ((line = data1.readLine()) != null) {
				// System.out.println(line);

				parseData1 = line.split(",");

				maNhanVien = parseData1[0];
				tenNhanVien = parseData1[1];
				ngaySinh = parseData1[2];
				diaChiEmail = parseData1[3];

				System.out.print(maNhanVien + "\t");
				System.out.print(tenNhanVien + "\t");
				System.out.print(ngaySinh + "\t");
				System.out.print(diaChiEmail + "\t");
				System.out.println();

				// Convert string to date sql format
				SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
				format.setLenient(false);
				java.util.Date parsed;
				java.sql.Date ngaySinhSql = null;

				try {
					parsed = (java.util.Date) format.parse(ngaySinh);
					ngaySinhSql = new java.sql.Date(parsed.getTime());
				} catch (Exception e) {
					System.out.println("Sai định dạng ngày giờ!");
				}

				// Insert data into database
				preStmt = conn.prepareStatement("INSERT INTO nhanvien values (?,?,?,?,?)");
				preStmt.setString(1, maNhanVien);
				preStmt.setString(2, tenNhanVien);
				preStmt.setDate(3, ngaySinhSql);
				preStmt.setString(4, diaChiEmail);
				preStmt.setInt(5, 0);
				try {
					preStmt.execute();
				} catch (SQLIntegrityConstraintViolationException e) {
					e.getMessage();
				}
			}

			System.out.println("Dữ liệu từ file: data2.txt");
			int numberOfLine = 0;
			while ((line = data2.readLine()) != null) {
				++numberOfLine;

				// System.out.println(line);

				parseData2 = line.split(",");
				maNhanVien = parseData2[0];
				thuNhap = Integer.parseInt(parseData2[1]);

				System.out.print(maNhanVien + "\t");
				System.out.print(thuNhap + "\t");
				System.out.println();

				if (thuNhap < 0) {
					obj.logToFile("Dòng " + numberOfLine + ": Thu nhập không được nhỏ hơn 0: " + thuNhap + "\n");
					// System.out.println("Dòng " + numberOfLine + ": Thu nhập không được nhỏ hơn 0:
					// " + thuNhap);
					continue;
				}
				// Insert data into database
				preStmt = conn.prepareStatement("SELECT MaNhanVien FROM nhanvien WHERE MaNhanVien=?");
				preStmt.setString(1, maNhanVien);
				rs = preStmt.executeQuery();

				if (!rs.next())
					obj.logToFile("Dòng " + numberOfLine + ": Không tồn tại nhân viên: " + maNhanVien + "\n");
				// System.out.println(
				// "Dòng " + numberOfLine + ": Không tồn tại nhân viên có mã nhân viên: " +
				// maNhanVien);
				else {
					preStmt = conn.prepareStatement("UPDATE nhanvien SET ThuNhap= ThuNhap + ? WHERE MaNhanVien=?");
					preStmt.setInt(1, thuNhap);
					preStmt.setString(2, maNhanVien);
					preStmt.executeUpdate();
				}
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private BufferedReader loadFile(String path) {
		try {
			fr = new FileReader(path);
			br = new BufferedReader(fr);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return br;
	}

	private void logToFile(String msg) {
		try {
			fw = new FileWriter("error2.txt", true);
			bw = new BufferedWriter(fw);
			bw.write(msg);

			System.out.print(msg);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
				if (fw != null)
					fw.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}

		}
	}
}
