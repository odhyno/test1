package logic.thread;

import logic.dao.NotifyDAO;

public class CheckThread implements Runnable{
	 
	String loggedUser;
	
	 public  CheckThread(String username) {	 
		 
		 this.loggedUser=username;
	}

	public synchronized void run(){ 	 
		
		NotifyDAO.checkNotify(this.loggedUser);
		
	}
	
}