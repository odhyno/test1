package logic.web;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logic.bean.UserBean;
import logic.control.ControlProfile;
import logic.utility.WindowManager;


/**
 * Servlet implementation class ModifyProfileWeb
 */
@WebServlet("/ModifyProfileWeb")
public class ModifyProfileWeb extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ModifyProfileWeb() {
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

		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String date =request.getParameter("date");

		if ("logout".equals(action)) {
			WindowManager.getInstance().setLoggedUser(null);
			response.sendRedirect("LoginWeb.jsp");			
			return;
		}
		UserBean user = ctrlProfile.getCurrentUserData(session.getAttribute("credentials").toString());

		if (firstname.length() != 0) {
			user.setFirstname(firstname);
		}
		if (lastname.length() != 0) {
			user.setLastname(lastname);
		}
		if (date.length() != 0) {
			user.setBirthDate(date);

		}

		ctrlProfile.modifyCurrentUserProfile(user);
		
		ctrlProfile = ControlProfile.getInstance();
		user = ctrlProfile.getCurrentUserData(session.getAttribute("credentials").toString());

		String newProfile = "YOUR PROFILE:\n\nUsername: " + user.getUsername() + "\nEmail: " + user.getEmail()
				+ "\nFirst name: " + user.getFirstname() + "\nLast name: " + user.getLastname() + "\nSubs Date: "
				+ user.getSubsDate() + "\nBirth Date: " + user.getBirthDate();

		session.setAttribute("profile", newProfile);
		response.sendRedirect("ProfileWeb.jsp");

	}

}
