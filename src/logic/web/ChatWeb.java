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
 * Servlet implementation class ChatWeb
 */
@WebServlet("/ChatWeb")
public class ChatWeb extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChatWeb() {
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
		
		String message = request.getParameter("message");
		
		HttpSession session = request.getSession();
		
		
		Observer controllerSendMessage = ControlSendMessage.getInstance();
 		
 		if(message.length()==0) {
			
			response.sendRedirect("Error.jsp");
    		return;
		}
		
 		MessageBean messageBean= new MessageBean();
 		
 			
	 	//setto il messageBean
		messageBean.setTesto(message);
		messageBean.setMittente(session.getAttribute("credentials").toString());
		messageBean.setRicevente(session.getAttribute("receiver").toString());
			
		controllerSendMessage.inserText(messageBean);
		List<MessageBean> listMessage= controllerSendMessage.showMessages(messageBean);
	    if(listMessage.size()>=1 ) {
	    	
	    	 StringBuilder bld = new StringBuilder();
		 
	        bld.append("Messagges\n\n");
		    	
		    for(int i=0;i<listMessage.size();i++) {
		    		
		    		bld.append(Integer.toString(i+1) + "\nMittente: " + listMessage.get(listMessage.size()-1-i).getMittente() +
			 		"\nRicevente: " + listMessage.get(listMessage.size()-1-i).getRicevente() + "\nTesto: " + listMessage.get(listMessage.size()-1-i).getTesto() + "\n\n");
		    }
		    message= bld.toString();
			session.setAttribute("messages",message);
				
			response.sendRedirect("Chat.jsp");

	    }
	}

}
