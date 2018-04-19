package cuoiky;

import java.sql.SQLException;
import java.text.ParseException;

public class Cau2 {

	public static void main(String[] args) throws ParseException {
			// Connect database
			try {
				Class.forName("com.mysql.jdbc.Driver");
				String url = "jdbc:mysql://localhost:3306/coincard";
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

	}

}
