package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Dispatch;

import DAO.LoginDAO;
import model.Login;

@WebServlet("/ValidarLogin")
public class LoginUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		LoginDAO loginDAO = new LoginDAO();
		Login login = new Login();
		
		login.setUsuario(req.getParameter("usuario"));
		login.setSenha(req.getParameter("senha"));
		
		RequestDispatcher dispatcher;
		
		System.out.println("LoginUsuario -> ValidarLogin");
		
		if(loginDAO.ValidarLogin(login)) {
			dispatcher = req.getRequestDispatcher("acessoliberado.jsp");
					}else {
			dispatcher = req.getRequestDispatcher("acessonegado.jsp");
		}
		
		dispatcher.forward(req, resp);
	}
	
	
}
