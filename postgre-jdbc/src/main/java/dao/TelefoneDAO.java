package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexaojdbc.SingleConnection;
import model.Telefone;

public class TelefoneDAO {
	
	private Connection connection = null;
	
	public TelefoneDAO() {
		connection = SingleConnection.getConnection();
	}
	
	public void salvar(Telefone Telefone) {
		String sql = "INSERT INTO Telefone (numero, tipo,clienteId) VALUES(?,?,?)";
		try {
			
			PreparedStatement insert = connection.prepareStatement(sql);
			
			insert.setString(1, Telefone.getNumero());
			insert.setString(2, Telefone.getTipo());
			insert.setLong(3, Telefone.getClienteId());
			
			insert.execute();
			
			connection.commit(); // salvar no banco de dados
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Telefone> selecionar(){
		String sql = "select * from Telefone";
		
		List<Telefone> list = new ArrayList<Telefone>();
		
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultado = statement.executeQuery();
			
			while(resultado.next()) {
				
				Telefone Telefone = new Telefone();
				Telefone.setId(resultado.getLong("id"));
				Telefone.setClienteId(resultado.getLong("clienteId"));
				
				Telefone.setNumero(resultado.getString("numero"));
				Telefone.setTipo(resultado.getString("tipo"));
				
				list.add(Telefone);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	public Telefone Buscar(Long id){
		String sql = "select * from Telefone where id= " + id;
		
		Telefone Telefone = new Telefone();
		
		try {
			
			PreparedStatement statement = connection.prepareStatement(sql);
	
			ResultSet resultado = statement.executeQuery();
			
				while(resultado.next()) {
					Telefone.setId(resultado.getLong("id"));
					Telefone.setClienteId(resultado.getLong("clienteId"));
					Telefone.setNumero(resultado.getString("numero"));
					Telefone.setTipo(resultado.getString("tipo"));
					
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return Telefone;
	}
	
	public void Atualizar(Telefone Telefone){
		String sql = "update Telefone set numero='" + Telefone.getNumero() + "', tipo='" + Telefone.getTipo() + "', clienteId=" + Telefone.getClienteId() + " where id= " + Telefone.getId();
		
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.execute();
			connection.commit();
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
	}
	
	
	public void Deletar(Long id) {
		
		String sql = "delete from Telefone where id=" + id;
		
		PreparedStatement statement;
		try {
			
			statement = connection.prepareStatement(sql);		
			statement.execute();
			connection.commit();
			
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
	}
	
	
}
