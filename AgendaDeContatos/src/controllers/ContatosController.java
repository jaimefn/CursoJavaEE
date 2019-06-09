package controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.ws.util.StringUtils;

import beans.Numeros;
import dao.ContatoDAO;
import model.Contato;
import model.Usuario;

@WebServlet("/Contatos")
public class ContatosController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ContatoDAO contatoDao = new ContatoDAO();
		List<Contato> contatos = new ArrayList<Contato>();

		String acao = req.getParameter("acao");
		String usuarioId = req.getParameter("usuarioId");
		String contatoId = req.getParameter("contatoId");

		try {

			if (acao.equals("ListarContatos")) {

				contatos = getListaDeContatos(Long.parseLong(usuarioId));

				req.setAttribute("usuarioId", usuarioId);
				req.setAttribute("contatos", contatos);
				RequestDispatcher rs = req.getRequestDispatcher("TelaListarContatos.jsp");
				rs.forward(req, resp);

			} else if (acao.equals("ExcluirContato")) {
				usuarioId = contatoDao.getUsuarioId(Long.parseLong(contatoId)).toString();
				contatoDao.Deletar(Long.parseLong(contatoId));
				resp.sendRedirect("Contatos?acao=ListarContatos&usuarioId=" + usuarioId);
			} else if (acao.equals("EditarContato")) {

				System.out.println("EditarCadastro");
				Contato contato = contatoDao.BuscarContato(Long.parseLong(contatoId));

				req.setAttribute("titulo", "Editar Contato");
				req.setAttribute("contato", contato);

				RequestDispatcher rs = req.getRequestDispatcher("TelaCadastrarEditarContato.jsp");
				rs.forward(req, resp);

			} else if (acao.equals("CriarContato")) {
				System.out.println("CriarCadastro");

				Contato contato = new Contato();
				contato.setUsuarioId(Long.parseLong(usuarioId));
				contato.setId(0L);
				
				req.setAttribute("titulo", "Criar Novo Contato");
				req.setAttribute("contato", contato);

				RequestDispatcher rs = req.getRequestDispatcher("TelaCadastrarEditarContato.jsp");
				rs.forward(req, resp);

			}else if (acao.equals("SalvarContato")) {
				System.out.println("SalvarCadastro");

				Contato contato = new Contato();

				contato = loadContatoViaParametros(req);

				if (contato.getId() == 0)
					contatoDao.Novo(contato);
				else
					contatoDao.Atualizar(contato);

				resp.sendRedirect("Contatos?acao=ListarContatos&usuarioId=" + contato.getUsuarioId());

			} else {

			}

		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (DateTimeParseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("saiu");

	}

	private Contato loadContatoViaParametros(HttpServletRequest req) throws Exception, DateTimeParseException {

		Contato contato = new Contato();
		String str_contatoId = "";
		String str_usuarioId = "";

		Long contatoId = 0L;
		Long usuarioId = 0L;

		str_contatoId = req.getParameter("contatoId");
		str_usuarioId = req.getParameter("usuarioId");

		if (Numeros.IsNumeric(str_contatoId))
			contatoId = Long.parseLong(str_contatoId);
		if (Numeros.IsNumeric(str_usuarioId))
			usuarioId = Long.parseLong(str_usuarioId);

		contato.setId(contatoId);
		contato.setUsuarioId(usuarioId);

		contato.setNome(req.getParameter("nome"));
		contato.setEndereco(req.getParameter("endereco"));
		contato.setEmail(req.getParameter("email"));
		contato.setTelefone(req.getParameter("telefone"));
		contato.setRedeSocial(req.getParameter("redeSocial"));

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String date = req.getParameter("dataNascimento");
		LocalDate dataNascimento = LocalDate.parse(date, formatter);
		contato.setDataCadastro(null);

		try {
			contato.setDataNascimento(dataNascimento);
		} catch (DateTimeParseException e) {
			throw new DateTimeException("Data de Nascimento Invalida");
		}
		return contato;
	}

	private List<Contato> getListaDeContatos(Long usuarioId) throws SQLException {
		ContatoDAO contatoDao = new ContatoDAO();
		return contatoDao.SelecionarContatosPorUsuarioId(usuarioId);
	}

}
