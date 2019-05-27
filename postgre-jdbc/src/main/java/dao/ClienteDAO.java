package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexaojdbc.SingleConnection;
import model.Cliente;

public class ClienteDAO {
	
	private Connection connection = null;
	
	public ClienteDAO() {
		connection = SingleConnection.getConnection();
	}
	
	public void salvar(Cliente cliente) {
		String sql = "INSERT INTO cliente (nome, email) VALUES(?,?)";
		try {
			PreparedStatement insert = connection.prepareStatement(sql);
			insert.setString(1, cliente.getNome());
			insert.setString(2, cliente.getEmail());
			insert.execute();
			connection.commit(); // salvar no banco de dados
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Cliente> selecionar(){
		String sql = "select * from cliente";
		
		List<Cliente> list = new ArrayList<Cliente>();
		
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultado = statement.executeQuery();
			
			while(resultado.next()) {
				
				Cliente cliente = new Cliente();
				cliente.setId(resultado.getLong("id"));
				cliente.setNome(resultado.getString("nome"));
				cliente.setEmail(resultado.getString("email"));
				
				list.add(cliente);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	public Cliente Buscar(Long id){
		String sql = "select * from cliente where id= " + id;
		
		Cliente cliente = new Cliente();
		
		try {
			
			PreparedStatement statement = connection.prepareStatement(sql);
	
			ResultSet resultado = statement.executeQuery();
			
				while(resultado.next()) {
					cliente.setId(resultado.getLong("id"));
					cliente.setNome(resultado.getString("nome"));
					cliente.setEmail(resultado.getString("email"));
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return cliente;
	}
	
	public void Atualizar(Cliente cliente){
		String sql = "update cliente set nome='" + cliente.getNome() + "', email='" + cliente.getEmail() + "' where id=" + cliente.getId();
		
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
		
		String sql = "delete from cliente where id=" + id;
		
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
