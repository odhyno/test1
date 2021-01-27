package webGUI;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.UserBean;
import control.ControlLogin;

/**
 * Servlet implementation class RecoveryWeb
 */
@WebServlet("/RecoveryWeb")
public class RecoveryWeb extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecoveryWeb() {
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
		String username=request.getParameter("username");
		String email=request.getParameter("email");
		
		UserBean usBean= new UserBean();
		
		ControlLogin ctrlRecoverData = ControlLogin.getInstance();
		
		
		if ("username".length()==0) {
			response.sendRedirect("Error.jsp");
			return;
		}
		
		if ("email".length()==0) {
			response.sendRedirect("Error.jsp");
			return;
		}
		
		//setto lo UserBean
		usBean.setUsername(username);
		usBean.setEmail(email);
		
		int res=ctrlRecoverData.sendEmail(usBean);
		if(res==1) {
			response.sendRedirect("LoginWeb.jsp");
			return;
		}
		else {
	
			response.sendRedirect("Error.jsp");
			return;
		}
	}

}
