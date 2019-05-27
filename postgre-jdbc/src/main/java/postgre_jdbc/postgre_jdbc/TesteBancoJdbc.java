package postgre_jdbc.postgre_jdbc;

import java.util.List;

import org.junit.Test;

import conexaojdbc.SingleConnection;
import dao.ClienteDAO;
import model.Cliente;


public class TesteBancoJdbc {


	@Test
	public void NovoCliente() {
		Cliente cliente = new Cliente();
		ClienteDAO clienteDao = new ClienteDAO();
		
		cliente.setNome("Julia Nascimento");
		cliente.setEmail("juliasp@hotmail.com");
		
		clienteDao.salvar(cliente);
	
	}

	@Test
	public void ExibirTodosClientes() {
		
		List<Cliente> list = new ClienteDAO().selecionar();
		
		for (Cliente cliente : list) {
			System.out.println(cliente);
		}
			
	}
	
	@Test
	public void BuscarPorId() {
		
		Cliente cliente = new ClienteDAO().Buscar(1L);
		
		System.out.println(cliente);
		
			
	}
	
	@Test
	public void Atualizar() {
		
		Cliente cliente = new Cliente();
		ClienteDAO clienteDao = new ClienteDAO();
		
		cliente.setId(1L);
		cliente.setNome("Eliane Maria da Silva Nascimento");
		cliente.setEmail("elianemaria@gmail.com");
		
		
		clienteDao.Atualizar(cliente);
		
		System.out.println("ok");
		
			
	}
	@Test
	public void Deletar() {
		
		ClienteDAO clienteDao = new ClienteDAO();
		
		clienteDao.Deletar(4L);
		
		System.out.println("Deletou com Sucesso");
		
	}
	
	
}
