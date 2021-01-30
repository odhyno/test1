package logic.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logic.bean.MessageBean;
import logic.control.ControlSendMessage;
import logic.patterns.Observer;

/**
 * Servlet implementation class SendMessageWeb
 */
@WebServlet("/SendMessageWeb")
public class SendMessageWeb extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendMessageWeb() {
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
		
		Observer controllerSendMessage = ControlSendMessage.getInstance();
		
		String receiver = request.getParameter("username");
		
		MessageBean messageBean = new MessageBean();
    	
		HttpSession session = request.getSession();
		
		
    	messageBean.setMittente(session.getAttribute("credentials").toString());
    	messageBean.setRicevente(receiver);
    	
    	int res=controllerSendMessage.checkUser(receiver);
    	if(res==0) {
    		
    		response.sendRedirect("Error.jsp");
    		return;
    		
    	}
    	
    	
    	session.setAttribute("receiver",receiver);
		List<MessageBean> messages= controllerSendMessage.showMessages(messageBean);
	    if(messages.size()>=1 ) {
	    	  
	    	StringBuilder bld = new StringBuilder();
	    	bld.append("Messagges\n\n");
		    	
		    for(int i=0;i<messages.size();i++) {
		    		
		    		bld.append(Integer.toString(i+1) + "\nMittente: " + messages.get(messages.size()-1-i).getMittente() +
			 		"\nRicevente: " + messages.get(messages.size()-1-i).getRicevente() + "\nTesto: " + messages.get(messages.size()-1-i).getTesto() + "\n\n");
		    }
		    String str = bld.toString();
			session.setAttribute("messages",str);
				
			response.sendRedirect("Chat.jsp");
			return;
				
	    
	    }
	    response.sendRedirect("Error.jsp");
    		
    		
	}

}
