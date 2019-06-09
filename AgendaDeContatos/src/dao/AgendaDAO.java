package dao;

import java.sql.SQLException;

import model.Contato;
import model.Email;
import model.RedeSocial;
import model.Telefone;

public class AgendaDAO {

	public void NovoContato(Contato contato) throws SQLException {

		ContatoDAO contatoDao = new ContatoDAO();
		TelefoneDAO telefoneDao = new TelefoneDAO();
		EmailDAO emailDao = new EmailDAO();
		RedeSocialDAO redeSocialDao = new RedeSocialDAO();

		try {

			Long newContactId = contatoDao.Novo(contato);

			for (RedeSocial redeSocial : contato.getRedesSociais()) {
				redeSocial.setContatoId(newContactId);
				redeSocialDao.Novo(redeSocial);
			}

			for (Email email : contato.getEmails()) {
				email.setContatoId(newContactId);
				emailDao.Novo(email);
			}

			for (Telefone telefone : contato.getTelefones()) {
				telefone.setContatoId(newContactId);
				telefoneDao.Novo(telefone);
			}

		} catch (SQLException e) {
			throw new SQLException(e.getMessage());
		}
	}

	public void DeletarContato(Long contatoId) throws SQLException {
		
		ContatoDAO contatoDao = new ContatoDAO();
		TelefoneDAO telefoneDao = new TelefoneDAO();
		EmailDAO emailDao = new EmailDAO();
		RedeSocialDAO redeSocialDao = new RedeSocialDAO();

		try {

			telefoneDao.DeletarPorContatoId(contatoId);
			emailDao.DeletarPorContatoId(contatoId);
			redeSocialDao.DeletarPorContatoId(contatoId);
			contatoDao.Deletar(contatoId);

		} catch (SQLException e) {
			throw new SQLException(e.getMessage());
		}
	}

	
}
