package logic.patterns;

import java.util.List;

import logic.bean.MessageBean;
import logic.bean.NotifyBean;

public interface Observer {

	 public void  update(int value,String username);
	 
	 public List<String> showUsers(String loggedUser);
	 
	 public List<MessageBean> showMessages(MessageBean messageBean);
	 
	 public int inserText(MessageBean messageBean);
	 
	 public void removeObserver();
	 
	 public int checkUser(String ricevente);

	public void add();
	 
}
