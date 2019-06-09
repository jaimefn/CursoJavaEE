package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection.SingleConnection;
import model.Contato;
import model.Telefone;
import model.Usuario;

public class UsuarioDAO {

private Connection connection;
	
	public Long Novo(Usuario usuario) throws SQLException {
		connection = SingleConnection.getConnection();
		
		String sqlInsertUsuario = "INSERT INTO usuario (nome,usuario,senha,endereco,foto_url,data_nascimento,data_cadastro,telefone,email) VALUES (?,?,?,?,?,?,?,?,?)";
		
		PreparedStatement statement = connection.prepareStatement(sqlInsertUsuario,Statement.RETURN_GENERATED_KEYS);
		
		statement.setString(1, usuario.getNome());
		statement.setString(2, usuario.getUsuario());
		statement.setString(3, usuario.getSenha());
		statement.setString(4, usuario.getEndereco());
		statement.setString(5, usuario.getFotoUrl());
		statement.setDate(6, Date.valueOf(usuario.getDataNascimento().toString()));
		statement.setDate(7, Date.valueOf(java.time.LocalDate.now()));
		statement.setString(8, usuario.getTelefone());
		statement.setString(9, usuario.getEmail());

		
		int affectedRows = statement.executeUpdate();
		
		if(affectedRows == 0) {
			throw new SQLException("Usuario -> Não foi possível Salvar");
		}
		
		ResultSet rs = statement.getGeneratedKeys();

		if (rs.next()) {

			 return rs.getLong("id");

		} else {
			throw new SQLException("Não foi possível obter o ID do Usuario");
		}
	}
	
	
	
	public void DeletarPorId(Long id) throws SQLException {
		String sqlDeleteUsuario = "DELETE FROM usuario WHERE id=" + id;
		int affectedRows = 0;
		
		connection = SingleConnection.getConnection();
				
		try {
			PreparedStatement statement = connection.prepareStatement(sqlDeleteUsuario);
			affectedRows = statement.executeUpdate();	
						
		} catch (SQLException e) {
			throw new SQLException(e.getMessage());
		}
	}

	
	public Long ValidarLogin(String usuario, String senha) throws SQLException {
	connection = SingleConnection.getConnection();
		
		String sql = "SELECT id from usuario where usuario='" + usuario + "' and senha='" + senha + "';";
		Long id = 0L;
		
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			
		
			if(rs.next()) {
				id = rs.getLong(1); 
			}else {
				throw new SQLException("Usuario não localizado");
			}
		
		return id;
				
	}
	
}
