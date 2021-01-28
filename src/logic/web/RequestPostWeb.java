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
import logic.control.ControlRequestPost;

/**
 * Servlet implementation class RequestPostWeb
 */
@WebServlet("/RequestPostWeb")
public class RequestPostWeb extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RequestPostWeb() {
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

		HttpSession session = request.getSession();
		
		String action = request.getParameter("action");

		//UserBean usBean = new UserBean();

		if ("NewPost".equals(action)) {

			response.sendRedirect("NewRequestPostWeb.jsp");
			return;

		}

		else if ("ManagePost".equals(action)) {
			
			 ControlRequestPost ctrlPost = ControlRequestPost.getInstance();
				
			 List<PostBean> postList = ctrlPost.filterRequestPostByUsername(session.getAttribute("credentials").toString());
				
			 String requestpost;
			 if(postList.size() == 0) {
					
				 requestpost = "non ci sono post";
					
			}  
			 else {
				 requestpost = "Post #" + Integer.toString(1) + "\nTitolo: " + postList.get(0).getTitolo() +
							"\nAutore: " + postList.get(0).getAutore() + "\n\nDescrizione: " + postList.get(0).getDescrizione() + "\n\n";
				 for(int i=1; i<postList.size(); i++) {
						
					 requestpost =	requestpost + "Post #" + Integer.toString(i+1) + "\nTitolo: " + postList.get(i).getTitolo() +
								"\nAutore: " + postList.get(i).getAutore() + "\n\nDescrizione: " + postList.get(i).getDescrizione() + "\n\n";
				}
			 }
				    	
			session.setAttribute("requestmypost", requestpost);

			response.sendRedirect("ManageRequestPostWeb.jsp");
			return;
		}
		
		response.sendRedirect("HomePageWeb.jsp");
		return;

	}

}
