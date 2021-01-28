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
 * Servlet implementation class NewRequestPostWeb
 */
@WebServlet("/NewRequestPostWeb")
public class NewRequestPostWeb extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NewRequestPostWeb() {
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
		String action = request.getParameter("action");

		HttpSession session = request.getSession();

		String title = request.getParameter("title");
		String description = request.getParameter("description");

		if ("insert".equals(action)) {
			PostBean post = new PostBean();

			ControlRequestPost ctrlRequestPost = ControlRequestPost.getInstance();

			post.setAutore(session.getAttribute("credentials").toString());
			post.setTitolo(title);
			post.setDescrizione(description);

			int res = ctrlRequestPost.insertRequestPost(post);
			if (res == -1) {
				response.sendRedirect("Error.jsp");
				return;
			}
			
			 ctrlRequestPost = ControlRequestPost.getInstance();
				
			 List<PostBean> postList2 = ctrlRequestPost.getRequestPosts();
			 
			 StringBuilder bld = new StringBuilder();
				
			 String requestpost = "Post #" + Integer.toString(1) + "\nTitolo: " + postList2.get(0).getTitolo() +
						"\nAutore: " + postList2.get(0).getAutore() + "\n\nDescrizione: " + postList2.get(0).getDescrizione() + "\n\n";
			 for(int i=1; i<postList2.size(); i++) {
					
				 bld.append("Post #" + Integer.toString(i+1) + "\nTitolo: " + postList2.get(i).getTitolo() +
							"\nAutore: " + postList2.get(i).getAutore() + "\n\nDescrizione: " + postList2.get(i).getDescrizione() + "\n\n");
			}
		    requestpost= bld.toString();	
			session.setAttribute("requestpost", requestpost);				
			response.sendRedirect("RequestPostWeb.jsp");
			return;
		}

	}

}
