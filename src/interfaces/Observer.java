package interfaces;

import java.util.List;

import bean.MessageBean;
import bean.NotifyBean;

public interface Observer {

	 public void  update(NotifyBean notify);
	 
	 public List<String> showUsers(String loggedUser);
	 
	 public List<MessageBean> showMessages(MessageBean messageBean);
	 
	 public void inserText(MessageBean messageBean);
	 
	 public void removeObserver();
	 
	 public int checkUser(String ricevente);

	public void add();
	 
}
