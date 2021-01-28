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
 * Servlet implementation class ManageRequestPostWe
 */
@WebServlet("/ManageRequestPostWeb")
public class ManageRequestPostWeb extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageRequestPostWeb() {
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
		HttpSession session = request.getSession();

		String action = request.getParameter("action");
		String error = "Error.jsp";

		int id = Integer.parseInt(request.getParameter("text")) - 1;

		ControlRequestPost ctrlPost = ControlRequestPost.getInstance();

		PostBean post = new PostBean();
		post.setAutore(session.getAttribute("credentials").toString());

		if ("Modify".equals(action)) {

			String title = request.getParameter("title");
			String description = request.getParameter("description");

			post.setId(id);

			int res = ctrlPost.checkId(post);

			if (res == -1) {
				response.sendRedirect(error);
				return;

			}

			post.setTitolo(title);
			post.setDescrizione(description);

			res = ctrlPost.modifyRequestPost(post);
			if (res == -1) {
				response.sendRedirect(error);
				return;

			} 
		} else if ("Remove".equals(action)) {
			
			int res = ctrlPost.removeRequestPost(post);
			if (res == -1) {
				response.sendRedirect(error);
				return;

			}
		}
		
		
		ControlRequestPost ctrlRequestPost = ControlRequestPost.getInstance();

		List<PostBean> postList2 = ctrlRequestPost.getRequestPosts();

		String requestpost;
		
		 StringBuilder bld = new StringBuilder();

		if (postList2.size() == 0) {

			requestpost = "non ci sono post";
		} else {
			
			
	//		requestpost = "Post #" + Integer.toString(1) + "\nTitolo: " + postList2.get(0).getTitolo()
	//				+ "\nAutore: " + postList2.get(0).getAutore() + "\n\nDescrizione: "
	//				+ postList2.get(0).getDescrizione() + "\n\n";
			for (int i = 0; i < postList2.size(); i++) {

				bld.append("Post #" + Integer.toString(i + 1) + "\nTitolo: "
						+ postList2.get(i).getTitolo() + "\nAutore: " + postList2.get(i).getAutore()
						+ "\n\nDescrizione: " + postList2.get(i).getDescrizione() + "\n\n");
			}
		}
		requestpost = bld.toString();
		session.setAttribute("requestpost", requestpost);
		
		response.sendRedirect("RequestPostWeb.jsp");
		return;

	}

}
