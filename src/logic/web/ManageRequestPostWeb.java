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

		List<PostBean> mypostList = ctrlRequestPost.getRequestPosts();

		String requestmypost;
		
		 StringBuilder mybld = new StringBuilder();

		if (mypostList.size() == 0) {

			mybld.append("non ci sono post");
		} else {
			
			for (int i = 0; i < mypostList.size(); i++) {

				mybld.append("Post #" + Integer.toString(i + 1) + "\nTitolo: "
						+ mypostList.get(i).getTitolo() + "\nAutore: " + mypostList.get(i).getAutore()
						+ "\n\nDescrizione: " + mypostList.get(i).getDescrizione() + "\n\n");
			}
		}
		requestmypost = mybld.toString();
		session.setAttribute("requestpost", requestmypost);
		
		response.sendRedirect("RequestPostWeb.jsp");
	}

}
