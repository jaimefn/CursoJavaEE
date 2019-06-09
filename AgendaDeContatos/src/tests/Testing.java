package tests;

import java.sql.SQLException;
import java.time.LocalDate;

import org.junit.Test;

import dao.AgendaDAO;
import dao.ContatoDAO;
import dao.EmailDAO;
import dao.RedeSocialDAO;
import dao.TelefoneDAO;
import dao.UsuarioDAO;
import model.Contato;
import model.Email;
import model.RedeSocial;
import model.Telefone;
import model.Usuario;


public class Testing {

	@Test
	public void TestSalvar() {
		
		AgendaDAO agendaDao = new AgendaDAO();
		
		
		UsuarioDAO usuarioDao = new UsuarioDAO();
		Usuario usuario = new Usuario();
		
		
		usuario.setId(1L);
		
		ContatoDAO contatoDao = new ContatoDAO();
		Contato contato = new Contato();
		
		Telefone telefone1 = new Telefone();
		Telefone telefone2 = new Telefone();
		Telefone telefone3 = new Telefone();
		Telefone telefone4 = new Telefone();
		
		Email email1 = new Email();
		Email email2 = new Email();
		Email email3 = new Email();
		Email email4 = new Email();
		
		RedeSocial redeSocial1 = new RedeSocial();
		RedeSocial redeSocial2 = new RedeSocial();
		RedeSocial redeSocial3 = new RedeSocial();

		telefone1.setTipoId(1L);
		telefone2.setTipoId(2L);
		telefone3.setTipoId(3L);
		telefone4.setTipoId(4L);
		
		telefone1.setNumero("199504253");
		telefone2.setNumero("299504253");
		telefone3.setNumero("399504253");
		telefone4.setNumero("499504253");
			
		email1.setEmail("eduardocampos1@hotmail.com");
		email2.setEmail("eduardocampos2@hotmail.com");
		email3.setEmail("eduardocampos3@hotmail.com");
		email4.setEmail("eduardocampos4@hotmail.com");
		
		redeSocial1.setRede("eduardocampo.facebook.com.br");
		redeSocial2.setRede("eduardocampo.twitter.com.br");
		redeSocial3.setRede("eduardocampo.linkedin.com.br");
			
		contato.setNome("Eduardo dos Santos Silva");
		contato.setEndereco("Rua da Esperança, 168 Jd Bela Vista");
		contato.setTelefones(telefone1);
		contato.setTelefones(telefone2);
		contato.setTelefones(telefone3);
		contato.setTelefones(telefone4);
		contato.setEmails(email1);
		contato.setEmails(email2);
		contato.setEmails(email3);
		contato.setEmails(email4);
		contato.setRedesSociais(redeSocial1);
		contato.setRedesSociais(redeSocial2);
		contato.setRedesSociais(redeSocial3);

		contato.setDataNascimento(LocalDate.of(2000,01,02));
		
		try {
			contato.setUsuarioId(usuario.getId());	
			agendaDao.NovoContato(contato);
			System.out.println("Salvo com sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
	}

	@Test
	public void Deletar() {
		
		AgendaDAO agendaDao = new AgendaDAO();
		
		try {
			agendaDao.DeletarContato(15L);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
