package conexaojdbc;

import java.sql.Connection;
import java.sql.DriverManager;


public class SingleConnection {
	
	private static String url = "jdbc:postgresql://localhost:5432/teste";
	private static String user = "postgres";
	private static String password = "admin";
	private static Connection connection = null;
	
	static {
		Conectar();
	}
	
	public SingleConnection() {
		Conectar();
	}
	
	private static void Conectar() {
		
		if(connection == null) {
			try {
				Class.forName("org.postgresql.Driver"); //carrega o driver do banco de dados
				connection = DriverManager.getConnection(url, user, password);
				connection.setAutoCommit(false);//evitar salvamento automatico
				System.out.println("Conectou com Sucesso!");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}		
	}
	
	public static Connection getConnection() {
		return connection;
	}
	

}
