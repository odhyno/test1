package logic.entity;

import java.util.ArrayList;
import java.util.List;

import logic.bean.NotifyBean;
import logic.interfaces.Observer;


public class ObservableNotify {
	
	private static ObservableNotify instance= null;
	
	 private int value ;
	 private List<Observer> observers = new ArrayList<>();
	 
	 public static ObservableNotify getInstance()
	    {

	        if (instance == null) {

	            instance = new ObservableNotify();

	        }

	        return instance;

	    }
	 
	 //notifico il valore attuale non appena un observer si sottoscrive
	 //se qualcuno ha scritto mentre l utente era sconnesso manda notifica altrienti no
	 public void addObserver(Observer channel) { 
		 observers.add(channel);
	 }
	 
	 
	 public void removeObserver(Observer channel) {
		 
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
		 	for (Observer observer : observers) {
	        	
		 		observer.update(notifyBean);
	        }
	}

}
