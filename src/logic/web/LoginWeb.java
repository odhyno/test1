package logic.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logic.bean.UserBean;
import logic.control.ControlLogin;
import logic.utility.WindowManager;

/**
 * Servlet implementation class LoginWeb
 */
@WebServlet("/LoginWeb")
public class LoginWeb extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginWeb() {
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
		
		UserBean usBean= new UserBean();
		
		if ("register".equals(action)) {
			
			response.sendRedirect("RegisterWeb.jsp");
			return;
			
		}
		else if("recovery".equals(action)) {
			
			response.sendRedirect("RecoveryWeb.jsp");
			return;
		}
			
		String username=request.getParameter("username");
		String password=request.getParameter("password");
			
		//setto lo UserBean
		usBean.setUsername(username);
		usBean.setPassword(password);
			
		ControlLogin controllerLogin= ControlLogin.getInstance();
		//Chiamo il mio Controllore
		int res=controllerLogin.checkLogin(usBean);
			
		if(res==-1)
		{

			response.sendRedirect("FailedWeb.jsp");
			return;
		}
				
		usBean.setType(res);
		WindowManager.getInstance().setLoggedUser(usBean); 
			
		HttpSession session = request.getSession();
		session.setAttribute("credentials", username);
			
		if(res==1) {
			response.sendRedirect("HomePageAdminWeb.jsp");
			return;
		}
					
		response.sendRedirect("HomePageWeb.jsp");		 
	}

}
