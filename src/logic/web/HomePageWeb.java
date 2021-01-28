package logic.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logic.bean.PostBean;
import logic.bean.UserBean;
import logic.boundary.WindowManager;
import logic.control.ControlProfile;
import logic.control.ControlRequestPost;
import logic.control.ControlSendMessage;
import logic.interfaces.Observer;
import logic.thread.CheckThread;

/**
 * Servlet implementation class HomePageWeb
 */
@WebServlet("/HomePageWeb")
public class HomePageWeb extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HomePageWeb() {
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

		HttpSession session = request.getSession();

		String action = request.getParameter("action");

		switch (action) {

		case "sample post":
			response.sendRedirect("RegisterWeb.jsp");
			break;
		case "band/member post":
			ControlRequestPost ctrlRequestPost =  ControlRequestPost.getInstance();

			List<PostBean> postList2 = ctrlRequestPost.getRequestPosts();

			String requestpost;
			StringBuilder bld = new StringBuilder();

			if (postList2.size() == 0) {

				requestpost = "non ci sono post";
			} else {
				
				
	//			requestpost = "Post #" + Integer.toString(1) + "\nTitolo: " + postList2.get(0).getTitolo()
		//				+ "\nAutore: " + postList2.get(0).getAutore() + "\n\nDescrizione: "
			//			+ postList2.get(0).getDescrizione() + "\n\n";
				
				for (int i = 0; i < postList2.size(); i++) {

					bld.append( "Post #" + Integer.toString(i + 1) + "\nTitolo: "
							+ postList2.get(i).getTitolo() + "\nAutore: " + postList2.get(i).getAutore()
							+ "\n\nDescrizione: " + postList2.get(i).getDescrizione() + "\n\n");
				}
			}
			requestpost= bld.toString();
			session.setAttribute("requestpost", requestpost);

			response.sendRedirect("RequestPostWeb.jsp");
			break;
		case "messages":

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
			break;
		case "profile":

			ControlProfile ctrlProfile = ControlProfile.getInstance();
			UserBean user = ctrlProfile.getCurrentUserData(session.getAttribute("credentials").toString());

			String profile = "YOUR PROFILE:\n\nUsername: " + user.getUsername() + "\nEmail: " + user.getEmail()
					+ "\nFirst name: " + user.getFirstname() + "\nLast name: " + user.getLastname() + "\nSubs Date: "
					+ user.getSubsDate() + "\nBirth Date: " + user.getBirthDate();

			session.setAttribute("profile", profile);
			response.sendRedirect("ProfileWeb.jsp");
			break;
		case "logout":
			WindowManager.getInstance().setLoggedUser(null);
			response.sendRedirect("LoginWeb.jsp");
			break;

		}
	}

}
