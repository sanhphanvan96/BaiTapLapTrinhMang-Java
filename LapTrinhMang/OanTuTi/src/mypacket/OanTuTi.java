package mypacket;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class OanTuTi extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public OanTuTi() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cookie cookieKetQua = new Cookie("ketqua", "keo");
		response.addCookie(cookieKetQua);
		
		Cookie cookieChoose = new Cookie("choose", "");
		response.addCookie(cookieChoose);
		response.sendRedirect("OanTuTi.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
