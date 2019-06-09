package connection;

import java.sql.Connection;
import java.sql.DriverManager;


public class SingleConnection {
	
	private static Connection connection;
	private static String url = "jdbc:postgresql://localhost:5432/teste";
	private static String user = "postgres";
	private static String pass = "admin";
	
	static {
		Connect();
	}
	
	private SingleConnection() {
		Connect();
	}
	
	
	private static void Connect() {
		
		if(connection == null) {
			try {
				
				Class.forName("org.postgresql.Driver"); //carrega o driver do banco de dados
				connection = DriverManager.getConnection(url, user, pass);
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
	}
	
	public static Connection getConnection() {
		return connection;
	}

}
