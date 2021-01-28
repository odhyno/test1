package logic.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.bean.UserBean;
import logic.control.ControlLogin;

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
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		String error= "Error.jsp";
		String firstname=request.getParameter("firstname");
		String lastname=request.getParameter("lastname");
		String date =request.getParameter("date");
		
		UserBean usBean= new UserBean();
		ControlLogin controllerRegist = ControlLogin.getInstance();
		
		
		if ("username".length()==0 ||"password".length()==0 ||"email".length()==0||"firstname".length()==0||"lastname".length()==0) {
			response.sendRedirect(error);
			return;
		}
		
		if(!controllerRegist.checkIfEmailIsValid(email)) {
			response.sendRedirect(error);
			return;
		}
		String result =controllerRegist.checkUsernameAlreadyTaken(username);
		
		if (result.equals("trovato")) {

			response.sendRedirect(error);
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

		}
		
	}
	
}

