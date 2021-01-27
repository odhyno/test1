package webGUI;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import boundary.WindowManager;

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
		
		switch(action) {
		
		case "sample post":
			response.sendRedirect("RegisterWeb.jsp");
			break;
		case "band/member post":
			response.sendRedirect("RegisterWeb.jsp");
			break;
		case "topic post":
			response.sendRedirect("RegisterWeb.jsp");
			break;
		case "ranking":
			response.sendRedirect("RegisterWeb.jsp");
			break;
		case "view rules":
			response.sendRedirect("RegisterWeb.jsp");
			break;
		case "messages":
			response.sendRedirect("SendMessageWeb.jsp");
			break;
		case "profile":
			response.sendRedirect("RegisterWeb.jsp");
			break;
		case "logout":
			response.sendRedirect("LoginWeb.jsp");
			WindowManager.getInstance().setLoggedUser(null);
			break;
		case "manage rules":
			response.sendRedirect("RegisterWeb.jsp");
			break;
		case "manage report":
			response.sendRedirect("RegisterWeb.jsp");
			break;
		case "manage users":
			response.sendRedirect("RegisterWeb.jsp");
			break;
		case "do report":
			response.sendRedirect("RegisterWeb.jsp");
			break;
		case "read rules":
			response.sendRedirect("RegisterWeb.jsp");
			break;
		}
		
		return;
	}

}
