package logic.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.boundary.WindowManager;

/**
 * Servlet implementation class ProfileWeb
 */
@WebServlet("/ProfileWeb")
public class ProfileWeb extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileWeb() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
/*		
		HttpSession session = request.getSession();		
		if ("message".equals(action)) {
			Observer controllerSendMessage = ControlSendMessage.getInstance();
	    	controllerSendMessage.add();
	    	
	    	String username = WindowManager.getInstance().getLoggedUser().getUsername();
	    	
	    	Thread thread = new Thread(new CheckThread(username));
	    	thread.start();
	    	
	    	List<String> usernameList =controllerSendMessage.showUsers(username);
	    	
	    	String contacts = usernameList.get(0);
	    	
	    	for(int i=1;i<usernameList.size();i++) {
	    		
	    		contacts= contacts+ "\n"+ usernameList.get(i);
	    	}
			session.setAttribute("users", contacts);
			response.sendRedirect("SendMessageWeb.jsp");
			return;
			
		}
		if ("profile".equals(action)) {
			ControlProfile ctrlProfile = ControlProfile.getInstance();
			 UserBean user = ctrlProfile.getCurrentUserData(session.getAttribute("credentials").toString());
			 
			 String profile = "YOUR PROFILE:\n\nUsername: " + user.getUsername() 
					 + "\nEmail: "+ user.getEmail() + "\nFirst name: " + user.getFirstname() 
					 + "\nLast name: " + user.getLastname() + "\nSubs Date: " + user.getSubsDate()
					 + "\nBirth Date: " + user.getBirthDate();
			 
			session.setAttribute("profile",profile);
			response.sendRedirect("ProfileWeb.jsp");
			return;
		}
*/
		if ("logout".equals(action)) {
			WindowManager.getInstance().setLoggedUser(null);
			response.sendRedirect("LoginWeb.jsp");			
			return;
		}

		if ("ModifyProfile".equals(action)) {
			
			
		response.sendRedirect("ModifyProfileWeb.jsp");
		return;
			
		}
		
		response.sendRedirect("ModifyDataWeb.jsp");
		return;
		
	}

}
