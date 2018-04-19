package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bo.AccountBO;

@WebServlet("/CheckLoginServerlet")
public class CheckLoginServerlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CheckLoginServerlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username + ", " + password);
		AccountBO abo = new AccountBO();
		if (abo.login(username, password)) {
			RequestDispatcher rd = request.getRequestDispatcher("/info.jsp");
			request.setAttribute("account", abo.getInfo());
			rd.forward(request, response);
		} else {
			response.sendRedirect("login.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
