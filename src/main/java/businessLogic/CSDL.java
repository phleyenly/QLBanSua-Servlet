package businessLogic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CSDL {
	private static Connection ketNoi;

	public static Connection getKetNoi() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/qlbansua?=useUnicode=true&characterEncoding=UTF-8";
			ketNoi = DriverManager.getConnection(url, "root", "040520");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return ketNoi;
	}
}
