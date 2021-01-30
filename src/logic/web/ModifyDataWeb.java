package logic.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logic.bean.UserBean;
import logic.boundary.WindowManager;
import logic.control.ControlProfile;


/**
 * Servlet implementation class ModifyDataWeb
 */
@WebServlet("/ModifyDataWeb")
public class ModifyDataWeb extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ModifyDataWeb() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		ControlProfile ctrlProfile = ControlProfile.getInstance();

		String password = request.getParameter("password");
		String email = request.getParameter("email");

		if ("logout".equals(action)) {
			WindowManager.getInstance().setLoggedUser(null);
			response.sendRedirect("LoginWeb.jsp");
			return;
		}

		UserBean user = ctrlProfile.getCurrentUserData(session.getAttribute("credentials").toString());

		if (password.length() != 0) {
			user.setPassword(password);
		}
		if (email.length() != 0) {
			user.setEmail(email);
		}

		int res = ctrlProfile.modifyCurrentUserData(user);

		if (res == -1) {

			response.sendRedirect("Error.jsp");
			return;

		}
		
		response.sendRedirect("ProfileWeb.jsp");
	}

}
