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
HttpSession session = request.getSession();
		
	//	System.out.println(session.getAttribute("flag").toString());

		String action = request.getParameter("action");

	//	int value = Integer.parseInt(session.getAttribute("flag").toString());
		
		// System.out.println(value);

		int id = Integer.parseInt(request.getParameter("text")) - 1;

		ControlRequestPost ctrlPost = ControlRequestPost.getInstance();

		PostBean post = new PostBean();
		post.setAutore(session.getAttribute("credentials").toString());

		if ("Modify".equals(action)) {
			
			System.out.println("n COSA A CAZZO del motify");

			String title = request.getParameter("title");
			String description = request.getParameter("description");

			post.setId(id);

			int res = ctrlPost.checkId(post);

			if (res == -1) {
				response.sendRedirect("Error.jsp");
				return;

			}

			post.setTitolo(title);
			post.setDescrizione(description);

			res = ctrlPost.modifyRequestPost(post);
			if (res == -1) {
				response.sendRedirect("Error.jsp");
				return;

			} 
		} else if ("Remove".equals(action)) {
			

			int res = ctrlPost.removeRequestPost(post);
			System.out.println("n COSA A CAZZO del remove");
			if (res == -1) {
				response.sendRedirect("Error.jsp");
				return;

			}
		}
		
		
		ControlRequestPost ctrlRequestPost = ControlRequestPost.getInstance();

		List<PostBean> postList2 = ctrlRequestPost.getRequestPosts();

		String requestpost;

		if (postList2.size() == 0) {

			requestpost = "non ci sono post";
		} else {
			requestpost = "Post #" + Integer.toString(1) + "\nTitolo: " + postList2.get(0).getTitolo()
					+ "\nAutore: " + postList2.get(0).getAutore() + "\n\nDescrizione: "
					+ postList2.get(0).getDescrizione() + "\n\n";
			for (int i = 1; i < postList2.size(); i++) {

				requestpost = requestpost + "Post #" + Integer.toString(i + 1) + "\nTitolo: "
						+ postList2.get(i).getTitolo() + "\nAutore: " + postList2.get(i).getAutore()
						+ "\n\nDescrizione: " + postList2.get(i).getDescrizione() + "\n\n";
			}
		}

		session.setAttribute("requestpost", requestpost);
		
		response.sendRedirect("RequestPostWeb.jsp");
		return;

	}

}
