package entity;

import java.util.ArrayList;
import java.util.List;

import bean.NotifyBean;
import interfaces.Observer;


public class ObservableNotify {
	
	private static ObservableNotify instance= null;
	
	 private int value ;
	 private List<Observer> observers = new ArrayList<Observer>();
	 
	// private ControllerSendMessage controllerSendMessage;
	 
	 public static ObservableNotify getInstance()
	    {

	        if (instance == null) {

	            instance = new ObservableNotify();

	        }

	        return instance;

	    }
	 
	 
	 /*public void setListObserver()Observer channel {
		 
	 }*/
	 
	 //notifico il valore attuale non appena un observer si sottoscrive
	 //se qualcuno ha scritto mentre l utente era sconnesso manda notifica altrienti no
	 public void addObserver(Observer channel) {
		 
	//	 ControllerSendMessage controllerSendMessage = ControllerSendMessage.getInstance();
		 
		 System.out.println("preparo l observer");
		 
		/* if(value!=0) {
		 
			 controllerSendMessage.update(this.value);
		 
	     }*/
		 
		 observers.add(channel);
		// System.out.println(observers.size());
	 }
	 
	 
	 public void removeObserver(Observer channel) {
		 
		 System.out.println("tolgo l observer");
	        observers.remove(channel);
	 }
	    
	 public ObservableNotify() {
	        this.value = 0;
	 }
	    
	 public  synchronized  void setValue(int notice, String username) {
		 
		 	NotifyBean notifyBean = new NotifyBean();
		 	
		 	notifyBean.setUsername(username);
		 	
		 	this.value = notice;
	        
		 	notifyBean.setNotice(this.value);
	        
		// 	System.out.println("sto settando l observer");
		// 	System.out.println(observers.size());
	        
		 	for (Observer observer : observers) {
	        	
		 	//	System.out.println(observers.size());
		 		// controllerSendMessage = ControllerSendMessage.getInstance();
		 		observer.update(notifyBean);
	        }
	}

}
