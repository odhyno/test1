package logic.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logic.bean.UserBean;
import logic.boundary.WindowManager;
import logic.control.ControlProfile;
import logic.control.ControlSendMessage;
import logic.interfaces.Observer;
import logic.thread.CheckThread;

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
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
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

		String password = request.getParameter("firstname");
		String email = request.getParameter("lastname");

		if ("message".equals(action)) {
			Observer controllerSendMessage = ControlSendMessage.getInstance();
			controllerSendMessage.add();

			String username = WindowManager.getInstance().getLoggedUser().getUsername();

			Thread thread = new Thread(new CheckThread(username));
			thread.start();

			List<String> usernameList = controllerSendMessage.showUsers(username);

			String contacts = usernameList.get(0);

			for (int i = 1; i < usernameList.size(); i++) {

				contacts = contacts + "\n" + usernameList.get(i);
			}
			session.setAttribute("users", contacts);
			response.sendRedirect("SendMessageWeb.jsp");
			return;

		}
		if ("profile".equals(action)) {
			ctrlProfile = ControlProfile.getInstance();
			UserBean user = ctrlProfile.getCurrentUserData(session.getAttribute("credentials").toString());

			String profile = "YOUR PROFILE:\n\nUsername: " + user.getUsername() + "\nEmail: " + user.getEmail()
					+ "\nFirst name: " + user.getFirstname() + "\nLast name: " + user.getLastname() + "\nSubs Date: "
					+ user.getSubsDate() + "\nBirth Date: " + user.getBirthDate();

			session.setAttribute("profile", profile);
			response.sendRedirect("ProfileWeb.jsp");
			return;
		}

		if ("logout".equals(action)) {
			WindowManager.getInstance().setLoggedUser(null);
			response.sendRedirect("LoginWeb.jsp");
			return;
		}

		UserBean user = ctrlProfile.getCurrentUserData(session.getAttribute("credentials").toString());

		if (password.length() != 0) {
			user.setFirstname(password);
		}
		if (email.length() != 0) {
			user.setLastname(email);
		}

		int res = ctrlProfile.modifyCurrentUserData(user);

		if (res == 1) {

			response.sendRedirect("Error.jsp");
			return;

		}
	}

}
