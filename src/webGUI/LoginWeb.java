package webGUI;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.UserBean;
import boundary.WindowManager;
import control.ControlLogin;

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
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
		else {
			
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
			
			if(res==1) {
				HttpSession session = request.getSession();
				session.setAttribute("credentials", username);
				response.sendRedirect("HomePageAdminWeb.jsp");
			    return;
			}
			else {
				response.sendRedirect("HomePageWeb.jsp");
			    return;
			}
		
		}
		
	}

}
