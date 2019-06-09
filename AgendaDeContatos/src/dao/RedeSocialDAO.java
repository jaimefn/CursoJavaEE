package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connection.SingleConnection;
import model.RedeSocial;

public class RedeSocialDAO {
	
		private Connection connection;
	
	
	public void Novo(RedeSocial redeSocial) throws SQLException {
		connection = SingleConnection.getConnection();

		String sqlInsertRedeSocial = "INSERT INTO Rede_Social (rede,contato_Id) VALUES (?,?)";

		
		PreparedStatement statement = connection.prepareStatement(sqlInsertRedeSocial);
		
		statement.setString(1, redeSocial.getRede());
		statement.setLong(2, redeSocial.getContatoId());
		
		int affectedRows = statement.executeUpdate();
		
		if(affectedRows == 0) {
			throw new SQLException("RedeSocial -> Não foi possível Salvar o Contato");
		}
	}
	
	
	public void DeletarPorId(Long id) throws SQLException {
		String sqlDeleteRedeSocial = "DELETE FROM rede_social WHERE id=" + id;
		int affectedRows = 0;
		
		connection = SingleConnection.getConnection();
				
		try {
			PreparedStatement statement = connection.prepareStatement(sqlDeleteRedeSocial);
			affectedRows = statement.executeUpdate();	
						
		} catch (SQLException e) {
			throw new SQLException(e.getMessage());
		}
		

	}

	public void DeletarPorContatoId(Long contatoId) throws SQLException {
		String sqlDeleteRedesSociais = "DELETE FROM rede_social WHERE contato_id=" + contatoId;
		
		int affectedRows = 0;
		
		connection = SingleConnection.getConnection();
				
		try {
			PreparedStatement statement = connection.prepareStatement(sqlDeleteRedesSociais);
			affectedRows = statement.executeUpdate();	
						
		} catch (SQLException e) {
			throw new SQLException(e.getMessage());
		}
	}	
	
}
