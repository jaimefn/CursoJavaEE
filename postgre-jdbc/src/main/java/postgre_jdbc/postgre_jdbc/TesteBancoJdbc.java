package postgre_jdbc.postgre_jdbc;

import java.util.List;

import org.junit.Test;

import conexaojdbc.SingleConnection;
import dao.ClienteDAO;
import model.Cliente;
import dao.TelefoneDAO;
import model.Telefone;;


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
	public void BuscarClientePorId() {
		
		Cliente cliente = new ClienteDAO().Buscar(1L);
		
		System.out.println(cliente);
		
			
	}
	
	@Test
	public void AtualizarCliente() {
		
		Cliente cliente = new Cliente();
		ClienteDAO clienteDao = new ClienteDAO();
		
		cliente.setId(1L);
		cliente.setNome("Eliane Maria da Silva Nascimento");
		cliente.setEmail("elianemaria@gmail.com");
		
		
		clienteDao.Atualizar(cliente);
		
		System.out.println("ok");
		
			
	}
	@Test
	public void DeletarCliente() {
		
		ClienteDAO clienteDao = new ClienteDAO();
		
		clienteDao.Deletar(4L);
		
		System.out.println("Deletou com Sucesso");
		
	}
	
	
	
	@Test
	public void NovoTelefone() {
		Cliente cliente = new Cliente();
		
		cliente = new ClienteDAO().Buscar(1L);
		
		Telefone Telefone = new Telefone();
		TelefoneDAO TelefoneDao = new TelefoneDAO();
		
		Telefone.setClienteId(cliente.getId());
		Telefone.setNumero("99504253");
		Telefone.setTipo("Cel");
		
		TelefoneDao.salvar(Telefone);
	
	}

	@Test
	public void ExibirTodosTelefones() {
		
		List<Telefone> list = new TelefoneDAO().selecionar();
		
		for (Telefone Telefone : list) {
			System.out.println(Telefone);
		}
			
	}
	
	@Test
	public void BuscarTelefonePorId() {
		
		Telefone Telefone = new TelefoneDAO().Buscar(2L);
		
		System.out.println(Telefone);
		
			
	}
	
	@Test
	public void AtualizarTelefone() {
		
		Telefone Telefone = new Telefone();
		TelefoneDAO TelefoneDao = new TelefoneDAO();
		
		Telefone.setId(1L);
		Telefone.setNumero("98987645");
		Telefone.setTipo("Res");
		Telefone.setClienteId(2L);
		
		
		TelefoneDao.Atualizar(Telefone);
		
		System.out.println("ok");
		
			
	}
	@Test
	public void DeletarTelefone() {
		
		TelefoneDAO TelefoneDao = new TelefoneDAO();
		
		TelefoneDao.Deletar(4L);
		
		System.out.println("Deletou com Sucesso");
		
	}
	
	
	
	
}
