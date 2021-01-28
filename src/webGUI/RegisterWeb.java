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
 * Servlet implementation class RegisterWeb
 */
@WebServlet("/RegisterWeb")
public class RegisterWeb extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterWeb() {
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
		// TODO Auto-generated method stub
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		
		System.out.println(email);
		String firstname=request.getParameter("firstname");
		String lastname=request.getParameter("lastname");
		String date =request.getParameter("date");
		
		UserBean usBean= new UserBean();
		ControlLogin controllerRegist = ControlLogin.getInstance();
		
		
		if ("username".length()==0) {
			response.sendRedirect("Error.jsp");
			return;
		}
		
		if ("password".length()==0) {
			response.sendRedirect("Error.jsp");
			return;
		}
		
		if ("email".length()==0) {
			response.sendRedirect("Error.jsp");
			return;
		}
		if ("firstname".length()==0) {
			response.sendRedirect("Error.jsp");
			return;
		}
		if ("lastname".length()==0) {
			response.sendRedirect("Error.jsp");
			return;
		}
		System.out.println("valore : "+ controllerRegist.checkIfEmailIsValid(email) );
		if(!controllerRegist.checkIfEmailIsValid(email)) {
			response.sendRedirect("Error.jsp");
			return;
		}
		String result =controllerRegist.checkUsernameAlreadyTaken(username);
		
		if (result.equals("trovato")) {

			response.sendRedirect("Error.jsp");
			return;

		} else {
			
			usBean.setUsername(username);
			usBean.setPassword(password);
			usBean.setEmail(email);
			usBean.setFirstname(firstname);
			usBean.setLastname(lastname);
			
			usBean.setBirthDate(date);

			controllerRegist.registerUser(usBean);

			response.sendRedirect("LoginWeb.jsp");
			return;

		}
		
	}
	
}

