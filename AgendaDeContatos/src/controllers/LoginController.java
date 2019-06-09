package controllers;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Dispatch;

import org.junit.Test;

import connection.SingleConnection;
import dao.UsuarioDAO;
import sun.rmi.server.Dispatcher;

@WebServlet("/ValidarLogin")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginController() {
		super();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		UsuarioDAO usuarioDao = new UsuarioDAO();

		String user = req.getParameter("usuario");
		String senha = req.getParameter("senha");

		try {
			
			Long usuarioId = usuarioDao.ValidarLogin(user, senha);
			resp.sendRedirect("Contatos?acao=ListarContatos&usuarioId="+ usuarioId);
			
		} catch (Exception e) {
			e.printStackTrace();
			resp.sendRedirect("TelaAcessoNegado.jsp");
		}

	}

}
