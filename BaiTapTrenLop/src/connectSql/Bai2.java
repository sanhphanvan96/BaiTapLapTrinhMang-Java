package connectSql;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.mysql.jdbc.Connection;

public class Bai2 {

	public static void main(String[] args) throws ParseException {
		try {
			// Connect database
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/baithi";
			Connection conn = (Connection) DriverManager.getConnection(url, "root", "");
			System.out.println("Đã kết nối cơ sở dữ liệu");

			Statement stm = conn.createStatement();
			FileReader file1 = new FileReader("data1.txt");
			BufferedReader br1 = new BufferedReader(file1);
			String line;
			System.out.println("Dữ liệu file 1");
			while ((line = br1.readLine()) != null) {
				System.out.println(line);
			}
			
			FileReader file2 = new FileReader("data2.txt");
			BufferedReader br2 = new BufferedReader(file2);
			System.out.println("Dữ liệu file 2");
			while ((line = br2.readLine()) != null) {
				System.out.println(line);
			}
	} catch (Exception e) {}
	}

}
