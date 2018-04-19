package simpleServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/signup")
public class signup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public signup() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("signup.html");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		try {
			Double a = Double.parseDouble(request.getParameter("a"));
			Double b = Double.parseDouble(request.getParameter("b"));
			PrintWriter out = response.getWriter();
			out.println("a + b = " + (a + b) + "<br>");
			out.println("a - b = " + (a - b) + "<br>");
			out.println("a * b = " + (a * b) + "<br>");
			out.println("a / b = " + (a / b) + "<br>");
		} catch (Exception e) {
			doGet(request, response);
		}
	}

}
