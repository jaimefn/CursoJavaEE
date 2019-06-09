package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Login;
import connection.SingleConnection;

public class LoginDAO {

	public boolean ValidarLogin(Login login) {
		
		Connection conn = SingleConnection.getConnection();
		
		String sql = "select * from login where usuario='" + login.getUsuario() + "' and senha='" + login.getSenha() + "'";
		
		boolean resultado = false;
		
		try {
			
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			
			
			
				if(resultSet.next()) resultado = true;
			
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
		return resultado;
	}
		
}
