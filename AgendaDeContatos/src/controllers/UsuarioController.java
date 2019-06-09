package controllers;

import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsuarioDAO;
import model.Usuario;

@WebServlet("/CadastrarUsuario")
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UsuarioController() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UsuarioDAO usuarioDao = new UsuarioDAO();
		
		try {
			Usuario usuario = loadUsuarioViaParametros(req);
			//implementar verificação se Usuario já existe
			Long usuarioId = usuarioDao.Novo(usuario);
			req.setAttribute("nome", usuario.getNome());
			req.setAttribute("id", usuarioId);
		
			RequestDispatcher rd = req.getRequestDispatcher("TelaBoasVindas.jsp");
			rd.forward(req, resp);
		}catch(DateTimeParseException e) {
			e.printStackTrace();
			resp.sendRedirect("TelaAcessoNegado.jsp");
		}catch(Exception e) {
			e.printStackTrace();
			resp.sendRedirect("TelaAcessoNegado.jsp");
		}
		
	}
	
	private Usuario loadUsuarioViaParametros(HttpServletRequest req) throws Exception, DateTimeParseException {
		
		Usuario usuario = new Usuario();
		Long id = 0L;
		
		try {
			id = Long.parseLong(req.getParameter("id"));
		}catch(NumberFormatException e) {
			id = 0L;
		}
		usuario.setId(id);
		usuario.setNome(req.getParameter("nome"));
		usuario.setEndereco(req.getParameter("endereco"));
		usuario.setEmail(req.getParameter("email"));
		usuario.setTelefone(req.getParameter("telefone"));
		usuario.setUsuario(req.getParameter("usuario"));
		usuario.setSenha(req.getParameter("senha"));
		usuario.setFotoUrl(req.getParameter("fotoUrl"));

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String date = req.getParameter("dataNascimento");
		LocalDate dataNascimento = LocalDate.parse(date, formatter);
		usuario.setDataCadastro(LocalDateTime.now());

		try {
			usuario.setDataNascimento(dataNascimento);
		}catch(DateTimeParseException e) {
			throw new DateTimeException("Data de Nascimento Invalida");
		}
		return usuario;
	}

}
