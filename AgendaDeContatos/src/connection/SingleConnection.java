package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingleConnection {
	
	private static String url = "jdbc:postgresql://localhost:5432/agenda";
	private static String user = "postgres";
	private static String pwd = "admin";
	
	private static Connection connection = null;
	
	static{
		Connect();
	}
	
	private SingleConnection() {
		Connect();
	}
	
	private static void Connect() {
		if(connection == null) {
			try {
				Class.forName("org.postgresql.Driver"); //carrega o driver do banco de dados
				connection = DriverManager.getConnection(url,user,pwd);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public static Connection getConnection() {		
		return connection;
	}
	
}
