package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connection.SingleConnection;
import model.Email;

public class EmailDAO {

	private Connection connection;
	
	public void Novo(Email email) throws SQLException {
		connection = SingleConnection.getConnection();
		
		String sqlInsertEmail = "INSERT INTO Email (email,contato_Id) VALUES (?,?)";
	
		
		PreparedStatement statement = connection.prepareStatement(sqlInsertEmail);
		
		statement.setString(1, email.getEmail());
		statement.setLong(2, email.getContatoId());
		
		int affectedRows = statement.executeUpdate();
		
		if(affectedRows == 0) {
			throw new SQLException("Email -> Não foi possível Salvar o Contato");
		}
	}
	
	public void DeletarPorId(Long id) throws SQLException {
		String sqlDeleteEmail = "DELETE FROM email WHERE id=" + id;
		int affectedRows = 0;
		
		connection = SingleConnection.getConnection();
				
		try {
			PreparedStatement statement = connection.prepareStatement(sqlDeleteEmail);
			affectedRows = statement.executeUpdate();	
						
		} catch (SQLException e) {
			throw new SQLException(e.getMessage());
		}
	}

	public void DeletarPorContatoId(Long contatoId) throws SQLException {
		String sqlDeleteEmails = "DELETE FROM email WHERE contato_id=" + contatoId;
		
		int affectedRows = 0;
		
		connection = SingleConnection.getConnection();
				
		try {
			PreparedStatement statement = connection.prepareStatement(sqlDeleteEmails);
			affectedRows = statement.executeUpdate();	
						
		} catch (SQLException e) {
			throw new SQLException(e.getMessage());
		}
	}

}
